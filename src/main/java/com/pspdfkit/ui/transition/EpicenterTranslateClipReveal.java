package com.pspdfkit.ui.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class EpicenterTranslateClipReveal extends Visibility {
    private static final String PROPNAME_BOUNDS = "android:epicenterReveal:bounds";
    private static final String PROPNAME_CLIP = "android:epicenterReveal:clip";
    private static final String PROPNAME_TRANSLATE_X = "android:epicenterReveal:translateX";
    private static final String PROPNAME_TRANSLATE_Y = "android:epicenterReveal:translateY";
    private static final String PROPNAME_TRANSLATE_Z = "android:epicenterReveal:translateZ";
    private static final String PROPNAME_Z = "android:epicenterReveal:z";
    private final TimeInterpolator mInterpolatorX;
    private final TimeInterpolator mInterpolatorY;
    private final TimeInterpolator mInterpolatorZ;

    public static class State {
        int lower;
        float trans;
        int upper;

        public State() {
        }

        public State(int i, int i2, float f) {
            this.lower = i;
            this.upper = i2;
            this.trans = f;
        }
    }

    public static class StateEvaluator implements TypeEvaluator<State> {
        private final State mTemp;

        private StateEvaluator() {
            this.mTemp = new State();
        }

        @Override // android.animation.TypeEvaluator
        public State evaluate(float f, State state, State state2) {
            State state3 = this.mTemp;
            int i = state.upper;
            state3.upper = i + ((int) ((state2.upper - i) * f));
            int i2 = state.lower;
            state3.lower = i2 + ((int) ((state2.lower - i2) * f));
            float f2 = state.trans;
            state3.trans = f2 + ((int) ((state2.trans - f2) * f));
            return state3;
        }
    }

    public static class StateProperty extends Property<View, State> {
        public static final char TARGET_X = 'x';
        public static final char TARGET_Y = 'y';
        private final int mTargetDimension;
        private final Rect mTempRect;
        private final State mTempState;

        public StateProperty(char c) {
            super(State.class, "state_" + c);
            this.mTempRect = new Rect();
            this.mTempState = new State();
            this.mTargetDimension = c;
        }

        @Override // android.util.Property
        public State get(View view) {
            Rect rect = this.mTempRect;
            if (!view.getClipBounds(rect)) {
                rect.setEmpty();
            }
            State state = this.mTempState;
            if (this.mTargetDimension == 120) {
                float translationX = view.getTranslationX();
                state.trans = translationX;
                int i = (int) translationX;
                state.lower = rect.left + i;
                state.upper = rect.right + i;
                return state;
            }
            float translationY = view.getTranslationY();
            state.trans = translationY;
            int i2 = (int) translationY;
            state.lower = rect.top + i2;
            state.upper = rect.bottom + i2;
            return state;
        }

        @Override // android.util.Property
        public void set(View view, State state) {
            Rect rect = this.mTempRect;
            if (view.getClipBounds(rect)) {
                if (this.mTargetDimension == 120) {
                    int i = state.lower;
                    int i2 = (int) state.trans;
                    rect.left = i - i2;
                    rect.right = state.upper - i2;
                } else {
                    int i3 = state.lower;
                    int i4 = (int) state.trans;
                    rect.top = i3 - i4;
                    rect.bottom = state.upper - i4;
                }
                view.setClipBounds(rect);
            }
            if (this.mTargetDimension == 120) {
                view.setTranslationX(state.trans);
            } else {
                view.setTranslationY(state.trans);
            }
        }
    }

    public EpicenterTranslateClipReveal() {
        this.mInterpolatorX = null;
        this.mInterpolatorY = null;
        this.mInterpolatorZ = null;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, view.getWidth(), view.getHeight()));
        transitionValues.values.put(PROPNAME_TRANSLATE_X, Float.valueOf(view.getTranslationX()));
        transitionValues.values.put(PROPNAME_TRANSLATE_Y, Float.valueOf(view.getTranslationY()));
        transitionValues.values.put(PROPNAME_TRANSLATE_Z, Float.valueOf(view.getTranslationZ()));
        transitionValues.values.put(PROPNAME_Z, Float.valueOf(view.getZ()));
        transitionValues.values.put(PROPNAME_CLIP, view.getClipBounds());
    }

    private static Animator createRectAnimator(final View view, State state, State state2, float f, State state3, State state4, float f2, TransitionValues transitionValues, TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2, TimeInterpolator timeInterpolator3) {
        StateEvaluator stateEvaluator = new StateEvaluator();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Z, f, f2);
        if (timeInterpolator3 != null) {
            objectAnimatorOfFloat.setInterpolator(timeInterpolator3);
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, new StateProperty(StateProperty.TARGET_X), stateEvaluator, state, state3);
        if (timeInterpolator != null) {
            objectAnimatorOfObject.setInterpolator(timeInterpolator);
        }
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(view, new StateProperty(StateProperty.TARGET_Y), stateEvaluator, state2, state4);
        if (timeInterpolator2 != null) {
            objectAnimatorOfObject2.setInterpolator(timeInterpolator2);
        }
        final Rect rect = (Rect) transitionValues.values.get(PROPNAME_CLIP);
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.transition.EpicenterTranslateClipReveal.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setClipBounds(rect);
            }
        };
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2, objectAnimatorOfFloat);
        animatorSet.addListener(animatorListenerAdapter);
        return animatorSet;
    }

    private Rect getBestRect(TransitionValues transitionValues) {
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_CLIP);
        return rect == null ? (Rect) transitionValues.values.get(PROPNAME_BOUNDS) : rect;
    }

    private Rect getEpicenterOrCenter(Rect rect) {
        Rect epicenter = getEpicenter();
        if (epicenter != null) {
            return epicenter;
        }
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        return new Rect(iCenterX, iCenterY, iCenterX, iCenterY);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        Rect epicenterOrCenter = getEpicenterOrCenter(rect);
        float fCenterX = epicenterOrCenter.centerX() - rect.centerX();
        float fCenterY = epicenterOrCenter.centerY() - rect.centerY();
        float fFloatValue = 0.0f - ((Float) transitionValues2.values.get(PROPNAME_Z)).floatValue();
        view.setTranslationX(fCenterX);
        view.setTranslationY(fCenterY);
        view.setTranslationZ(fFloatValue);
        float fFloatValue2 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_X)).floatValue();
        float fFloatValue3 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_Y)).floatValue();
        float fFloatValue4 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_Z)).floatValue();
        Rect bestRect = getBestRect(transitionValues2);
        Rect epicenterOrCenter2 = getEpicenterOrCenter(bestRect);
        view.setClipBounds(epicenterOrCenter2);
        return createRectAnimator(view, new State(epicenterOrCenter2.left, epicenterOrCenter2.right, fCenterX), new State(epicenterOrCenter2.top, epicenterOrCenter2.bottom, fCenterY), fFloatValue, new State(bestRect.left, bestRect.right, fFloatValue2), new State(bestRect.top, bestRect.bottom, fFloatValue3), fFloatValue4, transitionValues2, this.mInterpolatorX, this.mInterpolatorY, this.mInterpolatorZ);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        Rect epicenterOrCenter = getEpicenterOrCenter(rect);
        float fCenterX = epicenterOrCenter.centerX() - rect.centerX();
        float fCenterY = epicenterOrCenter.centerY() - rect.centerY();
        float fFloatValue = 0.0f - ((Float) transitionValues.values.get(PROPNAME_Z)).floatValue();
        float fFloatValue2 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_X)).floatValue();
        float fFloatValue3 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_Y)).floatValue();
        float fFloatValue4 = ((Float) transitionValues2.values.get(PROPNAME_TRANSLATE_Z)).floatValue();
        Rect bestRect = getBestRect(transitionValues);
        Rect epicenterOrCenter2 = getEpicenterOrCenter(bestRect);
        view.setClipBounds(bestRect);
        return createRectAnimator(view, new State(bestRect.left, bestRect.right, fFloatValue2), new State(bestRect.top, bestRect.bottom, fFloatValue3), fFloatValue4, new State(epicenterOrCenter2.left, epicenterOrCenter2.right, fCenterX), new State(epicenterOrCenter2.top, epicenterOrCenter2.bottom, fCenterY), fFloatValue, transitionValues2, this.mInterpolatorX, this.mInterpolatorY, this.mInterpolatorZ);
    }

    public EpicenterTranslateClipReveal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterpolatorX = new LinearOutSlowInInterpolator();
        this.mInterpolatorY = new FastOutSlowInInterpolator();
        this.mInterpolatorZ = new FastOutSlowInInterpolator();
    }
}
