package com.box.android.preview.annotations;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayerProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0017J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/annotations/SelectedDrawable;", "Landroid/graphics/drawable/Drawable;", "color", "", "strokeWidth", "", "selectionShadowColor", "<init>", "(IFI)V", "clearPaint", "Landroid/graphics/Paint;", "paint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "getOpacity", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectedDrawable extends Drawable {
    public static final float CORNER_RAD = 10.0f;
    public static final float SHADOW_RAD = 50.0f;
    private final Paint clearPaint;
    private final Paint paint;
    public static final int $stable = 8;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public SelectedDrawable(int i, float f, int i2) {
        Paint paint = new Paint();
        this.clearPaint = paint;
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f);
        paint2.setShadowLayer(50.0f, 0.0f, 0.0f, i2);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AnnotationUtils annotationUtils = AnnotationUtils.INSTANCE;
        Paint paint = this.paint;
        Paint paint2 = this.clearPaint;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        AnnotationUtils.drawRect$default(canvas, paint, paint2, 50.0f, 10.0f, bounds, null, 64, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.getColorFilter();
    }
}
