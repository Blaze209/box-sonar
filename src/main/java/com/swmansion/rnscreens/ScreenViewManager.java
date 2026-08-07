package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.pspdfkit.internal.cw;
import com.swmansion.rnscreens.bottomsheet.SheetDetents;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\b\u0017\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\\B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0015H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0017J\u001a\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00100\u001a\u00020'H\u0016J\u0018\u00101\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00102\u001a\u00020'H\u0016J\u0018\u00103\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00104\u001a\u00020'H\u0016J\u001a\u00105\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020\u0017H\u0016J\u001a\u00107\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00108\u001a\u00020'H\u0016J\u001a\u00109\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010:\u001a\u00020'H\u0016J\u001f\u0010;\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001f\u0010>\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010<J\u0018\u0010?\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001c\u0010@\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010A\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010B\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020\u0017H\u0016J\u001a\u0010C\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010D\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001c\u0010E\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010FH\u0016J\u001a\u0010G\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010H\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001c\u0010I\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010J\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010K\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010L\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010M\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010N\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010O\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010P\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u00106\u001a\u00020'H\u0016J\u001a\u0010Q\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010RH\u0016J\u0018\u0010S\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0017H\u0016J\u0018\u0010T\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020'H\u0016J\u0018\u0010U\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0011H\u0016J\u0018\u0010V\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020'H\u0016J\u0018\u0010W\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0017H\u0016J\u001a\u0010X\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0ZH\u0016J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "Lcom/facebook/react/viewmanagers/RNSScreenManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setActivityState", "", "view", cw.PARAM_ACTIVITY_STATE, "", "addView", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeViewAt", "removeView", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "setStackPresentation", "presentation", "setStackAnimation", "animation", "setGestureEnabled", "gestureEnabled", "", "setReplaceAnimation", "setScreenOrientation", "screenOrientation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarStyle", "statusBarStyle", "setStatusBarHidden", "statusBarHidden", "setNavigationBarHidden", "navigationBarHidden", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setSheetElevation", "value", "setSheetShouldOverflowTopInset", "sheetShouldOverflowTopInset", "setSheetDefaultResizeAnimationEnabled", "sheetDefaultResizeAnimationEnabled", "setStatusBarColor", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setStatusBarTranslucent", "setNavigationBarColor", "setNavigationBarTranslucent", "setFullScreenSwipeEnabled", "setFullScreenSwipeShadowEnabled", "setTransitionDuration", "setHideKeyboardOnSwipe", "setCustomAnimationOnSwipe", "setGestureResponseDistance", "Lcom/facebook/react/bridge/ReadableMap;", "setHomeIndicatorHidden", "setPreventNativeDismiss", "setSwipeDirection", "setBottomScrollEdgeEffect", "setLeftScrollEdgeEffect", "setRightScrollEdgeEffect", "setTopScrollEdgeEffect", "setSynchronousShadowStateUpdatesEnabled", "setIos26AllowInteractionsDuringTransition", "setAndroidResetScreenShadowStateOnOrientationChangeEnabled", "setSheetAllowedDetents", "Lcom/facebook/react/bridge/ReadableArray;", "setSheetLargestUndimmedDetent", "setSheetGrabberVisible", "setSheetCornerRadius", "setSheetExpandsWhenScrolledToEdge", "setSheetInitialDetent", "setScreenId", "getExportedCustomDirectEventTypeConstants", "", "getDelegate", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = ScreenViewManager.REACT_CLASS)
public class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {
    public static final String REACT_CLASS = "RNSScreen";
    private final ViewManagerDelegate<Screen> delegate;

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setAndroidResetScreenShadowStateOnOrientationChangeEnabled(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setBottomScrollEdgeEffect(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setCustomAnimationOnSwipe(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeEnabled(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeShadowEnabled(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setGestureResponseDistance(Screen view, ReadableMap value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHideKeyboardOnSwipe(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHomeIndicatorHidden(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setIos26AllowInteractionsDuringTransition(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setLeftScrollEdgeEffect(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setNavigationBarColor(Screen view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setNavigationBarTranslucent(Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setPreventNativeDismiss(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setRightScrollEdgeEffect(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setStatusBarColor(Screen view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setStatusBarTranslucent(Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSwipeDirection(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSynchronousShadowStateUpdatesEnabled(Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setTopScrollEdgeEffect(Screen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setTransitionDuration(Screen view, int value) {
    }

    public ScreenViewManager() {
        super(null, 1, null);
        this.delegate = new RNSScreenManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public Screen createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new Screen(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setActivityState(Screen view, float activityState) {
        Intrinsics.checkNotNullParameter(view, "view");
        setActivityState(view, (int) activityState);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(Screen parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof ScreenContentWrapper) {
            parent.registerLayoutCallbackForWrapper((ScreenContentWrapper) child);
        } else if (child instanceof ScreenFooter) {
            parent.setFooter((ScreenFooter) child);
        }
        super.addView(parent, child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(Screen parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getChildAt(index) instanceof ScreenFooter) {
            parent.setFooter(null);
        }
        super.removeViewAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(Screen parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        super.removeView(parent, view);
        if (view instanceof ScreenFooter) {
            parent.setFooter(null);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(Screen view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(Screen view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.onFinalizePropsUpdate$react_native_screens_release();
    }

    public final void setActivityState(Screen view, int activityState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (activityState == -1) {
            return;
        }
        if (activityState == 0) {
            view.setActivityState(Screen.ActivityState.INACTIVE);
        } else if (activityState == 1) {
            view.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
        } else {
            if (activityState != 2) {
                return;
            }
            view.setActivityState(Screen.ActivityState.ON_TOP);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.equals("fullScreenModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.equals("containedTransparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r3.equals("pageSheet") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r3.equals("containedModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r3.equals("modal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r1 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if (r3.equals("transparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r1 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStackPresentation(com.swmansion.rnscreens.Screen r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            if (r3 == 0) goto L62
            int r1 = r3.hashCode()
            switch(r1) {
                case -76271493: goto L54;
                case 3452698: goto L49;
                case 104069805: goto L3e;
                case 438078970: goto L35;
                case 872434704: goto L2c;
                case 955284238: goto L23;
                case 1171936146: goto L1a;
                case 1798290171: goto Lf;
                default: goto Le;
            }
        Le:
            goto L62
        Lf:
            java.lang.String r1 = "formSheet"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r1 = com.swmansion.rnscreens.Screen.StackPresentation.FORM_SHEET
            goto L5e
        L1a:
            java.lang.String r1 = "fullScreenModal"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            goto L46
        L23:
            java.lang.String r1 = "containedTransparentModal"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            goto L5c
        L2c:
            java.lang.String r1 = "pageSheet"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            goto L46
        L35:
            java.lang.String r1 = "containedModal"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            goto L46
        L3e:
            java.lang.String r1 = "modal"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
        L46:
            com.swmansion.rnscreens.Screen$StackPresentation r1 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L5e
        L49:
            java.lang.String r1 = "push"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
            com.swmansion.rnscreens.Screen$StackPresentation r1 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L5e
        L54:
            java.lang.String r1 = "transparentModal"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L62
        L5c:
            com.swmansion.rnscreens.Screen$StackPresentation r1 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L5e:
            r2.setStackPresentation(r1)
            return
        L62:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "Unknown presentation type "
            r2.<init>(r0)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r3.equals("default") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        if (r3.equals("flip") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        if (r3.equals("simple_push") != false) goto L42;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStackAnimation(com.swmansion.rnscreens.Screen r2, java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setGestureEnabled(Screen view, boolean gestureEnabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setGestureEnabled(gestureEnabled);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setReplaceAnimation(Screen view, String animation) {
        Screen.ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (animation == null || Intrinsics.areEqual(animation, TokenRequest.TokenType.POP)) {
            replaceAnimation = Screen.ReplaceAnimation.POP;
        } else {
            if (!Intrinsics.areEqual(animation, "push")) {
                throw new JSApplicationIllegalArgumentException("Unknown replace animation type " + animation);
            }
            replaceAnimation = Screen.ReplaceAnimation.PUSH;
        }
        view.setReplaceAnimation(replaceAnimation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setScreenOrientation(Screen view, String screenOrientation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScreenOrientation(screenOrientation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setStatusBarAnimation(Screen view, String statusBarAnimation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarAnimated(Boolean.valueOf((statusBarAnimation == null || Intrinsics.areEqual("none", statusBarAnimation)) ? false : true));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setStatusBarStyle(Screen view, String statusBarStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarStyle(statusBarStyle);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setStatusBarHidden(Screen view, boolean statusBarHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarHidden(Boolean.valueOf(statusBarHidden));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setNavigationBarHidden(Screen view, boolean navigationBarHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarHidden(Boolean.valueOf(navigationBarHidden));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setNativeBackButtonDismissalEnabled(Screen view, boolean nativeBackButtonDismissalEnabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeBackButtonDismissalEnabled(nativeBackButtonDismissalEnabled);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetElevation(Screen view, int value) {
        if (view != null) {
            view.setSheetElevation(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetShouldOverflowTopInset(Screen view, boolean sheetShouldOverflowTopInset) {
        if (view != null) {
            view.setSheetShouldOverflowTopInset(sheetShouldOverflowTopInset);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetDefaultResizeAnimationEnabled(Screen view, boolean sheetDefaultResizeAnimationEnabled) {
        if (view != null) {
            view.setSheetDefaultResizeAnimationEnabled(sheetDefaultResizeAnimationEnabled);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetAllowedDetents(Screen view, ReadableArray value) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null && value.size() > 0) {
            int size = value.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(Double.valueOf(value.getDouble(i)));
            }
            arrayListListOf = arrayList;
        } else {
            arrayListListOf = CollectionsKt.listOf(Double.valueOf(1.0d));
        }
        view.setSheetDetents(new SheetDetents(arrayListListOf));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetLargestUndimmedDetent(Screen view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (-1 > value || value >= 3) {
            throw new IllegalStateException("[RNScreens] sheetLargestUndimmedDetent on Android supports values between -1 and 2".toString());
        }
        view.setSheetLargestUndimmedDetentIndex(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetGrabberVisible(Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetGrabberVisible(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetCornerRadius(Screen view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetCornerRadius(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetExpandsWhenScrolledToEdge(Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetExpandsWhenScrolledToEdge(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSheetInitialDetent(Screen view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetInitialDetentIndex(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setScreenId(Screen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str = value;
        if (str == null || str.length() == 0) {
            value = null;
        }
        view.setScreenId(value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to(ScreenDismissedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onDismissed"))), TuplesKt.to("topWillAppear", MapsKt.hashMapOf(TuplesKt.to("registrationName", "onWillAppear"))), TuplesKt.to(ScreenAppearEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onAppear"))), TuplesKt.to("topWillDisappear", MapsKt.hashMapOf(TuplesKt.to("registrationName", "onWillDisappear"))), TuplesKt.to(ScreenDisappearEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onDisappear"))), TuplesKt.to(HeaderHeightChangeEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onHeaderHeightChange"))), TuplesKt.to(HeaderBackButtonClickedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onHeaderBackButtonClicked"))), TuplesKt.to(ScreenTransitionProgressEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onTransitionProgress"))), TuplesKt.to(SheetDetentChangedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.to("registrationName", "onSheetDetentChanged"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<Screen> getDelegate() {
        return this.delegate;
    }
}
