package io.split.android.client.service.impressions;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionUtils {
    public static long truncateTimeframe(long timestampInMs, long defaultTimeIntervalMs) {
        return timestampInMs - (timestampInMs % defaultTimeIntervalMs);
    }
}
