package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.RequestHeaderFieldsTooLargeException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.message.RequestLine;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParser<T extends HttpRequest> extends AbstractMessageParser<T> {
    private final HttpRequestFactory<T> requestFactory;

    public DefaultHttpRequestParser(Http1Config http1Config, LineParser lineParser, HttpRequestFactory<T> httpRequestFactory) {
        super(http1Config, lineParser);
        this.requestFactory = (HttpRequestFactory) Args.notNull(httpRequestFactory, "Request factory");
    }

    public DefaultHttpRequestParser(Http1Config http1Config, HttpRequestFactory<T> httpRequestFactory) {
        this(http1Config, (LineParser) null, httpRequestFactory);
    }

    @Deprecated
    public DefaultHttpRequestParser(HttpRequestFactory<T> httpRequestFactory, Http1Config http1Config) {
        this(httpRequestFactory, (LineParser) null, http1Config);
    }

    @Deprecated
    public DefaultHttpRequestParser(HttpRequestFactory<T> httpRequestFactory, LineParser lineParser, Http1Config http1Config) {
        this(http1Config, lineParser, httpRequestFactory);
    }

    public DefaultHttpRequestParser(HttpRequestFactory<T> httpRequestFactory) {
        this((Http1Config) null, (LineParser) null, httpRequestFactory);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractMessageParser, org.apache.hc.core5.http.nio.NHttpMessageParser
    public T parse(SessionInputBuffer sessionInputBuffer, boolean z) throws HttpException, IOException {
        try {
            return (T) super.parse(sessionInputBuffer, z);
        } catch (MessageConstraintException e) {
            throw new RequestHeaderFieldsTooLargeException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractMessageParser
    public T createMessage(CharArrayBuffer charArrayBuffer) throws HttpException {
        RequestLine requestLine = getLineParser().parseRequestLine(charArrayBuffer);
        T t = (T) this.requestFactory.newHttpRequest(requestLine.getMethod(), requestLine.getUri());
        t.setVersion(requestLine.getProtocolVersion());
        return t;
    }
}
