package org.tinylog.writers.raw;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes5.dex */
public final class RandomAccessFileWriter implements ByteArrayWriter {
    private final RandomAccessFile file;

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void flush() {
    }

    public RandomAccessFileWriter(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public int readTail(byte[] bArr, int i, int i2) throws IOException {
        long length = this.file.length();
        long j = i2;
        this.file.seek(Math.max(0L, length - j));
        return this.file.read(bArr, i, (int) Math.min(length, j));
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i) throws IOException {
        write(bArr, 0, i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.file.write(bArr, i, i2);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void truncate(int i) throws IOException {
        RandomAccessFile randomAccessFile = this.file;
        randomAccessFile.setLength(Math.max(0L, randomAccessFile.length() - ((long) i)));
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void close() throws IOException {
        this.file.close();
    }
}
