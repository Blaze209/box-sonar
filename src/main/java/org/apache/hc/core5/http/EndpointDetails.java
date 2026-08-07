package org.apache.hc.core5.http;

import java.net.SocketAddress;
import org.apache.hc.core5.net.InetAddressUtils;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EndpointDetails implements HttpConnectionMetrics {
    private final SocketAddress localAddress;
    private final SocketAddress remoteAddress;
    private final Timeout socketTimeout;

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public abstract long getReceivedBytesCount();

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public abstract long getRequestCount();

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public abstract long getResponseCount();

    @Override // org.apache.hc.core5.http.HttpConnectionMetrics
    public abstract long getSentBytesCount();

    protected EndpointDetails(SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout) {
        this.remoteAddress = socketAddress;
        this.localAddress = socketAddress2;
        this.socketTimeout = timeout;
    }

    public SocketAddress getRemoteAddress() {
        return this.remoteAddress;
    }

    public SocketAddress getLocalAddress() {
        return this.localAddress;
    }

    public Timeout getSocketTimeout() {
        return this.socketTimeout;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(90);
        InetAddressUtils.formatAddress(sb, this.localAddress);
        sb.append("<->");
        InetAddressUtils.formatAddress(sb, this.remoteAddress);
        return sb.toString();
    }
}
