package com.pspdfkit.ui.note;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.zs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NoteMultilineAnnotationHinterDrawable extends NoteHinterDrawable implements zs {
    public NoteMultilineAnnotationHinterDrawable(Drawable drawable, Annotation annotation, AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration) {
        super(drawable, annotation, annotationNoteHinterThemeConfiguration);
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
        if (i == 100 || i == 103) {
            refresh();
        }
    }

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable
    public void refresh() {
        AnnotationType type = this.annotation.getType();
        AnnotationType annotationType = AnnotationType.INK;
        Annotation annotation = this.annotation;
        if (type == annotationType) {
            List<List<PointF>> lines = ((InkAnnotation) annotation).getLines();
            List<PointF> arrayList = lines.size() > 0 ? lines.get(0) : new ArrayList<>();
            if (!arrayList.isEmpty()) {
                this.pdfPoint = arrayList.get(0);
            }
        } else {
            AnnotationType type2 = annotation.getType();
            AnnotationType annotationType2 = AnnotationType.POLYLINE;
            Annotation annotation2 = this.annotation;
            if (type2 == annotationType2) {
                List<PointF> points = ((PolylineAnnotation) annotation2).getPoints();
                if (!points.isEmpty()) {
                    this.pdfPoint = points.get(0);
                }
            } else {
                if (annotation2.getType() != AnnotationType.POLYGON) {
                    throw new AssertionError("NoteMultilineAnnotationHinterDrawable class supports only ink, polyline and polygon annotations.");
                }
                List<PointF> points2 = ((PolygonAnnotation) this.annotation).getPoints();
                if (!points2.isEmpty()) {
                    this.pdfPoint = points2.get(0);
                }
            }
        }
        super.refresh();
    }

    @Override // com.pspdfkit.ui.note.NoteHinterDrawable, com.pspdfkit.ui.drawable.PdfDrawable
    public void updatePdfToViewTransformation(Matrix matrix) {
        super.updatePdfToViewTransformation(matrix);
        PointF pointF = this.pdfPoint;
        PointF pointF2 = this.viewPoint;
        Matrix pdfToPageTransformation = getPdfToPageTransformation();
        pointF2.set(pointF);
        s60.a(pointF2, pdfToPageTransformation);
        Rect rect = this.viewBoundingBoxRounded;
        PointF pointF3 = this.viewPoint;
        int i = (int) (pointF3.x - this.halfWidthPx);
        rect.left = i;
        int i2 = (int) (pointF3.y + this.halfHeightPx);
        rect.top = i2;
        rect.right = i + this.widthPx;
        rect.bottom = i2 + this.heightPx;
    }
}
