package sdk.pendo.io.actions;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.o5.c;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.e;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.w0;
import sdk.pendo.io.views.GuideViewHolder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B%\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J(\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\fH\u0016R4\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010-\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00067"}, d2 = {"Lsdk/pendo/io/actions/ToolTipVisualGuide;", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "", "idHash", "Landroid/view/View;", "viewFromJson", "root", "", "locationPlacement", "Lsdk/pendo/io/o5/c$a;", "createBuilder", "builder", "", "addBackDropPropertiesToBuilder", "dimenName", "", "getDimenInPxFromStringInDP", "Ljava/lang/ref/WeakReference;", "viewRef", "Lsdk/pendo/io/r5/g;", "analyticsData", "activatedBy", "init", "", "show", "removeFromMap", "removeOnMainThread", "onDestroy", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "backDropPropertiesToBePopulated", "Ljava/util/HashMap;", "anchorView", "Landroid/view/View;", "Lsdk/pendo/io/a0/l;", "getToolTipWidgetWrapperJsonObject", "()Lsdk/pendo/io/a0/l;", "toolTipWidgetWrapperJsonObject", "getTouchPassThrough", "()Z", "touchPassThrough", "Lsdk/pendo/io/o5/c;", "getTooltipManager", "()Lsdk/pendo/io/o5/c;", "tooltipManager", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class ToolTipVisualGuide extends FloatingVisualGuide {
    private static final String CLICK_ACTION_CLICK_THROUGH_VALUE = "click_through";
    private static final String TAG = "ToolTipVisualGuide";
    private View anchorView;
    private final HashMap<String, Object> backDropPropertiesToBePopulated;
    private static final int DEFAULT_BACKDROP_COLOR = Color.parseColor("#AA000000");
    private static final String BACKDROP_COLOR_KEY = "mobileBackdropBackground";
    private static final String SEE_THROUGH_FEATURE_TOGGLE = "seeThroughFeature";
    private static final String SEE_THROUGH_FEATURE_PADDING_TOP = "seeThroughFeaturePaddingTop";
    private static final String SEE_THROUGH_FEATURE_PADDING_RIGHT = "seeThroughFeaturePaddingRight";
    private static final String SEE_THROUGH_FEATURE_PADDING_BOTTOM = "seeThroughFeaturePaddingBottom";
    private static final String SEE_THROUGH_FEATURE_PADDING_LEFT = "seeThroughFeaturePaddingLeft";
    private static final String SEE_THROUGH_FEATURE_RADIUS = "seeThroughFeatureRadius";
    private static final HashSet<String> SUPPORTED_BACKDROP_PROPERTIES = new HashSet<>(CollectionsKt.listOf((Object[]) new String[]{BACKDROP_COLOR_KEY, SEE_THROUGH_FEATURE_TOGGLE, SEE_THROUGH_FEATURE_PADDING_TOP, SEE_THROUGH_FEATURE_PADDING_RIGHT, SEE_THROUGH_FEATURE_PADDING_BOTTOM, SEE_THROUGH_FEATURE_PADDING_LEFT, FloatingVisualGuide.BACKDROP_ENABLED_KEY, SEE_THROUGH_FEATURE_RADIUS, "ariaLabel"}));

    /* JADX INFO: renamed from: sdk.pendo.io.actions.ToolTipVisualGuide$removeOnMainThread$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.actions.ToolTipVisualGuide$removeOnMainThread$1", f = "ToolTipVisualGuide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ToolTipVisualGuide.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            c cVarA;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String strC = ToolTipVisualGuide.this.getAnalyticsData().c();
            if (strC == null || (cVarA = c.INSTANCE.a()) == null) {
                unit = null;
            } else {
                cVarA.remove(strC);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                ToolTipVisualGuide.this.onDestroy();
            }
            VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(false);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ToolTipVisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(VisualGuideBase.VisualGuideType.TOOLTIP, guideModel, visualGuideLifecycleListener, stepSeenManagerInterface);
        this.backDropPropertiesToBePopulated = new HashMap<>();
    }

    private final void addBackDropPropertiesToBuilder(c.a builder) {
        int color;
        Object obj;
        boolean z = true;
        builder.withBackDrop(true);
        if (this.backDropPropertiesToBePopulated.get(SEE_THROUGH_FEATURE_TOGGLE) != null && ((obj = this.backDropPropertiesToBePopulated.get(SEE_THROUGH_FEATURE_TOGGLE)) == null || !w0.a(obj))) {
            z = false;
        }
        if (this.backDropPropertiesToBePopulated.get(BACKDROP_COLOR_KEY) != null) {
            Object obj2 = this.backDropPropertiesToBePopulated.get(BACKDROP_COLOR_KEY);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            color = Color.parseColor(w0.a((String) obj2));
        } else {
            color = DEFAULT_BACKDROP_COLOR;
        }
        builder.a(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_BOTTOM));
        builder.d(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_TOP));
        builder.b(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_LEFT));
        builder.c(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_PADDING_RIGHT));
        builder.a(color);
        builder.withSeeThrough(z);
        builder.seeThroughRadius(getDimenInPxFromStringInDP(SEE_THROUGH_FEATURE_RADIUS));
    }

    private final c.a createBuilder(String idHash, View viewFromJson, View root, int locationPlacement) {
        PendoFloatingVisualGuideManager.Builder builderWithCustomView = new c.a(idHash).anchor(root, locationPlacement).closePolicy(0L).background(getBackground()).toggleArrow(true).withCustomView(viewFromJson);
        String guideId = getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        PendoFloatingVisualGuideManager.Builder builderWithCallback = builderWithCustomView.guideId(guideId).withCallback(addCallback(idHash));
        Intrinsics.checkNotNull(builderWithCallback, "null cannot be cast to non-null type external.sdk.pendo.io.tooltip.PendoTooltipManager.Builder");
        return (c.a) builderWithCallback;
    }

    private final float getDimenInPxFromStringInDP(String dimenName) {
        String str = (String) this.backDropPropertiesToBePopulated.get(dimenName);
        if (str == null) {
            return 0.0f;
        }
        return w0.a(w0.b(str), 0);
    }

    private final l getToolTipWidgetWrapperJsonObject() {
        List<StepModel> steps = getSteps();
        if (steps == null || steps.isEmpty()) {
            return null;
        }
        List<StepModel> steps2 = getSteps();
        Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
        Intrinsics.checkNotNullExpressionValue(currentStepIndex, "getCurrentStepIndex(...)");
        return GuideActionConfiguration.getGuideWidgetWrapperObject(steps2.get(currentStepIndex.intValue()));
    }

    private final boolean getTouchPassThrough() {
        l lVarA;
        l toolTipWidgetWrapperJsonObject = getToolTipWidgetWrapperJsonObject();
        if (toolTipWidgetWrapperJsonObject == null || (lVarA = w0.a(toolTipWidgetWrapperJsonObject.b("properties"), "click_action")) == null) {
            return false;
        }
        return StringsKt.equals(CLICK_ACTION_CLICK_THROUGH_VALUE, lVarA.a("value").g(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    public static final void show$lambda$3(ToolTipVisualGuide this$0, String str, View view, String str2, String str3, String str4, boolean z, String str5, String str6, boolean z2, String str7, String str8, String str9, String str10, c cVar) {
        boolean zBooleanValue;
        PendoDrawerListener pendoDrawerListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(str);
        c.a aVarCreateBuilder = this$0.createBuilder(str, view, this$0.anchorView, this$0.getLocationPlacementFrom(ViewProps.POSITION));
        if (str2 != null && str3 != null) {
            aVarCreateBuilder.strokeColor(str3).strokeWidth(str2);
        }
        if (str4 != null) {
            aVarCreateBuilder.frameRadius(str4);
        }
        if (z) {
            this$0.addBackDropPropertiesToBuilder(aVarCreateBuilder);
        }
        if (str5 != null && str6 != null) {
            aVarCreateBuilder.a(str5, str6);
        }
        aVarCreateBuilder.withTouchPassThrough(z2);
        aVarCreateBuilder.withMargins(str7, str8, str9, str10);
        aVarCreateBuilder.setPaneTitle(this$0.getPropertyValueFromViewProperties("ariaLabel"));
        View view2 = this$0.anchorView;
        if (view2 == null || !e1.a(view2, 0)) {
            zBooleanValue = false;
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            View view3 = this$0.anchorView;
            if (view3 != null) {
                view3.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            }
            if (accessibilityNodeInfoObtain == null || !accessibilityNodeInfoObtain.isVisibleToUser()) {
                zBooleanValue = false;
            } else {
                WeakReference<PendoDrawerListener> pendoDrawerListenerRef = PendoInternal.z().getPendoDrawerListenerRef();
                Integer numValueOf = (pendoDrawerListenerRef == null || (pendoDrawerListener = pendoDrawerListenerRef.get()) == null) ? null : Integer.valueOf(pendoDrawerListener.getDrawerState());
                if (numValueOf == null || numValueOf.intValue() == 0) {
                    Boolean boolValueOf = cVar != null ? Boolean.valueOf(cVar.a(aVarCreateBuilder.build())) : null;
                    if (boolValueOf != null) {
                        zBooleanValue = boolValueOf.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                } else {
                    zBooleanValue = false;
                }
            }
        }
        if (zBooleanValue) {
            this$0.getAndSetShowing(true);
            return;
        }
        m tracker = this$0.getTracker();
        if (tracker != null) {
            d.a(tracker, g.b.ERROR_REASON_UNKNOWN, this$0.mAdditionalInfo);
        }
        this$0.onDestroy();
        VisualGuidesManager.getInstance().setIsAnyGuideDisplayed(false);
    }

    public final synchronized c getTooltipManager() {
        PendoFloatingVisualGuideManager.INSTANCE.resetContext(sdk.pendo.io.d6.c.h().a());
        return c.INSTANCE.a();
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void init(WeakReference<View> viewRef, g analyticsData, String activatedBy) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        super.init(activatedBy, analyticsData);
        setAnalyticsData(analyticsData);
        this.anchorView = viewRef != null ? viewRef.get() : null;
        f floatingGuideProperties = getFloatingGuideProperties();
        if (floatingGuideProperties != null) {
            FloatingVisualGuide.extractProperties(floatingGuideProperties, this.backDropPropertiesToBePopulated, SUPPORTED_BACKDROP_PROPERTIES);
        }
        f floatingViewProperties = getFloatingViewProperties();
        if (floatingViewProperties != null) {
            FloatingVisualGuide.extractProperties(floatingViewProperties, getMViewPropertiesToBePopulated(), FloatingVisualGuide.getSUPPORTED_FLOATING_LAYOUT_PROPERTIES());
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized void onDestroy() {
        super.onDestroy();
        this.anchorView = null;
        e.INSTANCE.a().f();
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void removeFromMap(String idHash) {
        Intrinsics.checkNotNullParameter(idHash, "idHash");
        c cVarA = c.INSTANCE.a();
        if (cVarA != null) {
            cVarA.removeFromMap(idHash);
        }
    }

    public final synchronized void removeOnMainThread() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized boolean show() {
        boolean z;
        Object obj;
        PendoLogger.d("ToolTipVisualGuide show() starting", new Object[0]);
        final c tooltipManager = getTooltipManager();
        final String strC = getAnalyticsData().c();
        l viewContentJson = getViewContentJson(GuideActionConfiguration.VisualGuideType.TOOLTIP);
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        if (this.anchorView == null) {
            return false;
        }
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA == null) {
            return false;
        }
        StepGuideModel stepGuideModel = getStepGuideModel();
        if (stepGuideModel == null) {
            PendoLogger.d(TAG, "ToolTipVisualGuide show() method aborted. The stepGuideModel was null");
            return false;
        }
        createVisualAnimationManager(stepGuideModel);
        View view = this.anchorView;
        final View viewA = sdk.pendo.io.b.d.a(view != null ? view.getContext() : null, viewContentJson, (ViewGroup) null, GuideViewHolder.class, getGuideId(), currentStepId);
        final boolean touchPassThrough = getTouchPassThrough();
        final String dimenViewStringPropertyClean = getDimenViewStringPropertyClean("frameWidth");
        final String dimenViewStringPropertyClean2 = getDimenViewStringPropertyClean("frameRadius");
        final String strokeColor = getStrokeColor();
        final String dimenViewStringPropertyClean3 = getDimenViewStringPropertyClean("caret_width");
        final String dimenViewStringPropertyClean4 = getDimenViewStringPropertyClean("caret_height");
        final String dimenViewStringPropertyClean5 = getDimenViewStringPropertyClean("layout_marginLeft");
        final String dimenViewStringPropertyClean6 = getDimenViewStringPropertyClean("layout_marginRight");
        final String dimenViewStringPropertyClean7 = getDimenViewStringPropertyClean("layout_marginTop");
        final String dimenViewStringPropertyClean8 = getDimenViewStringPropertyClean("layout_marginBottom");
        if (this.backDropPropertiesToBePopulated.get(FloatingVisualGuide.BACKDROP_ENABLED_KEY) != null && (obj = this.backDropPropertiesToBePopulated.get(FloatingVisualGuide.BACKDROP_ENABLED_KEY)) != null) {
            if (w0.a(obj)) {
                z = true;
            }
            setStartDuration(System.currentTimeMillis());
            final boolean z2 = z;
            activityA.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.ToolTipVisualGuide$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ToolTipVisualGuide.show$lambda$3(this.f$0, strC, viewA, dimenViewStringPropertyClean, strokeColor, dimenViewStringPropertyClean2, z2, dimenViewStringPropertyClean3, dimenViewStringPropertyClean4, touchPassThrough, dimenViewStringPropertyClean7, dimenViewStringPropertyClean5, dimenViewStringPropertyClean6, dimenViewStringPropertyClean8, tooltipManager);
                }
            });
            return true;
        }
        z = false;
        setStartDuration(System.currentTimeMillis());
        final boolean z3 = z;
        activityA.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.ToolTipVisualGuide$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToolTipVisualGuide.show$lambda$3(this.f$0, strC, viewA, dimenViewStringPropertyClean, strokeColor, dimenViewStringPropertyClean2, z3, dimenViewStringPropertyClean3, dimenViewStringPropertyClean4, touchPassThrough, dimenViewStringPropertyClean7, dimenViewStringPropertyClean5, dimenViewStringPropertyClean6, dimenViewStringPropertyClean8, tooltipManager);
            }
        });
        return true;
    }
}
