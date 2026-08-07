package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationSelectedState;
import com.pspdfkit.ui.drawable.PdfDrawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfRegionAnnotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020$J\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0004J\u0010\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0017J\u0012\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105H\u0017J\b\u00106\u001a\u000202H\u0017J\b\u00107\u001a\u00020$H\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/box/android/preview/annotations/PdfRegionAnnotation;", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "Lcom/box/android/preview/annotations/model/Annotation;", "boundingBox", "Landroid/graphics/RectF;", "context", "Landroid/content/Context;", "annotationId", "", "<init>", "(Landroid/graphics/RectF;Landroid/content/Context;Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "getSelectedState", "()Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "setSelectedState", "(Lcom/box/android/preview/annotations/model/AnnotationSelectedState;)V", "widthScalingFactor", "", "getWidthScalingFactor", "()F", "setWidthScalingFactor", "(F)V", "screenCoordinates", "value", "boundingRect", "getBoundingRect", "()Landroid/graphics/RectF;", "setBoundingRect", "(Landroid/graphics/RectF;)V", "layerProvider", "Lcom/box/android/preview/annotations/RegionLayerProvider;", "intersection", "drawAnnotation", "", "canvas", "Landroid/graphics/Canvas;", "clearIntersection", "setIntersectingRect", "rectF", "draw", "setSelected", "setUnselected", "updatePdfToViewTransformation", "matrix", "Landroid/graphics/Matrix;", "setAlpha", "alpha", "", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "updateScreenCoordinates", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfRegionAnnotation extends PdfDrawable implements Annotation {
    public static final int $stable = 8;
    private final String annotationId;
    private RectF boundingRect;
    private RectF intersection;
    private RegionLayerProvider layerProvider;
    private final RectF screenCoordinates;
    private AnnotationSelectedState selectedState;
    private float widthScalingFactor;

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

    public PdfRegionAnnotation(RectF boundingBox, Context context, String annotationId) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        this.annotationId = annotationId;
        this.selectedState = AnnotationSelectedState.UNSELECTED.INSTANCE;
        this.widthScalingFactor = 1.0f;
        this.screenCoordinates = new RectF();
        this.boundingRect = boundingBox;
        this.layerProvider = new RegionLayerProvider(context);
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public String getAnnotationId() {
        return this.annotationId;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public AnnotationSelectedState getSelectedState() {
        return this.selectedState;
    }

    public void setSelectedState(AnnotationSelectedState annotationSelectedState) {
        Intrinsics.checkNotNullParameter(annotationSelectedState, "<set-?>");
        this.selectedState = annotationSelectedState;
    }

    public final float getWidthScalingFactor() {
        return this.widthScalingFactor;
    }

    public final void setWidthScalingFactor(float f) {
        this.widthScalingFactor = f;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public RectF getBoundingRect() {
        return this.boundingRect;
    }

    public void setBoundingRect(RectF value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.boundingRect.set(value);
        updateScreenCoordinates();
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void drawAnnotation(Canvas canvas) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.layerProvider.setWidthScalingFactor(getPdfToPageTransformation().mapRadius(this.widthScalingFactor));
        if (this.intersection != null) {
            rectF = new RectF();
            getPdfToPageTransformation().mapRect(rectF, this.intersection);
        } else {
            rectF = null;
        }
        RegionLayerProvider regionLayerProvider = this.layerProvider;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        regionLayerProvider.getLayers(bounds, getSelectedState(), rectF).draw(canvas);
    }

    public final void clearIntersection() {
        this.intersection = null;
    }

    public final void setIntersectingRect(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.intersection = rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawAnnotation(canvas);
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setSelected() {
        setSelectedState(AnnotationSelectedState.SELECTED.INSTANCE);
        invalidateSelf();
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setUnselected() {
        setSelectedState(AnnotationSelectedState.UNSELECTED.INSTANCE);
        invalidateSelf();
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        super.updatePdfToViewTransformation(matrix);
        updateScreenCoordinates();
    }

    private final void updateScreenCoordinates() {
        getPdfToPageTransformation().mapRect(this.screenCoordinates, getBoundingRect());
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        this.screenCoordinates.roundOut(bounds);
        setBounds(bounds);
    }
}
