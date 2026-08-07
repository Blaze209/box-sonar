package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.stamps.PredefinedStampType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class z30 extends Drawable {
    public static final HashSet t = new HashSet(Arrays.asList(PredefinedStampType.INITIAL_HERE, PredefinedStampType.SIGN_HERE, PredefinedStampType.WITNESS));
    public static final Typeface u;
    public static final Typeface v;
    public final StampAnnotation a;
    public final int b;
    public final DisplayMetrics c;
    public Path d;
    public Paint e;
    public Path f;
    public Paint g;
    public RectF h;
    public Paint i;
    public RectF j;
    public Paint k;
    public final float l;
    public final float m;
    public final float n;
    public final float o;
    public final float p;
    public final float q;
    public int r = -1;
    public int s = -1;

    static {
        Typeface typeface = Typeface.SANS_SERIF;
        u = Typeface.create(typeface, 1);
        v = Typeface.create(typeface, 3);
    }

    public z30(Context context, StampAnnotation stampAnnotation) {
        if (stampAnnotation.getStampType() == null && stampAnnotation.getTitle() == null) {
            throw new IllegalArgumentException("StampDrawable can't be used with image stamps.");
        }
        this.a = stampAnnotation;
        PredefinedStampType predefinedStampTypeFromStampType = PredefinedStampType.fromStampType(stampAnnotation.getStampType());
        if (predefinedStampTypeFromStampType == PredefinedStampType.ACCEPTED && stampAnnotation.getSubtitle() == null) {
            this.b = 1;
        } else if (predefinedStampTypeFromStampType == PredefinedStampType.REJECTED && stampAnnotation.getSubtitle() == null) {
            this.b = 2;
        } else if (t.contains(predefinedStampTypeFromStampType)) {
            this.b = 3;
        } else {
            this.b = 4;
        }
        this.p = a80.a(context, 6.0f);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        this.q = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        this.l = TypedValue.applyDimension(1, 6.0f, displayMetrics2);
        DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
        displayMetrics3.getClass();
        this.m = TypedValue.applyDimension(1, 4.0f, displayMetrics3);
        DisplayMetrics displayMetrics4 = context.getResources().getDisplayMetrics();
        displayMetrics4.getClass();
        this.n = TypedValue.applyDimension(1, 2.0f, displayMetrics4);
        this.c = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics5 = context.getResources().getDisplayMetrics();
        displayMetrics5.getClass();
        this.o = TypedValue.applyDimension(1, 26.0f, displayMetrics5);
    }

    public final void a(Path path, int i) {
        this.d = path;
        this.f = path;
        float fWidth = getBounds().width() / 100.0f;
        float fHeight = getBounds().height();
        float f = fHeight / 100.0f;
        float fMax = Math.max(fWidth, f);
        Matrix matrix = new Matrix();
        matrix.setScale(fWidth, -f);
        matrix.postTranslate(0.0f, fHeight);
        this.d.transform(matrix);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setColor(i9.a(i, 0.35f));
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(fMax * 2.0f);
        this.g.setColor(i);
        this.g.setAntiAlias(true);
        this.g.setDither(true);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        Path path = this.d;
        if (path != null && (paint2 = this.e) != null) {
            canvas.drawPath(path, paint2);
        }
        Path path2 = this.f;
        if (path2 != null && (paint = this.g) != null) {
            canvas.drawPath(path2, paint);
        }
        if (this.i != null && this.h != null) {
            String strB = a40.b(this.a);
            RectF rectF = this.h;
            canvas.drawText(strB, rectF.left, rectF.bottom, this.i);
        }
        if (this.k == null || this.j == null || this.a.getSubtitle() == null) {
            return;
        }
        String subtitle = this.a.getSubtitle();
        RectF rectF2 = this.j;
        canvas.drawText(subtitle, rectF2.left, rectF2.bottom, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.s;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        String str;
        if (rect.width() <= 0 || rect.height() <= 0 || getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        int iA = y30.a(this.b);
        if (iA == 0) {
            HashMap map = a40.a;
            Path path = new Path();
            path.moveTo(15.51f, 50.08f);
            path.lineTo(5.5f, 43.47f);
            path.lineTo(30.7f, 6.52f);
            path.lineTo(60.07f, 45.67f);
            path.lineTo(95.49f, 84.17f);
            path.lineTo(78.69f, 93.38f);
            path.lineTo(30.7f, 32.84f);
            path.lineTo(21.1f, 56.53f);
            path.close();
            a(path, -13281254);
        } else if (iA != 1) {
            boolean z = this.b == 3;
            int iA2 = a40.a(this.a);
            int iA3 = i9.a(iA2, 0.5f);
            Paint paint = new Paint();
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint.setColor(iA3);
            paint.setAntiAlias(true);
            paint.setDither(true);
            this.e = paint;
            Paint paint2 = new Paint();
            paint2.setStyle(style);
            paint2.setColor(iA2);
            paint2.setAntiAlias(true);
            paint2.setDither(true);
            this.g = paint2;
            RectF rectF = new RectF(getBounds());
            float f = this.p;
            float f2 = this.q;
            if (z) {
                float f3 = (f2 / 3.0f) + f;
                this.d = a40.a(rectF, f3, f3, 0.0f);
                this.f = a40.a(rectF, f, f, f2);
            } else {
                Path path2 = new Path();
                this.d = path2;
                float f4 = (f2 / 3.0f) + f;
                Path.Direction direction = Path.Direction.CW;
                path2.addRoundRect(rectF, f4, f4, direction);
                Path path3 = this.d;
                Path.FillType fillType = Path.FillType.EVEN_ODD;
                path3.setFillType(fillType);
                Path path4 = new Path();
                this.f = path4;
                path4.addRoundRect(rectF, f, f, direction);
                this.f.setFillType(fillType);
                RectF rectF2 = new RectF(rectF);
                rectF2.inset(f2, f2);
                if (rectF2.width() > 0.0f && rectF2.height() > 0.0f) {
                    float f5 = f - f2;
                    this.f.addRoundRect(rectF2, f5, f5, direction);
                }
            }
            float f6 = this.q / 2.0f;
            rectF.inset(f6, f6);
            boolean z2 = this.b == 3;
            int iA4 = a40.a(this.a);
            String strB = a40.b(this.a);
            String subtitle = this.a.getSubtitle();
            RectF rectF3 = new RectF(rectF);
            this.h = rectF3;
            if (z2) {
                rectF3.left = (rectF.width() / 5.0f) + rectF3.left;
            }
            RectF rectF4 = new RectF(rectF);
            this.j = rectF4;
            if (z2) {
                rectF4.left = (rectF.width() / 5.0f) + rectF4.left;
            }
            if (subtitle != null) {
                float fMin = Math.min(rectF.height() / 2.0f, this.o);
                this.h.bottom -= fMin;
                RectF rectF5 = this.j;
                rectF5.top = rectF5.bottom - fMin;
                rectF5.inset(this.l, this.n);
                Paint paint3 = new Paint();
                paint3.setTypeface(u);
                paint3.setColor(iA4);
                paint3.setAntiAlias(true);
                paint3.setDither(true);
                this.k = paint3;
                float fWidth = this.j.width();
                float fHeight = this.j.height() * 0.75f;
                DisplayMetrics displayMetrics = this.c;
                float f7 = displayMetrics.density;
                float fA = o50.a(subtitle, paint3, fWidth / f7, fHeight / f7, false, false, 192);
                str = subtitle;
                this.k.setTextSize(fA * displayMetrics.density);
                RectF rectF6 = this.j;
                Paint paint4 = this.k;
                Rect rect2 = new Rect();
                paint4.getTextBounds(str, 0, str.length(), rect2);
                rectF6.inset((int) Math.max(0.0f, (rectF6.width() - rect2.width()) / 2.0f), (int) Math.max(0.0f, (rectF6.height() - rect2.height()) / 2.0f));
            } else {
                str = subtitle;
            }
            this.h.inset(this.l, this.m);
            boolean z3 = this.a.getStampType() != null && this.a.getStampType().isStandard();
            Paint paint5 = new Paint();
            paint5.setTypeface(z3 ? v : u);
            paint5.setColor(iA4);
            paint5.setAntiAlias(true);
            paint5.setDither(true);
            this.i = paint5;
            float fWidth2 = this.h.width();
            float fHeight2 = this.h.height() * 0.6666667f;
            DisplayMetrics displayMetrics2 = this.c;
            float f8 = displayMetrics2.density;
            strB.getClass();
            this.i.setTextSize(o50.a(strB, paint5, fWidth2 / f8, fHeight2 / f8, false, false, 192) * displayMetrics2.density);
            if (str != null) {
                this.h.bottom = this.j.top - this.m;
            }
            RectF rectF7 = this.h;
            Paint paint6 = this.i;
            Rect rect3 = new Rect();
            paint6.getTextBounds(strB, 0, strB.length(), rect3);
            rectF7.inset((int) Math.max(0.0f, (rectF7.width() - rect3.width()) / 2.0f), (int) Math.max(0.0f, (rectF7.height() - rect3.height()) / 2.0f));
        } else {
            HashMap map2 = a40.a;
            Path path5 = new Path();
            path5.moveTo(6.5f, 20.01f);
            path5.lineTo(37.21f, 49.5f);
            path5.lineTo(6.5f, 80.21f);
            path5.lineTo(18.79f, 92.5f);
            path5.lineTo(49.5f, 61.79f);
            path5.lineTo(80.21f, 92.5f);
            path5.lineTo(92.5f, 80.21f);
            path5.lineTo(61.79f, 49.5f);
            path5.lineTo(92.5f, 20.01f);
            path5.lineTo(80.21f, 6.5f);
            path5.lineTo(49.5f, 37.21f);
            path5.lineTo(18.79f, 6.5f);
            path5.close();
            a(path5, -8781810);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
