package org.tinylog.writers.raw;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class CharsetAdjustmentWriterDecorator implements ByteArrayWriter {
    private final byte[] charsetHeader;
    private final ByteArrayWriter writer;

    public CharsetAdjustmentWriterDecorator(ByteArrayWriter byteArrayWriter, byte[] bArr) {
        this.writer = byteArrayWriter;
        this.charsetHeader = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public int readTail(byte[] bArr, int i, int i2) throws IOException {
        return this.writer.readTail(bArr, i, i2);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i) throws IOException {
        write(bArr, 0, i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (startsWithCharsetHeader(bArr, i, i2)) {
            ByteArrayWriter byteArrayWriter = this.writer;
            byte[] bArr2 = this.charsetHeader;
            byteArrayWriter.write(bArr, i + bArr2.length, i2 - bArr2.length);
            return;
        }
        this.writer.write(bArr, i, i2);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void truncate(int i) throws IOException {
        this.writer.truncate(i);
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // org.tinylog.writers.raw.ByteArrayWriter
    public void close() throws IOException {
        this.writer.close();
    }

    private boolean startsWithCharsetHeader(byte[] bArr, int i, int i2) {
        if (this.charsetHeader.length > i2) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.charsetHeader;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr2[i3] != bArr[i + i3]) {
                return false;
            }
            i3++;
        }
    }
}
