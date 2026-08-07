package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Magnifier;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.views.document.DocumentView;

/* JADX INFO: loaded from: classes3.dex */
public final class vo {
    public final View a;
    public final Magnifier b;
    public final b50 c;
    public final boolean d;
    public final boolean e;
    public final float f;
    public final float g;
    public boolean h;
    public ValueAnimator i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n = 1.25f;
    public boolean o;
    public boolean p;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            vo.this.p = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public boolean a;

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            vo voVar = vo.this;
            voVar.i = null;
            if (this.a) {
                return;
            }
            voVar.b.dismiss();
            vo voVar2 = vo.this;
            voVar2.l = 0.0f;
            voVar2.m = 0.0f;
            voVar2.n = 1.25f;
            voVar2.o = false;
            voVar2.b();
        }
    }

    public vo(DocumentView documentView, PdfConfiguration pdfConfiguration) {
        if (documentView == null) {
            throw new NullPointerException("View to magnify may not be null.");
        }
        if (pdfConfiguration == null) {
            throw new NullPointerException("PdfConfiguration may not be null.");
        }
        this.a = documentView;
        boolean zIsMagnifierEnabled = pdfConfiguration.isMagnifierEnabled();
        this.e = zIsMagnifierEnabled;
        if (!zIsMagnifierEnabled) {
            this.d = false;
            this.c = null;
            this.b = null;
            this.f = 0.0f;
            this.g = 0.0f;
            return;
        }
        this.b = new Magnifier(documentView);
        this.c = null;
        this.d = true;
        this.f = e();
        this.g = f();
        b();
    }

    public final void a(Canvas canvas) {
        if (this.e && !this.d) {
            b50 b50Var = this.c;
            if (!b50Var.p || b50Var.r == null) {
                return;
            }
            canvas.save();
            float fMax = Math.max(b50Var.m - b50Var.k, Math.min(b50Var.i, (b50Var.b.getWidth() - b50Var.m) - b50Var.k));
            float fMax2 = Math.max((b50Var.n - b50Var.l) + b50Var.c, Math.min(b50Var.j, (b50Var.b.getHeight() - b50Var.n) - b50Var.l));
            RectF rectF = b50Var.f;
            float f = b50Var.m;
            float f2 = b50Var.n;
            rectF.set(fMax - f, fMax2 - f2, fMax + f, fMax2 + f2);
            b50Var.f.offset(b50Var.b.getScrollX() + b50Var.k, b50Var.b.getScrollY() + b50Var.l);
            uz uzVar = b50Var.a;
            RectF rectF2 = b50Var.f;
            uzVar.a(canvas, rectF2.left, rectF2.top);
            b50Var.e.reset();
            Path path = b50Var.e;
            RectF rectF3 = b50Var.f;
            float f3 = b50Var.o;
            path.addRoundRect(rectF3, f3, f3, Path.Direction.CW);
            canvas.clipPath(b50Var.e);
            b50Var.b.getLocationInWindow(b50Var.h);
            canvas.translate((b50Var.b.getScrollX() - b50Var.h[0]) + b50Var.k, (b50Var.b.getScrollY() - b50Var.h[1]) + b50Var.l);
            b50Var.g.reset();
            Matrix matrix = b50Var.g;
            float f4 = b50Var.d;
            float f5 = b50Var.i;
            int[] iArr = b50Var.h;
            matrix.postScale(f4, f4, f5 + iArr[0], b50Var.j + iArr[1]);
            canvas.drawBitmap(b50Var.r, b50Var.g, b50Var.q);
            canvas.restore();
        }
    }

    public final void b() {
        if (this.d) {
            this.b.setZoom(1.25f);
            return;
        }
        b50 b50Var = this.c;
        b50Var.d = 1.25f;
        b50Var.b.invalidate();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.i = null;
        }
        this.p = false;
    }

    public final void d() {
        if (this.e) {
            this.h = false;
            if (this.d) {
                a();
                return;
            }
            b50 b50Var = this.c;
            b50Var.p = false;
            b50Var.b.invalidate();
            b50 b50Var2 = this.c;
            b50Var2.d = 1.25f;
            b50Var2.b.invalidate();
        }
    }

    public final float e() {
        if (this.e) {
            return this.d ? this.b.getDefaultHorizontalSourceToMagnifierOffset() : this.c.k;
        }
        return 0.0f;
    }

    public final float f() {
        if (this.e) {
            return this.d ? this.b.getDefaultVerticalSourceToMagnifierOffset() : this.c.l;
        }
        return 0.0f;
    }

    public final Point g() {
        if (!this.e) {
            return null;
        }
        if (this.d) {
            return this.b.getPosition();
        }
        b50 b50Var = this.c;
        b50Var.getClass();
        RectF rectF = b50Var.f;
        return new Point((int) rectF.left, (int) rectF.top);
    }

    public final int h() {
        if (this.e) {
            return this.d ? this.b.getWidth() : (int) this.c.f.width();
        }
        return 0;
    }

    public final void b(float f, float f2, float f3, float f4, float f5) {
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.n = f5;
        this.o = true;
        this.b.setZoom(f5);
        this.b.show(f, f2, f3 + f, f4 + f2);
    }

    public final void b(float f, float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        b(this.j, this.k, ((f - 0.0f) * fFloatValue) + 0.0f, ((f2 - 0.0f) * fFloatValue) + 0.0f, ((f3 - 0.5f) * fFloatValue) + 0.5f);
    }

    public final void a(float f, float f2, final float f3, final float f4, final float f5) {
        this.j = f;
        this.k = f2;
        this.p = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.i = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(300L);
        this.i.setInterpolator(new OvershootInterpolator(2.0f));
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.vo$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.b(f3, f4, f5, valueAnimator);
            }
        });
        this.i.addListener(new a());
        this.i.start();
    }

    public final void a() {
        c();
        if (!this.o) {
            this.b.dismiss();
            b();
            return;
        }
        final float f = this.l;
        final float f2 = this.m;
        final float f3 = this.n;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.i = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(150L);
        this.i.setInterpolator(new FastOutSlowInInterpolator());
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.vo$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.a(f, f2, f3, valueAnimator);
            }
        });
        this.i.addListener(new b());
        this.i.start();
    }

    public final void a(float f, float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        b(this.j, this.k, ((0.0f - f) * fFloatValue) + f, ((0.0f - f2) * fFloatValue) + f2, f3);
    }
}
