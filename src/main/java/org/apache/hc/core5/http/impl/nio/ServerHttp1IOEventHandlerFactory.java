package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.reactor.EndpointParameters;
import org.apache.hc.core5.reactor.IOEventHandler;
import org.apache.hc.core5.reactor.IOEventHandlerFactory;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class ServerHttp1IOEventHandlerFactory implements IOEventHandlerFactory {
    private final Timeout handshakeTimeout;
    private final ServerHttp1StreamDuplexerFactory streamDuplexerFactory;
    private final TlsStrategy tlsStrategy;

    public ServerHttp1IOEventHandlerFactory(ServerHttp1StreamDuplexerFactory serverHttp1StreamDuplexerFactory, TlsStrategy tlsStrategy, Timeout timeout) {
        this.streamDuplexerFactory = (ServerHttp1StreamDuplexerFactory) Args.notNull(serverHttp1StreamDuplexerFactory, "Stream duplexer factory");
        this.tlsStrategy = tlsStrategy;
        this.handshakeTimeout = timeout;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003a A[PHI: r0
      0x003a: PHI (r0v2 java.lang.String) = (r0v1 java.lang.String), (r0v6 java.lang.String) binds: [B:3:0x0006, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.apache.hc.core5.reactor.IOEventHandlerFactory
    public IOEventHandler createHandler(ProtocolIOSession protocolIOSession, Object obj) {
        ProtocolIOSession protocolIOSession2;
        String scheme = URIScheme.HTTP.id;
        if (this.tlsStrategy == null) {
            protocolIOSession2 = protocolIOSession;
        } else if (obj instanceof EndpointParameters) {
            EndpointParameters endpointParameters = (EndpointParameters) obj;
            scheme = endpointParameters.getScheme();
            if (URIScheme.HTTPS.same(scheme)) {
                protocolIOSession2 = protocolIOSession;
                this.tlsStrategy.upgrade(protocolIOSession2, endpointParameters, endpointParameters.getAttachment(), this.handshakeTimeout, null);
            } else {
                protocolIOSession2 = protocolIOSession;
            }
        } else {
            protocolIOSession2 = protocolIOSession;
            scheme = URIScheme.HTTPS.id;
            this.tlsStrategy.upgrade(protocolIOSession2, null, obj, this.handshakeTimeout, null);
        }
        return new ServerHttp1IOEventHandler(this.streamDuplexerFactory.create(scheme, protocolIOSession2));
    }
}
