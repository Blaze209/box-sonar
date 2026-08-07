package com.box.android.preview.previewtype.document;

import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewReducer$build$9 extends FunctionReferenceImpl implements Function1<CopySelectedTextReducer.Action, DocumentPreviewReducer.Action.CopyText> {
    public static final DocumentPreviewReducer$build$9 INSTANCE = new DocumentPreviewReducer$build$9();

    DocumentPreviewReducer$build$9() {
        super(1, DocumentPreviewReducer.Action.CopyText.class, "<init>", "<init>(Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentPreviewReducer.Action.CopyText invoke(CopySelectedTextReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentPreviewReducer.Action.CopyText(p0);
    }
}
