package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractorBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientMetrics;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpSpanNameExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpSpanStatusExtractor;
import io.opentelemetry.instrumentation.okhttp.v3_0.internal.OkHttpNetAttributesGetter;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpTelemetryBuilder {
    private static final String INSTRUMENTATION_NAME = "io.opentelemetry.okhttp-3.0";
    private final List<AttributesExtractor<Request, Response>> additionalExtractors = new ArrayList();
    private final HttpClientAttributesExtractorBuilder<Request, Response> httpAttributesExtractorBuilder = HttpClientAttributesExtractor.builder(OkHttpAttributesGetter.INSTANCE, new OkHttpNetAttributesGetter());
    private final OpenTelemetry openTelemetry;

    OkHttpTelemetryBuilder(OpenTelemetry openTelemetry) {
        this.openTelemetry = openTelemetry;
    }

    public OkHttpTelemetryBuilder addAttributesExtractor(AttributesExtractor<Request, Response> attributesExtractor) {
        this.additionalExtractors.add(attributesExtractor);
        return this;
    }

    public OkHttpTelemetryBuilder setCapturedRequestHeaders(List<String> list) {
        this.httpAttributesExtractorBuilder.setCapturedRequestHeaders(list);
        return this;
    }

    public OkHttpTelemetryBuilder setCapturedResponseHeaders(List<String> list) {
        this.httpAttributesExtractorBuilder.setCapturedResponseHeaders(list);
        return this;
    }

    public OkHttpTelemetry build() {
        OkHttpAttributesGetter okHttpAttributesGetter = OkHttpAttributesGetter.INSTANCE;
        return new OkHttpTelemetry(Instrumenter.builder(this.openTelemetry, INSTRUMENTATION_NAME, HttpSpanNameExtractor.create(okHttpAttributesGetter)).setSpanStatusExtractor(HttpSpanStatusExtractor.create(okHttpAttributesGetter)).addAttributesExtractor(this.httpAttributesExtractorBuilder.build()).addAttributesExtractors(this.additionalExtractors).addOperationMetrics(HttpClientMetrics.get()).buildInstrumenter(SpanKindExtractor.alwaysClient()), this.openTelemetry.getPropagators());
    }
}
