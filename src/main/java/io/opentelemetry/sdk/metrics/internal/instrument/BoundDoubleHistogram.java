package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundDoubleHistogram {
    void record(double d);

    void record(double d, Context context);

    void unbind();
}
