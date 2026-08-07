package com.pspdfkit.ui.drawable;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PdfDrawable extends Drawable {
    private final Matrix pdfToPageTransformation = new Matrix();

    public final Matrix getPdfToPageTransformation() {
        return this.pdfToPageTransformation;
    }

    public void updatePdfToViewTransformation(Matrix matrix) {
        uw.a(matrix, "matrix", null);
        this.pdfToPageTransformation.set(matrix);
    }
}
