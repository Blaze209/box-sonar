package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.ValueAtQuantile;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableValueAtQuantile implements ValueAtQuantile {
    public static ValueAtQuantile create(double d, double d2) {
        return new AutoValue_ImmutableValueAtQuantile(d, d2);
    }

    ImmutableValueAtQuantile() {
    }
}
