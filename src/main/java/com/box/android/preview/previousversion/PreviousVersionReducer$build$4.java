package com.box.android.preview.previousversion;

import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionReducer$build$4 extends FunctionReferenceImpl implements Function1<DocumentPreviewReducer.Action, PreviousVersionReducer.Action.Document> {
    public static final PreviousVersionReducer$build$4 INSTANCE = new PreviousVersionReducer$build$4();

    PreviousVersionReducer$build$4() {
        super(1, PreviousVersionReducer.Action.Document.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviousVersionReducer.Action.Document invoke(DocumentPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviousVersionReducer.Action.Document(p0);
    }
}
