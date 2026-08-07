package com.box.android.preview.previewtype.document;

import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$2 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, DocumentPreviewReducer.Action.CreateAnnotation> {
    public static final DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$2 INSTANCE = new DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$2();

    DocumentPreviewScreenKt$NutrientDocumentView$getCreateAnnotationStore$1$1$1$2() {
        super(1, DocumentPreviewReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentPreviewReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentPreviewReducer.Action.CreateAnnotation(p0);
    }
}
