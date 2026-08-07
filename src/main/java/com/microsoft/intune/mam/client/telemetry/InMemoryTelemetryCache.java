package com.microsoft.intune.mam.client.telemetry;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class InMemoryTelemetryCache implements TelemetryCache {
    private static final ConcurrentHashMap<String, Long> LAST_LOGGED_MAP = new ConcurrentHashMap<>();

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryCache
    public boolean shouldLogEvent(String str, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> concurrentHashMap = LAST_LOGGED_MAP;
        if (concurrentHashMap.containsKey(str) && jCurrentTimeMillis < j + concurrentHashMap.get(str).longValue()) {
            return false;
        }
        concurrentHashMap.put(str, Long.valueOf(jCurrentTimeMillis));
        return true;
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryCache
    public void clearCache() {
        LAST_LOGGED_MAP.clear();
    }
}
