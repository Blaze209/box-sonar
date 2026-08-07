package com.microsoft.identity.common.java.telemetry.observers;

import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public interface ITelemetryAggregatedObserver extends ITelemetryObserver<Map<String, String>> {
    @Override // com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver
    void onReceived(Map<String, String> map);
}
