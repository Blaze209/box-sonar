package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundLongCounter {
    void add(long j);

    void add(long j, Context context);

    void unbind();
}
