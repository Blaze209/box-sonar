package com.box.androidsdk.content.utils;

import com.box.androidsdk.content.listeners.ProgressListener;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes13.dex */
public class ProgressOutputStream extends OutputStream {
    private final ProgressListener listener;
    private final OutputStream stream;
    private long total;
    private long totalWritten;

    public ProgressOutputStream(OutputStream outputStream, ProgressListener progressListener, long j) {
        this.stream = outputStream;
        this.listener = progressListener;
        this.total = j;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long j) {
        this.total = j;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
        super.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.stream.flush();
        super.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.stream.write(bArr);
        long length = this.totalWritten + ((long) bArr.length);
        this.totalWritten = length;
        this.listener.onProgressChanged(length, this.total);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.stream.write(bArr, i, i2);
        if (i2 < bArr.length) {
            this.totalWritten += (long) i2;
        } else {
            this.totalWritten += (long) bArr.length;
        }
        this.listener.onProgressChanged(this.totalWritten, this.total);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.stream.write(i);
        long j = this.totalWritten + 1;
        this.totalWritten = j;
        this.listener.onProgressChanged(j, this.total);
    }
}
