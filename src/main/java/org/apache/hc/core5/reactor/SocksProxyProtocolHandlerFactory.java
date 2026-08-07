package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SocksProxyProtocolHandlerFactory implements IOEventHandlerFactory {
    private final IOEventHandlerFactory eventHandlerFactory;
    private final String password;
    private final InetSocketAddress targetAddress;
    private final String username;

    public SocksProxyProtocolHandlerFactory(SocketAddress socketAddress, String str, String str2, IOEventHandlerFactory iOEventHandlerFactory) throws IOException {
        this.eventHandlerFactory = iOEventHandlerFactory;
        this.username = str;
        this.password = str2;
        if (socketAddress instanceof InetSocketAddress) {
            this.targetAddress = (InetSocketAddress) socketAddress;
            return;
        }
        throw new IOException("Unsupported target address type for SOCKS proxy connection: " + socketAddress.getClass());
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandlerFactory
    public IOEventHandler createHandler(ProtocolIOSession protocolIOSession, Object obj) {
        throw new UnsupportedOperationException();
    }
}
