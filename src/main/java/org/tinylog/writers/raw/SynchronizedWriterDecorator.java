package org.tinylog.writers.raw;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class SynchronizedWriterDecorator implements ByteArrayWriter {
    private final Object mutex;
    private final ByteArrayWriter writer;

    public SynchronizedWriterDecorator(ByteArrayWriter byteArrayWriter, Object obj) {
        this.writer = byteArrayWriter;
        this.mutex = obj;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public int readTail(byte[] bArr, int i, int i2) throws IOException {
        int tail;
        synchronized (this.mutex) {
            tail = this.writer.readTail(bArr, i, i2);
        }
        return tail;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i) throws IOException {
        write(bArr, 0, i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this.mutex) {
            this.writer.write(bArr, i, i2);
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void truncate(int i) throws IOException {
        synchronized (this.mutex) {
            this.writer.truncate(i);
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void flush() throws IOException {
        synchronized (this.mutex) {
            this.writer.flush();
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void close() throws IOException {
        synchronized (this.mutex) {
            this.writer.close();
        }
    }
}
