package io.split.android.client.service.impressions;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsRecorderTaskConfig {
    private final long estimatedSizeInBytes;
    private final int impressionsPerPush;
    private final boolean shouldRecordTelemetry;

    public ImpressionsRecorderTaskConfig(int impressionsPerPush, long estimatedSizeInBytes, boolean shouldRecordTelemetry) {
        this.impressionsPerPush = impressionsPerPush;
        this.estimatedSizeInBytes = estimatedSizeInBytes;
        this.shouldRecordTelemetry = shouldRecordTelemetry;
    }

    public int getImpressionsPerPush() {
        return this.impressionsPerPush;
    }

    public long getEstimatedSizeInBytes() {
        return this.estimatedSizeInBytes;
    }

    public boolean shouldRecordTelemetry() {
        return this.shouldRecordTelemetry;
    }
}
