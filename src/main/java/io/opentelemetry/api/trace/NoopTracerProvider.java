package io.opentelemetry.api.trace;

/* JADX INFO: loaded from: classes4.dex */
public class NoopTracerProvider {
    public static TracerProvider getInstance() {
        return DefaultTracerProvider.getInstance();
    }
}
