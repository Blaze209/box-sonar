package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.message.RequestLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<ClassicHttpRequest> {
    private final Http1Config http1Config;

    public DefaultHttpRequestWriter(Http1Config http1Config, LineFormatter lineFormatter) {
        super(lineFormatter);
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
    }

    public DefaultHttpRequestWriter(LineFormatter lineFormatter) {
        this(null, lineFormatter);
    }

    public DefaultHttpRequestWriter() {
        this(null, null);
    }

    protected HttpVersion protocolVersion(HttpRequest httpRequest) {
        return this.http1Config.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.io.AbstractMessageWriter
    public void writeHeadLine(ClassicHttpRequest classicHttpRequest, CharArrayBuffer charArrayBuffer) throws IOException {
        getLineFormatter().formatRequestLine(charArrayBuffer, new RequestLine(classicHttpRequest.getMethod(), classicHttpRequest.getRequestUri(), protocolVersion(classicHttpRequest)));
    }
}
