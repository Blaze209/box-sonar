package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityInputStream extends InputStream {
    private final SessionInputBuffer buffer;
    private boolean closed;
    private final InputStream inputStream;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer, InputStream inputStream) {
        this.buffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.inputStream = (InputStream) Args.notNull(inputStream, "Input stream");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.closed) {
            return 0;
        }
        int length = this.buffer.length();
        return length > 0 ? length : this.inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        return this.buffer.read(this.inputStream);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        if (i2 == 0) {
            return 0;
        }
        return this.buffer.read(bArr, i, i2, this.inputStream);
    }
}
