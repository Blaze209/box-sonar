package com.box.android.preview.previewtype.document;

import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewReducer$build$12 extends FunctionReferenceImpl implements Function1<DocumentSearchReducer.Action, DocumentPreviewReducer.Action.Search> {
    public static final DocumentPreviewReducer$build$12 INSTANCE = new DocumentPreviewReducer$build$12();

    DocumentPreviewReducer$build$12() {
        super(1, DocumentPreviewReducer.Action.Search.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentPreviewReducer.Action.Search invoke(DocumentSearchReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentPreviewReducer.Action.Search(p0);
    }
}
