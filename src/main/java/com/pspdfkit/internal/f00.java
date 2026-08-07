package com.pspdfkit.internal;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;

/* JADX INFO: loaded from: classes3.dex */
public final class f00 implements CompletableOnSubscribe {
    public final View b;
    public final int c;
    public final DecelerateInterpolator e = new DecelerateInterpolator();
    public final AccelerateInterpolator f = new AccelerateInterpolator();
    public final long d = 200;
    public final boolean a = false;

    public f00(View view, int i) {
        this.b = view;
        this.c = i;
    }

    public final /* synthetic */ void a(CompletableEmitter completableEmitter) {
        if (this.c == 1) {
            this.b.setVisibility(this.a ? 4 : 8);
        }
        completableEmitter.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public final void subscribe(final CompletableEmitter completableEmitter) {
        this.b.setVisibility(0);
        int i = this.c;
        float f = i == 1 ? 1.0f : 0.0f;
        float f2 = i == 1 ? 0.0f : 1.0f;
        if (this.b.getScaleX() == f2 && this.b.getScaleY() == f2) {
            if (this.c == 1) {
                this.b.setVisibility(this.a ? 4 : 8);
            }
            completableEmitter.onComplete();
        } else {
            this.b.setScaleX(f);
            this.b.setScaleY(f);
            this.b.animate().scaleX(f2).scaleY(f2).setDuration(this.d).setInterpolator(this.c == 1 ? this.e : this.f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.f00$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(completableEmitter);
                }
            });
        }
    }

    public f00(FloatingActionButton floatingActionButton, int i) {
        this.b = floatingActionButton;
        this.c = i;
    }
}
