package com.eclipsesource.json;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes13.dex */
class WritingBuffer extends Writer {
    private final char[] buffer;
    private int fill;
    private final Writer writer;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    WritingBuffer(Writer writer) {
        this(writer, 16);
    }

    WritingBuffer(Writer writer, int i) {
        this.fill = 0;
        this.writer = writer;
        this.buffer = new char[i];
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        if (this.fill > this.buffer.length - 1) {
            flush();
        }
        char[] cArr = this.buffer;
        int i2 = this.fill;
        this.fill = i2 + 1;
        cArr[i2] = (char) i;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (this.fill > this.buffer.length - i2) {
            flush();
            if (i2 > this.buffer.length) {
                this.writer.write(cArr, i, i2);
                return;
            }
        }
        System.arraycopy(cArr, i, this.buffer, this.fill, i2);
        this.fill += i2;
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        if (this.fill > this.buffer.length - i2) {
            flush();
            if (i2 > this.buffer.length) {
                this.writer.write(str, i, i2);
                return;
            }
        }
        str.getChars(i, i + i2, this.buffer, this.fill);
        this.fill += i2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.write(this.buffer, 0, this.fill);
        this.fill = 0;
    }
}
