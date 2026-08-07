package com.box.android.browse.cpl.itemsList;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemsListReducer$build$1 extends FunctionReferenceImpl implements Function2<ItemsListReducer.State, ItemsListReducer.Action, ReducerResult<ItemsListReducer.State, ItemsListReducer.Action>> {
    ItemsListReducer$build$1(Object obj) {
        super(2, obj, ItemsListReducer.class, "reduceItemsList", "reduceItemsList(Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ItemsListReducer.State, ItemsListReducer.Action> invoke(ItemsListReducer.State p0, ItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ItemsListReducer) this.receiver).reduceItemsList(p0, p1);
    }
}
