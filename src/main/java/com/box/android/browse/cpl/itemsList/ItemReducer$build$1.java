package com.box.android.browse.cpl.itemsList;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemReducer$build$1 extends FunctionReferenceImpl implements Function2<ItemReducer.State, ItemReducer.Action, ReducerResult<ItemReducer.State, ItemReducer.Action>> {
    ItemReducer$build$1(Object obj) {
        super(2, obj, ItemReducer.class, "reduceOfflineState", "reduceOfflineState(Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ItemReducer.State, ItemReducer.Action> invoke(ItemReducer.State p0, ItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ItemReducer) this.receiver).reduceOfflineState(p0, p1);
    }
}
