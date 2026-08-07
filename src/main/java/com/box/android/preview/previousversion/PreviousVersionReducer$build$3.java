package com.box.android.preview.previousversion;

import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionReducer$build$3 extends FunctionReferenceImpl implements Function1<DocumentPreviewReducer.State, ItemState.Document> {
    public static final PreviousVersionReducer$build$3 INSTANCE = new PreviousVersionReducer$build$3();

    PreviousVersionReducer$build$3() {
        super(1, ItemState.Document.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Document invoke(DocumentPreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Document(p0);
    }
}
