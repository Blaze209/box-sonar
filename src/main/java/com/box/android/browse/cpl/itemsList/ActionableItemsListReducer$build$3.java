package com.box.android.browse.cpl.itemsList;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$3 extends FunctionReferenceImpl implements Function1<ItemsListReducer.Action, ActionableItemsListReducer.Action.ItemsListAction> {
    public static final ActionableItemsListReducer$build$3 INSTANCE = new ActionableItemsListReducer$build$3();

    ActionableItemsListReducer$build$3() {
        super(1, ActionableItemsListReducer.Action.ItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ActionableItemsListReducer.Action.ItemsListAction invoke(ItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ActionableItemsListReducer.Action.ItemsListAction(p0);
    }
}
