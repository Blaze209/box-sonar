package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedRequestHeaders = Collections.emptyList();
    List<String> capturedResponseHeaders = Collections.emptyList();
    final HttpClientAttributesGetter<REQUEST, RESPONSE> httpAttributesGetter;
    final NetClientAttributesGetter<REQUEST, RESPONSE> netAttributesGetter;

    HttpClientAttributesExtractorBuilder(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter, NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        this.httpAttributesGetter = httpClientAttributesGetter;
        this.netAttributesGetter = netClientAttributesGetter;
    }

    public HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedRequestHeaders(List<String> list) {
        this.capturedRequestHeaders = list;
        return this;
    }

    public HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedResponseHeaders(List<String> list) {
        this.capturedResponseHeaders = list;
        return this;
    }

    public HttpClientAttributesExtractor<REQUEST, RESPONSE> build() {
        return new HttpClientAttributesExtractor<>(this.httpAttributesGetter, this.netAttributesGetter, this.capturedRequestHeaders, this.capturedResponseHeaders);
    }
}
