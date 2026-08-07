package org.tinylog.writers.raw;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class BufferedWriterDecorator implements ByteArrayWriter {
    private static final int BUFFER_CAPACITY = 65536;
    private final byte[] buffer = new byte[65536];
    private int position = 0;
    private final ByteArrayWriter writer;

    public BufferedWriterDecorator(ByteArrayWriter byteArrayWriter) {
        this.writer = byteArrayWriter;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public int readTail(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.position;
        if (i2 <= i3) {
            System.arraycopy(this.buffer, i3 - i2, bArr, i, i2);
            return i2;
        }
        int tail = this.writer.readTail(bArr, i, i2 - i3);
        System.arraycopy(this.buffer, 0, bArr, i + tail, this.position);
        return tail + this.position;
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i) throws IOException {
        write(bArr, 0, i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.position;
        if (i3 > 0 && 65536 - i3 < i2) {
            this.writer.write(this.buffer, 0, i3);
            this.position = 0;
        }
        if (65536 < i2) {
            this.writer.write(bArr, i, i2);
        } else {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void truncate(int i) throws IOException {
        int i2 = this.position;
        if (i <= i2) {
            this.position = i2 - i;
        } else {
            this.writer.truncate(i - i2);
            this.position = 0;
        }
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void flush() throws IOException {
        int i = this.position;
        if (i > 0) {
            this.writer.write(this.buffer, 0, i);
            this.position = 0;
        }
        this.writer.flush();
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void close() throws IOException {
        int i = this.position;
        if (i > 0) {
            this.writer.write(this.buffer, 0, i);
        }
        this.writer.close();
    }
}
