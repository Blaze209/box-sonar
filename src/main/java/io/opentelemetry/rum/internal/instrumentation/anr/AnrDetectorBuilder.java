package io.opentelemetry.rum.internal.instrumentation.anr;

import android.os.Looper;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class AnrDetectorBuilder {
    final List<AttributesExtractor<StackTraceElement[], Void>> additionalExtractors = new ArrayList();
    Looper mainLooper = Looper.getMainLooper();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    AnrDetectorBuilder() {
    }

    public AnrDetectorBuilder addAttributesExtractor(AttributesExtractor<StackTraceElement[], Void> attributesExtractor) {
        this.additionalExtractors.add(attributesExtractor);
        return this;
    }

    public AnrDetectorBuilder setMainLooper(Looper looper) {
        this.mainLooper = looper;
        return this;
    }

    AnrDetectorBuilder setScheduler(ScheduledExecutorService scheduledExecutorService) {
        this.scheduler = scheduledExecutorService;
        return this;
    }

    public AnrDetector build() {
        return new AnrDetector(this);
    }
}
