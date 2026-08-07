package io.opentelemetry.sdk.metrics.internal.instrument;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundDoubleUpDownCounter {
    void add(double d);

    void add(double d, Context context);

    void unbind();
}
