package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.ObjectAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class sx implements Animator.AnimatorListener {
    public final /* synthetic */ qx.d a;
    public final /* synthetic */ ObjectAnimator b;

    public sx(qx.d dVar, ObjectAnimator objectAnimator) {
        this.a = dVar;
        this.b = objectAnimator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        animator.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.getClass();
        qx.d dVar = this.a;
        if (dVar != null) {
            dVar.a();
        }
        this.b.removeAllListeners();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        animator.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        animator.getClass();
    }
}
