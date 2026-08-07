package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedRequestHeaders = Collections.emptyList();
    List<String> capturedResponseHeaders = Collections.emptyList();
    final HttpServerAttributesGetter<REQUEST, RESPONSE> httpAttributesGetter;
    final NetServerAttributesGetter<REQUEST> netAttributesGetter;

    HttpServerAttributesExtractorBuilder(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        this.httpAttributesGetter = httpServerAttributesGetter;
        this.netAttributesGetter = netServerAttributesGetter;
    }

    public HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedRequestHeaders(List<String> list) {
        this.capturedRequestHeaders = list;
        return this;
    }

    public HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedResponseHeaders(List<String> list) {
        this.capturedResponseHeaders = list;
        return this;
    }

    public HttpServerAttributesExtractor<REQUEST, RESPONSE> build() {
        return new HttpServerAttributesExtractor<>(this.httpAttributesGetter, this.netAttributesGetter, this.capturedRequestHeaders, this.capturedResponseHeaders);
    }
}
