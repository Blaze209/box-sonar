package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class g9 extends Drawable {
    public final float a;
    public final int b;
    public final Paint c;
    public final Paint d;
    public final Paint e;
    public final w8 f;
    public final RectF g;
    public final float h;
    public final Path i;

    public g9(Context context, int i, int i2) {
        int i3 = i;
        Paint paint = new Paint();
        this.c = paint;
        this.d = new Paint();
        Paint paint2 = new Paint();
        this.e = paint2;
        this.g = new RectF();
        this.i = new Path();
        this.b = i3;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (Color.alpha(i3) != 255) {
            this.f = new w8(context);
        }
        a(0);
        paint2.setStyle(style);
        paint2.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setColor(-1426063361);
        i3 = i3 == 0 ? -1 : i3;
        double[] dArr = {d, 0.0d, 0.0d};
        ColorUtils.RGBToLAB(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
        double d = dArr[0] * ((double) 0.9f);
        paint2.setColorFilter(new PorterDuffColorFilter(ColorUtils.LABToColor(d, dArr[1], dArr[2]), PorterDuff.Mode.MULTIPLY));
        this.a = a80.a(context, i2);
        this.h = (int) un.a(context, 1, 1);
    }

    public final void a(int i) {
        this.d.reset();
        this.d.setStyle(Paint.Style.FILL);
        this.d.setAntiAlias(true);
        w8 w8Var = this.f;
        if (w8Var != null) {
            this.d.setShader(w8Var.a(i, this.b));
            return;
        }
        int iAlpha = Color.alpha(this.b);
        Paint paint = this.d;
        if (iAlpha == 255) {
            paint.setColor(this.b);
            this.d.setColorFilter(null);
        } else {
            paint.setColor(-1426063361);
            this.d.setColorFilter(new PorterDuffColorFilter(this.b, PorterDuff.Mode.MULTIPLY));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        RectF rectF = this.g;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, this.c);
        RectF rectF2 = this.g;
        float f2 = this.a;
        canvas.drawRoundRect(rectF2, f2, f2, this.d);
        canvas.drawPath(this.i, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.g.set(rect);
        a(rect.width());
        this.i.reset();
        Path path = this.i;
        RectF rectF = this.g;
        float f = this.a;
        Path.Direction direction = Path.Direction.CW;
        path.addRoundRect(rectF, f, f, direction);
        this.i.setFillType(Path.FillType.EVEN_ODD);
        RectF rectF2 = new RectF(this.g);
        float f2 = this.h;
        rectF2.inset(f2, f2);
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.i.addRoundRect(rectF2, Math.max(this.a - this.h, 0.0f), Math.max(this.a - this.h, 0.0f), direction);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
