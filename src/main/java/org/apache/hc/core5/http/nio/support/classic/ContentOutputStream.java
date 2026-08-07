package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ContentOutputStream extends OutputStream {
    private final ContentOutputBuffer buffer;

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
    }

    public ContentOutputStream(ContentOutputBuffer contentOutputBuffer) {
        Args.notNull(contentOutputBuffer, "Output buffer");
        this.buffer = contentOutputBuffer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.buffer.writeCompleted();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.buffer.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        if (bArr == null) {
            return;
        }
        this.buffer.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.buffer.write(i);
    }
}
