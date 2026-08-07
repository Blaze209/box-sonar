package com.box.android.capture.documentscanning;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScanningReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentScanningReducer$build$3 extends FunctionReferenceImpl implements Function1<ScanPageReducer.Action, DocumentScanningReducer.Action.Scanning> {
    public static final DocumentScanningReducer$build$3 INSTANCE = new DocumentScanningReducer$build$3();

    DocumentScanningReducer$build$3() {
        super(1, DocumentScanningReducer.Action.Scanning.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentScanningReducer.Action.Scanning invoke(ScanPageReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentScanningReducer.Action.Scanning(p0);
    }
}
