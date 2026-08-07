package com.pspdfkit.ui.note;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.zs;

/* JADX INFO: loaded from: classes3.dex */
public class NoteTextMarkupAnnotationHinterDrawable extends NoteHinterDrawable implements zs {
    private final int noteMarkupTextLeftPadding;

    public NoteTextMarkupAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration);
        this.noteMarkupTextLeftPadding = annotationNoteHinterThemeConfiguration.noteMarkupTextLeftPadding;
        annotation.getInternal().addOnAnnotationPropertyChangeListener(this);
        refresh();
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

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable
    public void refresh() {
        this.annotation.getBoundingBox(this.pdfBoundingBox);
        RectF rectF = this.pdfBoundingBox;
        float f = rectF.right;
        float f2 = rectF.top;
        this.pdfPoint.set(f, f2 - ((f2 - rectF.bottom) * 0.5f));
        super.refresh();
    }

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable, com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        super.updatePdfToViewTransformation(matrix);
        PointF pointF = this.pdfPoint;
        PointF pointF2 = this.viewPoint;
        pointF2.set(pointF);
        s60.a(pointF2, matrix);
        PointF pointF3 = this.viewPoint;
        float f = pointF3.x + this.noteMarkupTextLeftPadding;
        pointF3.x = f;
        RectF rectF = this.viewBoundingBox;
        float f2 = pointF3.y;
        float f3 = this.halfHeightPx;
        rectF.top = f2 - f3;
        rectF.bottom = f2 + f3;
        float f4 = this.halfWidthPx;
        rectF.left = f - f4;
        rectF.right = f + f4;
        rectF.round(this.viewBoundingBoxRounded);
    }
}
