package com.box.android.preview.previewtype.document;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewReducer$build$20 extends FunctionReferenceImpl implements Function2<DocumentPreviewReducer.State, DocumentPreviewReducer.Action, ReducerResult<DocumentPreviewReducer.State, DocumentPreviewReducer.Action>> {
    DocumentPreviewReducer$build$20(Object obj) {
        super(2, obj, DocumentPreviewReducer.class, "reduceDocumentPreviewAnalytics", "reduceDocumentPreviewAnalytics(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> invoke(DocumentPreviewReducer.State p0, DocumentPreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((DocumentPreviewReducer) this.receiver).reduceDocumentPreviewAnalytics(p0, p1);
    }
}
