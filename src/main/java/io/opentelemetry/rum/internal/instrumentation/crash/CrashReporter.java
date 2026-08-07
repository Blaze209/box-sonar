package io.opentelemetry.rum.internal.instrumentation.crash;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CrashReporter {
    private final List<AttributesExtractor<CrashDetails, Void>> additionalExtractors;

    public static CrashReporter create() {
        return builder().build();
    }

    public static CrashReporterBuilder builder() {
        return new CrashReporterBuilder();
    }

    CrashReporter(CrashReporterBuilder crashReporterBuilder) {
        this.additionalExtractors = crashReporterBuilder.additionalExtractors;
    }

    public void installOn(InstrumentedApplication instrumentedApplication) {
        Thread.setDefaultUncaughtExceptionHandler(new CrashReportingExceptionHandler(buildInstrumenter(instrumentedApplication.getOpenTelemetrySdk()), instrumentedApplication.getOpenTelemetrySdk().getSdkTracerProvider(), Thread.getDefaultUncaughtExceptionHandler()));
    }

    private Instrumenter<CrashDetails, Void> buildInstrumenter(OpenTelemetry openTelemetry) {
        return Instrumenter.builder(openTelemetry, "io.opentelemetry.crash", new SpanNameExtractor() { // from class: io.opentelemetry.rum.internal.instrumentation.crash.CrashReporter$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
            public final String extract(Object obj) {
                return ((CrashDetails) obj).spanName();
            }
        }).addAttributesExtractor(new CrashDetailsAttributesExtractor()).addAttributesExtractors(this.additionalExtractors).buildInstrumenter();
    }
}
