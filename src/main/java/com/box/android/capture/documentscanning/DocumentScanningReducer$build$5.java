package com.box.android.capture.documentscanning;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentScanningReducer$build$5 extends FunctionReferenceImpl implements Function1<EditScanPageReducer.State, DocumentScanningReducer.State.Edit> {
    public static final DocumentScanningReducer$build$5 INSTANCE = new DocumentScanningReducer$build$5();

    DocumentScanningReducer$build$5() {
        super(1, DocumentScanningReducer.State.Edit.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentScanningReducer.State.Edit invoke(EditScanPageReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentScanningReducer.State.Edit(p0);
    }
}
