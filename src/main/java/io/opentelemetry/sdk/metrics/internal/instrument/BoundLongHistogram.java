package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundLongHistogram {
    void record(long j);

    void record(long j, Context context);

    void unbind();
}
