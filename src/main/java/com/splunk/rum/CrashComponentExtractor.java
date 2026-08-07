package com.splunk.rum;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.rum.internal.instrumentation.crash.CrashDetails;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class CrashComponentExtractor implements AttributesExtractor<CrashDetails, Void> {
    private final AtomicBoolean crashHappened = new AtomicBoolean(false);

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, CrashDetails crashDetails, Void r4, Throwable th) {
    }

    CrashComponentExtractor() {
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, CrashDetails crashDetails) {
        String str;
        if (this.crashHappened.compareAndSet(false, true)) {
            str = "crash";
        } else {
            str = "error";
        }
        attributesBuilder.put(SplunkRum.COMPONENT_KEY, str);
    }
}
