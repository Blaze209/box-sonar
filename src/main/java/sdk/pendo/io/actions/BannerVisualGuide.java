package sdk.pendo.io.actions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.custom.PendoLinearLayout;
import sdk.pendo.io.views.custom.PendoScrollView;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B%\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u0011\u001a\u00020\u00102\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0015\u001a\u00020\u0010J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0016H\u0007R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lsdk/pendo/io/actions/BannerVisualGuide;", "Lsdk/pendo/io/actions/FloatingVisualGuide;", "", "idHash", "Landroid/view/View;", "viewFromJson", "root", "", "locationPlacement", "Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "createBuilder", "Ljava/lang/ref/WeakReference;", "viewRef", "Lsdk/pendo/io/r5/g;", "analyticsData", "activatedBy", "", "init", "", "show", "removeFromMap", "updateStepDuration", "Landroid/view/ViewGroup;", "createViewFromJson", "Lsdk/pendo/io/actions/PendoBannerGuideManager;", "getBannerManager", "()Lsdk/pendo/io/actions/PendoBannerGuideManager;", "bannerManager", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/models/GuideModel;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class BannerVisualGuide extends FloatingVisualGuide {
    private static final String GRAVITY_FOR_BANNER = "gravity";
    private static final HashSet<String> SUPPORTED_BANNER_PROPERTIES = new HashSet<>(CollectionsKt.listOf(GRAVITY_FOR_BANNER));
    private static final String TAG = "BannerVisualGuide";

    public BannerVisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(VisualGuideBase.VisualGuideType.BANNER, guideModel, visualGuideLifecycleListener, stepSeenManagerInterface);
    }

    private final PendoBannerGuideManager.Builder createBuilder(String idHash, View viewFromJson, View root, int locationPlacement) {
        PendoFloatingVisualGuideManager.Builder builderWithCustomView = new PendoBannerGuideManager.Builder(idHash).anchor(root, locationPlacement).closePolicy(0L).background(getBackground()).toggleArrow(true).withCustomView(viewFromJson);
        String guideId = getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        PendoFloatingVisualGuideManager.Builder builderWithCallback = builderWithCustomView.guideId(guideId).withCallback(addCallback(idHash));
        Intrinsics.checkNotNull(builderWithCallback, "null cannot be cast to non-null type sdk.pendo.io.actions.PendoBannerGuideManager.Builder");
        return (PendoBannerGuideManager.Builder) builderWithCallback;
    }

    private final synchronized PendoBannerGuideManager getBannerManager() {
        PendoFloatingVisualGuideManager.INSTANCE.resetContext(c.h().a());
        return PendoBannerGuideManager.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    public static final void show$lambda$1(BannerVisualGuide this$0, String str, View view, ViewGroup root, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, PendoBannerGuideManager pendoBannerGuideManager) {
        boolean zBooleanValue;
        PendoDrawerListener pendoDrawerListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(root, "$root");
        Intrinsics.checkNotNull(str);
        PendoBannerGuideManager.Builder builderCreateBuilder = this$0.createBuilder(str, view, root, this$0.getLocationPlacementFrom(GRAVITY_FOR_BANNER));
        if (str2 != null && str3 != null) {
            builderCreateBuilder.strokeColor(str3).strokeWidth(str2);
        }
        if (str4 != null) {
            builderCreateBuilder.frameRadius(str4);
        }
        builderCreateBuilder.withTouchPassThrough(z);
        builderCreateBuilder.withMargins(str5, str6, str7, str8);
        builderCreateBuilder.backgroundImageProperties(str9, str10, str11);
        builderCreateBuilder.setPaneTitle(str12);
        StepSeenManager.getInstance().setIsBannerGuideStep(true);
        if (e1.a(root, 0)) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            root.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            if (accessibilityNodeInfoObtain == null || !accessibilityNodeInfoObtain.isVisibleToUser()) {
                zBooleanValue = false;
            } else {
                WeakReference<PendoDrawerListener> pendoDrawerListenerRef = PendoInternal.z().getPendoDrawerListenerRef();
                Integer numValueOf = (pendoDrawerListenerRef == null || (pendoDrawerListener = pendoDrawerListenerRef.get()) == null) ? null : Integer.valueOf(pendoDrawerListener.getDrawerState());
                if (numValueOf == null || numValueOf.intValue() == 0) {
                    Boolean boolValueOf = pendoBannerGuideManager != null ? Boolean.valueOf(pendoBannerGuideManager.show(builderCreateBuilder.build())) : null;
                    if (boolValueOf != null) {
                        zBooleanValue = boolValueOf.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                } else {
                    zBooleanValue = false;
                }
            }
        } else {
            zBooleanValue = false;
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

    public final View createViewFromJson(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        View viewA = sdk.pendo.io.b.d.a(root.getContext(), getViewContentJson(GuideActionConfiguration.VisualGuideType.BANNER), (ViewGroup) null, GuideViewHolder.class, getGuideId(), this.mStepSeenManager.getCurrentStepId());
        if (viewA instanceof PendoScrollView) {
            View childAt = ((PendoScrollView) viewA).getChildAt(0);
            ViewGroup.LayoutParams layoutParams = childAt != null ? childAt.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            ViewGroup.LayoutParams layoutParams2 = childAt != null ? childAt.getLayoutParams() : null;
            if (layoutParams2 != null) {
                layoutParams2.width = -1;
            }
        }
        String dimenViewStringPropertyClean = getDimenViewStringPropertyClean(ViewProps.MAX_WIDTH);
        if (viewA != null && dimenViewStringPropertyClean != null) {
            if (viewA instanceof PendoLinearLayout) {
                ((PendoLinearLayout) viewA).setLayoutMaxWidth(e1.a(Integer.parseInt(dimenViewStringPropertyClean)));
                return viewA;
            }
            ((PendoScrollView) viewA).setLayoutMaxWidth(e1.a(Integer.parseInt(dimenViewStringPropertyClean)));
        }
        return viewA;
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void init(WeakReference<View> viewRef, g analyticsData, String activatedBy) {
        Intrinsics.checkNotNullParameter(analyticsData, "analyticsData");
        Intrinsics.checkNotNullParameter(activatedBy, "activatedBy");
        super.init(activatedBy, analyticsData);
        setAnalyticsData(analyticsData);
        f floatingViewProperties = getFloatingViewProperties();
        if (floatingViewProperties != null) {
            FloatingVisualGuide.extractProperties(floatingViewProperties, getMViewPropertiesToBePopulated(), FloatingVisualGuide.getSUPPORTED_FLOATING_LAYOUT_PROPERTIES());
        }
        f floatingGuideProperties = getFloatingGuideProperties();
        if (floatingGuideProperties != null) {
            FloatingVisualGuide.extractProperties(floatingGuideProperties, getMViewPropertiesToBePopulated(), SUPPORTED_BANNER_PROPERTIES);
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide
    public void removeFromMap(String idHash) {
        Intrinsics.checkNotNullParameter(idHash, "idHash");
        PendoBannerGuideManager companion = PendoBannerGuideManager.INSTANCE.getInstance();
        if (companion != null) {
            companion.removeFromMap(idHash);
        }
    }

    @Override // sdk.pendo.io.actions.FloatingVisualGuide, sdk.pendo.io.actions.VisualGuideBase
    public synchronized boolean show() {
        PendoLogger.d("BannerVisualGuide show() starting", new Object[0]);
        final PendoBannerGuideManager bannerManager = getBannerManager();
        final String strC = getAnalyticsData().c();
        Activity activityA = c.h().a();
        if (activityA == null) {
            activityA = c.h().i();
        }
        if (activityA == null) {
            return false;
        }
        StepGuideModel stepGuideModel = getStepGuideModel();
        if (stepGuideModel == null) {
            PendoLogger.d(TAG, "BannerVisualGuide show() method aborted. The stepGuideModel was null");
            return false;
        }
        createVisualAnimationManager(stepGuideModel);
        View decorView = activityA.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) decorView;
        Activity activity = activityA;
        final View viewCreateViewFromJson = createViewFromJson(viewGroup);
        final String dimenViewStringPropertyClean = getDimenViewStringPropertyClean("frameWidth");
        final String dimenViewStringPropertyClean2 = getDimenViewStringPropertyClean("frameRadius");
        final String strokeColor = getStrokeColor();
        final String dimenViewStringPropertyClean3 = getDimenViewStringPropertyClean("layout_marginLeft");
        final String dimenViewStringPropertyClean4 = getDimenViewStringPropertyClean("layout_marginRight");
        final String dimenViewStringPropertyClean5 = getDimenViewStringPropertyClean("layout_marginTop");
        final String dimenViewStringPropertyClean6 = getDimenViewStringPropertyClean("layout_marginBottom");
        final String propertyValueFromViewProperties = getPropertyValueFromViewProperties("backgroundImageUrl");
        final String propertyValueFromViewProperties2 = getPropertyValueFromViewProperties("backgroundImageFillType");
        final String propertyValueFromViewProperties3 = getPropertyValueFromViewProperties("accessibilityText");
        final String propertyValueFromViewProperties4 = getPropertyValueFromViewProperties("ariaLabel");
        updateStepDuration();
        final boolean z = true;
        activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.BannerVisualGuide$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BannerVisualGuide.show$lambda$1(this.f$0, strC, viewCreateViewFromJson, viewGroup, dimenViewStringPropertyClean, strokeColor, dimenViewStringPropertyClean2, z, dimenViewStringPropertyClean5, dimenViewStringPropertyClean3, dimenViewStringPropertyClean4, dimenViewStringPropertyClean6, propertyValueFromViewProperties, propertyValueFromViewProperties2, propertyValueFromViewProperties3, propertyValueFromViewProperties4, bannerManager);
            }
        });
        return true;
    }

    public final synchronized void updateStepDuration() {
        long jLongValue;
        HashMap<String, Long> bannerStepDuration;
        HashMap<String, Long> bannerStepDuration2;
        HashMap<String, Long> bannerStepDuration3;
        String currentStepId = this.mStepSeenManager.getCurrentStepId();
        PendoBannerGuideManager.Companion companion = PendoBannerGuideManager.INSTANCE;
        PendoBannerGuideManager companion2 = companion.getInstance();
        Long l = (companion2 == null || (bannerStepDuration3 = companion2.getBannerStepDuration()) == null) ? null : bannerStepDuration3.get(currentStepId);
        if (l == null || !this.mStepSeenManager.isBannerGuideStep()) {
            PendoLogger.d("BannerVisualGuide updateStepDuration - new banner step is displayed", new Object[0]);
            PendoBannerGuideManager companion3 = companion.getInstance();
            if (companion3 != null && (bannerStepDuration2 = companion3.getBannerStepDuration()) != null) {
                bannerStepDuration2.clear();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            PendoBannerGuideManager companion4 = companion.getInstance();
            if (companion4 != null && (bannerStepDuration = companion4.getBannerStepDuration()) != null) {
                bannerStepDuration.put(currentStepId, Long.valueOf(jCurrentTimeMillis));
            }
            jLongValue = jCurrentTimeMillis;
        } else {
            PendoLogger.d("BannerVisualGuide updateStepDuration - same banner step is displayed", new Object[0]);
            jLongValue = l.longValue();
        }
        setStartDuration(jLongValue);
    }
}
