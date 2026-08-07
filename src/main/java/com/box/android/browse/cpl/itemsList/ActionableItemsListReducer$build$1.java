package com.box.android.browse.cpl.itemsList;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ActionableItemsListReducer$build$1 extends FunctionReferenceImpl implements Function2<ActionableItemsListReducer.State, ActionableItemsListReducer.Action, ReducerResult<ActionableItemsListReducer.State, ActionableItemsListReducer.Action>> {
    ActionableItemsListReducer$build$1(Object obj) {
        super(2, obj, ActionableItemsListReducer.class, "reduceActionableItemsList", "reduceActionableItemsList(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> invoke(ActionableItemsListReducer.State p0, ActionableItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ActionableItemsListReducer) this.receiver).reduceActionableItemsList(p0, p1);
    }
}
