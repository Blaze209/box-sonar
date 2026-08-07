package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface WriteableMetricStorage {
    BoundStorageHandle bind(Attributes attributes);

    default void recordLong(long j, Attributes attributes, Context context) {
        BoundStorageHandle boundStorageHandleBind = bind(attributes);
        try {
            boundStorageHandleBind.recordLong(j, attributes, context);
        } finally {
            boundStorageHandleBind.release();
        }
    }

    default void recordDouble(double d, Attributes attributes, Context context) {
        BoundStorageHandle boundStorageHandleBind = bind(attributes);
        try {
            boundStorageHandleBind.recordDouble(d, attributes, context);
        } finally {
            boundStorageHandleBind.release();
        }
    }
}
