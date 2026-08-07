package sdk.pendo.io.actions;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.ActivationModel;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.s7.l0;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.t6.c;
import sdk.pendo.io.x6.g;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VisualGuideBase extends GuideModel {
    public static final String DEFAULT_ACTIVATED_BY = "";
    private static final int DEFAULT_IRRELEVANT_VALUE = -1;
    public static final String DISMISS_VISIBLE_GUIDES = "dismissVisibleGuides";
    public static final String GUIDE_STEP_ID_PARAMETER_NAME = "guideStepId";
    static final long NO_CLOSE_DELAY = 0;
    public static final String TAG = "VisualGuideBase";
    String mActivatedBy;
    WeakReference<Activity> mActivity;
    JSONObject mAdditionalInfo;
    private b mAdvanceGuideCommandSubscription;
    String mCarouselId;
    private ViewGroup mContainer;
    final sdk.pendo.io.h4.b<Object> mDestroyingSubject;
    private b mDismissGuideCommandSubscription;
    HashMap<String, GuideStepDuration> mGuideStepDurationMap;
    VisualGuideLifecycleListener mListener;
    private ViewGroup mRootView;
    AtomicBoolean mShowing;
    sdk.pendo.io.t5.b mStatusBarColorAnimation;
    protected StepSeenManagerInterface mStepSeenManager;
    VisualAnimationManager mVisualAnimationManager;
    VisualGuideType mVisualGuideType;

    public enum VisualGuideType {
        FULL_SCREEN(R.id.insert_visual_scrollview_container, R.layout.pnd_visual_insert),
        TOOLTIP(R.id.pnd_containerId, -1),
        BANNER(R.id.pnd_containerId, -1),
        CAROUSEL(R.id.pendo_view_pager_container, R.layout.pnd_view_pager);

        public final int mContainerId;
        public final int mLayoutId;

        VisualGuideType(int i, int i2) {
            this.mContainerId = i;
            this.mLayoutId = i2;
        }

        public int getContainerId() {
            return this.mContainerId;
        }

        public int getLayoutId() {
            return this.mLayoutId;
        }
    }

    VisualGuideBase(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener) {
        super(guideModel);
        this.mActivatedBy = "";
        this.mAdditionalInfo = new JSONObject();
        this.mShowing = new AtomicBoolean(false);
        this.mGuideStepDurationMap = new HashMap<>();
        this.mDestroyingSubject = sdk.pendo.io.h4.b.f();
        this.mListener = visualGuideLifecycleListener;
    }

    private void fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed() {
        VisualGuidesManager.getInstance().getIsAnyGuideDisplayedObservable().a(new j() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return VisualGuideBase.lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$0((Boolean) obj);
            }
        }).f().a(c.a(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.m16683x790b3099((Boolean) obj);
            }
        }, "VisualGuideBase is full screen guide displayed observer"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdvanceGuide(PendoCommand pendoCommand) {
        boolean zAdvanceGuide;
        if (getGuideId().equals(pendoCommand.getParamValueFromCommand("guideId"))) {
            Integer nextGuideStepIndex = getNextGuideStepIndex(pendoCommand);
            if (nextGuideStepIndex != null) {
                String guideStepId = getGuideStepId(nextGuideStepIndex.intValue());
                if (nextGuideStepIndex.intValue() >= getSteps().size() || guideStepId.equals("")) {
                    handleCapping();
                    this.mStepSeenManager.reset();
                    zAdvanceGuide = true;
                } else {
                    zAdvanceGuide = advanceGuide(pendoCommand, guideStepId, nextGuideStepIndex);
                }
            } else {
                zAdvanceGuide = true;
            }
            if (zAdvanceGuide) {
                handleHidingVisualGuide(pendoCommand);
                b bVar = this.mAdvanceGuideCommandSubscription;
                if (bVar == null || bVar.isDisposed()) {
                    return;
                }
                this.mAdvanceGuideCommandSubscription.dispose();
                this.mAdvanceGuideCommandSubscription = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDismissGuide(PendoCommand pendoCommand) {
        try {
            String paramValueFromCommand = pendoCommand.getParamValueFromCommand("guideId");
            if ((TextUtils.isEmpty(paramValueFromCommand) || !getGuideId().equals(paramValueFromCommand)) && !DISMISS_VISIBLE_GUIDES.equals(pendoCommand.getSourceId())) {
                return;
            }
            if (PendoCommandEventType.SdkEventType.TIME_OUT.equals(pendoCommand.getEventType())) {
                PendoCommandParameterInjector.getInstance().handleGuideTimeoutAnalytics(getGuideId(), getDuration());
            }
            if (PendoCommandDispatcher.PredefinedCommands.SOURCE_ID_BACK_BUTTON.equals(pendoCommand.getSourceId())) {
                handleBackButtonAction();
            }
            GuideModel guide = GuidesManager.INSTANCE.getGuide(getGuideId());
            boolean zEquals = getGuideId().equals(this.mStepSeenManager.getCurrentStepGuideId());
            if (guide != null) {
                guide.setGuideShown();
                guide.getStatusValue().terminateGuide(guide);
                changeGuideActivationAfterDismissIfNeeded(guide);
            }
            notifyClose(pendoCommand);
            if (!zEquals || !this.mStepSeenManager.isLaunchGuideFromGuideStep()) {
                handleCapping();
            }
            if (zEquals) {
                this.mStepSeenManager.reset();
            }
        } catch (Exception e) {
            PendoLogger.e("VisualGuideBase handleDismissGuide failed with command" + pendoCommand.toString() + " with error: " + e + " with message: " + e.getMessage(), new Object[0]);
        }
        handleHidingVisualGuide(pendoCommand);
        List<VisualGuideBase> showingGuides = VisualGuidesManager.getInstance().getShowingGuides();
        if (!showingGuides.isEmpty()) {
            PendoLogger.e("VisualGuideBase Guide still displayed after dismiss action logic. Displayed guides: " + showingGuides, new Object[0]);
            return;
        }
        b bVar = this.mDismissGuideCommandSubscription;
        if (bVar == null || bVar.isDisposed()) {
            return;
        }
        this.mDismissGuideCommandSubscription.dispose();
        this.mDismissGuideCommandSubscription = null;
    }

    private void handleHidingVisualGuide(PendoCommand pendoCommand) {
        hideVisualGuide(pendoCommand);
        GuidesConfigurationManager.INSTANCE.setLastSeenTimeMS(System.currentTimeMillis());
        fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed();
    }

    static /* synthetic */ boolean lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$0(Boolean bool) {
        return !bool.booleanValue();
    }

    private void notifyClose(PendoCommand pendoCommand) {
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.NOTIFY_CLOSE, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY).setSourceId(getGuideId()).setScope(pendoCommand.getScope()).setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(getGuideId())).build(), true);
    }

    private void subscribeForCommandActions() {
        this.mDismissGuideCommandSubscription = PendoGlobalCommandHandler.getInstance().getDismissGuideCommandPublisher().b(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.handleDismissGuide((PendoCommand) obj);
            }
        });
        this.mAdvanceGuideCommandSubscription = PendoGlobalCommandHandler.getInstance().getAdvanceGuideCommandPublisher().b(new e() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.handleAdvanceGuide((PendoCommand) obj);
            }
        });
    }

    protected boolean advanceGuide(PendoCommand pendoCommand, String str, Integer num) {
        notifyClose(pendoCommand);
        this.mStepSeenManager.setCurrentStepSeen(new StepSeen(getGuideId(), str, num));
        return true;
    }

    void changeGuideActivationAfterDismissIfNeeded(GuideModel guideModel) {
        StepModel guideStepModel = guideModel.getGuideStepModel(guideModel.getGuideStepId(0));
        if (guideStepModel == null || guideStepModel.getStepActivations() == null) {
            return;
        }
        for (ActivationModel activationModel : guideStepModel.getStepActivations()) {
            if (activationModel.isActivationOverriden() && ActivationManager.ActivationEvents.VIEW.getActivationEvent().equals(activationModel.getEvent()) && activationModel.getFeatureSelector() != null) {
                activationModel.setEvent(ActivationManager.ActivationEvents.CLICK.getActivationEvent());
                activationModel.setIsActivationOverridden(false);
            }
        }
    }

    void createVisualAnimationManager(StepGuideModel stepGuideModel) {
        this.mVisualAnimationManager = new VisualAnimationManager(getGuideId(), stepGuideModel.getConfiguration());
    }

    public void fireNextTrigger() {
        if (PlatformStateManager.INSTANCE.isTrackEventSolutionOnly()) {
            ActivationManager.INSTANCE.getActivationTriggerSubject().onNext(Boolean.TRUE);
        } else {
            PendoLogger.d(TAG, "EVENT -> Guide dismiss, rescan current screen");
            PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_SCREEN_CHANGED);
        }
    }

    public String getActivatedBy() {
        return this.mActivatedBy;
    }

    public final boolean getAndSetShowing(boolean z) {
        return this.mShowing.getAndSet(z);
    }

    public VisualAnimationManager getAnimationManager() {
        return this.mVisualAnimationManager;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    int getContainerId() {
        return this.mVisualGuideType.getContainerId();
    }

    public final synchronized long getDuration() {
        GuideStepDuration guideStepDuration = this.mGuideStepDurationMap.get(this.mStepSeenManager.getCurrentStepId());
        if (guideStepDuration == null) {
            return 0L;
        }
        return guideStepDuration.getDuration();
    }

    Integer getNextGuideStepIndex(PendoCommand pendoCommand) {
        Integer guideStepIndex = getGuideStepIndex(this.mStepSeenManager.getCurrentStepId());
        String parameterValue = null;
        if (guideStepIndex == null) {
            PendoLogger.w("VisualGuideBase Current guide step seen is null, not continuing to next guide", new Object[0]);
            return null;
        }
        List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
        if (parameters != null) {
            for (PendoCommandsEventBus.Parameter parameter : parameters) {
                if (parameter.getParameterName().equals(GUIDE_STEP_ID_PARAMETER_NAME)) {
                    parameterValue = parameter.getParameterValue();
                }
            }
        }
        return parameterValue != null ? getGuideStepIndex(parameterValue) : Integer.valueOf(guideStepIndex.intValue() + 1);
    }

    final ViewGroup getRootView() {
        return this.mRootView;
    }

    StepGuideModel getStepGuideModel() {
        return getGuideStepModel(this.mStepSeenManager.getCurrentStepIndex().intValue());
    }

    VisualGuideType getVisualGuideType() {
        return this.mVisualGuideType;
    }

    public void handleBackButtonAction() {
        m tracker = getTracker();
        if (tracker == null || tracker.b() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(getGuideId());
        if (visualGuide != null) {
            arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", visualGuide.getActivatedBy()));
            arrayList.add(new PendoCommandsEventBus.Parameter("displayDurationInMillis", "number", Long.toString(visualGuide.getDuration())));
            arrayList.add(new PendoCommandsEventBus.Parameter("displayDuration", "number", Long.toString(visualGuide.getDuration())));
        }
        PendoCommandParameterInjector.getInstance().addGenericParamsInjectAndDispatch(this, PendoCommandEventType.AnalyticsEventType.GUIDE_DISMISSED_BACK_BUTTON, arrayList);
        l0.e(getGuideId());
    }

    void handleCapping() {
        if (getGeneralGuideConfiguration() != null) {
            GuideCapping capping = getGeneralGuideConfiguration().getCapping();
            capping.consumeOne();
            if (capping.canConsumeOne()) {
                return;
            }
            ActivationManager.INSTANCE.removeGuideIdFromTriggers(getGuideId());
        }
    }

    public void handleGuideSeenAnalytics() {
        m tracker = getTracker();
        boolean z = false;
        if (tracker == null) {
            PendoLogger.e("VisualGuideBase handleGuideSeenAnalytics, tracker is null ", new Object[0]);
            return;
        }
        StepSeen currentStepSeen = StepSeenManager.getInstance().getCurrentStepSeen();
        if (currentStepSeen != null && currentStepSeen.isGuideSeenAnalyticSent()) {
            z = true;
        }
        if (tracker.b() == null || z) {
            return;
        }
        PendoCommandParameterInjector.getInstance().handleGuideDisplayedAnalytics(getGuideId(), this.mActivatedBy);
        if (currentStepSeen != null) {
            currentStepSeen.setGuideSeenAnalyticSent(true);
        }
    }

    void hideVisualGuide(final PendoCommand pendoCommand) {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference == null || weakReference.get() == null || this.mActivity.get().isFinishing()) {
            return;
        }
        this.mActivity.get().runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.VisualGuideBase$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m16684lambda$hideVisualGuide$2$sdkpendoioactionsVisualGuideBase(pendoCommand);
            }
        });
    }

    protected void init(String str, sdk.pendo.io.r5.g gVar) {
        this.mListener.onCreate(this);
        setTracker(i.a(gVar));
        this.mActivatedBy = str;
        subscribeForCommandActions();
    }

    protected synchronized void initializeTimeoutCounter(int i) {
    }

    public final boolean isShowing() {
        return this.mShowing.get();
    }

    /* JADX INFO: renamed from: lambda$fireNextTriggerForScreenChangeOnceNoGuideIsDisplayed$1$sdk-pendo-io-actions-VisualGuideBase, reason: not valid java name */
    /* synthetic */ void m16683x790b3099(Boolean bool) {
        fireNextTrigger();
    }

    /* JADX INFO: renamed from: lambda$hideVisualGuide$2$sdk-pendo-io-actions-VisualGuideBase, reason: not valid java name */
    /* synthetic */ void m16684lambda$hideVisualGuide$2$sdkpendoioactionsVisualGuideBase(PendoCommand pendoCommand) {
        this.mVisualAnimationManager.performHide(null, !DISMISS_VISIBLE_GUIDES.equals(pendoCommand.getSourceId()));
    }

    void onDestroy() {
    }

    protected synchronized void resetGuideStepDuration(String str) {
        GuideStepDuration guideStepDuration;
        if (this.mGuideStepDurationMap.containsKey(str) && (guideStepDuration = this.mGuideStepDurationMap.get(str)) != null) {
            guideStepDuration.reset();
        }
    }

    final void setContainerView(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    final void setRootView(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
    }

    synchronized void setStartDuration(long j) {
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        GuideStepDuration guideStepDuration = this.mGuideStepDurationMap.get(currentStepId);
        if (guideStepDuration == null) {
            guideStepDuration = new GuideStepDuration();
            this.mGuideStepDurationMap.put(currentStepId, guideStepDuration);
        }
        guideStepDuration.setStartDuration(j);
    }

    public abstract boolean show();

    void startTimeout() {
    }

    protected void unsubscribeSubscriptions() {
        b bVar = this.mDismissGuideCommandSubscription;
        if (bVar != null && !bVar.isDisposed()) {
            this.mDismissGuideCommandSubscription.dispose();
            this.mDismissGuideCommandSubscription = null;
        }
        b bVar2 = this.mAdvanceGuideCommandSubscription;
        if (bVar2 == null || bVar2.isDisposed()) {
            return;
        }
        this.mAdvanceGuideCommandSubscription.dispose();
        this.mAdvanceGuideCommandSubscription = null;
    }

    VisualGuideBase(StepGuideModel stepGuideModel, VisualGuideLifecycleListener visualGuideLifecycleListener) {
        super(stepGuideModel);
        this.mActivatedBy = "";
        this.mAdditionalInfo = new JSONObject();
        this.mShowing = new AtomicBoolean(false);
        this.mGuideStepDurationMap = new HashMap<>();
        this.mDestroyingSubject = sdk.pendo.io.h4.b.f();
        this.mListener = visualGuideLifecycleListener;
    }
}
