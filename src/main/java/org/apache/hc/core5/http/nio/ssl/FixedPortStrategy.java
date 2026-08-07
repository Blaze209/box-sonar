package org.apache.hc.core5.http.nio.ssl;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class FixedPortStrategy implements SecurePortStrategy {
    private final int[] securePorts;

    public FixedPortStrategy(int... iArr) {
        this.securePorts = (int[]) Args.notNull(iArr, "Secure ports");
    }

    @Override // org.apache.hc.core5.http.nio.ssl.SecurePortStrategy
    public boolean isSecure(SocketAddress socketAddress) {
        int port = ((InetSocketAddress) socketAddress).getPort();
        for (int i : this.securePorts) {
            if (port == i) {
                return true;
            }
        }
        return false;
    }
}
