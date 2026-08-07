package org.apache.hc.core5.http.impl.io;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.HttpMessageWriter;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.message.LineFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<ClassicHttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
    private final Http1Config http1Config;
    private final LineFormatter lineFormatter;

    public DefaultHttpRequestWriterFactory(Http1Config http1Config, LineFormatter lineFormatter) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    public DefaultHttpRequestWriterFactory(Http1Config http1Config) {
        this(http1Config, null);
    }

    public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter) {
        this(null, lineFormatter);
    }

    public DefaultHttpRequestWriterFactory() {
        this(null, null);
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<ClassicHttpRequest> create() {
        return new DefaultHttpRequestWriter(this.http1Config, this.lineFormatter);
    }
}
