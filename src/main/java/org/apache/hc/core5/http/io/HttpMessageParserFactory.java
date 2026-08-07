package org.apache.hc.core5.http.io;

import org.apache.hc.core5.http.MessageHeaders;
import org.apache.hc.core5.http.config.Http1Config;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageParserFactory<T extends MessageHeaders> {
    @Deprecated
    HttpMessageParser<T> create(Http1Config http1Config);

    default HttpMessageParser<T> create() {
        return create(Http1Config.DEFAULT);
    }
}
