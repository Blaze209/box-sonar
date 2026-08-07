package sdk.pendo.io.models;

import sdk.pendo.io.a0.f;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public class AnalyticsConfigurationModel {

    @c("bufferDuration")
    private int mBufferDuration;

    @c("bufferQueueSize")
    private int mBufferQueueSize;

    @c("immediateEvents")
    private f mImmediateEventsArray;

    @c("includeFeatureClickNestedTexts")
    private boolean mIncludeFeatureClickNestedTexts;

    @c("includeFeatureClickTexts")
    private boolean mIncludeFeatureClickTexts;

    @c("includePageViewTexts")
    private boolean mIncludePageViewTexts;

    @c("includeRetroElementCompatibilityHashes")
    private boolean mIncludeRetroElementCompatibilityHashes;

    @c("maxStorageSizeMB")
    private float mMaxStorageSizeMB;

    @c("isOldScreenIdFormat")
    private boolean mIsOldScreenIdFormat = true;

    @c("ignoreDynamicFragmentsInScrollView")
    private boolean mIgnoreDynamicFragmentsInScrollView = true;

    @c("isRespondToScrollChangeEventsForScreenId")
    private boolean mIsRespondToScrollChangeEventsForScreenId = false;

    @c("globalLayoutChangeDebouncer")
    private Long mGlobalLayoutChangeDebouncer = 100L;

    @c("disableMobileAccessibilityClickDetection")
    private boolean mDisableMobileAccessibilityClickDetection = true;

    public int getBufferDuration() {
        return this.mBufferDuration;
    }

    public int getBufferQueueSize() {
        return this.mBufferQueueSize;
    }

    public f getImmediateEventsArray() {
        return this.mImmediateEventsArray;
    }

    public float getMaxStoragesizeMB() {
        return this.mMaxStorageSizeMB;
    }

    public Long globalLayoutChangeDebouncer() {
        return this.mGlobalLayoutChangeDebouncer;
    }

    public boolean isIgnoreDynamicFragmentsInScrollView() {
        return this.mIgnoreDynamicFragmentsInScrollView;
    }

    public boolean isIncludeFeatureClickNestedTexts() {
        return this.mIncludeFeatureClickNestedTexts;
    }

    public boolean isIncludeFeatureClickTexts() {
        return this.mIncludeFeatureClickTexts;
    }

    public boolean isIncludePageViewTexts() {
        return this.mIncludePageViewTexts;
    }

    public boolean isIncludeRetroElementCompatibilityHashes() {
        return this.mIncludeRetroElementCompatibilityHashes;
    }

    public boolean isOldScreenIdFormat() {
        return this.mIsOldScreenIdFormat;
    }

    public boolean isRespondToScrollChangeEventsForScreenId() {
        return this.mIsRespondToScrollChangeEventsForScreenId;
    }

    public boolean isShouldDetectClicksForAccessibility() {
        return !this.mDisableMobileAccessibilityClickDetection;
    }
}
