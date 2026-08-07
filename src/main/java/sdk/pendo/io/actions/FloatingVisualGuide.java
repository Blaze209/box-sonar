package sdk.pendo.io.actions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.s7.w;
import sdk.pendo.io.s7.w0;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 @2\u00020\u0001:\u0001@B/\b\u0004\u0012\u0006\u00107\u001a\u000206\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?J(\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u0007H\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0004J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007R\"\u0010\u0006\u001a\u00020\u00058\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R:\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010#0\"j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010#`$8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u0004\u0018\u00010+8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00103\u001a\u0004\u0018\u00010+8G¢\u0006\u0006\u001a\u0004\b2\u0010-R\u0016\u00105\u001a\u0004\u0018\u00010\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b4\u00100¨\u0006A"}, d2 = {"Lsdk/pendo/io/actions/FloatingVisualGuide;", "Lsdk/pendo/io/actions/VisualGuideBase;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Lsdk/pendo/io/r5/g;", "analyticsData", "", "activatedBy", "", "init", "", "show", "idHash", "removeFromMap", "viewAttributeName", "", "getLocationPlacementFrom", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$FloatingGuideViewCallbacks;", "addCallback", "propertyName", "getDimenViewStringPropertyClean", "property", "getPropertyValueFromViewProperties", "onDestroy", "Lsdk/pendo/io/actions/GuideActionConfiguration$VisualGuideType;", "guideType", "Lsdk/pendo/io/a0/l;", "getViewContentJson", "Lsdk/pendo/io/r5/g;", "getAnalyticsData", "()Lsdk/pendo/io/r5/g;", "setAnalyticsData", "(Lsdk/pendo/io/r5/g;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mViewPropertiesToBePopulated", "Ljava/util/HashMap;", "getMViewPropertiesToBePopulated", "()Ljava/util/HashMap;", "TAG", "Ljava/lang/String;", "Lsdk/pendo/io/a0/f;", "getFloatingGuideProperties", "()Lsdk/pendo/io/a0/f;", "floatingGuideProperties", "getBackground", "()Ljava/lang/String;", AppStateModule.APP_STATE_BACKGROUND, "getFloatingViewProperties", "floatingViewProperties", "getStrokeColor", "strokeColor", "Lsdk/pendo/io/actions/VisualGuideBase$VisualGuideType;", "type", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/actions/VisualGuideBase$VisualGuideType;Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class FloatingVisualGuide extends VisualGuideBase {
    public static final String BACKDROP_ENABLED_KEY = "hasMobileBackdrop";
    private static final String DEFAULT_WHITE = "#FFFFFFFF";
    public static final String IS_MOBILE_BANNER_KEY = "isMobileBanner";
    private final String TAG;
    protected g analyticsData;
    private final HashMap<String, Object> mViewPropertiesToBePopulated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashSet<String> SUPPORTED_FLOATING_LAYOUT_PROPERTIES = new HashSet<>(CollectionsKt.listOf((Object[]) new String[]{ViewProps.POSITION, AppStateModule.APP_STATE_BACKGROUND, "fontFamily", "textColor", "text", "textStyle", "textSize", "textDirection", ViewProps.PADDING, "gravity", "frameColor", "frameWidth", "frameRadius", "layout_marginLeft", "layout_marginRight", "layout_marginTop", "layout_marginBottom", ViewProps.MAX_WIDTH, "backgroundImageUrl", "backgroundImageFillType", "accessibilityText", "ariaLabel", "caret_width", "caret_height"}));

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0013JT\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00062\u001a\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\tH\u0005R@\u0010\u000e\u001a\"\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u00050\bj\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005`\t8\u0004X\u0085\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/actions/FloatingVisualGuide$Companion;", "", "Lsdk/pendo/io/a0/f;", "properties", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "elementBoundProperties", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "relevantProperties", "", "extractProperties", "kotlin.jvm.PlatformType", "SUPPORTED_FLOATING_LAYOUT_PROPERTIES", "Ljava/util/HashSet;", "getSUPPORTED_FLOATING_LAYOUT_PROPERTIES", "()Ljava/util/HashSet;", "getSUPPORTED_FLOATING_LAYOUT_PROPERTIES$annotations", "()V", "BACKDROP_ENABLED_KEY", "Ljava/lang/String;", "DEFAULT_WHITE", "IS_MOBILE_BANNER_KEY", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        protected static /* synthetic */ void getSUPPORTED_FLOATING_LAYOUT_PROPERTIES$annotations() {
        }

        @JvmStatic
        protected final void extractProperties(f properties, HashMap<String, Object> elementBoundProperties, HashSet<String> relevantProperties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(elementBoundProperties, "elementBoundProperties");
            Intrinsics.checkNotNullParameter(relevantProperties, "relevantProperties");
            for (i iVar : properties) {
                if (iVar.j()) {
                    l lVarE = iVar.e();
                    String strG = lVarE.a("name").g();
                    if (relevantProperties.contains(strG)) {
                        String strG2 = lVarE.a("type").g();
                        i iVarA = lVarE.a("value");
                        boolean zAreEqual = Intrinsics.areEqual("json", strG2);
                        Intrinsics.checkNotNull(strG);
                        elementBoundProperties.put(strG, zAreEqual ? iVarA.e() : iVarA.g());
                        if (elementBoundProperties.size() == relevantProperties.size()) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        protected final HashSet<String> getSUPPORTED_FLOATING_LAYOUT_PROPERTIES() {
            return FloatingVisualGuide.SUPPORTED_FLOATING_LAYOUT_PROPERTIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected FloatingVisualGuide(VisualGuideBase.VisualGuideType type, GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(guideModel, visualGuideLifecycleListener);
        Intrinsics.checkNotNullParameter(type, "type");
        this.mViewPropertiesToBePopulated = new HashMap<>();
        this.TAG = "FloatingVisualGuide";
        this.mVisualGuideType = type;
        this.mStepSeenManager = stepSeenManagerInterface;
    }

    @JvmStatic
    protected static final void extractProperties(f fVar, HashMap<String, Object> map, HashSet<String> hashSet) {
        INSTANCE.extractProperties(fVar, map, hashSet);
    }

    protected static final HashSet<String> getSUPPORTED_FLOATING_LAYOUT_PROPERTIES() {
        return INSTANCE.getSUPPORTED_FLOATING_LAYOUT_PROPERTIES();
    }

    protected final PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks addCallback(final String idHash) {
        Intrinsics.checkNotNullParameter(idHash, "idHash");
        return new PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks() { // from class: sdk.pendo.io.actions.FloatingVisualGuide.addCallback.1
            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onClosing(boolean fromUser, long displayDuration, boolean wasShown) {
                if (wasShown) {
                    if (fromUser) {
                        PendoCommandParameterInjector.getInstance().handlePendoUserActionAnalytics(FloatingVisualGuide.this.getAnalyticsData().c(), displayDuration);
                    } else {
                        PendoCommandParameterInjector.getInstance().handleGuideTimeoutAnalytics(FloatingVisualGuide.this.getAnalyticsData().c(), displayDuration);
                    }
                }
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onDetach() {
                FloatingVisualGuide.this.removeFromMap(idHash);
                FloatingVisualGuide.this.onDestroy();
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onReadyForShow(ViewGroup guide) {
                Window window;
                FloatingVisualGuide.this.mActivity = new WeakReference<>(c.h().a());
                if (guide != null) {
                    FloatingVisualGuide.this.setContainerView(guide);
                }
                FloatingVisualGuide floatingVisualGuide = FloatingVisualGuide.this;
                Activity activity = floatingVisualGuide.mActivity.get();
                View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
                floatingVisualGuide.setRootView(decorView instanceof ViewGroup ? (ViewGroup) decorView : null);
                FloatingVisualGuide floatingVisualGuide2 = FloatingVisualGuide.this;
                VisualAnimationManager visualAnimationManager = floatingVisualGuide2.mVisualAnimationManager;
                WeakReference<Activity> weakReference = floatingVisualGuide2.mActivity;
                visualAnimationManager.performShow(weakReference != null ? weakReference.get() : null, null);
            }

            @Override // sdk.pendo.io.actions.PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks
            public void onTouchOutside() {
                l guideWidgetWrapperObject;
                List<StepModel> steps = FloatingVisualGuide.this.getSteps();
                if (steps == null || steps.isEmpty()) {
                    guideWidgetWrapperObject = null;
                } else {
                    List<StepModel> steps2 = FloatingVisualGuide.this.getSteps();
                    Integer currentStepIndex = FloatingVisualGuide.this.mStepSeenManager.getCurrentStepIndex();
                    Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
                    guideWidgetWrapperObject = GuideActionConfiguration.getGuideWidgetWrapperObject(steps2.get(currentStepIndex.intValue()));
                }
                if (guideWidgetWrapperObject == null) {
                    PendoLogger.d(FloatingVisualGuide.this.TAG + " No actions to handle touch outside tooltip event.", new Object[0]);
                    return;
                }
                f fVarB = w.b(guideWidgetWrapperObject, "actions");
                if (fVarB == null || fVarB.size() <= 0) {
                    return;
                }
                List<PendoCommand> pendoCommandsWithParameters = PendoCommand.getPendoCommandsWithParameters(fVarB, PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(FloatingVisualGuide.this.getGuideId()), new JavascriptRunner.GuideContext(FloatingVisualGuide.this.getGuideId()));
                JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(pendoCommandsWithParameters);
                PendoCommandDispatcher.getInstance().dispatchCommands(pendoCommandsWithParameters, PendoCommandEventType.UserEventType.TAP_ON, true);
            }
        };
    }

    protected final g getAnalyticsData() {
        g gVar = this.analyticsData;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analyticsData");
        return null;
    }

    protected final String getBackground() {
        String str = (String) this.mViewPropertiesToBePopulated.get(AppStateModule.APP_STATE_BACKGROUND);
        if (str == null) {
            return DEFAULT_WHITE;
        }
        String strA = w0.a(str);
        Intrinsics.checkNotNullExpressionValue(strA, "convertRRGGBBAAToAARRGGBBColor(...)");
        return strA;
    }

    public final String getDimenViewStringPropertyClean(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        String str = (String) this.mViewPropertiesToBePopulated.get(propertyName);
        if (str != null) {
            return w0.b(str);
        }
        return null;
    }

    protected final f getFloatingGuideProperties() {
        List<StepModel> steps = getSteps();
        if (steps == null || steps.isEmpty()) {
            return null;
        }
        List<StepModel> steps2 = getSteps();
        Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
        Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
        return GuideActionConfiguration.getGuideContentProperties(steps2.get(currentStepIndex.intValue()));
    }

    public final f getFloatingViewProperties() {
        List<StepModel> steps = getSteps();
        if (steps == null || steps.isEmpty()) {
            return null;
        }
        List<StepModel> steps2 = getSteps();
        Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
        Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
        return GuideActionConfiguration.getTooltipProperties(steps2.get(currentStepIndex.intValue()));
    }

    protected final int getLocationPlacementFrom(String viewAttributeName) {
        Intrinsics.checkNotNullParameter(viewAttributeName, "viewAttributeName");
        String str = (String) this.mViewPropertiesToBePopulated.get(viewAttributeName);
        try {
            PendoFloatingVisualGuideManager.Companion companion = PendoFloatingVisualGuideManager.INSTANCE;
            Intrinsics.checkNotNull(str);
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Integer numValueOfGravity = companion.valueOfGravity(upperCase);
            Intrinsics.checkNotNull(numValueOfGravity);
            return numValueOfGravity.intValue();
        } catch (Exception unused) {
            return 2;
        }
    }

    protected final HashMap<String, Object> getMViewPropertiesToBePopulated() {
        return this.mViewPropertiesToBePopulated;
    }

    protected final String getPropertyValueFromViewProperties(String property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (String) this.mViewPropertiesToBePopulated.get(property);
    }

    protected final String getStrokeColor() {
        return (String) this.mViewPropertiesToBePopulated.get("frameColor");
    }

    public final l getViewContentJson(GuideActionConfiguration.VisualGuideType guideType) {
        Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
        if (currentStepIndex != null) {
            return GuideActionConfiguration.getFloatingGuideContent(getSteps().get(currentStepIndex.intValue()), guideType);
        }
        return null;
    }

    public abstract void init(WeakReference<View> viewRef, g analyticsData, String activatedBy);

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public synchronized void onDestroy() {
        super.onDestroy();
        VisualGuideLifecycleListener visualGuideLifecycleListener = this.mListener;
        if (visualGuideLifecycleListener != null) {
            visualGuideLifecycleListener.onDestroy(getGuideId());
        }
        getAndSetShowing(false);
        setContainerView(null);
        setRootView(null);
        setTracker(null);
        this.mActivity = null;
        GuidesManager.INSTANCE.setCurrentGuideAsNull();
    }

    public abstract void removeFromMap(String idHash);

    protected final void setAnalyticsData(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.analyticsData = gVar;
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public abstract boolean show();
}
