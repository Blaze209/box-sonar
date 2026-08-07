package com.box.android.capture.documentscanning;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentScanningReducer$build$9 extends FunctionReferenceImpl implements Function1<ReviewScanPageReducer.Action, DocumentScanningReducer.Action.Review> {
    public static final DocumentScanningReducer$build$9 INSTANCE = new DocumentScanningReducer$build$9();

    DocumentScanningReducer$build$9() {
        super(1, DocumentScanningReducer.Action.Review.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentScanningReducer.Action.Review invoke(ReviewScanPageReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentScanningReducer.Action.Review(p0);
    }
}
