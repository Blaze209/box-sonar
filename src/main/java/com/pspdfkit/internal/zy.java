package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.AnnotationRenderConfiguration;
import com.pspdfkit.ui.PdfFragment;

/* JADX INFO: loaded from: classes3.dex */
public final class zy extends vy {
    public final PdfFragment w;

    public zy(Context context, PdfConfiguration pdfConfiguration, PdfFragment pdfFragment) {
        super(context, pdfConfiguration, pdfFragment.getDocument());
        this.w = pdfFragment;
        setRefreshBoundingBoxAfterRendering(true);
    }

    @Override // com.pspdfkit.internal.vy
    public final AnnotationRenderConfiguration.Builder p() {
        return super.p().redactionAnnotationPreviewEnabled(this.w.isRedactionAnnotationPreviewEnabled());
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public void setAnnotation(Annotation annotation) {
        if (getAnnotation() == null || !getAnnotation().equals(annotation)) {
            super.setAnnotation(annotation);
            q();
        }
    }
}
