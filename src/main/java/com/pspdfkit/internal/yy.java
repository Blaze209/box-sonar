package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class yy extends vy {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy(Context context, PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        super(context, pdfConfiguration, pdfDocument);
        context.getClass();
        pdfConfiguration.getClass();
        pdfDocument.getClass();
        setRefreshBoundingBoxAfterRendering(true);
    }

    @Override // com.pspdfkit.internal.vy
    public final void q() {
        Annotation annotation = getAnnotation();
        if (annotation == null) {
            return;
        }
        if (annotation.getType() == AnnotationType.HIGHLIGHT) {
            getImageView().setBlendPaintProperties(getConfiguration());
            getImageView().setBackgroundColor(getConfiguration().isInvertColors() ? -16777216 : -1);
        } else {
            getImageView().c = null;
            getImageView().setBackground(null);
        }
    }

    @Override // com.pspdfkit.internal.vy, com.pspdfkit.internal.z4
    public void setAnnotation(Annotation annotation) {
        annotation.getClass();
        if (Intrinsics.areEqual(getAnnotation(), annotation)) {
            return;
        }
        super.setAnnotation(annotation);
        q();
    }
}
