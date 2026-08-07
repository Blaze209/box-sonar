package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.DocumentDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class iy implements AnnotationProvider.OnAnnotationUpdatedListener, DocumentCoordinator.OnDocumentVisibleListener {
    public final dv a;
    public PdfDocument b;
    public Job d;
    public DocumentCoordinator f;
    public final CoroutineScope c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    public final ArrayList e = new ArrayList();

    public iy(dv dvVar) {
        this.a = dvVar;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        if (!(annotation instanceof RedactionAnnotation) || this.e.contains(annotation)) {
            return;
        }
        this.e.add(annotation);
        boolean zIsEmpty = this.e.isEmpty();
        dv dvVar = this.a;
        if (zIsEmpty) {
            dvVar.d();
        } else {
            dvVar.v();
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        if (TypeIntrinsics.asMutableCollection(this.e).remove(annotation)) {
            boolean zIsEmpty = this.e.isEmpty();
            dv dvVar = this.a;
            if (zIsEmpty) {
                dvVar.d();
            } else {
                dvVar.v();
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }

    @Override // com.pspdfkit.ui.DocumentCoordinator.OnDocumentVisibleListener
    public final void onDocumentVisible(DocumentDescriptor documentDescriptor) {
        documentDescriptor.getClass();
        Job job = this.d;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.e.clear();
        boolean zIsEmpty = this.e.isEmpty();
        dv dvVar = this.a;
        if (zIsEmpty) {
            dvVar.d();
        } else {
            dvVar.v();
        }
    }
}
