package io.split.android.client.telemetry.storage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class BinarySearchLatencyTracker implements ILatencyTracker {
    private long[] latencies = new long[BUCKETS.length];
    private static final long MAX_LATENCY = 7481828;
    private static final long[] BUCKETS = {1000, 1500, 2250, 3375, 5063, 7594, 11391, 17086, 25629, 38443, 57665, 86498, 129746, 194620, 291929, 437894, 656841, 985261, 1477892, 2216838, 3325257, 4987885, MAX_LATENCY};

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void addLatencyMillis(long millis) {
        int iFindIndex = findIndex(millis * 1000);
        long[] jArr = this.latencies;
        jArr[iFindIndex] = jArr[iFindIndex] + 1;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void addLatencyMicros(long micros) {
        int iFindIndex = findIndex(micros);
        long[] jArr = this.latencies;
        jArr[iFindIndex] = jArr[iFindIndex] + 1;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long[] getLatencies() {
        return this.latencies;
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getLatency(int index) {
        return this.latencies[index];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public void clear() {
        this.latencies = new long[BUCKETS.length];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getBucketForLatencyMillis(long latency) {
        return this.latencies[findIndex(latency * 1000)];
    }

    @Override // io.split.android.client.telemetry.storage.ILatencyTracker
    public long getBucketForLatencyMicros(long latency) {
        return this.latencies[findIndex(latency)];
    }

    private int findIndex(long micros) {
        if (micros > MAX_LATENCY) {
            return BUCKETS.length - 1;
        }
        int iBinarySearch = Arrays.binarySearch(BUCKETS, micros);
        return iBinarySearch < 0 ? -(iBinarySearch + 1) : iBinarySearch;
    }
}
