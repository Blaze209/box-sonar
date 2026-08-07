package com.microsoft.identity.common.java.eststelemetry;

import com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry;

/* JADX INFO: loaded from: classes14.dex */
public interface IRequestTelemetryCache<T extends IRequestTelemetry> {
    void clear();

    T getRequestTelemetryFromCache();

    void saveRequestTelemetryToCache(T t);
}
