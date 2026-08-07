package com.box.android.preview.previewtype.document;

import com.box.android.preview.previewtype.document.print.PrintReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewReducer$build$15 extends FunctionReferenceImpl implements Function1<PrintReducer.Action, DocumentPreviewReducer.Action.Print> {
    public static final DocumentPreviewReducer$build$15 INSTANCE = new DocumentPreviewReducer$build$15();

    DocumentPreviewReducer$build$15() {
        super(1, DocumentPreviewReducer.Action.Print.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentPreviewReducer.Action.Print invoke(PrintReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentPreviewReducer.Action.Print(p0);
    }
}
