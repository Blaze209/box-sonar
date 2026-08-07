package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParser extends AbstractMessageParser<ClassicHttpResponse> {
    private final HttpResponseFactory<ClassicHttpResponse> responseFactory;

    public DefaultHttpResponseParser(Http1Config http1Config, LineParser lineParser, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        super(http1Config, lineParser);
        this.responseFactory = httpResponseFactory == null ? DefaultClassicHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    @Deprecated
    public DefaultHttpResponseParser(LineParser lineParser, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory, Http1Config http1Config) {
        this(http1Config, lineParser, httpResponseFactory);
    }

    public DefaultHttpResponseParser(Http1Config http1Config) {
        this(http1Config, (LineParser) null, (HttpResponseFactory<ClassicHttpResponse>) null);
    }

    public DefaultHttpResponseParser() {
        this(Http1Config.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.io.AbstractMessageParser
    public ClassicHttpResponse createMessage(CharArrayBuffer charArrayBuffer) throws HttpException, IOException {
        StatusLine statusLine = getLineParser().parseStatusLine(charArrayBuffer);
        ClassicHttpResponse classicHttpResponse = (ClassicHttpResponse) this.responseFactory.newHttpResponse(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        classicHttpResponse.setVersion(statusLine.getProtocolVersion());
        return classicHttpResponse;
    }
}
