package com.box.android.browse.cpl;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionReducer$build$1 extends FunctionReferenceImpl implements Function2<CollectionReducer.State, CollectionReducer.Action, ReducerResult<CollectionReducer.State, CollectionReducer.Action>> {
    CollectionReducer$build$1(Object obj) {
        super(2, obj, CollectionReducer.class, "reduceCollection", "reduceCollection(Lcom/box/android/browse/cpl/CollectionReducer$State;Lcom/box/android/browse/cpl/CollectionReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CollectionReducer.State, CollectionReducer.Action> invoke(CollectionReducer.State p0, CollectionReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CollectionReducer) this.receiver).reduceCollection(p0, p1);
    }
}
