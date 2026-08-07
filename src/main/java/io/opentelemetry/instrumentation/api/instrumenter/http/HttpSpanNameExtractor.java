package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final HttpCommonAttributesGetter<REQUEST, ?> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter) {
        return new HttpSpanNameExtractor(httpCommonAttributesGetter);
    }

    private HttpSpanNameExtractor(HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter) {
        this.getter = httpCommonAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public String extract(REQUEST request) {
        String strExtractRoute = extractRoute(request);
        if (strExtractRoute != null) {
            return strExtractRoute;
        }
        String strMethod = this.getter.method(request);
        if (strMethod != null) {
            return "HTTP " + strMethod;
        }
        return "HTTP request";
    }

    @Nullable
    private String extractRoute(REQUEST request) {
        HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter = this.getter;
        if (httpCommonAttributesGetter instanceof HttpServerAttributesGetter) {
            return ((HttpServerAttributesGetter) httpCommonAttributesGetter).route(request);
        }
        return null;
    }
}
