package sdk.pendo.io.actions;

import sdk.pendo.io.models.StepSeen;

/* JADX INFO: loaded from: classes4.dex */
public final class StepSeenManager implements StepSeenManagerInterface {
    private static volatile StepSeenManager INSTANCE;
    private static final Object LOCK = new Object();
    private StepSeen mCurrentStepSeen = null;
    private StepSeen mPreviousStepSeen = null;
    private boolean mIsBackwardsStep = false;
    private boolean mIsLaunchGuideFromGuideStep = false;
    private boolean misBannerGuideStep = false;

    private StepSeenManager() {
    }

    public static synchronized StepSeenManagerInterface getInstance() {
        StepSeenManager stepSeenManager;
        StepSeenManager stepSeenManager2;
        stepSeenManager = INSTANCE;
        if (stepSeenManager == null) {
            synchronized (LOCK) {
                stepSeenManager2 = INSTANCE;
                if (stepSeenManager2 == null) {
                    stepSeenManager2 = new StepSeenManager();
                    INSTANCE = stepSeenManager2;
                }
            }
            stepSeenManager = stepSeenManager2;
        }
        return stepSeenManager;
    }

    private void setPreviousStepSeen(StepSeen stepSeen) {
        this.mPreviousStepSeen = stepSeen;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public String getCurrentStepGuideId() {
        StepSeen stepSeen = this.mCurrentStepSeen;
        if (stepSeen != null) {
            return stepSeen.getGuideId();
        }
        return null;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public String getCurrentStepId() {
        StepSeen stepSeen = this.mCurrentStepSeen;
        if (stepSeen != null) {
            return stepSeen.getStepId();
        }
        return null;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public Integer getCurrentStepIndex() {
        StepSeen stepSeen = this.mCurrentStepSeen;
        return Integer.valueOf(stepSeen != null ? stepSeen.getStepIndex().intValue() : 0);
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public StepSeen getCurrentStepSeen() {
        return this.mCurrentStepSeen;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public Integer getPreviousStepIndex() {
        StepSeen stepSeen = this.mPreviousStepSeen;
        return Integer.valueOf(stepSeen != null ? stepSeen.getStepIndex().intValue() : 0);
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public boolean isBackwardsStep() {
        return this.mIsBackwardsStep;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public boolean isBannerGuideStep() {
        return this.misBannerGuideStep;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public boolean isLaunchGuideFromGuideStep() {
        return this.mIsLaunchGuideFromGuideStep;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public void reset() {
        this.mCurrentStepSeen = null;
        this.mPreviousStepSeen = null;
        this.mIsBackwardsStep = false;
        this.mIsLaunchGuideFromGuideStep = false;
        this.misBannerGuideStep = false;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public void setCurrentStepSeen(StepSeen stepSeen) {
        setPreviousStepSeen(this.mCurrentStepSeen);
        StepSeen stepSeen2 = this.mCurrentStepSeen;
        if (stepSeen2 == null || stepSeen2.getGuideId() == null || !this.mCurrentStepSeen.getGuideId().equals(stepSeen.getGuideId())) {
            this.mIsLaunchGuideFromGuideStep = false;
        }
        this.mCurrentStepSeen = stepSeen;
        this.mIsBackwardsStep = getCurrentStepIndex().intValue() < getPreviousStepIndex().intValue();
        this.misBannerGuideStep = false;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public void setIsBannerGuideStep(boolean z) {
        this.misBannerGuideStep = z;
    }

    @Override // sdk.pendo.io.actions.StepSeenManagerInterface
    public void setIsLaunchGuideFromGuideStep(boolean z) {
        this.mIsLaunchGuideFromGuideStep = z;
    }
}
