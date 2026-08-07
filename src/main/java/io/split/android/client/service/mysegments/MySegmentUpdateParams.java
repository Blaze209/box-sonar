package io.split.android.client.service.mysegments;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentUpdateParams {
    private final Long mSyncDelay;
    private final Long mTargetLargeSegmentsCn;
    private final Long mTargetSegmentsCn;

    public MySegmentUpdateParams(Long syncDelay, Long targetSegmentsCn, Long targetLargeSegmentsCn) {
        this.mSyncDelay = syncDelay;
        this.mTargetSegmentsCn = targetSegmentsCn;
        this.mTargetLargeSegmentsCn = targetLargeSegmentsCn;
    }

    public Long getSyncDelay() {
        return this.mSyncDelay;
    }

    public Long getTargetSegmentsCn() {
        return this.mTargetSegmentsCn;
    }

    public Long getTargetLargeSegmentsCn() {
        return this.mTargetLargeSegmentsCn;
    }
}
