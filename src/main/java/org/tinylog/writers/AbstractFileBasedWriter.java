package org.tinylog.writers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import org.tinylog.writers.raw.BufferedWriterDecorator;
import org.tinylog.writers.raw.ByteArrayWriter;
import org.tinylog.writers.raw.CharsetAdjustmentWriterDecorator;
import org.tinylog.writers.raw.LockedRandomAccessFileWriter;
import org.tinylog.writers.raw.RandomAccessFileWriter;
import org.tinylog.writers.raw.SynchronizedWriterDecorator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractFileBasedWriter extends AbstractWriter {
    protected AbstractFileBasedWriter(Map<String, String> map) {
        super(map);
    }

    protected String getFileName() {
        String stringValue = getStringValue("file");
        if (stringValue != null) {
            return stringValue;
        }
        throw new IllegalArgumentException("File name is missing for writer");
    }

    protected Charset getCharset() {
        String stringValue = getStringValue("charset");
        try {
            return stringValue == null ? Charset.defaultCharset() : Charset.forName(stringValue);
        } catch (IllegalArgumentException unused) {
            InternalLogger.log(Level.ERROR, "Invalid charset: " + stringValue);
            return Charset.defaultCharset();
        }
    }

    protected static ByteArrayWriter createByteArrayWriter(String str, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws IOException {
        ByteArrayWriter randomAccessFileWriter;
        File absoluteFile = new File(str).getAbsoluteFile();
        absoluteFile.getParentFile().mkdirs();
        byte[] charsetHeader = getCharsetHeader(charset);
        RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFile, "rw");
        if (z4) {
            FileLock fileLockLock = randomAccessFile.getChannel().lock();
            try {
                prepareLogFile(randomAccessFile, z, charsetHeader);
                fileLockLock.release();
                randomAccessFileWriter = new LockedRandomAccessFileWriter(randomAccessFile);
            } catch (Throwable th) {
                fileLockLock.release();
                throw th;
            }
        } else {
            prepareLogFile(randomAccessFile, z, charsetHeader);
            randomAccessFileWriter = new RandomAccessFileWriter(randomAccessFile);
        }
        if (z2) {
            randomAccessFileWriter = new BufferedWriterDecorator(randomAccessFileWriter);
        }
        if (z3) {
            randomAccessFileWriter = new SynchronizedWriterDecorator(randomAccessFileWriter, randomAccessFile);
        }
        return charsetHeader.length > 0 ? new CharsetAdjustmentWriterDecorator(randomAccessFileWriter, charsetHeader) : randomAccessFileWriter;
    }

    protected static byte[] getCharsetHeader(Charset charset) {
        byte[] bytes = " ".getBytes(charset);
        byte[] bytes2 = "  ".getBytes(charset);
        return Arrays.copyOf(bytes2, (bytes.length * 2) - bytes2.length);
    }

    private static void prepareLogFile(RandomAccessFile randomAccessFile, boolean z, byte[] bArr) throws IOException {
        if (z) {
            randomAccessFile.seek(randomAccessFile.length());
        } else {
            randomAccessFile.setLength(0L);
        }
        if (bArr.length <= 0 || randomAccessFile.length() != 0) {
            return;
        }
        randomAccessFile.write(bArr, 0, bArr.length);
    }
}
