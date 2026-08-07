package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ContentLengthOutputStream extends OutputStream {
    private final SessionOutputBuffer buffer;
    private boolean closed;
    private final long contentLength;
    private final OutputStream outputStream;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream, long j) {
        this.buffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.outputStream = (OutputStream) Args.notNull(outputStream, "Output stream");
        this.contentLength = Args.notNegative(j, "Content length");
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
        long j = this.total;
        long j2 = this.contentLength;
        if (j < j2) {
            long j3 = j2 - j;
            if (i2 > j3) {
                i2 = (int) j3;
            }
            this.buffer.write(bArr, i, i2, this.outputStream);
            this.total += (long) i2;
        }
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
        if (this.total < this.contentLength) {
            this.buffer.write(i, this.outputStream);
            this.total++;
        }
    }
}
