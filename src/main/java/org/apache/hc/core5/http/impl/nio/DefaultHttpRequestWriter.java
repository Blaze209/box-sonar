package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.message.RequestLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriter<T extends HttpRequest> extends AbstractMessageWriter<T> {
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

    protected HttpVersion protocolVersion(T t) {
        return this.http1Config.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractMessageWriter
    public void writeHeadLine(T t, CharArrayBuffer charArrayBuffer) throws IOException {
        charArrayBuffer.clear();
        getLineFormatter().formatRequestLine(charArrayBuffer, new RequestLine(t.getMethod(), t.getRequestUri(), protocolVersion(t)));
    }
}
