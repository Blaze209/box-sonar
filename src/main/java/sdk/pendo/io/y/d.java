package sdk.pendo.io.y;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends InputStream {
    private static final Queue<d> c = l.a(0);
    private InputStream a;
    private IOException b;

    d() {
    }

    public IOException a() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    public void b() {
        this.b = null;
        this.a = null;
        Queue<d> queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.a.skip(j);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public static d a(InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = c;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.b(inputStream);
        return dVarPoll;
    }

    void b(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
