package com.microsoft.identity.common.java.telemetry.relay;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public interface ITelemetryEventFilter<T> {
    @Nullable
    T apply(T t);
}
