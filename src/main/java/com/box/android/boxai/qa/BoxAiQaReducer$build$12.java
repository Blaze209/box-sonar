package com.box.android.boxai.qa;

import com.box.android.boxai.clearchat.BoxAiClearChatReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiQaReducer$build$12 extends FunctionReferenceImpl implements Function1<BoxAiClearChatReducer.Action, BoxAiQaReducer.Action.ClearChatAction> {
    public static final BoxAiQaReducer$build$12 INSTANCE = new BoxAiQaReducer$build$12();

    BoxAiQaReducer$build$12() {
        super(1, BoxAiQaReducer.Action.ClearChatAction.class, "<init>", "<init>(Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiQaReducer.Action.ClearChatAction invoke(BoxAiClearChatReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiQaReducer.Action.ClearChatAction(p0);
    }
}
