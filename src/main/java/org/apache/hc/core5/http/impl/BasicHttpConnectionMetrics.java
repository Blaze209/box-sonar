package org.apache.hc.core5.http.impl;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.hc.core5.http.HttpConnectionMetrics;
import org.apache.hc.core5.http.io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes5.dex */
public final class BasicHttpConnectionMetrics implements HttpConnectionMetrics {
    private final HttpTransportMetrics inTransportMetric;
    private final HttpTransportMetrics outTransportMetric;
    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong responseCount = new AtomicLong(0);

    public BasicHttpConnectionMetrics(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        this.inTransportMetric = httpTransportMetrics;
        this.outTransportMetric = httpTransportMetrics2;
    }

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.inTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public long getSentBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.outTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public long getRequestCount() {
        return this.requestCount.get();
    }

    public void incrementRequestCount() {
        this.requestCount.incrementAndGet();
    }

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public long getResponseCount() {
        return this.responseCount.get();
    }

    public void incrementResponseCount() {
        this.responseCount.incrementAndGet();
    }
}
