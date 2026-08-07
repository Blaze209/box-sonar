package com.pspdfkit.internal;

import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public interface oi extends l1 {
    @Override // com.pspdfkit.internal.l1
    default boolean a(Annotation annotation, jf jfVar, PdfConfiguration pdfConfiguration, MotionEvent motionEvent) {
        jfVar.getClass();
        pdfConfiguration.getClass();
        String contents = annotation.getContents();
        return contents != null && contents.length() != 0 && motionEvent != null && motionEvent.getAction() == 2 && pdfConfiguration.getSelectedAnnotationFontScalingOnResizeEnabled() && jfVar.a.a == o4.b.BOTTOM_RIGHT;
    }

    @Override // com.pspdfkit.internal.l1
    default void a(Annotation annotation, xv xvVar, xv xvVar2) {
        String contents = annotation.getContents();
        if (contents == null || contents.length() == 0) {
            contents = null;
        }
        String str = contents;
        if (str != null && (annotation instanceof FreeTextAnnotation)) {
            if (xvVar.c - xvVar.a == xvVar2.c - xvVar2.a && xvVar.b - xvVar.d == xvVar2.b - xvVar2.d) {
                return;
            }
            float fA = ji.a(((FreeTextAnnotation) annotation).getBorderWidth()) * 2;
            annotation.setTextSize(o50.a(str, ((e00) this).getPaintForFontScalingCalculation(), (xvVar2.c - xvVar2.a) - fA, (xvVar2.b - xvVar2.d) - fA, true, true, 128));
        }
    }
}
