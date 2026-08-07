package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public final class i30 extends Drawable {
    public static final int[] k = {-16777216, Integer.MIN_VALUE, 0};
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public Drawable d;
    public final int e;
    public final int f;
    public final int g;
    public int h;
    public int i;
    public float j;

    public i30(Context context, int i) {
        Paint paint = new Paint();
        this.a = paint;
        Paint paint2 = new Paint();
        this.b = paint2;
        Paint paint3 = new Paint();
        this.c = paint3;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        int iA = a80.a(context, 4);
        this.e = iA;
        this.f = ((int) un.a(context, 1, 12)) + iA;
        this.g = iA + ((int) un.a(context, 1, 4));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        paint3.setDither(true);
        paint3.setStrokeWidth((int) un.a(context, 1, 3));
        paint3.setColor(0);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.h, this.i, this.j, this.b);
        canvas.drawCircle(this.h, this.i, this.j - this.e, this.a);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.c.getColor() != 0) {
            canvas.drawCircle(this.h, this.i, this.j - this.g, this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = rect.centerX();
        this.i = rect.centerY();
        this.j = Math.min(rect.width() / 2.0f, rect.height() / 2.0f);
        this.b.setShader(new RadialGradient(this.h, this.i, this.j, k, (float[]) null, Shader.TileMode.CLAMP));
        Drawable drawable = this.d;
        if (drawable != null) {
            int i = (int) (this.j - this.f);
            int i2 = this.h;
            int i3 = this.i;
            drawable.setBounds(i2 - i, i3 - i, i2 + i, i3 + i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
