package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.nio.NHttpMessageParserFactory;
import org.apache.hc.core5.http.nio.NHttpMessageWriterFactory;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class ClientHttp1StreamDuplexerFactory {
    private final CharCodingConfig charCodingConfig;
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final NHttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final NHttpMessageParserFactory<HttpResponse> responseParserFactory;
    private final Http1StreamListener streamListener;

    public ClientHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParserFactory<HttpResponse> nHttpMessageParserFactory, NHttpMessageWriterFactory<HttpRequest> nHttpMessageWriterFactory, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, Http1StreamListener http1StreamListener) {
        this.httpProcessor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        this.charCodingConfig = charCodingConfig == null ? CharCodingConfig.DEFAULT : charCodingConfig;
        this.connectionReuseStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseParserFactory = nHttpMessageParserFactory == null ? new DefaultHttpResponseParserFactory(http1Config) : nHttpMessageParserFactory;
        this.requestWriterFactory = nHttpMessageWriterFactory == null ? new DefaultHttpRequestWriterFactory(http1Config) : nHttpMessageWriterFactory;
        this.incomingContentStrategy = contentLengthStrategy == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy2;
        this.streamListener = http1StreamListener;
    }

    public ClientHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParserFactory<HttpResponse> nHttpMessageParserFactory, NHttpMessageWriterFactory<HttpRequest> nHttpMessageWriterFactory, Http1StreamListener http1StreamListener) {
        this(httpProcessor, http1Config, charCodingConfig, connectionReuseStrategy, nHttpMessageParserFactory, nHttpMessageWriterFactory, null, null, http1StreamListener);
    }

    public ClientHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, Http1Config http1Config, CharCodingConfig charCodingConfig, Http1StreamListener http1StreamListener) {
        this(httpProcessor, http1Config, charCodingConfig, null, null, null, http1StreamListener);
    }

    public ClientHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, Http1Config http1Config, CharCodingConfig charCodingConfig) {
        this(httpProcessor, http1Config, charCodingConfig, null);
    }

    public ClientHttp1StreamDuplexer create(ProtocolIOSession protocolIOSession) {
        return new ClientHttp1StreamDuplexer(protocolIOSession, this.httpProcessor, this.http1Config, this.charCodingConfig, this.connectionReuseStrategy, this.responseParserFactory.create(), this.requestWriterFactory.create(), this.incomingContentStrategy, this.outgoingContentStrategy, this.streamListener);
    }
}
