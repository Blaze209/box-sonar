package org.apache.commons.io.output;

import androidx.collection.SieveCacheKt;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.count = 0L;
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    protected synchronized void beforeWrite(int i) {
        this.count += (long) i;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= SieveCacheKt.NodeLinkMask) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public int resetCount() {
        long jResetByteCount = resetByteCount();
        if (jResetByteCount <= SieveCacheKt.NodeLinkMask) {
            return (int) jResetByteCount;
        }
        throw new ArithmeticException("The byte count " + jResetByteCount + " is too large to be converted to an int");
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }
}
