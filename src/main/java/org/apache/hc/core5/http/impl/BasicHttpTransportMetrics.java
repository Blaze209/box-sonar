package org.apache.hc.core5.http.impl;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.hc.core5.http.io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpTransportMetrics implements HttpTransportMetrics {
    private final AtomicLong bytesTransferred = new AtomicLong(0);

    @Override // org.apache.hc.core5.http.io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred.get();
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred.addAndGet(j);
    }
}
