package org.tinylog.writers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.provider.InternalLogger;
import org.tinylog.writers.raw.ByteArrayWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class SharedFileWriter extends AbstractFormatPatternWriter {
    private final Charset charset;
    private final FileLock lock;
    private final RandomAccessFile lockFile;
    private final ByteArrayWriter writer;

    public SharedFileWriter() throws IOException {
        this(Collections.emptyMap());
    }

    public SharedFileWriter(Map<String, String> map) throws IOException {
        super(map);
        String fileName = getFileName();
        boolean booleanValue = getBooleanValue("append");
        boolean booleanValue2 = getBooleanValue("buffered");
        boolean booleanValue3 = getBooleanValue("writingthread");
        if (booleanValue) {
            this.lockFile = null;
            this.lock = null;
        } else {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName + ".lock", "rw");
            this.lockFile = randomAccessFile;
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
            if (fileLockTryLock == null) {
                booleanValue = true;
            } else {
                fileLockTryLock.release();
            }
            FileLock fileLockLock = randomAccessFile.getChannel().lock(0L, Long.MAX_VALUE, true);
            this.lock = fileLockLock;
            if (!fileLockLock.isShared()) {
                fileLockLock.release();
                InternalLogger.log(Level.WARN, "Operating system does not support shared locks. Shared file writer will only work properly, if append mode is enabled.");
                booleanValue = true;
            }
        }
        Charset charset = getCharset();
        this.charset = charset;
        this.writer = createByteArrayWriter(fileName, booleanValue, booleanValue2, true ^ booleanValue3, true, charset);
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        byte[] bytes = render(logEntry).getBytes(this.charset);
        this.writer.write(bytes, 0, bytes.length);
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws IOException {
        try {
            this.writer.close();
            if (this.lockFile != null) {
                try {
                    this.lock.release();
                } finally {
                    this.lockFile.close();
                }
            }
        } catch (Throwable th) {
            if (this.lockFile != null) {
                try {
                    this.lock.release();
                } finally {
                    this.lockFile.close();
                }
            }
            throw th;
        }
    }
}
