package org.apache.http.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public final class NetUtils {
    public static void formatAddress(StringBuilder sb, SocketAddress socketAddress) {
        Object hostAddress;
        Args.notNull(sb, "Buffer");
        Args.notNull(socketAddress, "Socket address");
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                hostAddress = address;
                hostAddress = address.getHostAddress();
            }
            hostAddress = address;
            sb.append(hostAddress).append(AbstractJsonLexerKt.COLON).append(inetSocketAddress.getPort());
            return;
        }
        sb.append(socketAddress);
    }
}
