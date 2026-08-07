package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LazyLineParser;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.nio.NHttpMessageParser;
import org.apache.hc.core5.http.nio.NHttpMessageParserFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParserFactory implements NHttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final Http1Config http1Config;
    private final LineParser lineParser;
    private final HttpRequestFactory<HttpRequest> requestFactory;

    public DefaultHttpRequestParserFactory(Http1Config http1Config, HttpRequestFactory<HttpRequest> httpRequestFactory, LineParser lineParser) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.requestFactory = httpRequestFactory == null ? DefaultHttpRequestFactory.INSTANCE : httpRequestFactory;
        this.lineParser = lineParser == null ? LazyLineParser.INSTANCE : lineParser;
    }

    public DefaultHttpRequestParserFactory(Http1Config http1Config) {
        this(http1Config, null, null);
    }

    public DefaultHttpRequestParserFactory() {
        this(null);
    }

    @Override // org.apache.hc.core5.http.nio.NHttpMessageParserFactory
    public NHttpMessageParser<HttpRequest> create() {
        return new DefaultHttpRequestParser(this.http1Config, this.lineParser, this.requestFactory);
    }
}
