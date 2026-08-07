package io.opentelemetry.instrumentation.api.instrumenter.net.internal;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface FallbackNamePortGetter<REQUEST> {
    @Nullable
    String name(REQUEST request);

    @Nullable
    Integer port(REQUEST request);

    static <REQUEST> FallbackNamePortGetter<REQUEST> noop() {
        return NoopNamePortGetter.INSTANCE;
    }
}
