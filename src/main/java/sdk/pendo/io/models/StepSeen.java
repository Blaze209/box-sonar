package sdk.pendo.io.models;

/* JADX INFO: loaded from: classes4.dex */
public final class StepSeen {
    private String mGuideId;
    private boolean mIsGuideSeenAnalyticSent = false;
    private final String mStepId;
    private final Integer mStepIndex;

    public StepSeen(String str, String str2, Integer num) {
        this.mGuideId = str;
        this.mStepId = str2;
        this.mStepIndex = num;
    }

    public String getGuideId() {
        return this.mGuideId;
    }

    public String getStepId() {
        return this.mStepId;
    }

    public Integer getStepIndex() {
        Integer num = this.mStepIndex;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public boolean isGuideSeenAnalyticSent() {
        return this.mIsGuideSeenAnalyticSent;
    }

    public void setGuideId(String str) {
        this.mGuideId = str;
    }

    public void setGuideSeenAnalyticSent(boolean z) {
        this.mIsGuideSeenAnalyticSent = z;
    }
}
