package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityOutputStream extends OutputStream {
    private final SessionOutputBuffer buffer;
    private boolean closed;
    private final OutputStream outputStream;

    public IdentityOutputStream(SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream) {
        this.buffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.outputStream = (OutputStream) Args.notNull(outputStream, "Output stream");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.buffer.flush(this.outputStream);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.buffer.flush(this.outputStream);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        this.buffer.write(bArr, i, i2, this.outputStream);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        this.buffer.write(i, this.outputStream);
    }
}
