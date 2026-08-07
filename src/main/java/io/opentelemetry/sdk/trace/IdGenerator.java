package io.opentelemetry.sdk.trace;

/* JADX INFO: loaded from: classes4.dex */
public interface IdGenerator {
    String generateSpanId();

    String generateTraceId();

    static IdGenerator random() {
        return RandomIdGenerator.INSTANCE;
    }
}
