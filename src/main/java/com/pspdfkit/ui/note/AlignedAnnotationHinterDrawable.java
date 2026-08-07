package com.pspdfkit.ui.note;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.zs;

/* JADX INFO: loaded from: classes3.dex */
public class AlignedAnnotationHinterDrawable extends NoteHinterDrawable implements zs {
    private final HorizontalAlignment horizontalAlignment;
    private final VerticalAlignment verticalAlignment;

    public enum HorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum VerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public AlignedAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration);
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        annotation.getInternal().addOnAnnotationPropertyChangeListener(this);
        refresh();
    }

    private float getX(RectF rectF) {
        int iOrdinal = this.horizontalAlignment.ordinal();
        if (iOrdinal == 0) {
            return rectF.left;
        }
        if (iOrdinal == 1) {
            return rectF.centerX();
        }
        if (iOrdinal == 2) {
            return rectF.right;
        }
        throw new IllegalStateException("Unhandled alignment constant: " + this.horizontalAlignment);
    }

    private float getY(RectF rectF) {
        int iOrdinal = this.verticalAlignment.ordinal();
        if (iOrdinal == 0) {
            return rectF.top;
        }
        if (iOrdinal == 1) {
            return rectF.centerY();
        }
        if (iOrdinal == 2) {
            return rectF.bottom;
        }
        throw new IllegalStateException("Unhandled alignment constant: " + this.verticalAlignment);
    }

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable
    public void dispose() {
        super.dispose();
        this.annotation.getInternal().removeOnAnnotationPropertyChangeListener(this);
    }

    @Override // com.pspdfkit.internal.zs
    public void onAnnotationPropertyChange(Annotation annotation, int i, Object obj, Object obj2) {
        if (i == 9) {
            refresh();
        }
    }

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable, com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        super.updatePdfToViewTransformation(matrix);
        this.annotation.getBoundingBox(this.pdfBoundingBox);
        this.pdfPoint.set(getX(this.pdfBoundingBox), getY(this.pdfBoundingBox));
        PointF pointF = this.pdfPoint;
        PointF pointF2 = this.viewPoint;
        pointF2.set(pointF);
        s60.a(pointF2, matrix);
        RectF rectF = this.viewBoundingBox;
        PointF pointF3 = this.viewPoint;
        float f = pointF3.y;
        float f2 = this.halfHeightPx;
        rectF.top = f - f2;
        rectF.bottom = f + f2;
        float f3 = pointF3.x;
        float f4 = this.halfWidthPx;
        rectF.left = f3 - f4;
        rectF.right = f3 + f4;
        rectF.round(this.viewBoundingBoxRounded);
    }
}
