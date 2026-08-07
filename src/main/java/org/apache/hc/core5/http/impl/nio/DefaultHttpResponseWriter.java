package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseWriter<T extends HttpResponse> extends AbstractMessageWriter<T> {
    private final Http1Config http1Config;

    public DefaultHttpResponseWriter(LineFormatter lineFormatter, Http1Config http1Config) {
        super(lineFormatter);
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
    }

    public DefaultHttpResponseWriter(LineFormatter lineFormatter) {
        this(lineFormatter, null);
    }

    public DefaultHttpResponseWriter() {
        this(null, null);
    }

    protected HttpVersion protocolVersion(T t) {
        return this.http1Config.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractMessageWriter
    public void writeHeadLine(T t, CharArrayBuffer charArrayBuffer) throws IOException {
        charArrayBuffer.clear();
        getLineFormatter().formatStatusLine(charArrayBuffer, new StatusLine(protocolVersion(t), t.getCode(), t.getReasonPhrase()));
    }
}
