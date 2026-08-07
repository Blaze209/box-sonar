package io.split.android.client.telemetry.storage;

/* JADX INFO: loaded from: classes4.dex */
interface ILatencyTracker {
    void addLatencyMicros(long micros);

    void addLatencyMillis(long millis);

    void clear();

    long getBucketForLatencyMicros(long latency);

    long getBucketForLatencyMillis(long latency);

    long[] getLatencies();

    long getLatency(int index);
}
