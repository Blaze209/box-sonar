package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.instant.ui.InstantPdfFragment;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;

/* JADX INFO: loaded from: classes3.dex */
public final class el extends c5 {
    public final px<hl> u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el(Context context, InstantPdfFragment instantPdfFragment, PdfConfiguration pdfConfiguration) {
        super(context, instantPdfFragment, pdfConfiguration);
        context.getClass();
        pdfConfiguration.getClass();
        this.u = new px<>(5);
    }

    public static final hl a(el elVar, PdfDocument pdfDocument) {
        return new hl(elVar.a, elVar.c, pdfDocument);
    }

    @Override // com.pspdfkit.internal.c5
    public final void b(z4<?> z4Var) {
        z4Var.getClass();
        if (!(z4Var instanceof hl)) {
            super.b(z4Var);
        } else {
            this.u.a((nx) z4Var);
            this.r.remove(z4Var);
        }
    }

    @Override // com.pspdfkit.internal.c5
    public final boolean a(z4<?> z4Var) {
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            return false;
        }
        if (annotation.getType() == AnnotationType.STAMP) {
            return z4Var instanceof hl;
        }
        return super.a(z4Var);
    }

    @Override // com.pspdfkit.internal.c5
    public final z4<?> a(Annotation annotation, AnnotationOverlayRenderStrategy.Strategy strategy) {
        annotation.getClass();
        final PdfDocument document = this.b.getDocument();
        if (document != null) {
            if (annotation.getType() == AnnotationType.STAMP && ((StampAnnotation) annotation).hasBitmap()) {
                nx nxVarA = this.u.a(new px.a() { // from class: com.pspdfkit.internal.el$$ExternalSyntheticLambda0
                    @Override // com.pspdfkit.internal.px.a
                    public final Object create() {
                        return el.a(this.f$0, document);
                    }
                });
                nxVarA.getClass();
                hl hlVar = (hl) nxVarA;
                hlVar.setAnnotation(annotation);
                this.r.add(hlVar);
                return hlVar;
            }
            return a(annotation, strategy, true);
        }
        throw new IllegalStateException("Annotation view can be created only while document is loaded!");
    }
}
