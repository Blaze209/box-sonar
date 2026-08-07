package com.box.android.browse.cpl.itemsList;

import com.box.android.boxai.BoxAiCenterReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$18 extends FunctionReferenceImpl implements Function1<BoxAiCenterReducer.Action, ActionableItemsListReducer.Action.BoxAiCenterAction> {
    public static final ActionableItemsListReducer$build$18 INSTANCE = new ActionableItemsListReducer$build$18();

    ActionableItemsListReducer$build$18() {
        super(1, ActionableItemsListReducer.Action.BoxAiCenterAction.class, "<init>", "<init>(Lcom/box/android/boxai/BoxAiCenterReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.BoxAiCenterAction invoke(BoxAiCenterReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.BoxAiCenterAction(p0);
    }
}
