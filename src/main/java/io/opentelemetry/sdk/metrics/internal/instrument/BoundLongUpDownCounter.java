package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundLongUpDownCounter {
    void add(long j);

    void add(long j, Context context);

    void unbind();
}
