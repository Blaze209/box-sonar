package com.box.android.preview.annotations;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.OnAddNewEditListener;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationEditListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/annotations/AnnotationEditListener;", "Lcom/pspdfkit/undo/OnAddNewEditListener;", "pendingAnnotations", "", "", "Lcom/pspdfkit/annotations/Annotation;", "<init>", "(Ljava/util/Map;)V", "getPendingAnnotations", "()Ljava/util/Map;", "onAddNewEdit", "", SemanticAttributes.FaasDocumentOperationValues.EDIT, "Lcom/pspdfkit/undo/edit/Edit;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationEditListener implements OnAddNewEditListener {
    public static final int $stable = 8;
    private final Map<String, Annotation> pendingAnnotations;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationEditListener(Map<String, ? extends Annotation> pendingAnnotations) {
        Intrinsics.checkNotNullParameter(pendingAnnotations, "pendingAnnotations");
        this.pendingAnnotations = pendingAnnotations;
    }

    public final Map<String, Annotation> getPendingAnnotations() {
        return this.pendingAnnotations;
    }

    @Override // com.pspdfkit.undo.OnAddNewEditListener
    public boolean onAddNewEdit(Edit edit) {
        Intrinsics.checkNotNullParameter(edit, "edit");
        Annotation annotation = (Annotation) CollectionsKt.firstOrNull(this.pendingAnnotations.values());
        Integer numValueOf = annotation != null ? Integer.valueOf(annotation.getPageIndex()) : null;
        AnnotationAddRemoveEdit annotationAddRemoveEdit = edit instanceof AnnotationAddRemoveEdit ? (AnnotationAddRemoveEdit) edit : null;
        return annotationAddRemoveEdit == null || numValueOf == null || annotationAddRemoveEdit.getPageIndex() == numValueOf.intValue();
    }
}
