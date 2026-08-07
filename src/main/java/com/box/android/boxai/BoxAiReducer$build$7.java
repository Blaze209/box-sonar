package com.box.android.boxai;

import com.box.android.boxai.agents.BoxAiAgentsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiReducer$build$7 extends FunctionReferenceImpl implements Function1<BoxAiAgentsReducer.Action, BoxAiReducer.Action.AgentsAction> {
    public static final BoxAiReducer$build$7 INSTANCE = new BoxAiReducer$build$7();

    BoxAiReducer$build$7() {
        super(1, BoxAiReducer.Action.AgentsAction.class, "<init>", "<init>(Lcom/box/android/boxai/agents/BoxAiAgentsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiReducer.Action.AgentsAction invoke(BoxAiAgentsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiReducer.Action.AgentsAction(p0);
    }
}
