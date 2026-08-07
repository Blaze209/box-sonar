package io.split.android.client.service.telemetry;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryTaskFactory {
    TelemetryConfigRecorderTask getTelemetryConfigRecorderTask();

    TelemetryStatsRecorderTask getTelemetryStatsRecorderTask();
}
