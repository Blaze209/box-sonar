package org.tinylog.writers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import org.tinylog.Level;
import org.tinylog.converters.FileConverter;
import org.tinylog.converters.NopFileConverter;
import org.tinylog.core.LogEntry;
import org.tinylog.path.DynamicPath;
import org.tinylog.path.FileTuple;
import org.tinylog.policies.Policy;
import org.tinylog.policies.StartupPolicy;
import org.tinylog.provider.InternalLogger;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.writers.raw.ByteArrayWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class RollingFileWriter extends AbstractFormatPatternWriter {
    private final int backups;
    private final boolean buffered;
    private final Charset charset;
    private final FileConverter converter;
    private final DynamicPath linkToLatest;
    private final DynamicPath path;
    private final List<Policy> policies;
    private ByteArrayWriter writer;
    private final boolean writingThread;

    public RollingFileWriter() throws IOException {
        this(Collections.emptyMap());
    }

    public RollingFileWriter(Map<String, String> map) throws IOException {
        String strResolve;
        super(map);
        DynamicPath dynamicPath = new DynamicPath(getFileName());
        this.path = dynamicPath;
        List<Policy> listCreatePolicies = createPolicies(getStringValue("policies"));
        this.policies = listCreatePolicies;
        FileConverter fileConverterCreateConverter = createConverter(getStringValue("convert"));
        this.converter = fileConverterCreateConverter;
        int i = map.containsKey("backups") ? Integer.parseInt(getStringValue("backups")) : -1;
        this.backups = i;
        this.linkToLatest = map.containsKey("latest") ? new DynamicPath(getStringValue("latest")) : null;
        List<FileTuple> allFileTuplesWithoutLinks = getAllFileTuplesWithoutLinks(fileConverterCreateConverter.getBackupSuffix());
        File fileFindLatestValidLogFile = findLatestValidLogFile(dynamicPath, allFileTuplesWithoutLinks);
        if (i >= 0) {
            deleteBackups(allFileTuplesWithoutLinks, i);
        }
        boolean z = false;
        if (fileFindLatestValidLogFile != null) {
            strResolve = fileFindLatestValidLogFile.getAbsolutePath();
            if (canBeContinued(strResolve, listCreatePolicies)) {
                z = true;
            } else {
                strResolve = dynamicPath.resolve();
            }
        } else {
            strResolve = dynamicPath.resolve();
        }
        Charset charset = getCharset();
        this.charset = charset;
        boolean booleanValue = getBooleanValue("buffered");
        this.buffered = booleanValue;
        this.writingThread = getBooleanValue("writingthread");
        this.writer = createByteArrayWriterAndLinkLatest(strResolve, z, booleanValue, charset);
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        byte[] bytes = render(logEntry).getBytes(this.charset);
        if (this.writingThread) {
            internalWrite(bytes);
            return;
        }
        synchronized (this.writer) {
            internalWrite(bytes);
        }
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws IOException {
        if (this.writingThread) {
            internalFlush();
            return;
        }
        synchronized (this.writer) {
            internalFlush();
        }
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws InterruptedException, IOException {
        if (this.writingThread) {
            internalClose();
            return;
        }
        synchronized (this.writer) {
            internalClose();
        }
    }

    private void internalWrite(byte[] bArr) throws IOException {
        if (!canBeContinued(bArr, this.policies)) {
            this.writer.close();
            this.converter.close();
            this.writer = createByteArrayWriterAndLinkLatest(this.path.resolve(), false, this.buffered, this.charset);
            Iterator<Policy> it = this.policies.iterator();
            while (it.hasNext()) {
                it.next().reset();
            }
            if (this.backups >= 0) {
                deleteBackups(getAllFileTuplesWithoutLinks(this.converter.getBackupSuffix()), this.backups);
            }
        }
        byte[] bArrWrite = this.converter.write(bArr);
        this.writer.write(bArrWrite, 0, bArrWrite.length);
    }

    private void internalFlush() throws IOException {
        this.writer.flush();
    }

    private void internalClose() throws InterruptedException, IOException {
        this.writer.close();
        this.converter.close();
        this.converter.shutdown();
    }

    private List<FileTuple> getAllFileTuplesWithoutLinks(String str) {
        List<FileTuple> allFiles = this.path.getAllFiles(str);
        if (this.linkToLatest != null && !RuntimeProvider.isAndroid()) {
            File absoluteFile = new File(this.linkToLatest.resolve()).getAbsoluteFile();
            Iterator<FileTuple> it = allFiles.iterator();
            while (it.hasNext()) {
                if (absoluteFile.equals(it.next().getOriginal())) {
                    it.remove();
                    break;
                }
            }
        }
        return allFiles;
    }

    private ByteArrayWriter createByteArrayWriterAndLinkLatest(String str, boolean z, boolean z2, Charset charset) throws IOException {
        this.converter.open(str);
        ByteArrayWriter byteArrayWriterCreateByteArrayWriter = createByteArrayWriter(str, z, z2, false, false, charset);
        if (this.linkToLatest != null) {
            File file = new File(str);
            File file2 = new File(this.linkToLatest.resolve());
            if (!RuntimeProvider.isAndroid()) {
                try {
                    Path path = file.toPath();
                    Path path2 = file2.toPath();
                    Files.deleteIfExists(path2);
                    Files.createLink(path2, path);
                    return byteArrayWriterCreateByteArrayWriter;
                } catch (IOException e) {
                    InternalLogger.log(Level.ERROR, e, "Failed to create link '" + file2 + "'");
                    return byteArrayWriterCreateByteArrayWriter;
                }
            }
            InternalLogger.log(Level.WARN, "Cannot create link to latest log file on Android");
        }
        return byteArrayWriterCreateByteArrayWriter;
    }

    private static File findLatestValidLogFile(DynamicPath dynamicPath, List<FileTuple> list) {
        for (FileTuple fileTuple : list) {
            if (fileTuple.getOriginal().isFile() && (fileTuple.getOriginal().equals(fileTuple.getBackup()) || !fileTuple.getBackup().isFile())) {
                File original = fileTuple.getOriginal();
                if (dynamicPath.isValid(original)) {
                    return original;
                }
            }
        }
        return null;
    }

    private static List<Policy> createPolicies(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.singletonList(new StartupPolicy(null));
        }
        if (RuntimeProvider.getProcessId() == Long.MIN_VALUE) {
            ServiceLoader.load(Policy.class);
        }
        return new org.tinylog.configuration.ServiceLoader(Policy.class, String.class).createList(str);
    }

    private static FileConverter createConverter(String str) {
        if (str == null || str.isEmpty()) {
            return new NopFileConverter();
        }
        if (RuntimeProvider.getProcessId() == Long.MIN_VALUE) {
            ServiceLoader.load(FileConverter.class);
        }
        FileConverter fileConverter = (FileConverter) new org.tinylog.configuration.ServiceLoader(FileConverter.class, new Class[0]).create(str, new Object[0]);
        return fileConverter == null ? new NopFileConverter() : fileConverter;
    }

    private static boolean canBeContinued(String str, List<Policy> list) {
        Iterator<Policy> it = list.iterator();
        boolean zContinueExistingFile = true;
        while (it.hasNext()) {
            zContinueExistingFile &= it.next().continueExistingFile(str);
        }
        return zContinueExistingFile;
    }

    private static boolean canBeContinued(byte[] bArr, List<Policy> list) {
        Iterator<Policy> it = list.iterator();
        boolean zContinueCurrentFile = true;
        while (it.hasNext()) {
            zContinueCurrentFile &= it.next().continueCurrentFile(bArr);
        }
        return zContinueCurrentFile;
    }

    private static void deleteBackups(List<FileTuple> list, int i) {
        while (i < list.size()) {
            list.get(i).delete();
            i++;
        }
    }
}
