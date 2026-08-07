package com.box.android.capture.documentscanning;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentScanningReducer$build$1 extends FunctionReferenceImpl implements Function2<DocumentScanningReducer.State, DocumentScanningReducer.Action, ReducerResult<DocumentScanningReducer.State, DocumentScanningReducer.Action>> {
    DocumentScanningReducer$build$1(Object obj) {
        super(2, obj, DocumentScanningReducer.class, "reduceDocScanning", "reduceDocScanning(Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<DocumentScanningReducer.State, DocumentScanningReducer.Action> invoke(DocumentScanningReducer.State p0, DocumentScanningReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((DocumentScanningReducer) this.receiver).reduceDocScanning(p0, p1);
    }
}
