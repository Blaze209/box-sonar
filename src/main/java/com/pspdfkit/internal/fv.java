package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public final class fv extends AnimatorListenerAdapter {
    public final /* synthetic */ dv a;

    public fv(dv dvVar) {
        this.a = dvVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.getClass();
        this.a.E.setVisibility(4);
    }
}
