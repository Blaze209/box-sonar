package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface BoundStorageHandle {
    void recordDouble(double d, Attributes attributes, Context context);

    void recordLong(long j, Attributes attributes, Context context);

    void release();
}
