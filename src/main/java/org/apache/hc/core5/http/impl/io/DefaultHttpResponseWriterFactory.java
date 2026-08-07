package org.apache.hc.core5.http.impl.io;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.HttpMessageWriter;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.message.LineFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<ClassicHttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final Http1Config http1Config;
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory(Http1Config http1Config, LineFormatter lineFormatter) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    public DefaultHttpResponseWriterFactory(Http1Config http1Config) {
        this(http1Config, null);
    }

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter) {
        this(null, lineFormatter);
    }

    public DefaultHttpResponseWriterFactory() {
        this(null, null);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<ClassicHttpResponse> create() {
        return new DefaultHttpResponseWriter(this.http1Config, this.lineFormatter);
    }
}
