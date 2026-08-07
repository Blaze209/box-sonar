package com.box.android.boxai;

import com.box.android.boxai.qa.BoxAiQaReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiReducer$build$3 extends FunctionReferenceImpl implements Function1<BoxAiQaReducer.State, BoxAiReducer.ScreenState.QaSession> {
    public static final BoxAiReducer$build$3 INSTANCE = new BoxAiReducer$build$3();

    BoxAiReducer$build$3() {
        super(1, BoxAiReducer.ScreenState.QaSession.class, "<init>", "<init>(Lcom/box/android/boxai/qa/BoxAiQaReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiReducer.ScreenState.QaSession invoke(BoxAiQaReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiReducer.ScreenState.QaSession(p0);
    }
}
