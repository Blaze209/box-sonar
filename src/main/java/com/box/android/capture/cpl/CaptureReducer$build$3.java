package com.box.android.capture.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureReducer$build$3 extends FunctionReferenceImpl implements Function1<ImageCaptureReducer.Action, CaptureReducer.Action.Camera> {
    public static final CaptureReducer$build$3 INSTANCE = new CaptureReducer$build$3();

    CaptureReducer$build$3() {
        super(1, CaptureReducer.Action.Camera.class, "<init>", "<init>(Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureReducer.Action.Camera invoke(ImageCaptureReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureReducer.Action.Camera(p0);
    }
}
