package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionsListReducer$build$1 extends FunctionReferenceImpl implements Function2<CollectionsListReducer.State, CollectionsListReducer.Action, ReducerResult<CollectionsListReducer.State, CollectionsListReducer.Action>> {
    CollectionsListReducer$build$1(Object obj) {
        super(2, obj, CollectionsListReducer.class, "reduceCollectionsList", "reduceCollectionsList(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CollectionsListReducer.State, CollectionsListReducer.Action> invoke(CollectionsListReducer.State p0, CollectionsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CollectionsListReducer) this.receiver).reduceCollectionsList(p0, p1);
    }
}
