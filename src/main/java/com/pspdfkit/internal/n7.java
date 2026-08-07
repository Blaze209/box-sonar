package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n7 implements f10 {
    public int e;
    public int f;
    public float g;
    public float h;
    public float i;
    public int a = 1;
    public float b = -1.0f;
    public final Matrix c = new Matrix();
    public boolean d = false;
    public Paint j = null;
    public xp k = null;
    public boolean l = true;
    public String m = null;

    public n7(int i, int i2, float f, float f2) {
        this.e = i;
        this.f = i2;
        this.h = f2;
        this.i = f2;
        this.g = f;
    }

    @Override // com.pspdfkit.internal.f10
    public void a(int i) {
        synchronized (this) {
            this.a = i;
        }
    }

    public abstract void a(Canvas canvas, Paint paint, Paint paint2, float f);

    @Override // com.pspdfkit.internal.f10
    public final void b(Canvas canvas, Paint paint, Paint paint2) {
        if (g()) {
            a(paint, paint2, this.b);
            a(canvas, paint, paint2, 1.0f);
        }
    }

    @Override // com.pspdfkit.internal.f10
    public final int c() {
        int i;
        synchronized (this) {
            i = this.a;
        }
        return i;
    }

    public void e() {
    }

    public final boolean f() {
        return this.h < 1.0f || this.i < 1.0f;
    }

    public boolean g() {
        return true;
    }

    public void h() {
    }

    @Override // com.pspdfkit.internal.f10
    public final void a(Canvas canvas, Paint paint, Paint paint2) {
        if (g()) {
            a(paint, paint2, 1.0f);
            a(canvas, paint, paint2, this.b);
        }
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a(float f, Matrix matrix) {
        boolean z;
        if (this.b != f) {
            this.b = f;
            z = true;
        } else {
            z = false;
        }
        if (this.d && this.c.equals(matrix)) {
            return z;
        }
        this.d = true;
        this.c.set(matrix);
        e();
        if (this.j != null) {
            this.j.setTextSize((s60.a(this.c) / this.b) * 18.0f);
        }
        return true;
    }

    public void a(Paint paint, Paint paint2, float f) {
        paint.setColor(this.e);
        paint.setAlpha(Math.round(this.h * 255.0f));
        if (paint2 != null) {
            paint2.setColor(this.f);
            if (this.f != 0) {
                paint2.setAlpha(Math.round(this.i * 255.0f));
            }
        }
        paint.setStrokeWidth((s60.a(this.c) * this.g) / f);
        Paint paint3 = this.j;
        if (paint3 != null) {
            paint3.setColor(paint.getColor());
            boolean z = this.l;
            Paint paint4 = this.j;
            if (z) {
                paint4.setAlpha(paint.getAlpha());
            } else {
                paint4.setAlpha(0);
            }
        }
    }

    public final boolean a(float f, float f2) {
        if (this.h == f && this.i == f2) {
            return false;
        }
        this.h = f;
        this.i = f2;
        return true;
    }

    public final void a(xp xpVar) {
        if (this.j == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setDither(true);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setTextAlign(Paint.Align.CENTER);
            this.j.setTypeface(ar.c().b().getDefaultTypeface());
        }
        if (this.k != xpVar) {
            this.k = xpVar;
            h();
        }
    }
}
