package com.box.android.capture.documentscanning;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentScanningReducer$build$8 extends FunctionReferenceImpl implements Function1<ReviewScanPageReducer.State, DocumentScanningReducer.State.Review> {
    public static final DocumentScanningReducer$build$8 INSTANCE = new DocumentScanningReducer$build$8();

    DocumentScanningReducer$build$8() {
        super(1, DocumentScanningReducer.State.Review.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentScanningReducer.State.Review invoke(ReviewScanPageReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentScanningReducer.State.Review(p0);
    }
}
