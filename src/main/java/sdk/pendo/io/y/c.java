package sdk.pendo.io.y;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends FilterInputStream {
    private final long a;
    private int b;

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
            return i;
        }
        if (this.a - ((long) this.b) <= 0) {
            return i;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.a - ((long) this.b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i;
        i = super.read();
        a(i >= 0 ? 1 : -1);
        return i;
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }
}
