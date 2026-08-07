package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private final SessionInputBuffer buffer;
    private boolean closed;
    private final long contentLength;
    private final InputStream inputStream;
    private long pos;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, InputStream inputStream, long j) {
        this.buffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.inputStream = (InputStream) Args.notNull(inputStream, "Input stream");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            if (this.pos < this.contentLength) {
                do {
                } while (read(new byte[2048]) >= 0);
            }
        } finally {
            this.closed = true;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return Math.min(this.buffer.length(), (int) (this.contentLength - this.pos));
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        if (this.pos >= this.contentLength) {
            return -1;
        }
        int i = this.buffer.read(this.inputStream);
        if (i != -1) {
            this.pos++;
            return i;
        }
        if (this.pos >= this.contentLength) {
            return i;
        }
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %d; received: %d)", Long.valueOf(this.contentLength), Long.valueOf(this.pos));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        if (i2 == 0) {
            return 0;
        }
        long j = this.pos;
        long j2 = this.contentLength;
        if (j >= j2) {
            return -1;
        }
        if (((long) i2) + j > j2) {
            i2 = (int) (j2 - j);
        }
        int i3 = this.buffer.read(bArr, i, i2, this.inputStream);
        if (i3 == -1 && this.pos < this.contentLength) {
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %d; received: %d)", Long.valueOf(this.contentLength), Long.valueOf(this.pos));
        }
        if (i3 > 0) {
            this.pos += (long) i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        if (j <= 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long jMin = Math.min(j, this.contentLength - this.pos);
        long j2 = 0;
        while (jMin > 0 && (i = read(bArr, 0, (int) Math.min(2048L, jMin))) != -1) {
            long j3 = i;
            j2 += j3;
            jMin -= j3;
        }
        return j2;
    }
}
