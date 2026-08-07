package sdk.pendo.io.models;

import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public class LastStepSeenConfigurationModel {

    @c("guideId")
    private String mGuideId;

    @c(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME)
    private String mGuideStepId;

    @c("time")
    private long mTime;

    public String getGuideId() {
        return this.mGuideId;
    }

    public String getGuideStepId() {
        return this.mGuideStepId;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }
}
