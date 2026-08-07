package com.pspdfkit.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class vn extends Drawable {
    public static final Matrix n = new Matrix();
    public final Context a;
    public final int b;
    public final int c;
    public final float d;
    public final BorderStylePreset e;
    public final LineEndType f;
    public final LineEndType g;
    public final zn h;
    public final Paint i;
    public final Path j;
    public final int k;
    public final Paint l;
    public boolean m;

    public vn(Context context, int i, float f, BorderStylePreset borderStylePreset, LineEndType lineEndType, LineEndType lineEndType2) {
        this.a = context;
        this.c = i;
        this.d = f;
        this.e = borderStylePreset;
        this.f = lineEndType;
        this.g = lineEndType2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        this.l = paint;
        zn znVar = new zn();
        this.h = znVar;
        znVar.e = i;
        if (znVar.g != f) {
            znVar.g = f;
            znVar.e();
        }
        znVar.z = new Pair<>(lineEndType, lineEndType2);
        znVar.n = borderStylePreset.getBorderStyle();
        znVar.p = borderStylePreset.getBorderEffect();
        float borderEffectIntensity = borderStylePreset.getBorderEffectIntensity();
        if (znVar.q != borderEffectIntensity) {
            znVar.q = borderEffectIntensity;
            znVar.e();
        }
        znVar.o = borderStylePreset.getDashArray();
        znVar.e();
        float fA = a80.a(context, 1.0f);
        if (znVar.q != fA) {
            znVar.q = fA;
            znVar.e();
        }
        this.j = new Path();
        this.b = (int) un.a(context, 1, 8);
        this.k = (int) un.a(context, 1, 2);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.m) {
            Context context = this.a;
            int i = this.c;
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorForeground, R.attr.colorForegroundInverse});
            int color = typedArrayObtainStyledAttributes.getColor(0, -16777216);
            int color2 = typedArrayObtainStyledAttributes.getColor(1, -1);
            typedArrayObtainStyledAttributes.recycle();
            int iArgb = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
            if (ColorUtils.calculateContrast(color, iArgb) <= ColorUtils.calculateContrast(color2, iArgb)) {
                color = color2;
            }
            int iCalculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(color, iArgb, 7.0f);
            if (iCalculateMinimumAlpha >= 0) {
                color = ColorUtils.setAlphaComponent(color, iCalculateMinimumAlpha);
            }
            this.h.e = color;
            this.l.setColor(color);
            canvas.drawPath(this.j, this.i);
        } else {
            this.l.setColor(this.c);
            this.h.e = this.c;
        }
        if (this.e.getBorderStyle() != BorderStyle.NONE) {
            this.h.a(1.0f, n);
            this.h.b(canvas, this.l, null);
            return;
        }
        this.l.setStrokeWidth(this.d * 2.0f);
        float fWidth = getBounds().width() / 2;
        float fHeight = getBounds().height() / 2;
        float fWidth2 = (getBounds().width() / 2) - (this.k * 8);
        canvas.drawCircle(fWidth, fHeight, fWidth2, this.l);
        float fSin = (float) (Math.sin(0.7853981633974483d) * ((double) fWidth2));
        canvas.drawLine(fWidth - fSin, fHeight - fSin, fWidth + fSin, fHeight + fSin, this.l);
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
    public final Drawable mutate() {
        return new vn(this.a, this.c, this.d, this.e, this.f, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        float fHeight = rect.height() / 2.0f;
        if (this.e.getBorderEffect() == BorderEffect.CLOUDY) {
            fHeight += this.h.q * 4.25f;
        }
        zn znVar = this.h;
        float f = this.b;
        float fWidth = rect.width() - this.b;
        znVar.getClass();
        znVar.a(Arrays.asList(new PointF(f, fHeight), new PointF(fWidth, fHeight)));
        this.j.reset();
        Path path = this.j;
        float f2 = this.k;
        path.addRoundRect(new RectF(f2, f2, rect.width() - this.k, rect.height() - this.k), 4.0f, 4.0f, Path.Direction.CW);
        this.j.setFillType(Path.FillType.EVEN_ODD);
        invalidateSelf();
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
            if (iArr[i] == 16842913) {
                z = true;
                break;
            }
            i++;
        }
        boolean z2 = z != this.m;
        this.m = z;
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
