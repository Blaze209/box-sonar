package com.box.androidsdk.content.utils;

import com.box.androidsdk.content.listeners.ProgressListener;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes13.dex */
public class ProgressInputStream extends InputStream {
    private final ProgressListener listener;
    private final InputStream stream;
    private long total;
    private long totalRead;

    public ProgressInputStream(InputStream inputStream, ProgressListener progressListener, long j) {
        this.stream = inputStream;
        this.listener = progressListener;
        this.total = j;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long j) {
        this.total = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.stream.read();
        long j = this.totalRead + 1;
        this.totalRead = j;
        this.listener.onProgressChanged(j, this.total);
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.stream.read(bArr, i, i2);
        long j = this.totalRead + ((long) i3);
        this.totalRead = j;
        this.listener.onProgressChanged(j, this.total);
        return i3;
    }
}
