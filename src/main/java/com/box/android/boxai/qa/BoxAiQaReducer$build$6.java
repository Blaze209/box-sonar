package com.box.android.boxai.qa;

import com.box.android.base.presentation.components.CopyTextReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiQaReducer$build$6 extends FunctionReferenceImpl implements Function1<CopyTextReducer.Action, BoxAiQaReducer.Action.CopyTextAction> {
    public static final BoxAiQaReducer$build$6 INSTANCE = new BoxAiQaReducer$build$6();

    BoxAiQaReducer$build$6() {
        super(1, BoxAiQaReducer.Action.CopyTextAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/CopyTextReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiQaReducer.Action.CopyTextAction invoke(CopyTextReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiQaReducer.Action.CopyTextAction(p0);
    }
}
