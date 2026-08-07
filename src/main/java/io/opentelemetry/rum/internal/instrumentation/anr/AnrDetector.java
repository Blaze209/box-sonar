package io.opentelemetry.rum.internal.instrumentation.anr;

import android.os.Handler;
import android.os.Looper;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor;
import io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class AnrDetector {
    private final List<AttributesExtractor<StackTraceElement[], Void>> additionalExtractors;
    private final Looper mainLooper;
    private final ScheduledExecutorService scheduler;

    public static AnrDetector create() {
        return builder().build();
    }

    public static AnrDetectorBuilder builder() {
        return new AnrDetectorBuilder();
    }

    AnrDetector(AnrDetectorBuilder anrDetectorBuilder) {
        this.additionalExtractors = anrDetectorBuilder.additionalExtractors;
        this.mainLooper = anrDetectorBuilder.mainLooper;
        this.scheduler = anrDetectorBuilder.scheduler;
    }

    public void installOn(InstrumentedApplication instrumentedApplication) {
        AnrDetectorToggler anrDetectorToggler = new AnrDetectorToggler(new AnrWatcher(new Handler(this.mainLooper), this.mainLooper.getThread(), buildAnrInstrumenter(instrumentedApplication.getOpenTelemetrySdk())), this.scheduler);
        anrDetectorToggler.onApplicationForegrounded();
        instrumentedApplication.registerApplicationStateListener(anrDetectorToggler);
    }

    private Instrumenter<StackTraceElement[], Void> buildAnrInstrumenter(OpenTelemetry openTelemetry) {
        return Instrumenter.builder(openTelemetry, "io.opentelemetry.anr", new SpanNameExtractor() { // from class: io.opentelemetry.rum.internal.instrumentation.anr.AnrDetector$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
            public final String extract(Object obj) {
                return TelemetryLogger.ANR;
            }
        }).setSpanStatusExtractor(new SpanStatusExtractor() { // from class: io.opentelemetry.rum.internal.instrumentation.anr.AnrDetector$$ExternalSyntheticLambda1
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor
            public final void extract(SpanStatusBuilder spanStatusBuilder, Object obj, Object obj2, Throwable th) {
                spanStatusBuilder.setStatus(StatusCode.ERROR);
            }
        }).addAttributesExtractor(new StackTraceFormatter()).addAttributesExtractors(this.additionalExtractors).buildInstrumenter();
    }
}
