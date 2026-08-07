package com.pspdfkit.internal;

import android.os.Bundle;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes3.dex */
public final class yr extends u20 {
    public final /* synthetic */ au a;
    public final /* synthetic */ NoteAnnotation b;
    public final /* synthetic */ zr c;

    public yr(zr zrVar, au auVar, NoteAnnotation noteAnnotation) {
        this.c = zrVar;
        this.a = auVar;
        this.b = noteAnnotation;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        vt pageEditor = this.a.getPageEditor();
        Annotation[] annotationArr = {this.b};
        pageEditor.getClass();
        List listAsList = ArraysKt.asList(annotationArr);
        listAsList.getClass();
        pageEditor.a(false, (Collection<? extends Annotation>) listAsList);
        if (this.a.getPdfConfiguration().getShowNoteEditorForNewNoteAnnotations()) {
            q0 q0Var = this.c.a;
            NoteAnnotation noteAnnotation = this.b;
            q0Var.getClass();
            q0Var.d.a(noteAnnotation);
        }
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        NoteAnnotation noteAnnotation2 = this.b;
        bundleA.putString(Analytics.Data.ANNOTATION_TYPE, noteAnnotation2.getType().name());
        bundleA.putInt(Analytics.Data.PAGE_INDEX, noteAnnotation2.getPageIndex());
        i0VarA.a(Analytics.Event.CREATE_ANNOTATION, bundleA);
        q0 q0Var2 = this.c.a;
        if (q0Var2.s == AnnotationTool.NOTE) {
            AnnotationTool annotationTool = AnnotationTool.NONE;
            AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            annotationTool.getClass();
            annotationToolVariantDefaultVariant.getClass();
            q0Var2.b.enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
        }
    }

    @Override // com.pspdfkit.internal.u20, io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        PdfLog.e("Nutri.NoteAnnotMHandler", th, "Failed to create note annotation.", new Object[0]);
    }
}
