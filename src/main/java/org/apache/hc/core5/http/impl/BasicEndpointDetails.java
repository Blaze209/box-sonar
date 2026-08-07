package org.apache.hc.core5.http.impl;

import java.net.SocketAddress;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpConnectionMetrics;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class BasicEndpointDetails extends EndpointDetails {
    private final HttpConnectionMetrics metrics;

    public BasicEndpointDetails(SocketAddress socketAddress, SocketAddress socketAddress2, HttpConnectionMetrics httpConnectionMetrics, Timeout timeout) {
        super(socketAddress, socketAddress2, timeout);
        this.metrics = httpConnectionMetrics;
    }

    @Override // org.apache.hc.core5.http.EndpointDetails, org.apache.hc.core5.http.HttpConnectionMetrics
    public long getRequestCount() {
        HttpConnectionMetrics httpConnectionMetrics = this.metrics;
        if (httpConnectionMetrics != null) {
            return httpConnectionMetrics.getRequestCount();
        }
        return 0L;
    }

    @Override // org.apache.hc.core5.http.EndpointDetails, org.apache.hc.core5.http.HttpConnectionMetrics
    public long getResponseCount() {
        HttpConnectionMetrics httpConnectionMetrics = this.metrics;
        if (httpConnectionMetrics != null) {
            return httpConnectionMetrics.getResponseCount();
        }
        return 0L;
    }

    @Override // org.apache.hc.core5.http.EndpointDetails, org.apache.hc.core5.http.HttpConnectionMetrics
    public long getSentBytesCount() {
        HttpConnectionMetrics httpConnectionMetrics = this.metrics;
        if (httpConnectionMetrics != null) {
            return httpConnectionMetrics.getSentBytesCount();
        }
        return 0L;
    }

    @Override // org.apache.hc.core5.http.EndpointDetails, org.apache.hc.core5.http.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        HttpConnectionMetrics httpConnectionMetrics = this.metrics;
        if (httpConnectionMetrics != null) {
            return httpConnectionMetrics.getReceivedBytesCount();
        }
        return 0L;
    }
}
