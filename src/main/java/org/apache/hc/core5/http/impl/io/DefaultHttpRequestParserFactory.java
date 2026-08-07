package org.apache.hc.core5.http.impl.io;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.HttpMessageParser;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.message.LazyLineParser;
import org.apache.hc.core5.http.message.LineParser;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<ClassicHttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final Http1Config http1Config;
    private final LineParser lineParser;
    private final HttpRequestFactory<ClassicHttpRequest> requestFactory;

    public DefaultHttpRequestParserFactory(Http1Config http1Config, LineParser lineParser, HttpRequestFactory<ClassicHttpRequest> httpRequestFactory) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineParser = lineParser == null ? LazyLineParser.INSTANCE : lineParser;
        this.requestFactory = httpRequestFactory == null ? DefaultClassicHttpRequestFactory.INSTANCE : httpRequestFactory;
    }

    public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory<ClassicHttpRequest> httpRequestFactory) {
        this(null, lineParser, httpRequestFactory);
    }

    public DefaultHttpRequestParserFactory(Http1Config http1Config) {
        this(http1Config, null, null);
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageParserFactory
    @Deprecated
    public HttpMessageParser<ClassicHttpRequest> create(Http1Config http1Config) {
        return new DefaultHttpRequestParser(http1Config, this.lineParser, this.requestFactory);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageParserFactory
    public HttpMessageParser<ClassicHttpRequest> create() {
        return new DefaultHttpRequestParser(this.http1Config, this.lineParser, this.requestFactory);
    }
}
