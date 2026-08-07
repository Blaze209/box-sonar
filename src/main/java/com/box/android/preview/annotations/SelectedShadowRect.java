package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.box.android.preview.R;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.ui.drawable.PdfDrawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfDrawingAnnotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0017J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\b\u0010(\u001a\u00020$H\u0017J\b\u0010)\u001a\u00020\u001cH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/box/android/preview/annotations/SelectedShadowRect;", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "boundingBox", "Landroid/graphics/RectF;", "context", "Landroid/content/Context;", ViewProps.VISIBLE, "", "<init>", "(Landroid/graphics/RectF;Landroid/content/Context;Z)V", "getVisible", "()Z", "setVisible", "(Z)V", "screenCoordinates", "width", "", "getWidth", "()F", "selectedDrawable", "Lcom/box/android/preview/annotations/SelectedDrawable;", "value", "boundingRect", "getBoundingRect", "()Landroid/graphics/RectF;", "setBoundingRect", "(Landroid/graphics/RectF;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "updatePdfToViewTransformation", "matrix", "Landroid/graphics/Matrix;", "setAlpha", "alpha", "", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "updateScreenCoordinates", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectedShadowRect extends PdfDrawable {
    public static final int $stable = 8;
    private RectF boundingRect;
    private final RectF screenCoordinates;
    private SelectedDrawable selectedDrawable;
    private boolean visible;
    private final float width;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public SelectedShadowRect(RectF boundingBox, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        Intrinsics.checkNotNullParameter(context, "context");
        this.visible = z;
        this.screenCoordinates = new RectF();
        float dimension = context.getResources().getDimension(R.dimen.box_annotation_bounding_box_stroke_width);
        this.width = dimension;
        this.selectedDrawable = new SelectedDrawable(context.getResources().getColor(R.color.box_black_01pc), dimension, context.getResources().getColor(R.color.box_black_99pc));
        this.boundingRect = boundingBox;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }

    public final float getWidth() {
        return this.width;
    }

    public final RectF getBoundingRect() {
        return this.boundingRect;
    }

    public final void setBoundingRect(RectF value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.boundingRect.set(value);
        updateScreenCoordinates();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.visible) {
            this.selectedDrawable.setBounds(getBounds());
            this.selectedDrawable.draw(canvas);
        }
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        super.updatePdfToViewTransformation(matrix);
        updateScreenCoordinates();
    }

    private final void updateScreenCoordinates() {
        getPdfToPageTransformation().mapRect(this.screenCoordinates, this.boundingRect);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        this.screenCoordinates.roundOut(bounds);
        setBounds(bounds);
    }
}
