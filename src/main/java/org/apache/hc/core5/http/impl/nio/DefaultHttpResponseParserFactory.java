package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LazyLaxLineParser;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.nio.NHttpMessageParser;
import org.apache.hc.core5.http.nio.NHttpMessageParserFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParserFactory implements NHttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final Http1Config http1Config;
    private final LineParser lineParser;
    private final HttpResponseFactory<HttpResponse> responseFactory;

    public DefaultHttpResponseParserFactory(Http1Config http1Config, HttpResponseFactory<HttpResponse> httpResponseFactory, LineParser lineParser) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.lineParser = lineParser == null ? LazyLaxLineParser.INSTANCE : lineParser;
    }

    public DefaultHttpResponseParserFactory(Http1Config http1Config) {
        this(http1Config, null, null);
    }

    public DefaultHttpResponseParserFactory() {
        this(null);
    }

    @Override // org.apache.hc.core5.http.nio.NHttpMessageParserFactory
    public NHttpMessageParser<HttpResponse> create() {
        return new DefaultHttpResponseParser(this.http1Config, this.lineParser, this.responseFactory);
    }
}
