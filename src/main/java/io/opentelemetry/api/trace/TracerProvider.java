package io.opentelemetry.api.trace;

/* JADX INFO: loaded from: classes4.dex */
public interface TracerProvider {
    Tracer get(String str);

    Tracer get(String str, String str2);

    static TracerProvider noop() {
        return DefaultTracerProvider.getInstance();
    }

    default TracerBuilder tracerBuilder(String str) {
        return DefaultTracerBuilder.getInstance();
    }
}
