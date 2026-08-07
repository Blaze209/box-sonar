package sdk.pendo.io.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesConfigurationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandParameterInjector;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.logging.a;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.r5.b;
import sdk.pendo.io.s7.l;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.t6.d;

/* JADX INFO: loaded from: classes4.dex */
public class InitModel {
    public static final Object CACHE_LOCK = new Object();
    private static final String REMOTE_DEBUG_INFO_TAG = "info";
    private static final String REMOTE_DEBUG_MESSAGES_TAG = "messages";

    @c("guideActions")
    private f mGuideActions;

    @c("guides")
    private List<GuideModel> mGuides;

    @c("configuration")
    private InitConfiguration mInitConfiguration;

    @c("metadata")
    private MetadataModel mMetadata;

    private void checkIfDebugRemoteNeededAndInit() {
        DebugConfigurationModel debugConfigurationModel = this.mInitConfiguration.getDebugConfigurationModel();
        if (debugConfigurationModel != null) {
            final a aVarA = a.INSTANCE.a();
            aVarA.b(debugConfigurationModel.getRefreshIntervalMs());
            PendoLogger.plant(aVarA);
            j.c(aVarA.getRefreshInterval(), TimeUnit.SECONDS, sdk.pendo.io.i4.a.b()).a(d.a(new e<Long>() { // from class: sdk.pendo.io.models.InitModel.1
                @Override // sdk.pendo.io.q3.e
                public void accept(Long l) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArrayF = aVarA.f();
                        aVarA.d();
                        JSONObject jSONObjectA = l.a();
                        jSONObject.put(InitModel.REMOTE_DEBUG_MESSAGES_TAG, jSONArrayF);
                        jSONObject.put("info", jSONObjectA);
                        sdk.pendo.io.f6.a.d().a(jSONObject);
                    } catch (Exception e) {
                        PendoLogger.e(e, e.getMessage(), new Object[0]);
                    }
                }
            }, "InitModel interval observable for remote debug observer"));
        }
    }

    private void sendGuidesReceivedAnalytics() {
        for (GuideModel guideModel : getGuideList()) {
            ArrayList arrayList = new ArrayList();
            if (VisualGuidesManager.getInstance().getVisualGuide(guideModel.getGuideId()) != null) {
                arrayList.add(new PendoCommandsEventBus.Parameter("seenReason", "string", VisualGuidesManager.getInstance().getVisualGuide(guideModel.getGuideId()).getActivatedBy()));
            }
            PendoCommandParameterInjector.getInstance().addGenericParamsInjectAndDispatch(guideModel, PendoCommandEventType.AnalyticsEventType.GUIDE_RECEIVED, arrayList);
        }
    }

    public List<GuideModel> getGuideList() {
        List<GuideModel> list = this.mGuides;
        return list != null ? list : new ArrayList();
    }

    public InitConfiguration getInitConfiguration() {
        return this.mInitConfiguration;
    }

    public void init() {
        synchronized (CACHE_LOCK) {
            if (this.mInitConfiguration != null) {
                PendoInternal.z().setPolicy(this.mInitConfiguration.getInitAnalyticsModel().isIncludePageViewTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeFeatureClickTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeFeatureClickNestedTexts(), this.mInitConfiguration.getInitAnalyticsModel().isIncludeRetroElementCompatibilityHashes(), this.mInitConfiguration.getInitAnalyticsModel().isOldScreenIdFormat(), this.mInitConfiguration.getInitAnalyticsModel().isIgnoreDynamicFragmentsInScrollView(), this.mInitConfiguration.getInitAnalyticsModel().isRespondToScrollChangeEventsForScreenId(), this.mInitConfiguration.getInitAnalyticsModel().globalLayoutChangeDebouncer().longValue(), this.mInitConfiguration.getInitAnalyticsModel().isShouldDetectClicksForAccessibility());
                checkIfDebugRemoteNeededAndInit();
                if (this.mInitConfiguration.getReactConfigurationModel() != null && this.mInitConfiguration.getReactConfigurationModel().getRnnClickDelayMs() >= 0) {
                    PlatformStateManager.INSTANCE.setRnnClickDelayMs(this.mInitConfiguration.getReactConfigurationModel().getRnnClickDelayMs());
                }
                GuidesConfigurationModel guidesConfigurationModel = this.mInitConfiguration.getGuidesConfigurationModel();
                if (guidesConfigurationModel != null) {
                    if (guidesConfigurationModel.getThrottlingConfigurationModel() != null) {
                        GuidesConfigurationManager.INSTANCE.setThrottlingConfiguration(guidesConfigurationModel.getThrottlingConfigurationModel());
                    }
                    if (guidesConfigurationModel.getLastStepSeenConfigurationModel() != null) {
                        GuidesConfigurationManager.INSTANCE.setLastStepSeenConfigurationModel(guidesConfigurationModel.getLastStepSeenConfigurationModel());
                    }
                }
                b.f().b(this.mInitConfiguration.getInitAnalyticsModel());
                b.f().a(this.mInitConfiguration.getInitAnalyticsModel());
                PendoLogger.d("Buffer and storage size params updated:  bufferQueueSize = '" + b.f().e() + "' bufferDuration = '" + b.f().d() + "' maxStorageSizeMB = '" + b.f().g() + "'.", new Object[0]);
            } else {
                PendoLogger.d("Using default buffer and default storage size:  bufferQueueSize = '" + b.f().e() + "' bufferDuration = '" + b.f().d() + "' maxStorageSizeMB = '" + b.f().g() + "'.", new Object[0]);
            }
            GuidesActionsManager.getInstance().dismissVisibleGuides();
            PendoInternal.a(this.mMetadata);
            GuidesManager.INSTANCE.storeAndActivateSessionGuides(getGuideList(), PendoCommand.getPendoCommands(this.mGuideActions));
            sendGuidesReceivedAnalytics();
            ActivationManager.INSTANCE.restartWithGuides(getGuideList());
        }
    }

    public void setGuides(List<GuideModel> list) {
        this.mGuides = list;
    }
}
