package io.split.android.client.telemetry.storage;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryInitConsumer {
    long getActiveFactories();

    long getNonReadyUsage();

    long getRedundantFactories();

    long getTimeUntilReady();

    long getTimeUntilReadyFromCache();
}
