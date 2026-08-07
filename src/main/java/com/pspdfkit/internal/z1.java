package com.pspdfkit.internal;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.PdfFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 {
    public final DocumentView a;
    public final PdfFragment b;
    public final at c;

    public final class a {
        public a() {
        }
    }

    public z1(DocumentView documentView, PdfFragment pdfFragment, at atVar) {
        documentView.getClass();
        pdfFragment.getClass();
        atVar.getClass();
        this.a = documentView;
        this.b = pdfFragment;
        this.c = atVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Annotation annotation) {
        annotation.getClass();
        PdfFragment pdfFragment = this.b;
        at atVar = this.c;
        pdfFragment.getClass();
        atVar.getClass();
        x1 x1Var = null;
        x1Var = null;
        if (pdfFragment.getDocument() != null) {
            boolean z = false;
            Object[] objArr = ww.g(annotation) || annotation.getType() == AnnotationType.NOTE;
            if (annotation.getType() == AnnotationType.FREETEXT) {
                tg tgVarB = ar.b();
                PdfConfiguration configuration = pdfFragment.getConfiguration();
                configuration.getClass();
                if (tgVarB.b(configuration)) {
                    z = true;
                }
            }
            if (annotation.getInternal().isInstantCommentThreadRoot() || objArr != false || z) {
                FragmentManager parentFragmentManager = pdfFragment.getParentFragmentManager();
                parentFragmentManager.getClass();
                Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag("Nutrient.AnnotationEditor");
                c2 c2Var = fragmentFindFragmentByTag instanceof c2 ? (c2) fragmentFindFragmentByTag : null;
                if (c2Var == null) {
                    try {
                        Object objNewInstance = ks.class.getDeclaredConstructor(null).newInstance(null);
                        objNewInstance.getClass();
                        c2Var = (c2) objNewInstance;
                    } catch (Exception e) {
                        throw new IllegalStateException("Could not instantiate annotation editor fragment. Fragment requires a public empty constructor!", e);
                    }
                }
                FragmentManager parentFragmentManager2 = pdfFragment.getParentFragmentManager();
                parentFragmentManager2.getClass();
                x1 x1Var2 = new x1(c2Var, parentFragmentManager2);
                c2Var.d = pdfFragment;
                c2Var.e = atVar;
                c2Var.g = pdfFragment.getAnnotationConfiguration();
                c2Var.h = pdfFragment.getAnnotationPreferences();
                c2Var.f = pdfFragment.getConfiguration();
                PdfDocument document = pdfFragment.getDocument();
                c2Var.a = document instanceof lm ? (lm) document : null;
                wu wuVar = c2Var.b;
                if (wuVar == null || (annotation != wuVar.d && (annotation.getPageIndex() != wuVar.a || !Intrinsics.areEqual(annotation.getInternal().getUuid(), wuVar.b)))) {
                    wu wuVar2 = new wu(annotation.getPageIndex(), annotation.getInternal().getUuid(), annotation.getObjectNumber());
                    wuVar2.d = annotation;
                    c2Var.b = wuVar2;
                    c2Var.a(annotation);
                }
                x1Var = x1Var2;
            }
        }
        if (x1Var == null) {
            return;
        }
        x1Var.c = new a();
        if (x1Var.a.isAdded()) {
            return;
        }
        x1Var.a.show(x1Var.b, "Nutrient.AnnotationEditor");
        x1Var.a.getParentFragmentManager().executePendingTransactions();
    }
}
