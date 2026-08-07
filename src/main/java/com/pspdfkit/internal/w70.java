package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.projection.ViewProjection;
import com.pspdfkit.ui.PdfFragment;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class w70 implements ViewProjection {
    public final PdfFragment a;
    public final uv b;
    public final Matrix c = new Matrix();

    public w70(PdfFragment pdfFragment, uv uvVar) {
        this.a = pdfFragment;
        this.b = uvVar;
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final Matrix getPageToViewTransformation(int i, Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        PdfDocument document = this.a.getDocument();
        if (document == null) {
            throw new IllegalStateException("Transformation failed since document has not been loaded yet.");
        }
        if (i < 0 || i >= document.getPageCount()) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "Transformation failed because of invalid page: %d", Integer.valueOf(i)));
        }
        DocumentView documentView = this.b.n;
        if ((documentView != null ? documentView.a(i, matrix) : null) != null) {
            return matrix;
        }
        throw new IllegalStateException(String.format(Locale.getDefault(), "Transformation of coordinates for page %d not possible. Layout is not yet ready.", Integer.valueOf(i)));
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final Matrix getViewToPageTransformation(int i, Matrix matrix) {
        Matrix matrix2 = new Matrix();
        getPageToViewTransformation(i, matrix).invert(matrix2);
        return matrix2;
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final void toPdfPoint(PointF pointF, int i) {
        uw.a(pointF, "point", null);
        synchronized (this.c) {
            getPageToViewTransformation(i, this.c);
            Matrix matrix = this.c;
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            s60.a(pointF, matrix2);
        }
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final void toPdfRect(RectF rectF, int i) {
        synchronized (this.c) {
            getPageToViewTransformation(i, this.c);
            s60.a(rectF, this.c);
        }
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final void toViewPoint(PointF pointF, int i) {
        uw.a(pointF, "point", null);
        synchronized (this.c) {
            getPageToViewTransformation(i, this.c);
            s60.a(pointF, this.c);
        }
    }

    @Override // com.pspdfkit.projection.ViewProjection
    public final void toViewRect(RectF rectF, int i) {
        uw.a(rectF, "rect", null);
        synchronized (this.c) {
            getPageToViewTransformation(i, this.c);
            this.c.mapRect(rectF);
        }
    }
}
