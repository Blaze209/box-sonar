package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import com.pspdfkit.R;
import com.pspdfkit.ui.PdfFragment;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class ex {
    public static final int[] a = R.styleable.pspdf__PropertyInspector;
    public static final int b = R.attr.pspdf__propertyInspectorStyle;
    public static final int c = R.style.PSPDFKit_PropertyInspector;

    @JvmStatic
    public static final TypedArray a(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, a, b, c);
        typedArrayObtainStyledAttributes.getClass();
        return typedArrayObtainStyledAttributes;
    }

    @JvmStatic
    public static final void a(PdfFragment pdfFragment, Matrix matrix) {
        pdfFragment.getClass();
        if (matrix == null) {
            matrix = new Matrix();
        }
        int pageIndex = pdfFragment.getPageIndex();
        float zoomScale = pdfFragment.getZoomScale(pageIndex);
        pdfFragment.getViewProjection().getPageToViewTransformation(pageIndex, matrix);
        float f = 1 / zoomScale;
        matrix.postScale(f, f);
    }
}
