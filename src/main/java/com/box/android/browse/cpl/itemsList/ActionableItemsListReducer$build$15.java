package com.box.android.browse.cpl.itemsList;

import com.box.android.boxai.BoxAiReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$15 extends FunctionReferenceImpl implements Function1<BoxAiReducer.Action, ActionableItemsListReducer.Action.BoxAiAction> {
    public static final ActionableItemsListReducer$build$15 INSTANCE = new ActionableItemsListReducer$build$15();

    ActionableItemsListReducer$build$15() {
        super(1, ActionableItemsListReducer.Action.BoxAiAction.class, "<init>", "<init>(Lcom/box/android/boxai/BoxAiReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.BoxAiAction invoke(BoxAiReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.BoxAiAction(p0);
    }
}
