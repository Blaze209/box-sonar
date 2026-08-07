package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<ClassicHttpResponse> {
    private final Http1Config http1Config;

    public DefaultHttpResponseWriter(Http1Config http1Config, LineFormatter lineFormatter) {
        super(lineFormatter);
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
    }

    public DefaultHttpResponseWriter(LineFormatter lineFormatter) {
        this(null, lineFormatter);
    }

    public DefaultHttpResponseWriter() {
        this(null, null);
    }

    protected HttpVersion protocolVersion(HttpResponse httpResponse) {
        return this.http1Config.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.io.AbstractMessageWriter
    public void writeHeadLine(ClassicHttpResponse classicHttpResponse, CharArrayBuffer charArrayBuffer) throws IOException {
        getLineFormatter().formatStatusLine(charArrayBuffer, new StatusLine(protocolVersion(classicHttpResponse), classicHttpResponse.getCode(), classicHttpResponse.getReasonPhrase()));
    }
}
