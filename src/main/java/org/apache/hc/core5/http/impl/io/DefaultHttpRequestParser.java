package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.RequestHeaderFieldsTooLargeException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.message.RequestLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParser extends AbstractMessageParser<ClassicHttpRequest> {
    private final HttpRequestFactory<ClassicHttpRequest> requestFactory;

    public DefaultHttpRequestParser(Http1Config http1Config, LineParser lineParser, HttpRequestFactory<ClassicHttpRequest> httpRequestFactory) {
        super(http1Config, lineParser);
        this.requestFactory = httpRequestFactory == null ? DefaultClassicHttpRequestFactory.INSTANCE : httpRequestFactory;
    }

    @Deprecated
    public DefaultHttpRequestParser(LineParser lineParser, HttpRequestFactory<ClassicHttpRequest> httpRequestFactory, Http1Config http1Config) {
        this(http1Config, lineParser, httpRequestFactory);
    }

    public DefaultHttpRequestParser(Http1Config http1Config) {
        this(http1Config, (LineParser) null, (HttpRequestFactory<ClassicHttpRequest>) null);
    }

    public DefaultHttpRequestParser() {
        this(Http1Config.DEFAULT, (LineParser) null, (HttpRequestFactory<ClassicHttpRequest>) null);
    }

    @Override // org.apache.hc.core5.http.impl.io.AbstractMessageParser, org.apache.hc.core5.http.io.HttpMessageParser
    public ClassicHttpRequest parse(SessionInputBuffer sessionInputBuffer, InputStream inputStream) throws HttpException, IOException {
        try {
            return (ClassicHttpRequest) super.parse(sessionInputBuffer, inputStream);
        } catch (MessageConstraintException e) {
            throw new RequestHeaderFieldsTooLargeException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.io.AbstractMessageParser
    public ClassicHttpRequest createMessage(CharArrayBuffer charArrayBuffer) throws HttpException, IOException {
        RequestLine requestLine = getLineParser().parseRequestLine(charArrayBuffer);
        ClassicHttpRequest classicHttpRequest = (ClassicHttpRequest) this.requestFactory.newHttpRequest(requestLine.getMethod(), requestLine.getUri());
        classicHttpRequest.setVersion(requestLine.getProtocolVersion());
        return classicHttpRequest;
    }
}
