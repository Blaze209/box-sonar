package com.swmansion.rnscreens.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContentWrapper;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.events.ScreenAnimationDelegate;
import com.swmansion.rnscreens.events.ScreenEventEmitter;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import com.swmansion.rnscreens.transition.ExternalBoundaryValuesEvaluator;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SheetAnimationCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001aJ+\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0000¢\u0006\u0002\b!J.\u0010\"\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J.\u0010'\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\r\u0010(\u001a\u00020\u001cH\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u001cH\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\u0010\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0002J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020\u0012H\u0002J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0002J \u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020\u001cH\u0002J\u0014\u0010>\u001a\u00020\u001c*\u00020\u00032\u0006\u0010?\u001a\u00020\fH\u0002J\f\u0010@\u001a\u00020\u001c*\u00020\u0003H\u0002J \u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020FH\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/SheetAnimationCoordinator;", "", "screen", "Lcom/swmansion/rnscreens/Screen;", "<init>", "(Lcom/swmansion/rnscreens/Screen;)V", "screenRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "activeKeyboardAnimationsCount", "", "isKeyboardAnimationInProgress", "", "()Z", "isSheetAnimationInProgress", "currentContentAnimator", "Landroid/animation/ValueAnimator;", "lastKeyboardBottomOffset", "createSheetEnterAnimator", "Landroid/animation/Animator;", "sheetAnimationContext", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate$SheetAnimationContext;", "createSheetEnterAnimator$react_native_screens_release", "createSheetExitAnimator", "createSheetExitAnimator$react_native_screens_release", "updateSheetContentHeightWithAnimation", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "oldHeight", "newHeight", "updateSheetContentHeightWithAnimation$react_native_screens_release", "animateContentExpanding", "clampedNewHeight", "currentTranslationY", "", "visibleDelta", "animateContentShrinking", "notifyKeyboardAnimationStart", "notifyKeyboardAnimationStart$react_native_screens_release", "notifyKeyboardAnimationEnd", "notifyKeyboardAnimationEnd$react_native_screens_release", "handleKeyboardInsetsProgress", "insets", "Landroidx/core/view/WindowInsetsCompat;", "handleKeyboardInsetsProgress$react_native_screens_release", "computeSheetOffsetYWithIMEPresent", "keyboardHeight", "updateSheetTranslationY", "baseTranslationY", "createSheetSlideInAnimator", "createSheetSlideOutAnimator", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "createDimmingViewAlphaAnimator", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "dimmingDelegate", "Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "cancelCurrentContentAnimation", "layoutBottomSheetAtHeight", "height", "finalizeBottomSheetLayoutUpdates", "attachCommonListeners", "animatorSet", "Landroid/animation/AnimatorSet;", "isEnter", "screenStackFragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetAnimationCoordinator {
    private int activeKeyboardAnimationsCount;
    private ValueAnimator currentContentAnimator;
    private boolean isSheetAnimationInProgress;
    private int lastKeyboardBottomOffset;
    private final WeakReference<Screen> screenRef;

    public SheetAnimationCoordinator(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.screenRef = new WeakReference<>(screen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Screen getScreen() {
        Screen screen = this.screenRef.get();
        if (screen != null) {
            return screen;
        }
        throw new IllegalStateException("[RNScreens] Screen has been destroyed and shouldn't be the subject of any animations".toString());
    }

    private final boolean isKeyboardAnimationInProgress() {
        return this.activeKeyboardAnimationsCount > 0;
    }

    public final Animator createSheetEnterAnimator$react_native_screens_release(SheetDelegate.SheetAnimationContext sheetAnimationContext) {
        Intrinsics.checkNotNullParameter(sheetAnimationContext, "sheetAnimationContext");
        AnimatorSet animatorSet = new AnimatorSet();
        DimmingViewManager dimmingDelegate = sheetAnimationContext.getDimmingDelegate();
        ScreenStackFragment fragment = sheetAnimationContext.getFragment();
        ValueAnimator valueAnimatorCreateDimmingViewAlphaAnimator = createDimmingViewAlphaAnimator(0.0f, dimmingDelegate.getMaxAlpha(), dimmingDelegate);
        AnimatorSet.Builder builderPlay = animatorSet.play(createSheetSlideInAnimator());
        if (!dimmingDelegate.willDimForDetentIndex(getScreen(), getScreen().getSheetInitialDetentIndex())) {
            builderPlay = null;
        }
        if (builderPlay != null) {
            builderPlay.with(valueAnimatorCreateDimmingViewAlphaAnimator);
        }
        attachCommonListeners(animatorSet, true, fragment);
        return animatorSet;
    }

    public final Animator createSheetExitAnimator$react_native_screens_release(SheetDelegate.SheetAnimationContext sheetAnimationContext) {
        Intrinsics.checkNotNullParameter(sheetAnimationContext, "sheetAnimationContext");
        AnimatorSet animatorSet = new AnimatorSet();
        CoordinatorLayout coordinatorLayout = sheetAnimationContext.getCoordinatorLayout();
        DimmingViewManager dimmingDelegate = sheetAnimationContext.getDimmingDelegate();
        ScreenStackFragment fragment = sheetAnimationContext.getFragment();
        ValueAnimator valueAnimatorCreateDimmingViewAlphaAnimator = createDimmingViewAlphaAnimator(dimmingDelegate.getDimmingView().getAlpha(), 0.0f, dimmingDelegate);
        animatorSet.play(valueAnimatorCreateDimmingViewAlphaAnimator).with(createSheetSlideOutAnimator(coordinatorLayout));
        attachCommonListeners(animatorSet, false, fragment);
        return animatorSet;
    }

    public final void updateSheetContentHeightWithAnimation$react_native_screens_release(BottomSheetBehavior<Screen> behavior, int oldHeight, int newHeight) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        float translationY = getScreen().getTranslationY();
        int iResolveClampedHeight = SheetUtilsKt.resolveClampedHeight(getScreen(), oldHeight, translationY);
        int iResolveClampedHeight2 = SheetUtilsKt.resolveClampedHeight(getScreen(), newHeight, translationY);
        if (this.isSheetAnimationInProgress || isKeyboardAnimationInProgress()) {
            BottomSheetBehaviorExtKt.updateMetrics$default(behavior, Integer.valueOf(iResolveClampedHeight2), null, 2, null);
            layoutBottomSheetAtHeight(getScreen(), iResolveClampedHeight2);
            finalizeBottomSheetLayoutUpdates(getScreen());
            return;
        }
        float f = iResolveClampedHeight2 - iResolveClampedHeight;
        if (f == 0.0f) {
            return;
        }
        if (f > 0.0f) {
            animateContentExpanding(behavior, iResolveClampedHeight2, translationY, f);
        } else {
            animateContentShrinking(behavior, iResolveClampedHeight2, translationY, f);
        }
    }

    private final void animateContentExpanding(final BottomSheetBehavior<Screen> behavior, final int clampedNewHeight, float currentTranslationY, float visibleDelta) {
        Screen screen = getScreen();
        screen.setTranslationY(screen.getTranslationY() + visibleDelta);
        cancelCurrentContentAnimation();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getScreen().getTranslationY(), currentTranslationY);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$animateContentExpanding$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BottomSheetBehaviorExtKt.updateMetrics$default(behavior, Integer.valueOf(clampedNewHeight), null, 2, null);
                SheetAnimationCoordinator sheetAnimationCoordinator = this;
                sheetAnimationCoordinator.layoutBottomSheetAtHeight(sheetAnimationCoordinator.getScreen(), clampedNewHeight);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.currentContentAnimator = null;
                SheetAnimationCoordinator sheetAnimationCoordinator = this;
                sheetAnimationCoordinator.finalizeBottomSheetLayoutUpdates(sheetAnimationCoordinator.getScreen());
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SheetAnimationCoordinator.animateContentExpanding$lambda$3$lambda$2(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.currentContentAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateContentExpanding$lambda$3$lambda$2(SheetAnimationCoordinator sheetAnimationCoordinator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Screen screen = sheetAnimationCoordinator.getScreen();
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        screen.setTranslationY(((Float) animatedValue).floatValue());
    }

    private final void animateContentShrinking(final BottomSheetBehavior<Screen> behavior, final int clampedNewHeight, final float currentTranslationY, float visibleDelta) {
        cancelCurrentContentAnimation();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(currentTranslationY, currentTranslationY - visibleDelta);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$animateContentShrinking$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BottomSheetBehaviorExtKt.updateMetrics$default(behavior, Integer.valueOf(clampedNewHeight), null, 2, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.currentContentAnimator = null;
                SheetAnimationCoordinator sheetAnimationCoordinator = this;
                sheetAnimationCoordinator.layoutBottomSheetAtHeight(sheetAnimationCoordinator.getScreen(), clampedNewHeight);
                this.getScreen().setTranslationY(currentTranslationY);
                SheetAnimationCoordinator sheetAnimationCoordinator2 = this;
                sheetAnimationCoordinator2.finalizeBottomSheetLayoutUpdates(sheetAnimationCoordinator2.getScreen());
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SheetAnimationCoordinator.animateContentShrinking$lambda$5$lambda$4(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.currentContentAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateContentShrinking$lambda$5$lambda$4(SheetAnimationCoordinator sheetAnimationCoordinator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Screen screen = sheetAnimationCoordinator.getScreen();
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        screen.setTranslationY(((Float) animatedValue).floatValue());
    }

    public final void notifyKeyboardAnimationStart$react_native_screens_release() {
        this.activeKeyboardAnimationsCount++;
    }

    public final void notifyKeyboardAnimationEnd$react_native_screens_release() {
        this.activeKeyboardAnimationsCount = Math.max(0, this.activeKeyboardAnimationsCount - 1);
    }

    public final void handleKeyboardInsetsProgress$react_native_screens_release(WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        this.lastKeyboardBottomOffset = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        if (this.isSheetAnimationInProgress) {
            return;
        }
        updateSheetTranslationY(0.0f);
    }

    private final int computeSheetOffsetYWithIMEPresent(int keyboardHeight) {
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate;
        Fragment fragment = getScreen().getFragment();
        Integer numTryResolveMaxFormSheetHeight$react_native_screens_release = (fragment == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null) ? null : sheetDelegate.tryResolveMaxFormSheetHeight$react_native_screens_release();
        if (numTryResolveMaxFormSheetHeight$react_native_screens_release == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration".toString());
        }
        if (SheetUtilsKt.isSheetFitToContents(getScreen())) {
            ScreenContentWrapper contentWrapper = getScreen().getContentWrapper();
            return Math.min(Math.max(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue() - (contentWrapper != null ? contentWrapper.getHeight() : 0), 0), keyboardHeight);
        }
        return Math.min(numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue() - ((int) (RangesKt.coerceIn(getScreen().getSheetDetents().highest$react_native_screens_release(), 0.0d, 1.0d) * ((double) numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue()))), keyboardHeight);
    }

    private final void updateSheetTranslationY(float baseTranslationY) {
        getScreen().setTranslationY(baseTranslationY - computeSheetOffsetYWithIMEPresent(this.lastKeyboardBottomOffset));
    }

    private final ValueAnimator createSheetSlideInAnimator() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ExternalBoundaryValuesEvaluator(new Function1() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(SheetAnimationCoordinator.createSheetSlideInAnimator$lambda$7(this.f$0, (Number) obj));
            }
        }, new Function1() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SheetAnimationCoordinator.createSheetSlideInAnimator$lambda$8((Number) obj);
            }
        }), Float.valueOf(getScreen().getHeight()), Float.valueOf(0.0f));
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SheetAnimationCoordinator.createSheetSlideInAnimator$lambda$10$lambda$9(this.f$0, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "apply(...)");
        return valueAnimatorOfObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createSheetSlideInAnimator$lambda$7(SheetAnimationCoordinator sheetAnimationCoordinator, Number number) {
        return sheetAnimationCoordinator.getScreen().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float createSheetSlideInAnimator$lambda$8(Number number) {
        return Float.valueOf(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSheetSlideInAnimator$lambda$10$lambda$9(SheetAnimationCoordinator sheetAnimationCoordinator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sheetAnimationCoordinator.updateSheetTranslationY(((Float) animatedValue).floatValue());
    }

    private final ValueAnimator createSheetSlideOutAnimator(CoordinatorLayout coordinatorLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (coordinatorLayout.getBottom() - getScreen().getTop()) - getScreen().getTranslationY());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SheetAnimationCoordinator.createSheetSlideOutAnimator$lambda$12$lambda$11(this.f$0, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSheetSlideOutAnimator$lambda$12$lambda$11(SheetAnimationCoordinator sheetAnimationCoordinator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sheetAnimationCoordinator.updateSheetTranslationY(((Float) animatedValue).floatValue());
    }

    private final ValueAnimator createDimmingViewAlphaAnimator(float from, float to, final DimmingViewManager dimmingDelegate) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(from, to);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SheetAnimationCoordinator.createDimmingViewAlphaAnimator$lambda$15$lambda$14(dimmingDelegate, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDimmingViewAlphaAnimator$lambda$15$lambda$14(DimmingViewManager dimmingViewManager, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f != null) {
            dimmingViewManager.getDimmingView().setAlpha(f.floatValue());
        }
    }

    private final void cancelCurrentContentAnimation() {
        ValueAnimator valueAnimator = this.currentContentAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.currentContentAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.currentContentAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.currentContentAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void layoutBottomSheetAtHeight(Screen screen, int i) {
        screen.layout(screen.getLeft(), screen.getBottom() - i, screen.getRight(), screen.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finalizeBottomSheetLayoutUpdates(Screen screen) {
        screen.getParent().requestLayout();
        screen.onSheetYTranslationChanged$react_native_screens_release();
    }

    private final void attachCommonListeners(AnimatorSet animatorSet, boolean isEnter, ScreenStackFragment screenStackFragment) {
        ScreenAnimationDelegate.AnimationType animationType;
        ScreenStackFragment screenStackFragment2 = screenStackFragment;
        ScreenEventEmitter screenEventEmitter = new ScreenEventEmitter(getScreen());
        if (isEnter) {
            animationType = ScreenAnimationDelegate.AnimationType.ENTER;
        } else {
            animationType = ScreenAnimationDelegate.AnimationType.EXIT;
        }
        animatorSet.addListener(new ScreenAnimationDelegate(screenStackFragment2, screenEventEmitter, animationType));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.swmansion.rnscreens.bottomsheet.SheetAnimationCoordinator.attachCommonListeners.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SheetAnimationCoordinator.this.isSheetAnimationInProgress = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SheetAnimationCoordinator.this.isSheetAnimationInProgress = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SheetAnimationCoordinator.this.isSheetAnimationInProgress = false;
                SheetAnimationCoordinator.this.getScreen().onSheetYTranslationChanged$react_native_screens_release();
            }
        });
    }
}
