package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class p4 implements OnAnnotationSelectedListener {
    public final Function3<AnnotationSelectionController, Annotation, Boolean, Boolean> a;
    public final Function2<Annotation, Boolean, Unit> b;
    public final Function2<List<? extends Annotation>, Boolean, Unit> c;
    public final Function2<Annotation, Boolean, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public p4(Function3<? super AnnotationSelectionController, ? super Annotation, ? super Boolean, Boolean> function3, Function2<? super Annotation, ? super Boolean, Unit> function2, Function2<? super List<? extends Annotation>, ? super Boolean, Unit> function4, Function2<? super Annotation, ? super Boolean, Unit> function5) {
        function3.getClass();
        function2.getClass();
        function4.getClass();
        function5.getClass();
        this.a = function3;
        this.b = function2;
        this.c = function4;
        this.d = function5;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final void onAnnotationDeselected(Annotation annotation, boolean z) {
        annotation.getClass();
        this.d.invoke(annotation, Boolean.valueOf(z));
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final void onAnnotationSelected(Annotation annotation, boolean z) {
        annotation.getClass();
        this.b.invoke(annotation, Boolean.valueOf(z));
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final void onAnnotationSelectionFinished(List<? extends Annotation> list, boolean z) {
        list.getClass();
        this.c.invoke(list, Boolean.valueOf(z));
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final boolean onPrepareAnnotationSelection(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        annotationSelectionController.getClass();
        annotation.getClass();
        return this.a.invoke(annotationSelectionController, annotation, Boolean.valueOf(z)).booleanValue();
    }
}
