package com.pspdfkit.internal;

import android.graphics.RectF;
import android.view.animation.AnimationUtils;
import androidx.compose.animation.core.CubicBezierEasing;
import com.pspdfkit.internal.views.document.DocumentView;

/* JADX INFO: loaded from: classes3.dex */
public final class b80 {
    public final DocumentView a;
    public final ln b;
    public long d;
    public long e;
    public float i;
    public float j;
    public boolean k;
    public final CubicBezierEasing c = new CubicBezierEasing(0.16f, 0.01f, 0.36f, 1.0f);
    public float f = 1.0f;
    public float g = 1.0f;
    public float h = 1.0f;

    public b80(DocumentView documentView, ln lnVar) {
        this.a = documentView;
        this.b = lnVar;
    }

    public static final void b(b80 b80Var) {
        b80Var.a();
    }

    public final void a() {
        if (this.k) {
            float fCurrentAnimationTimeMillis = this.d > 0 ? (AnimationUtils.currentAnimationTimeMillis() - this.e) / this.d : 1.0f;
            if (fCurrentAnimationTimeMillis >= 1.0f) {
                this.b.a(this.h / this.g, this.i, this.j);
                this.b.l();
                this.k = false;
            } else {
                float fTransform = this.c.transform(fCurrentAnimationTimeMillis);
                float f = this.f;
                float f2 = ((this.h - f) * fTransform) + f;
                this.b.a(f2 / this.g, this.i, this.j);
                this.g = f2;
                this.a.postOnAnimationDelayed(new Runnable() { // from class: com.pspdfkit.internal.b80$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b80.a(this.f$0);
                    }
                }, 8L);
            }
        }
    }

    public static final void a(b80 b80Var) {
        b80Var.a();
    }

    public final void a(long j) {
        this.b.a(this.i, this.j);
        this.d = j;
        this.e = AnimationUtils.currentAnimationTimeMillis();
        this.k = true;
        if (j > 0) {
            this.a.postOnAnimationDelayed(new Runnable() { // from class: com.pspdfkit.internal.b80$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    b80.b(this.f$0);
                }
            }, 8L);
        } else {
            a();
        }
    }

    public final void a(float f, float f2, float f3, float f4, long j) {
        this.k = false;
        this.i = f;
        this.j = f2;
        this.f = f3;
        this.g = f3;
        this.h = f4;
        a(j);
    }

    public final void a(RectF rectF, RectF rectF2, float f, long j) {
        int i;
        int i2;
        rectF2.getClass();
        this.k = false;
        float fMin = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height()) * f;
        ln lnVar = this.b;
        float fMax = Math.max(lnVar.b, Math.min(fMin, lnVar.c));
        boolean z = Math.abs(f - fMax) < 0.001f;
        float f2 = fMax / f;
        float fWidth = (rectF.width() / f2) - rectF2.width();
        float fHeight = (rectF.height() / f2) - rectF2.height();
        float f3 = fWidth / 2.0f;
        float f4 = rectF2.left - f3;
        rectF2.left = f4;
        float f5 = rectF2.right + f3;
        rectF2.right = f5;
        float f6 = fHeight / 2.0f;
        float f7 = rectF2.top - f6;
        rectF2.top = f7;
        float f8 = rectF2.bottom + f6;
        rectF2.bottom = f8;
        int i3 = (int) f4;
        int i4 = (int) f5;
        int i5 = (int) rectF.left;
        int i6 = (int) rectF.right;
        int i7 = ((i4 + i5) - i3) - i6;
        if (i7 != 0) {
            i = ((i4 * i5) - (i3 * i6)) / i7;
        } else {
            i = (i3 + i4) / 2;
        }
        this.i = i;
        int i8 = (int) f7;
        int i9 = (int) f8;
        int i10 = (int) rectF.top;
        int i11 = (int) rectF.bottom;
        int i12 = ((i9 + i10) - i8) - i11;
        if (i12 != 0) {
            i2 = ((i9 * i10) - (i8 * i11)) / i12;
        } else {
            i2 = (i8 + i9) / 2;
        }
        this.j = i2;
        this.f = f;
        this.g = f;
        this.h = fMax;
        if (z) {
            this.b.a((int) ((f4 + f5) / 2.0f), (int) ((f7 + f8) / 2.0f), (int) j);
            this.k = false;
        } else {
            a(j);
        }
    }
}
