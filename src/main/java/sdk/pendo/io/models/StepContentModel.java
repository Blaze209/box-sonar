package sdk.pendo.io.models;

import java.util.List;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
public class StepContentModel {

    @c("carouselId")
    private String mCarouselId;

    @c("guideId")
    private String mGuideId;

    @c(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME)
    private String mGuideStepId;

    @c("pollTypes")
    private List<String> mPollTypes;

    @c(GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE)
    private StepGuideModel mStepGuideModel;

    public String getCarouselId() {
        return this.mCarouselId;
    }

    public String getGuideId() {
        return this.mGuideId;
    }

    public String getGuideStepId() {
        return this.mGuideStepId;
    }

    public List<String> getPollTypes() {
        return this.mPollTypes;
    }

    public StepGuideModel getStepModel() {
        return this.mStepGuideModel;
    }

    public void setGuideId(String str) {
        this.mGuideId = str;
    }

    public void setGuideStepId(String str) {
        this.mGuideStepId = str;
    }

    public void setStepContentModel(StepGuideModel stepGuideModel) {
        this.mStepGuideModel = stepGuideModel;
    }
}
