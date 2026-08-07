package io.split.android.client.telemetry.storage;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryInitProducer {
    void recordActiveFactories(int count);

    void recordNonReadyUsage();

    void recordRedundantFactories(int count);

    void recordTimeUntilReady(long time);

    void recordTimeUntilReadyFromCache(long timeUntilReadyFromCache);
}
