package org.tinylog.writers.raw;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes5.dex */
public final class LockedRandomAccessFileWriter implements ByteArrayWriter {
    private final RandomAccessFile file;

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void flush() {
    }

    public LockedRandomAccessFileWriter(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public int readTail(byte[] bArr, int i, int i2) throws IOException {
        FileChannel channel = this.file.getChannel();
        FileLock fileLockLock = channel.lock();
        try {
            long size = channel.size();
            int iMin = (int) Math.min(size, i2);
            channel.position(size - ((long) iMin));
            return this.file.read(bArr, i, iMin);
        } finally {
            fileLockLock.release();
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i) throws IOException {
        write(bArr, 0, i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i, int i2) throws IOException {
        FileChannel channel = this.file.getChannel();
        FileLock fileLockLock = channel.lock();
        try {
            channel.position(channel.size());
            this.file.write(bArr, i, i2);
        } finally {
            fileLockLock.release();
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void truncate(int i) throws IOException {
        FileChannel channel = this.file.getChannel();
        FileLock fileLockLock = channel.lock();
        try {
            this.file.setLength(Math.max(0L, channel.size() - ((long) i)));
        } finally {
            fileLockLock.release();
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void close() throws IOException {
        this.file.close();
    }
}
