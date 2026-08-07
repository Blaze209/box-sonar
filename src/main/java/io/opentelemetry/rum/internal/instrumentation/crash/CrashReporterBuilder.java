package io.opentelemetry.rum.internal.instrumentation.crash;

import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CrashReporterBuilder {
    final List<AttributesExtractor<CrashDetails, Void>> additionalExtractors = new ArrayList();

    CrashReporterBuilder() {
    }

    public CrashReporterBuilder addAttributesExtractor(AttributesExtractor<CrashDetails, Void> attributesExtractor) {
        this.additionalExtractors.add(attributesExtractor);
        return this;
    }

    public CrashReporter build() {
        return new CrashReporter(this);
    }
}
