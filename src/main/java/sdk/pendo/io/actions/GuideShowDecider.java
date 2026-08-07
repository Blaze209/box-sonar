package sdk.pendo.io.actions;

import sdk.pendo.io.a0.f;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideConfigurationModel;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.o6.a;
import sdk.pendo.io.s7.j;

/* JADX INFO: loaded from: classes4.dex */
public class GuideShowDecider implements GuideShowDeciderInterface {
    private static volatile GuideShowDecider INSTANCE = null;
    public static final String TAG = "GuideShowDecider";

    public static synchronized GuideShowDeciderInterface getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GuideShowDecider();
        }
        return INSTANCE;
    }

    private boolean hasInternet() {
        if (j.a()) {
            return true;
        }
        PendoLogger.d("Not showing guide due to connectivity.", new Object[0]);
        return false;
    }

    private boolean isShowingCurrentGuide(String str) {
        return VisualGuidesManager.getInstance().isGuideShowing(str);
    }

    private boolean isWithinThrottlingInterval(GuideModel guideModel, int i) {
        GuidesConfigurationManager guidesConfigurationManager = GuidesConfigurationManager.INSTANCE;
        if (guidesConfigurationManager.getIsThrottlingEnabled() && guidesConfigurationManager.getLastSeenTimeMS() != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            StepGuideModel guideStepModel = guideModel.getGuideStepModel(i);
            GuideConfigurationModel configuration = guideStepModel != null ? guideStepModel.getConfiguration() : null;
            if ((jCurrentTimeMillis + (configuration != null ? configuration.getDelayMs() : 0L)) - guidesConfigurationManager.getLastSeenTimeMS().longValue() <= guidesConfigurationManager.getThrottlingIntervalMS()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCappingLeft(GuideModel guideModel) {
        GuideCapping capping = guideModel.getGeneralGuideConfiguration().getCapping();
        if (!capping.canConsumeOne()) {
            PendoLogger.e(TAG, "hasCappingLeft was called with canConsumeOne == false, guidId: " + guideModel.getGuideId(), (Throwable) null);
        }
        return capping.canConsumeOne();
    }

    public boolean isOngoingMultiStep(int i) {
        return i > 0 || i < StepSeenManager.getInstance().getPreviousStepIndex().intValue();
    }

    public boolean isShowingFullSizeGuide() {
        return VisualGuidesManager.getInstance().isAnyGuideDisplayed();
    }

    public boolean shouldActivateThrottlingConsideringActivation(GuideModel guideModel) {
        f activations = guideModel.getActivations();
        if (activations == null || activations.size() == 0) {
            return true;
        }
        try {
            String string = activations.iterator().next().e().a("event").toString();
            return string.contains(ActivationManager.ActivationEvents.APP_LAUNCH.getActivationEvent()) || string.contains(ActivationManager.ActivationEvents.VIEW.getActivationEvent());
        } catch (Exception unused) {
            PendoLogger.d("shouldActivateThrottlingConsideringActivation - either guideActivationsArray is empty or guide's missing an event property", new Object[0]);
            return false;
        }
    }

    @Override // sdk.pendo.io.actions.GuideShowDeciderInterface
    public boolean shouldShowGuide(GuideModel guideModel, int i) {
        if (!hasInternet()) {
            return false;
        }
        if (a.d().s() || isOngoingMultiStep(i)) {
            return true;
        }
        if (isShowingCurrentGuide(guideModel.getGuideId())) {
            return false;
        }
        if (StepSeenManager.getInstance().isLaunchGuideFromGuideStep()) {
            return true;
        }
        if (!shouldActivateThrottlingConsideringActivation(guideModel) || !isWithinThrottlingInterval(guideModel, i)) {
            return hasCappingLeft(guideModel);
        }
        StepSeenManager.getInstance().reset();
        return false;
    }
}
