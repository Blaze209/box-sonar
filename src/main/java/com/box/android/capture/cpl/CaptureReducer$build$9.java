package com.box.android.capture.cpl;

import com.box.android.capture.documentscanning.DocumentScanningReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureReducer$build$9 extends FunctionReferenceImpl implements Function1<DocumentScanningReducer.Action, CaptureReducer.Action.DocumentScanning> {
    public static final CaptureReducer$build$9 INSTANCE = new CaptureReducer$build$9();

    CaptureReducer$build$9() {
        super(1, CaptureReducer.Action.DocumentScanning.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureReducer.Action.DocumentScanning invoke(DocumentScanningReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureReducer.Action.DocumentScanning(p0);
    }
}
