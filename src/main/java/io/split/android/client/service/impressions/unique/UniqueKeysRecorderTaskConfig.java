package io.split.android.client.service.impressions.unique;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKeysRecorderTaskConfig {
    private final int mElementsPerPush;
    private final long mEstimatedSizeInBytes;

    public UniqueKeysRecorderTaskConfig(int elementsPerPush, long estimatedSizeInByes) {
        this.mElementsPerPush = elementsPerPush;
        this.mEstimatedSizeInBytes = estimatedSizeInByes;
    }

    public int getElementsPerPush() {
        return this.mElementsPerPush;
    }

    public long getEstimatedSizeInBytes() {
        return this.mEstimatedSizeInBytes;
    }
}
