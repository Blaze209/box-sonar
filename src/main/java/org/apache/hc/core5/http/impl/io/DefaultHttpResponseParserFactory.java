package org.apache.hc.core5.http.impl.io;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.HttpMessageParser;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.message.LazyLaxLineParser;
import org.apache.hc.core5.http.message.LineParser;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<ClassicHttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final Http1Config http1Config;
    private final LineParser lineParser;
    private final HttpResponseFactory<ClassicHttpResponse> responseFactory;

    public DefaultHttpResponseParserFactory(Http1Config http1Config, LineParser lineParser, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineParser = lineParser == null ? LazyLaxLineParser.INSTANCE : lineParser;
        this.responseFactory = httpResponseFactory == null ? DefaultClassicHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this(null, lineParser, httpResponseFactory);
    }

    public DefaultHttpResponseParserFactory(Http1Config http1Config) {
        this(http1Config, null, null);
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageParserFactory
    @Deprecated
    public HttpMessageParser<ClassicHttpResponse> create(Http1Config http1Config) {
        return new DefaultHttpResponseParser(http1Config, this.lineParser, this.responseFactory);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageParserFactory
    public HttpMessageParser<ClassicHttpResponse> create() {
        return new DefaultHttpResponseParser(this.http1Config, this.lineParser, this.responseFactory);
    }
}
