package com.box.android.boxai.prompt;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiPromptReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiPromptReducer$build$1 extends FunctionReferenceImpl implements Function2<BoxAiPromptReducer.State, BoxAiPromptReducer.Action, ReducerResult<BoxAiPromptReducer.State, BoxAiPromptReducer.Action>> {
    BoxAiPromptReducer$build$1(Object obj) {
        super(2, obj, BoxAiPromptReducer.class, "reducePromptAction", "reducePromptAction(Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> invoke(BoxAiPromptReducer.State p0, BoxAiPromptReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((BoxAiPromptReducer) this.receiver).reducePromptAction(p0, p1);
    }
}
