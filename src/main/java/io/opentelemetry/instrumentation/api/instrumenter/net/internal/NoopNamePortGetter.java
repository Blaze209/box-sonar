package io.opentelemetry.instrumentation.api.instrumenter.net.internal;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
enum NoopNamePortGetter implements FallbackNamePortGetter<Object> {
    INSTANCE;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter
    @Nullable
    public String name(Object obj) {
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter
    @Nullable
    public Integer port(Object obj) {
        return null;
    }
}
