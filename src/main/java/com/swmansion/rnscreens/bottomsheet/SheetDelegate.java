package com.swmansion.rnscreens.bottomsheet;

import android.animation.Animator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.inputmethod.InputMethodManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.pspdfkit.BuildConfig;
import com.swmansion.rnscreens.InsetsObserverProxy;
import com.swmansion.rnscreens.KeyboardDidHide;
import com.swmansion.rnscreens.KeyboardNotVisible;
import com.swmansion.rnscreens.KeyboardState;
import com.swmansion.rnscreens.KeyboardVisible;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContainer;
import com.swmansion.rnscreens.ScreenContentWrapper;
import com.swmansion.rnscreens.ScreenFooter;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.utils.DecorViewInsetsUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SheetDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0004WXYZB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020+H\u0002J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020+H\u0002J\u001b\u00109\u001a\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0000¢\u0006\u0002\b;J5\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010=\u001a\u00020\u000eH\u0000¢\u0006\u0002\b>J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020@H\u0016J\u0010\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0011\u0010E\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010GJ\u000f\u0010I\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010GJ\u0015\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bPJ\u0015\u0010Q\u001a\u00020+2\u0006\u0010B\u001a\u00020@H\u0000¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020+H\u0000¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020+H\u0000¢\u0006\u0002\bVR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006["}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "screen", "Lcom/swmansion/rnscreens/Screen;", "<init>", "(Lcom/swmansion/rnscreens/Screen;)V", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "isKeyboardVisible", "", "keyboardState", "Lcom/swmansion/rnscreens/KeyboardState;", "lastTopInset", "", "value", "lastStableDetentIndex", "getLastStableDetentIndex", "()I", "lastStableState", "getLastStableState$annotations", "()V", "getLastStableState", "sheetStateObserver", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$SheetStateObserver;", "keyboardHandlerCallback", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$KeyboardHandler;", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "stackFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "getStackFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "requireDecorView", "Landroid/view/View;", "viewToRestoreFocus", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getInputMethodManager", "()Landroid/view/inputmethod/InputMethodManager;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "handleHostFragmentOnCreate", "handleHostFragmentOnStart", "handleHostFragmentOnResume", "handleHostFragmentOnPause", "handleHostFragmentOnDestroy", "onSheetStateChanged", "newState", "preserveBackgroundFocus", "restoreBackgroundFocus", "updateBottomSheetMetrics", "behavior", "updateBottomSheetMetrics$react_native_screens_release", "configureBottomSheetBehaviour", "selectedDetentIndex", "configureBottomSheetBehaviour$react_native_screens_release", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "insets", "shouldDismissSheetInState", "state", "tryResolveMaxFormSheetHeight", "tryResolveMaxFormSheetHeight$react_native_screens_release", "()Ljava/lang/Integer;", "tryResolveSafeAreaSpaceForSheet", "tryResolveContainerHeight", "createSheetEnterAnimator", "Landroid/animation/Animator;", "sheetAnimationContext", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$SheetAnimationContext;", "createSheetEnterAnimator$react_native_screens_release", "createSheetExitAnimator", "createSheetExitAnimator$react_native_screens_release", "handleKeyboardInsetsProgress", "handleKeyboardInsetsProgress$react_native_screens_release", "notifyKeyboardAnimationStart", "notifyKeyboardAnimationStart$react_native_screens_release", "notifyKeyboardAnimationEnd", "notifyKeyboardAnimationEnd$react_native_screens_release", "KeyboardHandler", "SheetStateObserver", "SheetAnimationContext", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetDelegate implements LifecycleEventObserver, OnApplyWindowInsetsListener {
    public static final String TAG = "SheetDelegate";
    private boolean isKeyboardVisible;
    private final KeyboardHandler keyboardHandlerCallback;
    private KeyboardState keyboardState;
    private int lastStableDetentIndex;
    private int lastStableState;
    private int lastTopInset;
    private final Screen screen;
    private final SheetStateObserver sheetStateObserver;
    private View viewToRestoreFocus;

    /* JADX INFO: compiled from: SheetDelegate.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getLastStableState$annotations() {
    }

    private final boolean shouldDismissSheetInState(int state) {
        return state == 5;
    }

    public SheetDelegate(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screen = screen;
        this.keyboardState = KeyboardNotVisible.INSTANCE;
        this.lastStableDetentIndex = screen.getSheetInitialDetentIndex();
        this.lastStableState = screen.getSheetDetents().sheetStateFromIndex$react_native_screens_release(screen.getSheetInitialDetentIndex());
        SheetStateObserver sheetStateObserver = new SheetStateObserver();
        this.sheetStateObserver = sheetStateObserver;
        this.keyboardHandlerCallback = new KeyboardHandler();
        boolean z = screen.getFragment() instanceof ScreenStackFragment;
        Fragment fragment = screen.getFragment();
        Intrinsics.checkNotNull(fragment);
        fragment.getLifecycleRegistry().addObserver(this);
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior == null) {
            throw new IllegalStateException("[RNScreens] Sheet delegate accepts screen with initialized sheet behaviour only.".toString());
        }
        sheetBehavior.addBottomSheetCallback(sheetStateObserver);
    }

    public final Screen getScreen() {
        return this.screen;
    }

    public final int getLastStableDetentIndex() {
        return this.lastStableDetentIndex;
    }

    public final int getLastStableState() {
        return this.lastStableState;
    }

    private final BottomSheetBehavior<Screen> getSheetBehavior() {
        return this.screen.getSheetBehavior();
    }

    private final ScreenStackFragment getStackFragment() {
        Fragment fragment = this.screen.getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
        return (ScreenStackFragment) fragment;
    }

    private final View requireDecorView() {
        Activity currentActivity = this.screen.getReactContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("[RNScreens] Attempt to access activity on detached context".toString());
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        return decorView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputMethodManager getInputMethodManager() {
        Object systemService = this.screen.getReactContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            return (InputMethodManager) systemService;
        }
        return null;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            handleHostFragmentOnCreate();
            return;
        }
        if (i == 2) {
            handleHostFragmentOnStart();
            return;
        }
        if (i == 3) {
            handleHostFragmentOnResume();
        } else if (i == 4) {
            handleHostFragmentOnPause();
        } else {
            if (i != 5) {
                return;
            }
            handleHostFragmentOnDestroy();
        }
    }

    private final void handleHostFragmentOnCreate() {
        preserveBackgroundFocus();
    }

    private final void handleHostFragmentOnStart() {
        InsetsObserverProxy.INSTANCE.registerOnView(requireDecorView());
    }

    private final void handleHostFragmentOnResume() {
        InsetsObserverProxy.INSTANCE.addOnApplyWindowInsetsListener(this);
    }

    private final void handleHostFragmentOnPause() {
        InsetsObserverProxy.INSTANCE.removeOnApplyWindowInsetsListener(this);
    }

    private final void handleHostFragmentOnDestroy() {
        restoreBackgroundFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSheetStateChanged(int newState) {
        boolean zIsStateStable = SheetUtils.INSTANCE.isStateStable(newState);
        if (zIsStateStable) {
            this.lastStableState = newState;
            this.lastStableDetentIndex = this.screen.getSheetDetents().indexFromSheetState$react_native_screens_release(newState);
        }
        this.screen.onSheetDetentChanged$react_native_screens_release(this.lastStableDetentIndex, zIsStateStable);
        if (shouldDismissSheetInState(newState)) {
            getStackFragment().dismissSelf$react_native_screens_release();
        }
    }

    private final void preserveBackgroundFocus() {
        View currentFocus;
        View decorView;
        Activity currentActivity = this.screen.getReactContext().getCurrentActivity();
        if (currentActivity == null || (currentFocus = currentActivity.getCurrentFocus()) == null) {
            return;
        }
        Window window = currentActivity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && Intrinsics.areEqual((Object) DecorViewInsetsUtilsKt.isSoftKeyboardVisibleOrNull(decorView), (Object) true)) {
            this.viewToRestoreFocus = currentFocus;
        }
        this.screen.requestFocus();
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private final void restoreBackgroundFocus() {
        View view = this.viewToRestoreFocus;
        if (view != null) {
            view.requestFocus();
            InputMethodManager inputMethodManager = getInputMethodManager();
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 0);
            }
        }
        this.viewToRestoreFocus = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0034  */
    public final void updateBottomSheetMetrics$react_native_screens_release(BottomSheetBehavior<Screen> behavior) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Integer numTryResolveMaxFormSheetHeight$react_native_screens_release = tryResolveMaxFormSheetHeight$react_native_screens_release();
        if (numTryResolveMaxFormSheetHeight$react_native_screens_release == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration".toString());
        }
        boolean zIsSheetFitToContents = SheetUtilsKt.isSheetFitToContents(this.screen);
        if (zIsSheetFitToContents) {
            ScreenContentWrapper contentWrapper = this.screen.getContentWrapper();
            if (contentWrapper != null) {
                numValueOf = Integer.valueOf(contentWrapper.getHeight());
                numValueOf.intValue();
                if (!SheetUtilsKt.isLaidOutOrHasCachedLayout(contentWrapper)) {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
        } else {
            if (zIsSheetFitToContents) {
                throw new NoWhenBranchMatchedException();
            }
            numValueOf = Integer.valueOf((int) (this.screen.getSheetDetents().highest$react_native_screens_release() * ((double) numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())));
        }
        BottomSheetBehaviorExtKt.updateMetrics(behavior, numValueOf, this.screen.getSheetDetents().getCount$react_native_screens_release() == 3 ? Integer.valueOf(this.screen.getSheetDetents().expandedOffsetFromTop$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue(), this.lastTopInset, this.screen.getSheetShouldOverflowTopInset())) : null);
    }

    public static /* synthetic */ BottomSheetBehavior configureBottomSheetBehaviour$react_native_screens_release$default(SheetDelegate sheetDelegate, BottomSheetBehavior bottomSheetBehavior, KeyboardState keyboardState, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            keyboardState = KeyboardNotVisible.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            i = sheetDelegate.lastStableDetentIndex;
        }
        return sheetDelegate.configureBottomSheetBehaviour$react_native_screens_release(bottomSheetBehavior, keyboardState, i);
    }

    public final BottomSheetBehavior<Screen> configureBottomSheetBehaviour$react_native_screens_release(BottomSheetBehavior<Screen> behavior, KeyboardState keyboardState, int selectedDetentIndex) {
        int iMaxAllowedHeight$react_native_screens_release;
        BottomSheetBehavior<Screen> bottomSheetBehavior;
        int iMaxAllowedHeight$react_native_screens_release2;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(keyboardState, "keyboardState");
        Integer numTryResolveMaxFormSheetHeight$react_native_screens_release = tryResolveMaxFormSheetHeight$react_native_screens_release();
        if (numTryResolveMaxFormSheetHeight$react_native_screens_release == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration".toString());
        }
        behavior.setHideable(true);
        behavior.setDraggable(true);
        behavior.addBottomSheetCallback(this.sheetStateObserver);
        ScreenFooter footer = this.screen.getFooter();
        if (footer != null) {
            footer.registerWithSheetBehavior(behavior);
        }
        if (keyboardState instanceof KeyboardNotVisible) {
            int count$react_native_screens_release = this.screen.getSheetDetents().getCount$react_native_screens_release();
            if (count$react_native_screens_release == 1) {
                if (SheetUtilsKt.isSheetFitToContents(this.screen)) {
                    iMaxAllowedHeight$react_native_screens_release2 = this.screen.getSheetDetents().maxAllowedHeightForFitToContents$react_native_screens_release(this.screen);
                } else {
                    iMaxAllowedHeight$react_native_screens_release2 = this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue());
                }
                BottomSheetBehaviorExtKt.useSingleDetent$default(behavior, Integer.valueOf(iMaxAllowedHeight$react_native_screens_release2), false, Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()), 2, null);
                return behavior;
            }
            if (count$react_native_screens_release == 2) {
                return BottomSheetBehaviorExtKt.useTwoDetents(behavior, Integer.valueOf(this.screen.getSheetDetents().sheetStateFromIndex$react_native_screens_release(selectedDetentIndex)), Integer.valueOf(this.screen.getSheetDetents().firstHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Integer.valueOf(this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()));
            }
            if (count$react_native_screens_release == 3) {
                return BottomSheetBehaviorExtKt.useThreeDetents(behavior, Integer.valueOf(this.screen.getSheetDetents().sheetStateFromIndex$react_native_screens_release(selectedDetentIndex)), Integer.valueOf(this.screen.getSheetDetents().firstHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Integer.valueOf(this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Float.valueOf(this.screen.getSheetDetents().halfExpandedRatio$react_native_screens_release()), Integer.valueOf(this.screen.getSheetDetents().expandedOffsetFromTop$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue(), this.lastTopInset, this.screen.getSheetShouldOverflowTopInset())), Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()));
            }
            throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().getCount$react_native_screens_release() + ". Expected at most 3.");
        }
        if (keyboardState instanceof KeyboardVisible) {
            boolean z = ((KeyboardVisible) keyboardState).getHeight() != 0;
            int count$react_native_screens_release2 = this.screen.getSheetDetents().getCount$react_native_screens_release();
            if (count$react_native_screens_release2 == 1) {
                behavior.addBottomSheetCallback(this.keyboardHandlerCallback);
                return behavior;
            }
            if (count$react_native_screens_release2 == 2) {
                if (z) {
                    BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, 3, null, null, null, 14, null);
                } else {
                    BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, null, null, null, null, 15, null);
                }
                behavior.addBottomSheetCallback(this.keyboardHandlerCallback);
                return behavior;
            }
            if (count$react_native_screens_release2 == 3) {
                if (z) {
                    bottomSheetBehavior = behavior;
                    BottomSheetBehaviorExtKt.useThreeDetents$default(bottomSheetBehavior, 3, null, null, null, null, null, 62, null);
                } else {
                    bottomSheetBehavior = behavior;
                    BottomSheetBehaviorExtKt.useThreeDetents$default(bottomSheetBehavior, null, null, null, null, null, null, 63, null);
                }
                bottomSheetBehavior.addBottomSheetCallback(this.keyboardHandlerCallback);
                return bottomSheetBehavior;
            }
            throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().getCount$react_native_screens_release() + ". Expected at most 3.");
        }
        if (!(keyboardState instanceof KeyboardDidHide)) {
            throw new NoWhenBranchMatchedException();
        }
        behavior.removeBottomSheetCallback(this.keyboardHandlerCallback);
        int count$react_native_screens_release3 = this.screen.getSheetDetents().getCount$react_native_screens_release();
        if (count$react_native_screens_release3 == 1) {
            if (SheetUtilsKt.isSheetFitToContents(this.screen)) {
                iMaxAllowedHeight$react_native_screens_release = this.screen.getSheetDetents().maxAllowedHeightForFitToContents$react_native_screens_release(this.screen);
            } else {
                iMaxAllowedHeight$react_native_screens_release = this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue());
            }
            BottomSheetBehaviorExtKt.useSingleDetent(behavior, Integer.valueOf(iMaxAllowedHeight$react_native_screens_release), false, Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()));
            return behavior;
        }
        if (count$react_native_screens_release3 == 2) {
            return BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, null, Integer.valueOf(this.screen.getSheetDetents().firstHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Integer.valueOf(this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()), 1, null);
        }
        if (count$react_native_screens_release3 == 3) {
            return BottomSheetBehaviorExtKt.useThreeDetents$default(behavior, null, Integer.valueOf(this.screen.getSheetDetents().firstHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Integer.valueOf(this.screen.getSheetDetents().maxAllowedHeight$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue())), Float.valueOf(this.screen.getSheetDetents().halfExpandedRatio$react_native_screens_release()), Integer.valueOf(this.screen.getSheetDetents().expandedOffsetFromTop$react_native_screens_release(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue(), this.lastTopInset, this.screen.getSheetShouldOverflowTopInset())), Boolean.valueOf(this.screen.getSheetShouldOverflowTopInset()), 1, null);
        }
        throw new IllegalStateException("[RNScreens] Invalid detent count " + this.screen.getSheetDetents().getCount$react_native_screens_release() + ". Expected at most 3.");
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        boolean zIsVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
        Insets insets4 = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
        this.lastTopInset = Math.max(insets3.top, insets4.top);
        if (zIsVisible) {
            this.isKeyboardVisible = true;
            this.keyboardState = new KeyboardVisible(insets2.bottom);
            BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
            if (sheetBehavior != null) {
                configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior, this.keyboardState, 0, 4, null);
            }
        } else {
            BottomSheetBehavior<Screen> sheetBehavior2 = getSheetBehavior();
            if (sheetBehavior2 != null) {
                if (this.isKeyboardVisible) {
                    configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior2, KeyboardDidHide.INSTANCE, 0, 4, null);
                } else if (!Intrinsics.areEqual(this.keyboardState, KeyboardNotVisible.INSTANCE)) {
                    configureBottomSheetBehaviour$react_native_screens_release$default(this, sheetBehavior2, KeyboardNotVisible.INSTANCE, 0, 4, null);
                }
            }
            this.keyboardState = KeyboardNotVisible.INSTANCE;
            this.isKeyboardVisible = false;
        }
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(insets3.left, insets3.top, insets3.right, zIsVisible ? 0 : insets3.bottom)).build();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
        return windowInsetsCompatBuild;
    }

    public final Integer tryResolveMaxFormSheetHeight$react_native_screens_release() {
        if (this.screen.getSheetShouldOverflowTopInset()) {
            return tryResolveContainerHeight();
        }
        return tryResolveSafeAreaSpaceForSheet();
    }

    private final Integer tryResolveSafeAreaSpaceForSheet() {
        Integer numTryResolveContainerHeight = tryResolveContainerHeight();
        if (numTryResolveContainerHeight != null) {
            return Integer.valueOf(numTryResolveContainerHeight.intValue() - this.lastTopInset);
        }
        return null;
    }

    private final Integer tryResolveContainerHeight() {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        DisplayMetrics displayMetrics;
        ScreenContainer container = this.screen.getContainer();
        if (container != null) {
            return Integer.valueOf(container.getHeight());
        }
        ThemedReactContext reactContext = this.screen.getReactContext();
        Resources resources = reactContext.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return Integer.valueOf(displayMetrics.heightPixels);
        }
        Object systemService = reactContext.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null || (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) == null || (bounds = currentWindowMetrics.getBounds()) == null) {
            return null;
        }
        return Integer.valueOf(bounds.height());
    }

    public final Animator createSheetEnterAnimator$react_native_screens_release(SheetAnimationContext sheetAnimationContext) {
        Intrinsics.checkNotNullParameter(sheetAnimationContext, "sheetAnimationContext");
        return this.screen.getSheetAnimationCoordinator$react_native_screens_release().createSheetEnterAnimator$react_native_screens_release(sheetAnimationContext);
    }

    public final Animator createSheetExitAnimator$react_native_screens_release(SheetAnimationContext sheetAnimationContext) {
        Intrinsics.checkNotNullParameter(sheetAnimationContext, "sheetAnimationContext");
        return this.screen.getSheetAnimationCoordinator$react_native_screens_release().createSheetExitAnimator$react_native_screens_release(sheetAnimationContext);
    }

    public final void handleKeyboardInsetsProgress$react_native_screens_release(WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        this.screen.getSheetAnimationCoordinator$react_native_screens_release().handleKeyboardInsetsProgress$react_native_screens_release(insets);
    }

    public final void notifyKeyboardAnimationStart$react_native_screens_release() {
        this.screen.getSheetAnimationCoordinator$react_native_screens_release().notifyKeyboardAnimationStart$react_native_screens_release();
    }

    public final void notifyKeyboardAnimationEnd$react_native_screens_release() {
        this.screen.getSheetAnimationCoordinator$react_native_screens_release().notifyKeyboardAnimationEnd$react_native_screens_release();
    }

    /* JADX INFO: compiled from: SheetDelegate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$KeyboardHandler;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "<init>", "(Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;)V", "onStateChanged", "", "bottomSheet", "Landroid/view/View;", "newState", "", "onSlide", "slideOffset", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class KeyboardHandler extends BottomSheetBehavior.BottomSheetCallback {
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        public KeyboardHandler() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4 && WindowInsetsCompat.toWindowInsetsCompat(bottomSheet.getRootWindowInsets()).isVisible(WindowInsetsCompat.Type.ime())) {
                bottomSheet.requestFocus();
                InputMethodManager inputMethodManager = SheetDelegate.this.getInputMethodManager();
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(bottomSheet.getWindowToken(), 0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SheetDelegate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$SheetStateObserver;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "<init>", "(Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;)V", "onStateChanged", "", "bottomSheet", "Landroid/view/View;", "newState", "", "onSlide", "slideOffset", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class SheetStateObserver extends BottomSheetBehavior.BottomSheetCallback {
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        public SheetStateObserver() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            SheetDelegate.this.onSheetStateChanged(newState);
        }
    }

    /* JADX INFO: compiled from: SheetDelegate.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$SheetAnimationContext;", "", BuildConfig.FLAVOR, "Lcom/swmansion/rnscreens/ScreenStackFragment;", "screen", "Lcom/swmansion/rnscreens/Screen;", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "dimmingDelegate", "Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "<init>", "(Lcom/swmansion/rnscreens/ScreenStackFragment;Lcom/swmansion/rnscreens/Screen;Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;)V", "getFragment", "()Lcom/swmansion/rnscreens/ScreenStackFragment;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "getCoordinatorLayout", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getDimmingDelegate", "()Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class SheetAnimationContext {
        private final CoordinatorLayout coordinatorLayout;
        private final DimmingViewManager dimmingDelegate;
        private final ScreenStackFragment fragment;
        private final Screen screen;

        public static /* synthetic */ SheetAnimationContext copy$default(SheetAnimationContext sheetAnimationContext, ScreenStackFragment screenStackFragment, Screen screen, CoordinatorLayout coordinatorLayout, DimmingViewManager dimmingViewManager, int i, Object obj) {
            if ((i & 1) != 0) {
                screenStackFragment = sheetAnimationContext.fragment;
            }
            if ((i & 2) != 0) {
                screen = sheetAnimationContext.screen;
            }
            if ((i & 4) != 0) {
                coordinatorLayout = sheetAnimationContext.coordinatorLayout;
            }
            if ((i & 8) != 0) {
                dimmingViewManager = sheetAnimationContext.dimmingDelegate;
            }
            return sheetAnimationContext.copy(screenStackFragment, screen, coordinatorLayout, dimmingViewManager);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScreenStackFragment getFragment() {
            return this.fragment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Screen getScreen() {
            return this.screen;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CoordinatorLayout getCoordinatorLayout() {
            return this.coordinatorLayout;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DimmingViewManager getDimmingDelegate() {
            return this.dimmingDelegate;
        }

        public final SheetAnimationContext copy(ScreenStackFragment fragment, Screen screen, CoordinatorLayout coordinatorLayout, DimmingViewManager dimmingDelegate) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(dimmingDelegate, "dimmingDelegate");
            return new SheetAnimationContext(fragment, screen, coordinatorLayout, dimmingDelegate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SheetAnimationContext)) {
                return false;
            }
            SheetAnimationContext sheetAnimationContext = (SheetAnimationContext) other;
            return Intrinsics.areEqual(this.fragment, sheetAnimationContext.fragment) && Intrinsics.areEqual(this.screen, sheetAnimationContext.screen) && Intrinsics.areEqual(this.coordinatorLayout, sheetAnimationContext.coordinatorLayout) && Intrinsics.areEqual(this.dimmingDelegate, sheetAnimationContext.dimmingDelegate);
        }

        public int hashCode() {
            return (((((this.fragment.hashCode() * 31) + this.screen.hashCode()) * 31) + this.coordinatorLayout.hashCode()) * 31) + this.dimmingDelegate.hashCode();
        }

        public String toString() {
            return "SheetAnimationContext(fragment=" + this.fragment + ", screen=" + this.screen + ", coordinatorLayout=" + this.coordinatorLayout + ", dimmingDelegate=" + this.dimmingDelegate + ")";
        }

        public SheetAnimationContext(ScreenStackFragment fragment, Screen screen, CoordinatorLayout coordinatorLayout, DimmingViewManager dimmingDelegate) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(dimmingDelegate, "dimmingDelegate");
            this.fragment = fragment;
            this.screen = screen;
            this.coordinatorLayout = coordinatorLayout;
            this.dimmingDelegate = dimmingDelegate;
        }

        public final ScreenStackFragment getFragment() {
            return this.fragment;
        }

        public final Screen getScreen() {
            return this.screen;
        }

        public final CoordinatorLayout getCoordinatorLayout() {
            return this.coordinatorLayout;
        }

        public final DimmingViewManager getDimmingDelegate() {
            return this.dimmingDelegate;
        }
    }
}
