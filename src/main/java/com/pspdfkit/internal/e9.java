package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public final class e9 extends Drawable {
    public final Paint b;
    public final Paint c;
    public final float d;
    public final float e;
    public final int f;
    public final w8 i;
    public int g = 255;
    public boolean h = true;
    public final Paint a = new Paint();

    public e9(Context context, int i, int i2, float f, float f2, float f3) {
        this.f = i2;
        Paint paint = new Paint();
        this.b = paint;
        Paint paint2 = new Paint();
        this.c = paint2;
        paint.setColor(i);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(a80.a(context, f3));
        paint.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        this.d = TypedValue.applyDimension(1, f, displayMetrics);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        this.e = TypedValue.applyDimension(1, f2, displayMetrics2);
        if (Color.alpha(i2) != 255) {
            this.i = new w8(context);
        }
        a();
    }

    public final void a() {
        this.a.reset();
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        w8 w8Var = this.i;
        Paint paint = this.a;
        if (w8Var == null) {
            paint.setColor(this.f);
        } else {
            paint.setShader(w8Var.a(getBounds().width(), this.f));
        }
        this.a.setAlpha(this.g);
        this.b.setAlpha(this.g);
        this.c.setColor(this.h ? -1 : -7829368);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float fWidth = getBounds().width() / 2.0f;
        float fHeight = getBounds().height() / 2.0f;
        canvas.drawCircle(fWidth, fHeight, this.d - 1.0f, this.c);
        canvas.drawCircle(fWidth, fHeight, this.d, this.a);
        float f = this.e;
        if (f > 0.0f) {
            canvas.drawCircle(fWidth, fHeight, f, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (iArr[i] == 16842910) {
                z = true;
                break;
            }
            i++;
        }
        boolean z2 = z != this.h;
        this.h = z;
        a();
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.g = i;
        a();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
