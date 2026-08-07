package io.split.android.client.service.impressions;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionManagerConfig {
    private final long mImpressionsChunkSize;
    private final long mImpressionsCounterRefreshRate;
    private final Mode mImpressionsMode;
    private final int mImpressionsQueueSize;
    private final long mImpressionsRefreshRate;
    private final long mUniqueKeysRefreshRate;

    public ImpressionManagerConfig(long impressionsRefreshRate, long impressionsCounterRefreshRate, ImpressionsMode impressionsMode, int impressionsQueueSize, long impressionsChunkSize, long uniqueKeysRefreshRate) {
        this(impressionsRefreshRate, impressionsCounterRefreshRate, Mode.fromImpressionMode(impressionsMode), impressionsQueueSize, impressionsChunkSize, uniqueKeysRefreshRate);
    }

    public ImpressionManagerConfig(long impressionsRefreshRate, long impressionsCounterRefreshRate, Mode impressionsMode, int impressionsQueueSize, long impressionsChunkSize, long uniqueKeysRefreshRate) {
        this.mImpressionsRefreshRate = impressionsRefreshRate;
        this.mImpressionsCounterRefreshRate = impressionsCounterRefreshRate;
        this.mImpressionsMode = impressionsMode;
        this.mImpressionsQueueSize = impressionsQueueSize;
        this.mImpressionsChunkSize = impressionsChunkSize;
        this.mUniqueKeysRefreshRate = uniqueKeysRefreshRate;
    }

    public long getImpressionsRefreshRate() {
        return this.mImpressionsRefreshRate;
    }

    public long getImpressionsCounterRefreshRate() {
        return this.mImpressionsCounterRefreshRate;
    }

    public Mode getImpressionsMode() {
        return this.mImpressionsMode;
    }

    public int getImpressionsQueueSize() {
        return this.mImpressionsQueueSize;
    }

    public long getImpressionsChunkSize() {
        return this.mImpressionsChunkSize;
    }

    public long getUniqueKeysRefreshRate() {
        return this.mUniqueKeysRefreshRate;
    }

    public enum Mode {
        OPTIMIZED,
        DEBUG,
        NONE;

        public static Mode fromImpressionMode(ImpressionsMode mode) {
            if (mode == ImpressionsMode.DEBUG) {
                return DEBUG;
            }
            if (mode == ImpressionsMode.NONE) {
                return NONE;
            }
            return OPTIMIZED;
        }

        public boolean isDebug() {
            return this == DEBUG;
        }

        public boolean isNone() {
            return this == NONE;
        }

        public boolean isOptimized() {
            return this == OPTIMIZED;
        }
    }
}
