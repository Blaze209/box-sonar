package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.nio.NHttpMessageWriter;
import org.apache.hc.core5.http.nio.NHttpMessageWriterFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriterFactory implements NHttpMessageWriterFactory<HttpRequest> {
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

    @Override // org.apache.hc.core5.http.nio.NHttpMessageWriterFactory
    public NHttpMessageWriter<HttpRequest> create() {
        return new DefaultHttpRequestWriter(this.http1Config, this.lineFormatter);
    }
}
