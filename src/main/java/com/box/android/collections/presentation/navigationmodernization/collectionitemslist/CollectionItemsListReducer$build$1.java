package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionItemsListReducer$build$1 extends FunctionReferenceImpl implements Function2<CollectionItemsListReducer.State, CollectionItemsListReducer.Action, ReducerResult<CollectionItemsListReducer.State, CollectionItemsListReducer.Action>> {
    CollectionItemsListReducer$build$1(Object obj) {
        super(2, obj, CollectionItemsListReducer.class, "reduceActions", "reduceActions(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> invoke(CollectionItemsListReducer.State p0, CollectionItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CollectionItemsListReducer) this.receiver).reduceActions(p0, p1);
    }
}
