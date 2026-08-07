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
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.NHttpMessageParserFactory;
import org.apache.hc.core5.http.nio.NHttpMessageWriterFactory;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerHttp1StreamDuplexerFactory {
    private final CharCodingConfig charCodingConfig;
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final HandlerFactory<AsyncServerExchangeHandler> exchangeHandlerFactory;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final NHttpMessageParserFactory<HttpRequest> requestParserFactory;
    private final NHttpMessageWriterFactory<HttpResponse> responseWriterFactory;
    private final Http1StreamListener streamListener;

    public ServerHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, HandlerFactory<AsyncServerExchangeHandler> handlerFactory, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParserFactory<HttpRequest> nHttpMessageParserFactory, NHttpMessageWriterFactory<HttpResponse> nHttpMessageWriterFactory, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, Http1StreamListener http1StreamListener) {
        this.httpProcessor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.exchangeHandlerFactory = (HandlerFactory) Args.notNull(handlerFactory, "Exchange handler factory");
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        this.charCodingConfig = charCodingConfig == null ? CharCodingConfig.DEFAULT : charCodingConfig;
        this.connectionReuseStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.requestParserFactory = nHttpMessageParserFactory == null ? new DefaultHttpRequestParserFactory(http1Config) : nHttpMessageParserFactory;
        this.responseWriterFactory = nHttpMessageWriterFactory == null ? new DefaultHttpResponseWriterFactory(http1Config) : nHttpMessageWriterFactory;
        this.incomingContentStrategy = contentLengthStrategy == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy2;
        this.streamListener = http1StreamListener;
    }

    public ServerHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, HandlerFactory<AsyncServerExchangeHandler> handlerFactory, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParserFactory<HttpRequest> nHttpMessageParserFactory, NHttpMessageWriterFactory<HttpResponse> nHttpMessageWriterFactory, Http1StreamListener http1StreamListener) {
        this(httpProcessor, handlerFactory, http1Config, charCodingConfig, connectionReuseStrategy, nHttpMessageParserFactory, nHttpMessageWriterFactory, null, null, http1StreamListener);
    }

    public ServerHttp1StreamDuplexerFactory(HttpProcessor httpProcessor, HandlerFactory<AsyncServerExchangeHandler> handlerFactory, Http1Config http1Config, CharCodingConfig charCodingConfig, Http1StreamListener http1StreamListener) {
        this(httpProcessor, handlerFactory, http1Config, charCodingConfig, null, null, null, http1StreamListener);
    }

    public ServerHttp1StreamDuplexer create(String str, ProtocolIOSession protocolIOSession) {
        return new ServerHttp1StreamDuplexer(protocolIOSession, this.httpProcessor, this.exchangeHandlerFactory, str, this.http1Config, this.charCodingConfig, this.connectionReuseStrategy, this.requestParserFactory.create(), this.responseWriterFactory.create(), this.incomingContentStrategy, this.outgoingContentStrategy, this.streamListener);
    }
}
