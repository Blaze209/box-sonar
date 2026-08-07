package com.pspdfkit.internal;

import android.view.animation.DecelerateInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class n8 {
    public final com.pspdfkit.internal.views.inspector.bottomsheet.d<?> a;

    public n8(com.pspdfkit.internal.views.inspector.bottomsheet.d<?> dVar) {
        this.a = dVar;
    }

    public static final void a(n8 n8Var) {
        com.pspdfkit.internal.views.inspector.bottomsheet.d<?> dVar = n8Var.a;
        dVar.setVisibility(8);
        com.pspdfkit.internal.views.inspector.bottomsheet.d.a aVar = dVar.b;
        if (aVar != null) {
            aVar.onHide(dVar);
        }
    }

    public static final void b(n8 n8Var) {
        com.pspdfkit.internal.views.inspector.bottomsheet.d<?> dVar = n8Var.a;
        com.pspdfkit.internal.views.inspector.bottomsheet.d.a aVar = dVar.b;
        if (aVar != null) {
            aVar.onShow(dVar);
        }
    }

    public final void c() {
        this.a.animate().cancel();
    }

    public final void a() {
        this.a.animate().cancel();
        this.a.animate().setInterpolator(new FastOutSlowInInterpolator()).setDuration(150L);
        this.a.animate().translationY(this.a.getHeight());
        this.a.animate().withEndAction(new Runnable() { // from class: com.pspdfkit.internal.n8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                n8.a(this.f$0);
            }
        });
    }

    public final void b() {
        this.a.animate().cancel();
        this.a.animate().setInterpolator(new FastOutLinearInInterpolator()).setDuration(150L);
        com.pspdfkit.internal.views.inspector.bottomsheet.d<?> dVar = this.a;
        dVar.setTranslationY(dVar.getHeight());
        this.a.animate().translationY(0.0f);
        this.a.animate().withEndAction(new Runnable() { // from class: com.pspdfkit.internal.n8$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                n8.b(this.f$0);
            }
        });
    }

    public final void a(int i, final int i2) {
        if (i2 > i) {
            this.a.animate().cancel();
            this.a.setTranslationY(i2 - i);
            this.a.animate().setInterpolator(new DecelerateInterpolator()).translationY(0.0f);
        } else if (i > i2) {
            this.a.animate().cancel();
            this.a.setTranslationY(0.0f);
            this.a.animate().setInterpolator(new DecelerateInterpolator()).translationY(i - i2).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.n8$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    n8.a(this.f$0, i2);
                }
            });
        }
    }

    public static final void a(n8 n8Var, int i) {
        n8Var.a.setMeasuredHeight$sdk_nutrient(i);
        n8Var.a.setTranslationY(0.0f);
    }
}
