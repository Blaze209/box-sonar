package io.split.android.client.service.sseclient.notifications.mysegments;

import io.split.android.client.service.sseclient.notifications.HashingAlgorithm;
import io.split.android.client.service.sseclient.notifications.MySegmentUpdateStrategy;
import io.split.android.client.utils.MurmurHash3;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class SyncDelayCalculatorImpl implements SyncDelayCalculator {
    public static final long DEFAULT_SYNC_INTERVAL_MS = TimeUnit.SECONDS.toMillis(60);

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.SyncDelayCalculator
    public long calculateSyncDelay(String key, Long updateIntervalMs, Integer algorithmSeed, MySegmentUpdateStrategy updateStrategy, HashingAlgorithm hashingAlgorithm) {
        if ((updateStrategy != MySegmentUpdateStrategy.UNBOUNDED_FETCH_REQUEST && updateStrategy != MySegmentUpdateStrategy.BOUNDED_FETCH_REQUEST) || hashingAlgorithm == HashingAlgorithm.NONE) {
            return 0L;
        }
        if (updateIntervalMs == null || updateIntervalMs.longValue() <= 0) {
            updateIntervalMs = Long.valueOf(DEFAULT_SYNC_INTERVAL_MS);
        }
        if (algorithmSeed == null) {
            algorithmSeed = 0;
        }
        return MurmurHash3.murmurhash3_x86_32(key, 0, key.length(), algorithmSeed.intValue()) % updateIntervalMs.longValue();
    }
}
