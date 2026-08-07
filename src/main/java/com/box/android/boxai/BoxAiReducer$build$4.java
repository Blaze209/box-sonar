package com.box.android.boxai;

import com.box.android.boxai.qa.BoxAiQaReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiReducer$build$4 extends FunctionReferenceImpl implements Function1<BoxAiQaReducer.Action, BoxAiReducer.Action.QaAiAction> {
    public static final BoxAiReducer$build$4 INSTANCE = new BoxAiReducer$build$4();

    BoxAiReducer$build$4() {
        super(1, BoxAiReducer.Action.QaAiAction.class, "<init>", "<init>(Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiReducer.Action.QaAiAction invoke(BoxAiQaReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiReducer.Action.QaAiAction(p0);
    }
}
