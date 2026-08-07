package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.Size;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ni extends e00 {
    public final j10 p;
    public final RectF q;
    public final Matrix r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni(Context context, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, AnnotationConfigurationRegistry annotationConfigurationRegistry) {
        super(context, pdfDocument, pdfConfiguration, annotationConfigurationRegistry);
        context.getClass();
        pdfDocument.getClass();
        pdfConfiguration.getClass();
        annotationConfigurationRegistry.getClass();
        List list = Collections.EMPTY_LIST;
        j10 j10Var = new j10(context, pdfConfiguration, null, 0);
        this.p = j10Var;
        this.q = new RectF();
        this.r = new Matrix();
        addView(j10Var);
    }

    @Override // com.pspdfkit.internal.e00, com.pspdfkit.internal.z4
    public final void a(Matrix matrix, float f) {
        matrix.getClass();
        super.a(matrix, f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.getClass();
        ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
        layoutParams2.getClass();
        OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams2;
        overlayLayoutParams.pageRect.getScreenRect().set(((OverlayLayoutParams) layoutParams).pageRect.getScreenRect());
        overlayLayoutParams.pageRect.updatePageRect(matrix);
        j10 j10Var = this.p;
        j10Var.a.set(matrix);
        j10Var.m = f;
        j10Var.b();
    }

    @Override // com.pspdfkit.internal.e00, com.pspdfkit.internal.z4
    public final void b() {
        super.b();
        this.p.b();
    }

    @Override // com.pspdfkit.internal.e00
    public final void c() {
        FreeTextAnnotation annotation = getAnnotation();
        if (annotation != null) {
            int rotation = annotation.getRotation();
            this.q.set(getEditTextRect());
            if (rotation == 90 || rotation == 270) {
                this.r.setRotate(rotation, getEditTextRect().centerX(), getEditTextRect().centerY());
                this.r.mapRect(this.q, getEditTextRect());
            }
            li editTextView = getEditTextView();
            RectF rectF = this.q;
            editTextView.layout((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.p.layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // com.pspdfkit.internal.e00
    public final void d() {
        this.p.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        float fWidth = getEditTextRect().width();
        float fHeight = getEditTextRect().height();
        FreeTextAnnotation annotation = getAnnotation();
        Integer numValueOf = annotation != null ? Integer.valueOf(annotation.getRotation()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 90) || (numValueOf != null && numValueOf.intValue() == 270)) {
            fWidth = getEditTextRect().height();
            fHeight = getEditTextRect().width();
        }
        getEditTextView().measure(View.MeasureSpec.makeMeasureSpec((int) Math.ceil(fWidth), 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.ceil(fHeight), 1073741824));
    }

    @Override // com.pspdfkit.internal.e00, com.pspdfkit.internal.z4
    public final void n() {
        super.n();
        this.p.n();
    }

    @Override // com.pspdfkit.internal.e00, com.pspdfkit.internal.nx
    public final void recycle() {
        this.b.recycle();
        this.p.recycle();
    }

    @Override // com.pspdfkit.internal.e00, com.pspdfkit.internal.z4
    public void setAnnotation(FreeTextAnnotation freeTextAnnotation) {
        freeTextAnnotation.getClass();
        super.setAnnotation(freeTextAnnotation);
        this.p.setAnnotation(freeTextAnnotation);
    }

    @Override // com.pspdfkit.internal.e00
    public final void a(FreeTextAnnotation freeTextAnnotation) {
        Size sizeA = ji.a(freeTextAnnotation, new RectF());
        EdgeInsets textInsets = freeTextAnnotation.getTextInsets();
        textInsets.getClass();
        float f = textInsets.left;
        boolean z = f == 0.0f;
        boolean z2 = textInsets.top == 0.0f;
        float pdfToViewScale = !z ? getPdfToViewScale() * f : 0.0f;
        float pdfToViewScale2 = z2 ? 0.0f : getPdfToViewScale() * textInsets.top;
        getEditTextRect().set(pdfToViewScale, pdfToViewScale2, (getPdfToViewScale() * sizeA.width) + pdfToViewScale, (getPdfToViewScale() * sizeA.height) + pdfToViewScale2);
    }
}
