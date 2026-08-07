package com.pspdfkit.internal.views.inspector.bottomsheet;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public b(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        MaterialShapeDrawable materialShapeDrawable = this.a.h;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(fFloatValue);
        }
    }
}
