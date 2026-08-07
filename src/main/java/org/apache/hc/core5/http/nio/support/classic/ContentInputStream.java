package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ContentInputStream extends InputStream {
    private final ContentInputBuffer buffer;

    public ContentInputStream(ContentInputBuffer contentInputBuffer) {
        Args.notNull(contentInputBuffer, "Input buffer");
        this.buffer = contentInputBuffer;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.buffer.length();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        return this.buffer.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return this.buffer.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.buffer.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        while (this.buffer.read(new byte[1024], 0, 1024) >= 0) {
        }
        super.close();
    }
}
