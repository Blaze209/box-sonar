package sdk.pendo.io.actions;

import android.content.Intent;
import android.view.View;
import com.box.android.observability.DiagnosisParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.actions.guides.GuideContextSwitchRules;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.i3.b;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.Completed;
import sdk.pendo.io.models.GeneralGuidesConfiguration;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.GuideStatus;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.s7.e;
import sdk.pendo.io.s7.j;
import sdk.pendo.io.s7.r;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.t6.d;
import sdk.pendo.io.w5.a;
import sdk.pendo.io.x6.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\bn\u0010oJ$\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002J*\u0010\"\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0002J$\u0010&\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u001dH\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001dJ2\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001f0.2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0010\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u00020\bJ\u0017\u00106\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0011H\u0001¢\u0006\u0004\b4\u00105J\u001f\u00109\u001a\u0004\u0018\u00010\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H\u0001¢\u0006\u0004\b7\u00108J\u001d\u0010>\u001a\u00020\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110:H\u0001¢\u0006\u0004\b<\u0010=J\u001d\u0010A\u001a\u00020\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110:H\u0001¢\u0006\u0004\b@\u0010=J\b\u0010B\u001a\u00020\bH\u0016J?\u0010F\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0000¢\u0006\u0004\bD\u0010EJ\u0019\u0010I\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0004\bG\u0010HJ?\u0010K\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0000¢\u0006\u0004\bJ\u0010EJK\u0010N\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\bL\u0010MJ4\u0010Q\u001a\u00020\b2\u0006\u0010P\u001a\u00020O2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J\u001a\u0010R\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007J\u0006\u0010S\u001a\u00020\bJ\u0006\u0010T\u001a\u00020\u001fJ\u0006\u0010U\u001a\u00020\bR\u0014\u0010V\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00040X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\\R\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010e\u001a\u0004\bk\u0010l¨\u0006p"}, d2 = {"Lsdk/pendo/io/actions/GuidesManager;", "Lsdk/pendo/io/actions/GuidesManagerInterface;", "Lsdk/pendo/io/w5/a;", "", "Lsdk/pendo/io/models/GuideModel;", "guideModelList", "Lsdk/pendo/io/actions/PendoCommand;", "guideActions", "", "setActiveGuidesAndGuideActions", "cancelCurrentGuide", "", "isUnableToShowGuide", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "interruptGuide", "purgeGuide", "sendError", "Lsdk/pendo/io/models/GuideCandidate;", "guideCandidate", "runGuide", "guideModel", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "activatedBy", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "targetViewRef", "startVisualTooltip", "Landroid/content/Intent;", "intent", "", "guideActionId", "", "stepIndex", "isPreviewGuide", "startVisualActivityAndSetAsFullScreen", "Lsdk/pendo/io/models/GuideStatus;", "status", "handleGuideStatusError", "storeAndActivateSessionGuides", "getGuideActions", "guideId", "getGuide", "addGuideToGuidesMap", "removeGuideFromSystem", "guideCandidates", "guideTriggeredByView", "Lkotlin/Pair;", "show", "testGuideModel", "activateNonSessionGuide", "activateSessionGuides", "newGuide", "shouldShowTheGuide$pendoIO_release", "(Lsdk/pendo/io/models/GuideCandidate;)Z", "shouldShowTheGuide", "selectForShow$pendoIO_release", "(Ljava/util/List;)Lsdk/pendo/io/models/GuideCandidate;", "selectForShow", "", "guides", "handleGuidesWithErrorAndRemoveIt$pendoIO_release", "(Ljava/util/List;)Z", "handleGuidesWithErrorAndRemoveIt", "guideModelsOrdered", "handleControlGuidesAndRemoveIt$pendoIO_release", "handleControlGuidesAndRemoveIt", "showPreview", "targetView", "internalRunGuide$pendoIO_release", "(Lsdk/pendo/io/models/GuideModel;ZLsdk/pendo/io/actions/ActivationManager$ActivationEvents;ILjava/lang/ref/WeakReference;)V", "internalRunGuide", "shouldWaitForActivityResumeToShowGuide$pendoIO_release", "(Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;)Z", "shouldWaitForActivityResumeToShowGuide", "handleGuideShowing$pendoIO_release", "handleGuideShowing", "startExecutionByGuideType$pendoIO_release", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;Ljava/lang/ref/WeakReference;ZLjava/lang/String;I)V", "startExecutionByGuideType", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "visualGuide", "startShowingFloatingVisualGuide", "startVisualBanner", DiagnosisParams.CLEAR_ON_LOGOUT, "getCountGuidesInMemory", "setCurrentGuideAsNull", "TAG", "Ljava/lang/String;", "", "activeGuidesMap", "Ljava/util/Map;", "activeGuideActionList", "Ljava/util/List;", "FIRST_STEP_INDEX", "I", "sessionGuidesList", "sessionGuideActions", "currentGuide", "Lsdk/pendo/io/models/GuideCandidate;", "Lsdk/pendo/io/g6/b;", "guidesApiManager$delegate", "Lkotlin/Lazy;", "getGuidesApiManager", "()Lsdk/pendo/io/g6/b;", "guidesApiManager", "Lsdk/pendo/io/s7/e;", "anchorViewUtils$delegate", "getAnchorViewUtils", "()Lsdk/pendo/io/s7/e;", "anchorViewUtils", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class GuidesManager implements GuidesManagerInterface, a {
    private static final int FIRST_STEP_INDEX = 0;
    public static final GuidesManager INSTANCE;
    private static final String TAG = "GuidesManager";
    private static List<PendoCommand> activeGuideActionList;
    private static final Map<String, GuideModel> activeGuidesMap;

    /* JADX INFO: renamed from: anchorViewUtils$delegate, reason: from kotlin metadata */
    private static final Lazy anchorViewUtils;
    private static GuideCandidate currentGuide;

    /* JADX INFO: renamed from: guidesApiManager$delegate, reason: from kotlin metadata */
    private static final Lazy guidesApiManager;
    private static List<PendoCommand> sessionGuideActions;
    private static List<? extends GuideModel> sessionGuidesList;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GuideActionConfiguration.VisualGuideType.values().length];
            try {
                iArr[GuideActionConfiguration.VisualGuideType.FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuideActionConfiguration.VisualGuideType.TOOLTIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuideActionConfiguration.VisualGuideType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final GuidesManager guidesManager = new GuidesManager();
        INSTANCE = guidesManager;
        activeGuidesMap = new HashMap();
        activeGuideActionList = new LinkedList();
        sessionGuidesList = new LinkedList();
        sessionGuideActions = new LinkedList();
        b bVar = b.a;
        LazyThreadSafetyMode lazyThreadSafetyModeA = bVar.a();
        final sdk.pendo.io.d3.a aVar = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        guidesApiManager = LazyKt.lazy(lazyThreadSafetyModeA, (Function0) new Function0<sdk.pendo.io.g6.b>() { // from class: sdk.pendo.io.actions.GuidesManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.g6.b] */
            @Override // kotlin.jvm.functions.Function0
            public final sdk.pendo.io.g6.b invoke() {
                sdk.pendo.io.v2.a aVar2 = guidesManager;
                return (aVar2 instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar2).getScope() : aVar2.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.g6.b.class), aVar, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeA2 = bVar.a();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        anchorViewUtils = LazyKt.lazy(lazyThreadSafetyModeA2, (Function0) new Function0<e>() { // from class: sdk.pendo.io.actions.GuidesManager$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.s7.e] */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                sdk.pendo.io.v2.a aVar2 = guidesManager;
                return (aVar2 instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar2).getScope() : aVar2.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(e.class), objArr2, objArr3);
            }
        });
    }

    private GuidesManager() {
    }

    @JvmStatic
    public static final void cancelCurrentGuide() {
        GuideCandidate guideCandidate = currentGuide;
        if (guideCandidate != null) {
            guideCandidate.getGuideModel().setCancelled();
            guideCandidate.getGuideModel().terminateStatus();
            PendoLogger.d("GuidesManager Dismissing guide " + guideCandidate.getGuideModel().getGuideName() + " because a new session has been started.", new Object[0]);
        }
    }

    private final e getAnchorViewUtils() {
        return (e) anchorViewUtils.getValue();
    }

    private final sdk.pendo.io.g6.b getGuidesApiManager() {
        return (sdk.pendo.io.g6.b) guidesApiManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleGuideShowing$lambda$22(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGuideShowing$lambda$23(String str, GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference weakReference, boolean z, int i, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        Intrinsics.checkNotNullParameter(activatedBy, "$activatedBy");
        String strG = c.h().g();
        if (strG == null || str == null || !Intrinsics.areEqual(strG, str)) {
            INSTANCE.setCurrentGuideAsNull();
        } else {
            INSTANCE.startExecutionByGuideType$pendoIO_release(guideModel, activatedBy, weakReference, z, guideModel.getGuideId(), i);
        }
    }

    private final void handleGuideStatusError(GuideCandidate guideCandidate, GuideStatus status) {
        if (guideCandidate.getActivationEvent() == ActivationManager.ActivationEvents.VIEW) {
            PendoLogger.d(TAG, "EVENT -> Guide with VIEW activation error, rescan current screen");
            PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_SCREEN_CHANGED);
        }
        GuideModel guideModel = guideCandidate.getGuideModel();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        status.sendError(guideModel, pendoCommandParameterInjector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalRunGuide$lambda$19(GuideModel guideModel, boolean z, ActivationManager.ActivationEvents activatedBy, int i, WeakReference weakReference, sdk.pendo.io.t4.a aVar) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        Intrinsics.checkNotNullParameter(activatedBy, "$activatedBy");
        INSTANCE.handleGuideShowing$pendoIO_release(guideModel, z, activatedBy, i, weakReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean internalRunGuide$lambda$20(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalRunGuide$lambda$21(GuideModel guideModel, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        guideStatus.sendError(guideModel, pendoCommandParameterInjector);
        guideModel.terminateStatus();
        INSTANCE.getAnchorViewUtils().f();
        PendoLogger.d(TAG, "EVENT -> Guide error, rescan current screen");
        PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_SCREEN_CHANGED);
    }

    private final void interruptGuide(GuideModel guide) {
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        removeGuideFromSystem(guideId);
        ActivationManager activationManager = ActivationManager.INSTANCE;
        String guideId2 = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId2, "getGuideId(...)");
        activationManager.removeGuideIdFromTriggers(guideId2);
        GuideStatus statusValue = guide.getStatusValue();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        statusValue.sendError(guide, pendoCommandParameterInjector);
        guide.terminateStatus();
    }

    private final boolean isUnableToShowGuide() {
        if (!j.a()) {
            PendoLogger.d("GuidesManager-> Not showing guide due to connectivity.", new Object[0]);
            return true;
        }
        if (PendoInternal.d()) {
            PendoLogger.d("GuidesManager-> Pause guides from showing - api was called.", new Object[0]);
            return true;
        }
        if (!VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
            return false;
        }
        PendoLogger.d("GuidesManager-> Not showing guides because one is already showing.", new Object[0]);
        return true;
    }

    private final void purgeGuide(GuideModel guide) {
        ActivationManager activationManager = ActivationManager.INSTANCE;
        String guideId = guide.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        activationManager.removeGuideIdFromTriggers(guideId);
        StepSeenManager.getInstance().setCurrentStepSeen(null);
        activeGuidesMap.remove(guide.getGuideId());
    }

    private final synchronized void runGuide(final GuideCandidate guideCandidate) {
        sdk.pendo.io.k3.j<GuideStatus> status = guideCandidate.getGuideModel().getStatus();
        final AnonymousClass1 anonymousClass1 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager.runGuide.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                return Boolean.valueOf(guideStatus.getStatus() >= GuideStatus.INSTANCE.getCONTENT_READY());
            }
        };
        status.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return GuidesManager.runGuide$lambda$13(anonymousClass1, obj);
            }
        }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda8
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                GuidesManager.runGuide$lambda$18(guideCandidate, (GuideStatus) obj);
            }
        }, "Run guide"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runGuide$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuide$lambda$18(final GuideCandidate guideCandidate, GuideStatus guideStatus) {
        Intrinsics.checkNotNullParameter(guideCandidate, "$guideCandidate");
        if (guideStatus.getHasError()) {
            GuidesManager guidesManager = INSTANCE;
            Intrinsics.checkNotNull(guideStatus);
            guidesManager.handleGuideStatusError(guideCandidate, guideStatus);
            return;
        }
        final GuideModel guideModel = guideCandidate.getGuideModel();
        final int stepIndex = guideCandidate.getStepIndex();
        StepGuideModel guideStepModel = guideModel.getGuideStepModel(stepIndex);
        if (guideStepModel != null) {
            final ActivationManager.ActivationEvents activationEvent = guideCandidate.getActivationEvent();
            long delayMs = guideStepModel.getConfiguration().getDelayMs();
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled() && platformStateManager.getRnnClickDelayMs() > 0 && activationEvent == ActivationManager.ActivationEvents.CLICK) {
                List<StepModel> steps = guideModel.getSteps();
                if (GuideActionConfiguration.getStepVisualPendoGuideType(steps != null ? steps.get(stepIndex) : null) == GuideActionConfiguration.VisualGuideType.FULLSCREEN) {
                    delayMs = RangesKt.coerceAtLeast(delayMs, platformStateManager.getRnnClickDelayMs());
                }
            }
            if (delayMs <= 0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)).plus(new CoroutineName("runGuideScope")).plus(new GuidesManager$runGuide$lambda$18$lambda$17$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE))), null, null, new GuidesManager$runGuide$2$1$3(guideModel, activationEvent, stepIndex, guideCandidate, null), 3, null);
            } else {
                PendoLogger.d("GuidesManager Pendo got delay.", new Object[0]);
                sdk.pendo.io.k3.j.a(sdk.pendo.io.constants.a.a).b(delayMs, TimeUnit.MILLISECONDS).a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda5
                    @Override // sdk.pendo.io.q3.j
                    public final boolean test(Object obj) {
                        return GuidesManager.runGuide$lambda$18$lambda$17$lambda$14(obj);
                    }
                }).a(sdk.pendo.io.n3.a.a()).a((o) d.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda6
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        GuidesManager.runGuide$lambda$18$lambda$17$lambda$15(guideModel, activationEvent, stepIndex, guideCandidate, obj);
                    }
                }, "GuidesManager delayed run observer"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runGuide$lambda$18$lambda$17$lambda$14(Object obj) {
        boolean zIsAnyGuideDisplayed = VisualGuidesManager.getInstance().isAnyGuideDisplayed();
        PendoLogger.d("GuidesManager Is guide showing: " + zIsAnyGuideDisplayed + ".", new Object[0]);
        return !zIsAnyGuideDisplayed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuide$lambda$18$lambda$17$lambda$15(GuideModel guideModel, ActivationManager.ActivationEvents guideActivatedBy, int i, GuideCandidate guideCandidate, Object obj) {
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        Intrinsics.checkNotNullParameter(guideActivatedBy, "$guideActivatedBy");
        Intrinsics.checkNotNullParameter(guideCandidate, "$guideCandidate");
        PendoLogger.d("GuidesManager Running delayed guide.", new Object[0]);
        INSTANCE.internalRunGuide$pendoIO_release(guideModel, false, guideActivatedBy, i, guideCandidate.getTargetView());
    }

    private final void sendError(GuideModel guide) {
        GuideStatus statusValue = guide.getStatusValue();
        PendoCommandParameterInjector pendoCommandParameterInjector = PendoCommandParameterInjector.getInstance();
        Intrinsics.checkNotNullExpressionValue(pendoCommandParameterInjector, "getInstance(...)");
        statusValue.sendError(guide, pendoCommandParameterInjector);
    }

    private final synchronized void setActiveGuidesAndGuideActions(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActions) {
        PendoLogger.v("GuidesManager-> setActiveGuidesAndGuideActions with " + guideModelList.size() + " guides", new Object[0]);
        setCurrentGuideAsNull();
        activeGuidesMap.clear();
        activeGuideActionList = guideActions;
        for (GuideModel guideModel : guideModelList) {
            PendoLogger.v("GuidesManager-> guideId: " + guideModel.getGuideId() + ", guideName: " + guideModel.getGuideName(), new Object[0]);
            GuidesManager guidesManager = INSTANCE;
            guidesManager.addGuideToGuidesMap(guideModel);
            if (guideModel.getContentUrl() == null) {
                guideModel.setContentReady();
                guidesManager.getGuidesApiManager().b(guideModel);
            } else {
                guideModel.setContentNotReady();
                guidesManager.getGuidesApiManager().a(guideModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPreview$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPreview$lambda$12(Boolean bool) {
        StepSeenManager.getInstance().setCurrentStepSeen(new StepSeen(GuideModel.PREVIEW_GUIDE_ID, GuideModel.PREVIEW_GUIDE_STEP_ID, 0));
        GuidesManager guidesManager = INSTANCE;
        GuideModel guideModelE = sdk.pendo.io.o6.a.d().e();
        Intrinsics.checkNotNullExpressionValue(guideModelE, "getPreviewGuide(...)");
        guidesManager.internalRunGuide$pendoIO_release(guideModelE, true, ActivationManager.ActivationEvents.PREVIEW, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startExecutionByGuideType$lambda$24(Object obj) {
        boolean zIsAnyGuideDisplayed = VisualGuidesManager.getInstance().isAnyGuideDisplayed();
        PendoLogger.d("GuidesManager Is guide showing: " + zIsAnyGuideDisplayed + ".", new Object[0]);
        return !zIsAnyGuideDisplayed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startExecutionByGuideType$lambda$25(GuideActionConfiguration.VisualGuideType visualGuideType, GuideModel guideModel, ActivationManager.ActivationEvents activationEvents, WeakReference weakReference, Object obj) {
        Intrinsics.checkNotNullParameter(visualGuideType, "$visualGuideType");
        Intrinsics.checkNotNullParameter(guideModel, "$guideModel");
        if (visualGuideType == GuideActionConfiguration.VisualGuideType.TOOLTIP) {
            PendoLogger.d("GuidesManager Running delayed tooltip guide.", new Object[0]);
            INSTANCE.startVisualTooltip(guideModel, activationEvents, weakReference);
        } else {
            PendoLogger.d("GuidesManager Running delayed banner guide.", new Object[0]);
            INSTANCE.startVisualBanner(guideModel, activationEvents);
        }
    }

    private final synchronized void startVisualActivityAndSetAsFullScreen(Intent intent, String guideActionId, int stepIndex, boolean isPreviewGuide) {
        if (sdk.pendo.io.s7.c.a(intent, guideActionId, Integer.valueOf(stepIndex), Boolean.valueOf(isPreviewGuide))) {
            VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(true);
        }
    }

    private final synchronized void startVisualTooltip(GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference<View> targetViewRef) {
        View view;
        if (targetViewRef != null) {
            try {
                view = targetViewRef.get();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            view = null;
        }
        if (view == null) {
            PendoLogger.d("GuidesManager startVisualTooltip targetViewRef is null, cannot display tooltip, guide id - " + guideModel.getGuideId(), new Object[0]);
        } else {
            if (VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
                return;
            }
            startShowingFloatingVisualGuide(new ToolTipVisualGuide(guideModel, VisualGuidesManager.getInstance(), StepSeenManager.getInstance()), guideModel, activatedBy, targetViewRef);
        }
    }

    public final synchronized void activateNonSessionGuide(GuideModel testGuideModel) {
        PendoLogger.d("GuidesManager activating nonSession Guide", new Object[0]);
        LinkedList linkedList = new LinkedList();
        if (testGuideModel != null) {
            linkedList.add(testGuideModel);
        }
        setActiveGuidesAndGuideActions(linkedList, CollectionsKt.emptyList());
        ActivationManager.INSTANCE.restartWithGuides(CollectionsKt.toList(activeGuidesMap.values()));
    }

    public final synchronized void activateSessionGuides() {
        PendoLogger.d("GuidesManager activating session Guides", new Object[0]);
        setActiveGuidesAndGuideActions(sessionGuidesList, sessionGuideActions);
        ActivationManager.INSTANCE.restartWithGuides(CollectionsKt.toList(activeGuidesMap.values()));
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void addGuideToGuidesMap(GuideModel guideModel) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Map<String, GuideModel> map = activeGuidesMap;
        String guideId = guideModel.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        map.put(guideId, guideModel);
    }

    public final void clear() {
        activeGuidesMap.clear();
        activeGuideActionList = new LinkedList();
        sessionGuideActions = new LinkedList();
        sessionGuidesList = new LinkedList();
    }

    public final int getCountGuidesInMemory() {
        return activeGuidesMap.size();
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized GuideModel getGuide(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        return activeGuidesMap.get(guideId);
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized List<PendoCommand> getGuideActions() {
        return new LinkedList(activeGuideActionList);
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return a.C0510a.a(this);
    }

    public final boolean handleControlGuidesAndRemoveIt$pendoIO_release(List<GuideCandidate> guideModelsOrdered) {
        Intrinsics.checkNotNullParameter(guideModelsOrdered, "guideModelsOrdered");
        if (guideModelsOrdered.isEmpty()) {
            return false;
        }
        Iterator<GuideCandidate> it = guideModelsOrdered.iterator();
        boolean z = false;
        while (it.hasNext()) {
            GuideModel guideModel = it.next().getGuideModel();
            if (!guideModel.isInControlGroup()) {
                break;
            }
            it.remove();
            if (GuideShowDecider.getInstance().shouldShowGuide(guideModel, 0)) {
                PendoCommandParameterInjector.getInstance().handleControlGroupAnalytics(guideModel);
                guideModel.capOut();
            }
            z = true;
        }
        return z;
    }

    public final void handleGuideShowing$pendoIO_release(final GuideModel guideModel, final boolean isPreviewGuide, final ActivationManager.ActivationEvents activatedBy, final int stepIndex, final WeakReference<View> targetView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        final String strG = c.h().g();
        sdk.pendo.io.k3.j<GuideStatus> status = guideModel.getStatus();
        final GuidesManager$handleGuideShowing$1 guidesManager$handleGuideShowing$1 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$handleGuideShowing$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                int status2 = guideStatus.getStatus();
                GuideStatus.Companion companion = GuideStatus.INSTANCE;
                return Boolean.valueOf(status2 == companion.getREADY() || guideStatus.getStatus() == companion.getGUIDE_SHOWN());
            }
        };
        status.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return GuidesManager.handleGuideShowing$lambda$22(guidesManager$handleGuideShowing$1, obj);
            }
        }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                GuidesManager.handleGuideShowing$lambda$23(strG, guideModel, activatedBy, targetView, isPreviewGuide, stepIndex, (GuideStatus) obj);
            }
        }, "GuideManager internalRunGuide"));
    }

    public final boolean handleGuidesWithErrorAndRemoveIt$pendoIO_release(List<GuideCandidate> guides) {
        Intrinsics.checkNotNullParameter(guides, "guides");
        Iterator<GuideCandidate> it = guides.iterator();
        boolean z = false;
        while (it.hasNext()) {
            GuideModel guideModel = it.next().getGuideModel();
            if (guideModel.getStatusValue() == null || !guideModel.getStatusValue().getHasError()) {
                break;
            }
            guideModel.capOut();
            purgeGuide(guideModel);
            it.remove();
            sendError(guideModel);
            z = true;
        }
        return z;
    }

    public final synchronized void internalRunGuide$pendoIO_release(final GuideModel guideModel, final boolean isPreviewGuide, final ActivationManager.ActivationEvents activatedBy, final int stepIndex, final WeakReference<View> targetView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        if (!isPreviewGuide && activatedBy == ActivationManager.ActivationEvents.CLICK) {
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled()) {
                if (GuideTapOnManager.getsIsTapIndicationRunning()) {
                    return;
                } else {
                    GuideTapOnManager.setsIsTapIndicationRunning(true);
                }
            }
            GuideTapOnManager.runTapOnIndication();
        }
        if (c.h().a() != null) {
            handleGuideShowing$pendoIO_release(guideModel, isPreviewGuide, activatedBy, stepIndex, targetView);
        } else if (shouldWaitForActivityResumeToShowGuide$pendoIO_release(activatedBy)) {
            sdk.pendo.io.k3.g<sdk.pendo.io.t4.a> gVarF = c.h().e().f();
            sdk.pendo.io.q3.e eVar = new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda9
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    GuidesManager.internalRunGuide$lambda$19(guideModel, isPreviewGuide, activatedBy, stepIndex, targetView, (sdk.pendo.io.t4.a) obj);
                }
            };
            guideModel = guideModel;
            gVarF.a(sdk.pendo.io.t6.c.a(eVar, "GuidesManager observing the next onResume"));
        } else {
            setCurrentGuideAsNull();
        }
        sdk.pendo.io.k3.j<GuideStatus> status = guideModel.getStatus();
        final GuidesManager$internalRunGuide$2 guidesManager$internalRunGuide$2 = new Function1<GuideStatus, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager$internalRunGuide$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GuideStatus guideStatus) {
                return Boolean.valueOf(guideStatus.getHasError());
            }
        };
        status.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda10
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return GuidesManager.internalRunGuide$lambda$20(guidesManager$internalRunGuide$2, obj);
            }
        }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda11
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                GuidesManager.internalRunGuide$lambda$21(guideModel, (GuideStatus) obj);
            }
        }, "GuideManager internalRunGuide"));
    }

    public final synchronized void removeGuideFromSystem(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        activeGuidesMap.remove(guideId);
    }

    public final GuideCandidate selectForShow$pendoIO_release(List<GuideCandidate> guideCandidates) {
        GuideCapping capping;
        Intrinsics.checkNotNullParameter(guideCandidates, "guideCandidates");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guideCandidates.iterator();
        while (true) {
            boolean zCanConsumeOne = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GeneralGuidesConfiguration generalGuideConfiguration = ((GuideCandidate) next).getGuideModel().getGeneralGuideConfiguration();
            if (generalGuideConfiguration != null && (capping = generalGuideConfiguration.getCapping()) != null) {
                zCanConsumeOne = capping.canConsumeOne();
            }
            if (zCanConsumeOne) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!(((GuideCandidate) obj).getGuideModel().getStatusValue() instanceof Completed)) {
                arrayList2.add(obj);
            }
        }
        List<GuideCandidate> mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        if (mutableList.isEmpty()) {
            PendoLogger.i("GuidesManager->selectForShow there is no guide with capping remain", new Object[0]);
            return null;
        }
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: sdk.pendo.io.actions.GuidesManager$selectForShow$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GuideCandidate) t).getGuideModel().getPriority()), Integer.valueOf(((GuideCandidate) t2).getGuideModel().getPriority()));
                }
            });
        }
        boolean zHandleGuidesWithErrorAndRemoveIt$pendoIO_release = handleGuidesWithErrorAndRemoveIt$pendoIO_release(mutableList);
        boolean zHandleControlGuidesAndRemoveIt$pendoIO_release = handleControlGuidesAndRemoveIt$pendoIO_release(mutableList);
        boolean z = zHandleControlGuidesAndRemoveIt$pendoIO_release;
        while (true) {
            if (!zHandleGuidesWithErrorAndRemoveIt$pendoIO_release && !zHandleControlGuidesAndRemoveIt$pendoIO_release) {
                break;
            }
            zHandleGuidesWithErrorAndRemoveIt$pendoIO_release = handleGuidesWithErrorAndRemoveIt$pendoIO_release(mutableList);
            zHandleControlGuidesAndRemoveIt$pendoIO_release = handleControlGuidesAndRemoveIt$pendoIO_release(mutableList);
            z = zHandleControlGuidesAndRemoveIt$pendoIO_release || z;
        }
        String activationEvent = guideCandidates.get(0).getActivationEvent().getActivationEvent();
        if ((mutableList.isEmpty() && z && Intrinsics.areEqual(activationEvent, ActivationManager.ActivationEvents.CLICK.getActivationEvent())) || mutableList.isEmpty()) {
            return null;
        }
        return (GuideCandidate) CollectionsKt.first((List) mutableList);
    }

    public final void setCurrentGuideAsNull() {
        currentGuide = null;
    }

    public final boolean shouldShowTheGuide$pendoIO_release(GuideCandidate newGuide) {
        Intrinsics.checkNotNullParameter(newGuide, "newGuide");
        GuideCandidate guideCandidate = currentGuide;
        if (guideCandidate != null) {
            if (Intrinsics.areEqual(guideCandidate.getGuideId(), newGuide.getGuideId()) && guideCandidate.getStepIndex() == newGuide.getStepIndex()) {
                return false;
            }
            if (!Intrinsics.areEqual(guideCandidate.getGuideId(), newGuide.getGuideId()) && !GuideContextSwitchRules.INSTANCE.shouldInterruptCurrentGuide(guideCandidate.getActivationEvent(), newGuide.getActivationEvent())) {
                return false;
            }
        }
        return GuideShowDecider.getInstance().shouldShowGuide(newGuide.getGuideModel(), newGuide.getStepIndex());
    }

    public final boolean shouldWaitForActivityResumeToShowGuide$pendoIO_release(ActivationManager.ActivationEvents activatedBy) {
        return activatedBy == ActivationManager.ActivationEvents.TRACK_EVENT || activatedBy == ActivationManager.ActivationEvents.APP_LAUNCH;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x009c A[Catch: Exception -> 0x00b3, all -> 0x0154, TryCatch #1 {Exception -> 0x00b3, blocks: (B:5:0x0008, B:7:0x000e, B:10:0x001a, B:12:0x001e, B:14:0x0028, B:15:0x002d, B:17:0x0037, B:21:0x0045, B:23:0x004d, B:26:0x0059, B:28:0x005d, B:30:0x006b, B:31:0x0072, B:33:0x007a, B:35:0x0086, B:37:0x009e, B:36:0x009c, B:18:0x003e), top: B:60:0x0008, outer: #0 }] */
    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized Pair<String, Integer> show(List<GuideCandidate> guideCandidates, WeakReference<View> guideTriggeredByView) {
        View view;
        Intrinsics.checkNotNullParameter(guideCandidates, "guideCandidates");
        try {
            if (isUnableToShowGuide()) {
                return TuplesKt.to("", -1);
            }
            GuideCandidate guideCandidate = currentGuide;
            if (guideCandidate != null && guideCandidate.getGuideModel().isCompleted()) {
                INSTANCE.setCurrentGuideAsNull();
            }
            GuideCandidate guideCandidateSelectForShow$pendoIO_release = StepSeenManager.getInstance().getCurrentStepSeen() != null ? guideCandidates.get(0) : selectForShow$pendoIO_release(guideCandidates);
            if (guideCandidateSelectForShow$pendoIO_release != null) {
                GuidesManager guidesManager = INSTANCE;
                if (!guidesManager.shouldShowTheGuide$pendoIO_release(guideCandidateSelectForShow$pendoIO_release)) {
                    return TuplesKt.to("", -1);
                }
                GuideCandidate guideCandidate2 = currentGuide;
                if (guideCandidate2 != null && !Intrinsics.areEqual(guideCandidate2.getGuideId(), guideCandidateSelectForShow$pendoIO_release.getGuideId())) {
                    guidesManager.interruptGuide(guideCandidate2.getGuideModel());
                }
                if (guideCandidateSelectForShow$pendoIO_release.getActivationEvent() == ActivationManager.ActivationEvents.TRACK_EVENT) {
                    ActivationManager activationManager = ActivationManager.INSTANCE;
                    if (activationManager.getTrackEventsBeforeSessionStart().isEmpty()) {
                        currentGuide = guideCandidateSelectForShow$pendoIO_release;
                    } else {
                        currentGuide = GuideCandidate.copy$default(guideCandidateSelectForShow$pendoIO_release, null, 0, ActivationManager.ActivationEvents.ANY, null, 11, null);
                        activationManager.getTrackEventsBeforeSessionStart().clear();
                    }
                } else {
                    currentGuide = guideCandidateSelectForShow$pendoIO_release;
                }
                guidesManager.runGuide(guideCandidateSelectForShow$pendoIO_release);
                return TuplesKt.to(guideCandidateSelectForShow$pendoIO_release.getGuideId(), Integer.valueOf(guideCandidateSelectForShow$pendoIO_release.getStepIndex()));
            }
            return TuplesKt.to("", -1);
        } catch (Exception e) {
            String str = "";
            for (GuideCandidate guideCandidate3 : guideCandidates) {
                String guideId = guideCandidate3.getGuideId();
                int stepIndex = guideCandidate3.getStepIndex();
                ActivationManager.ActivationEvents activationEvent = guideCandidate3.getActivationEvent();
                WeakReference<View> targetView = guideCandidate3.getTargetView();
                str = str + "guideId: " + guideId + " stepIndex: " + stepIndex + " event: " + activationEvent + " view: " + ((targetView == null || (view = targetView.get()) == null) ? null : Integer.valueOf(view.hashCode())) + "\n";
            }
            PendoLogger.e("GuidesManager show fed problematic content with error: " + e + " with input summary: " + str, new Object[0]);
        }
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void showPreview() {
        GuidesActionsManager.getInstance().dismissVisibleGuides();
        sdk.pendo.io.k3.j<Boolean> isAnyGuideDisplayedObservable = VisualGuidesManager.getInstance().getIsAnyGuideDisplayedObservable();
        final C20351 c20351 = new Function1<Boolean, Boolean>() { // from class: sdk.pendo.io.actions.GuidesManager.showPreview.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        };
        isAnyGuideDisplayedObservable.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return GuidesManager.showPreview$lambda$11(c20351, obj);
            }
        }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                GuidesManager.showPreview$lambda$12((Boolean) obj);
            }
        }, "GuidesManager full screen guide showing observer"));
    }

    public final void startExecutionByGuideType$pendoIO_release(final GuideModel guideModel, final ActivationManager.ActivationEvents activatedBy, final WeakReference<View> targetView, boolean isPreviewGuide, String guideId, int stepIndex) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        if (StepSeenManager.getInstance().getCurrentStepSeen() == null) {
            String guideStepId = guideModel.getGuideStepId(stepIndex);
            if (!Intrinsics.areEqual(guideStepId, "")) {
                StepSeenManager.getInstance().setCurrentStepSeen(new StepSeen(guideId, guideStepId, Integer.valueOf(stepIndex)));
            }
        }
        List<StepModel> steps = guideModel.getSteps();
        final GuideActionConfiguration.VisualGuideType stepVisualPendoGuideType = GuideActionConfiguration.getStepVisualPendoGuideType(steps != null ? steps.get(stepIndex) : null);
        Intrinsics.checkNotNullExpressionValue(stepVisualPendoGuideType, "getStepVisualPendoGuideType(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[stepVisualPendoGuideType.ordinal()];
        if (i == 1) {
            startVisualActivityAndSetAsFullScreen(PendoGuideVisualActivity.INSTANCE.a(guideId, activatedBy, isPreviewGuide), guideId, stepIndex, isPreviewGuide);
        } else if (i == 2 || i == 3) {
            sdk.pendo.io.k3.j.a(sdk.pendo.io.constants.a.a).b(sdk.pendo.io.i4.a.a()).a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda12
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return GuidesManager.startExecutionByGuideType$lambda$24(obj);
                }
            }).a(sdk.pendo.io.n3.a.a()).a((o) d.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.actions.GuidesManager$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    GuidesManager.startExecutionByGuideType$lambda$25(stepVisualPendoGuideType, guideModel, activatedBy, targetView, obj);
                }
            }, "GuidesManager main thread posting observer"));
        }
    }

    public final synchronized void startShowingFloatingVisualGuide(FloatingVisualGuide visualGuide, GuideModel guideModel, ActivationManager.ActivationEvents activatedBy, WeakReference<View> targetViewRef) {
        Intrinsics.checkNotNullParameter(visualGuide, "visualGuide");
        sdk.pendo.io.r5.g gVarA = i.e().a(guideModel);
        VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(true);
        getAnchorViewUtils().a(targetViewRef != null ? targetViewRef.get() : null);
        if (!r.a(targetViewRef, visualGuide, gVarA, activatedBy != null ? activatedBy.getActivationEvent() : null) && guideModel != null) {
            guideModel.setContentError();
        }
    }

    public final synchronized void startVisualBanner(GuideModel guideModel, ActivationManager.ActivationEvents activatedBy) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        if (VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
            return;
        }
        startShowingFloatingVisualGuide(new BannerVisualGuide(guideModel, VisualGuidesManager.getInstance(), StepSeenManager.getInstance()), guideModel, activatedBy, null);
    }

    @Override // sdk.pendo.io.actions.GuidesManagerInterface
    public synchronized void storeAndActivateSessionGuides(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActions) {
        Intrinsics.checkNotNullParameter(guideModelList, "guideModelList");
        Intrinsics.checkNotNullParameter(guideActions, "guideActions");
        sessionGuidesList = guideModelList;
        sessionGuideActions = guideActions;
        setActiveGuidesAndGuideActions(guideModelList, guideActions);
    }
}
