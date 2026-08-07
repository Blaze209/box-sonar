package com.box.android.preview.annotations;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayerProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0017J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/annotations/RectDrawable;", "Landroid/graphics/drawable/Drawable;", "color", "", "strokeWidth", "", "intersection", "Landroid/graphics/RectF;", "style", "Landroid/graphics/Paint$Style;", "<init>", "(IFLandroid/graphics/RectF;Landroid/graphics/Paint$Style;)V", "clearPaint", "Landroid/graphics/Paint;", "paint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "getOpacity", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RectDrawable extends Drawable {
    public static final float CORNER_RAD = 10.0f;
    private final Paint clearPaint;
    private RectF intersection;
    private final Paint paint;
    public static final int $stable = 8;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public RectDrawable(int i, float f, RectF rectF, Paint.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.intersection = rectF;
        Paint paint = new Paint(1);
        this.clearPaint = paint;
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setColor(i);
        paint2.setStyle(style);
        paint2.setStrokeWidth(f);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setStrokeWidth(f + 6.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public /* synthetic */ RectDrawable(int i, float f, RectF rectF, Paint.Style style, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, (i2 & 4) != 0 ? null : rectF, (i2 & 8) != 0 ? Paint.Style.STROKE : style);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.intersection == null) {
            canvas.drawRoundRect(new RectF(getBounds()), 10.0f, 10.0f, this.paint);
            return;
        }
        AnnotationUtils annotationUtils = AnnotationUtils.INSTANCE;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        AnnotationUtils.drawRect$default(canvas, this.paint, this.clearPaint, 0.0f, 10.0f, bounds, this.intersection, 8, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
