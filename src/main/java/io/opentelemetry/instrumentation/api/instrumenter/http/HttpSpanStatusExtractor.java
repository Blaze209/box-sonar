package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpSpanStatusExtractor<REQUEST, RESPONSE> implements SpanStatusExtractor<REQUEST, RESPONSE> {
    private final HttpCommonAttributesGetter<? super REQUEST, ? super RESPONSE> getter;
    private final HttpStatusConverter statusConverter;

    public static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> create(HttpClientAttributesGetter<? super REQUEST, ? super RESPONSE> httpClientAttributesGetter) {
        return new HttpSpanStatusExtractor(httpClientAttributesGetter, HttpStatusConverter.CLIENT);
    }

    public static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> create(HttpServerAttributesGetter<? super REQUEST, ? super RESPONSE> httpServerAttributesGetter) {
        return new HttpSpanStatusExtractor(httpServerAttributesGetter, HttpStatusConverter.SERVER);
    }

    private HttpSpanStatusExtractor(HttpCommonAttributesGetter<? super REQUEST, ? super RESPONSE> httpCommonAttributesGetter, HttpStatusConverter httpStatusConverter) {
        this.getter = httpCommonAttributesGetter;
        this.statusConverter = httpStatusConverter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor
    public void extract(SpanStatusBuilder spanStatusBuilder, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        Integer numStatusCode;
        StatusCode statusCodeStatusFromHttpStatus;
        if (response != null && (numStatusCode = this.getter.statusCode(request, response, th)) != null && (statusCodeStatusFromHttpStatus = this.statusConverter.statusFromHttpStatus(numStatusCode.intValue())) == StatusCode.ERROR) {
            spanStatusBuilder.setStatus(statusCodeStatusFromHttpStatus);
        } else {
            SpanStatusExtractor.getDefault().extract(spanStatusBuilder, request, response, th);
        }
    }
}
