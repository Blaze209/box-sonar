package io.opentelemetry.instrumentation.api.internal;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface SpanKeyProvider {
    @Nullable
    SpanKey internalGetSpanKey();
}
