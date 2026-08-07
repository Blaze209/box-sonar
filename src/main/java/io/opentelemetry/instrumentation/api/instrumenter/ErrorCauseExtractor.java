package io.opentelemetry.instrumentation.api.instrumenter;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface ErrorCauseExtractor {
    Throwable extract(Throwable th);

    static ErrorCauseExtractor getDefault() {
        return DefaultErrorCauseExtractor.INSTANCE;
    }
}
