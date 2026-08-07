package com.box.android.boxai.qa;

import com.box.android.boxai.prompt.BoxAiPromptReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiQaScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiQaScreenKt$BoxAiQaScreen$2$4$1 extends FunctionReferenceImpl implements Function1<BoxAiPromptReducer.Action, BoxAiQaReducer.Action.PromptInputAction> {
    public static final BoxAiQaScreenKt$BoxAiQaScreen$2$4$1 INSTANCE = new BoxAiQaScreenKt$BoxAiQaScreen$2$4$1();

    BoxAiQaScreenKt$BoxAiQaScreen$2$4$1() {
        super(1, BoxAiQaReducer.Action.PromptInputAction.class, "<init>", "<init>(Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiQaReducer.Action.PromptInputAction invoke(BoxAiPromptReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiQaReducer.Action.PromptInputAction(p0);
    }
}
