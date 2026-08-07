package io.split.android.client.service.impressions.strategy;

/* JADX INFO: loaded from: classes4.dex */
public final class ImpressionStrategyConfig {
    private final long mDedupeTimeIntervalInMs;
    private final long mImpressionsChunkSize;
    private final int mImpressionsCounterRefreshRate;
    private final int mImpressionsQueueSize;
    private final int mImpressionsRefreshRate;
    private final int mUniqueKeysRefreshRate;
    private final boolean mUserConsentIsGranted;

    public ImpressionStrategyConfig(int impressionsQueueSize, long impressionsChunkSize, int impressionsRefreshRate, int impressionsCounterRefreshRate, int uniqueKeysRefreshRate, boolean userConsentIsGranted, long dedupeTimeIntervalInMs) {
        this.mImpressionsQueueSize = impressionsQueueSize;
        this.mImpressionsChunkSize = impressionsChunkSize;
        this.mImpressionsRefreshRate = impressionsRefreshRate;
        this.mImpressionsCounterRefreshRate = impressionsCounterRefreshRate;
        this.mUniqueKeysRefreshRate = uniqueKeysRefreshRate;
        this.mUserConsentIsGranted = userConsentIsGranted;
        this.mDedupeTimeIntervalInMs = dedupeTimeIntervalInMs;
    }

    public int getImpressionsQueueSize() {
        return this.mImpressionsQueueSize;
    }

    public long getImpressionsChunkSize() {
        return this.mImpressionsChunkSize;
    }

    public int getImpressionsRefreshRate() {
        return this.mImpressionsRefreshRate;
    }

    public int getImpressionsCounterRefreshRate() {
        return this.mImpressionsCounterRefreshRate;
    }

    public int getUniqueKeysRefreshRate() {
        return this.mUniqueKeysRefreshRate;
    }

    public boolean isUserConsentGranted() {
        return this.mUserConsentIsGranted;
    }

    public long getDedupeTimeIntervalInMs() {
        return this.mDedupeTimeIntervalInMs;
    }
}
