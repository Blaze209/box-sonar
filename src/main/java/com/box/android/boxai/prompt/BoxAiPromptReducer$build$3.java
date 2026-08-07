package com.box.android.boxai.prompt;

import com.box.android.base.presentation.components.inputbar.BasicInputBarReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiPromptReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiPromptReducer$build$3 extends FunctionReferenceImpl implements Function1<BasicInputBarReducer.Action, BoxAiPromptReducer.Action.TextInputAction> {
    public static final BoxAiPromptReducer$build$3 INSTANCE = new BoxAiPromptReducer$build$3();

    BoxAiPromptReducer$build$3() {
        super(1, BoxAiPromptReducer.Action.TextInputAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiPromptReducer.Action.TextInputAction invoke(BasicInputBarReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiPromptReducer.Action.TextInputAction(p0);
    }
}
