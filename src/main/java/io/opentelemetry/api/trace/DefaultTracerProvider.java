package io.opentelemetry.api.trace;

/* JADX INFO: loaded from: classes4.dex */
class DefaultTracerProvider implements TracerProvider {
    private static final TracerProvider INSTANCE = new DefaultTracerProvider();

    static TracerProvider getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str) {
        return DefaultTracer.getInstance();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str, String str2) {
        return DefaultTracer.getInstance();
    }

    private DefaultTracerProvider() {
    }
}
