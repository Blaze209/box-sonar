package org.apache.hc.core5.http;

import java.io.IOException;
import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnection extends SocketModalCloseable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    EndpointDetails getEndpointDetails();

    SocketAddress getLocalAddress();

    ProtocolVersion getProtocolVersion();

    SocketAddress getRemoteAddress();

    SSLSession getSSLSession();

    boolean isOpen();
}
