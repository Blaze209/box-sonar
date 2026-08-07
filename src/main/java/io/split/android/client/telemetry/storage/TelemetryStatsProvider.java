package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.Stats;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryStatsProvider {
    void clearStats();

    Stats getTelemetryStats();
}
