package org.apache.hc.core5.http.impl;

import java.net.InetSocketAddress;
import org.apache.hc.core5.function.Resolver;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.URIScheme;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultAddressResolver implements Resolver<HttpHost, InetSocketAddress> {
    public static final DefaultAddressResolver INSTANCE = new DefaultAddressResolver();

    @Override // org.apache.hc.core5.function.Resolver
    public InetSocketAddress resolve(HttpHost httpHost) {
        if (httpHost == null) {
            return null;
        }
        int port = httpHost.getPort();
        if (port < 0) {
            String schemeName = httpHost.getSchemeName();
            if (URIScheme.HTTP.same(schemeName)) {
                port = 80;
            } else if (URIScheme.HTTPS.same(schemeName)) {
                port = 443;
            }
        }
        if (httpHost.getAddress() != null) {
            return new InetSocketAddress(httpHost.getAddress(), port);
        }
        return new InetSocketAddress(httpHost.getHostName(), port);
    }
}
