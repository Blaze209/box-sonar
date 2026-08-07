package com.pspdfkit.internal;

import android.animation.Animator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class rx implements Animator.AnimatorListener {
    public final /* synthetic */ qx.b a;
    public final /* synthetic */ qx.d b;

    public rx(qx.b bVar, qx.d dVar) {
        this.a = bVar;
        this.b = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        animator.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.getClass();
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            this.b.getClass();
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            this.b.a();
        }
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
