package com.box.android.capture.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureReducer$build$15 extends FunctionReferenceImpl implements Function1<CaptureSettingsReducer.Action, CaptureReducer.Action.CaptureSettings> {
    public static final CaptureReducer$build$15 INSTANCE = new CaptureReducer$build$15();

    CaptureReducer$build$15() {
        super(1, CaptureReducer.Action.CaptureSettings.class, "<init>", "<init>(Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureReducer.Action.CaptureSettings invoke(CaptureSettingsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureReducer.Action.CaptureSettings(p0);
    }
}
