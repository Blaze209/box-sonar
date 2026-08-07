package com.microsoft.intune.mam.client.telemetry;

/* JADX INFO: loaded from: classes3.dex */
public interface TelemetryCache {
    void clearCache();

    boolean shouldLogEvent(String str, long j);
}
