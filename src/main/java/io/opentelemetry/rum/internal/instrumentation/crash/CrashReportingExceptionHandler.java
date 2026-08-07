package io.opentelemetry.rum.internal.instrumentation.crash;

import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class CrashReportingExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler existingHandler;
    private final Instrumenter<CrashDetails, Void> instrumenter;
    private final SdkTracerProvider sdkTracerProvider;

    CrashReportingExceptionHandler(Instrumenter<CrashDetails, Void> instrumenter, SdkTracerProvider sdkTracerProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.instrumenter = instrumenter;
        this.sdkTracerProvider = sdkTracerProvider;
        this.existingHandler = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        reportCrash(thread, th);
        this.sdkTracerProvider.forceFlush().join(10L, TimeUnit.SECONDS);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.existingHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void reportCrash(Thread thread, Throwable th) {
        CrashDetails crashDetailsCreate = CrashDetails.create(thread, th);
        this.instrumenter.end(this.instrumenter.start(Context.current(), crashDetailsCreate), crashDetailsCreate, null, th);
    }
}
