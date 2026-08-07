package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParser<T extends HttpResponse> extends AbstractMessageParser<T> {
    private final HttpResponseFactory<T> responseFactory;

    public DefaultHttpResponseParser(Http1Config http1Config, LineParser lineParser, HttpResponseFactory<T> httpResponseFactory) {
        super(http1Config, lineParser);
        this.responseFactory = (HttpResponseFactory) Args.notNull(httpResponseFactory, "Response factory");
    }

    public DefaultHttpResponseParser(Http1Config http1Config, HttpResponseFactory<T> httpResponseFactory) {
        this(http1Config, (LineParser) null, httpResponseFactory);
    }

    @Deprecated
    public DefaultHttpResponseParser(HttpResponseFactory<T> httpResponseFactory, LineParser lineParser, Http1Config http1Config) {
        this(http1Config, lineParser, httpResponseFactory);
    }

    @Deprecated
    public DefaultHttpResponseParser(HttpResponseFactory<T> httpResponseFactory, Http1Config http1Config) {
        this(httpResponseFactory, (LineParser) null, http1Config);
    }

    public DefaultHttpResponseParser(HttpResponseFactory<T> httpResponseFactory) {
        this((Http1Config) null, (LineParser) null, httpResponseFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractMessageParser
    public T createMessage(CharArrayBuffer charArrayBuffer) throws HttpException {
        StatusLine statusLine = getLineParser().parseStatusLine(charArrayBuffer);
        T t = (T) this.responseFactory.newHttpResponse(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        t.setVersion(statusLine.getProtocolVersion());
        return t;
    }
}
