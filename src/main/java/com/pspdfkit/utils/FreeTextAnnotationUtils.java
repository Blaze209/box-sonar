package com.pspdfkit.utils;

import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ji;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\"\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"placeCallOutPoints", "", "Lcom/pspdfkit/annotations/FreeTextAnnotation;", "resizeToFitText", "document", "Lcom/pspdfkit/document/PdfDocument;", "widthScaleMode", "Lcom/pspdfkit/utils/ScaleMode;", "heightScaleMode", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FreeTextAnnotationUtils {
    public static final void placeCallOutPoints(FreeTextAnnotation freeTextAnnotation) {
        freeTextAnnotation.getClass();
        freeTextAnnotation.getClass();
        ji.a(freeTextAnnotation, false);
    }

    public static final void resizeToFitText(FreeTextAnnotation freeTextAnnotation, PdfDocument pdfDocument, ScaleMode scaleMode, ScaleMode scaleMode2) {
        freeTextAnnotation.getClass();
        pdfDocument.getClass();
        scaleMode.getClass();
        scaleMode2.getClass();
        Size pageSize = pdfDocument.getPageSize(freeTextAnnotation.getPageIndex());
        pageSize.getClass();
        ji.a(freeTextAnnotation, pageSize, scaleMode, scaleMode2, null, null);
    }
}
