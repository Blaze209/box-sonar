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
public class ClientHttp1IOEventHandlerFactory implements IOEventHandlerFactory {
    private final Timeout handshakeTimeout;
    private final ClientHttp1StreamDuplexerFactory streamDuplexerFactory;
    private final TlsStrategy tlsStrategy;

    public ClientHttp1IOEventHandlerFactory(ClientHttp1StreamDuplexerFactory clientHttp1StreamDuplexerFactory, TlsStrategy tlsStrategy, Timeout timeout) {
        this.streamDuplexerFactory = (ClientHttp1StreamDuplexerFactory) Args.notNull(clientHttp1StreamDuplexerFactory, "Stream duplexer factory");
        this.tlsStrategy = tlsStrategy;
        this.handshakeTimeout = timeout;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // org.apache.hc.core5.reactor.IOEventHandlerFactory
    public IOEventHandler createHandler(ProtocolIOSession protocolIOSession, Object obj) {
        ProtocolIOSession protocolIOSession2;
        if (obj instanceof EndpointParameters) {
            EndpointParameters endpointParameters = (EndpointParameters) obj;
            if (this.tlsStrategy == null || !URIScheme.HTTPS.same(endpointParameters.getScheme())) {
                protocolIOSession2 = protocolIOSession;
            } else {
                protocolIOSession2 = protocolIOSession;
                this.tlsStrategy.upgrade(protocolIOSession2, endpointParameters, endpointParameters.getAttachment(), this.handshakeTimeout, null);
            }
        } else {
            protocolIOSession2 = protocolIOSession;
        }
        return new ClientHttp1IOEventHandler(this.streamDuplexerFactory.create(protocolIOSession2));
    }
}
