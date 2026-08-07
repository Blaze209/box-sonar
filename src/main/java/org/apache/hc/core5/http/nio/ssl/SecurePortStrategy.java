package org.apache.hc.core5.http.nio.ssl;

import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface SecurePortStrategy {
    boolean isSecure(SocketAddress socketAddress);
}
