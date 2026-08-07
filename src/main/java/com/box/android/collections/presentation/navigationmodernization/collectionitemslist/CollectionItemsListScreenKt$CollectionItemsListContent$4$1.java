package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionItemsListScreenKt$CollectionItemsListContent$4$1 extends FunctionReferenceImpl implements Function1<CollectionItemsListReducer.Action, Unit> {
    CollectionItemsListScreenKt$CollectionItemsListContent$4$1(Object obj) {
        super(1, obj, Store.class, "send", "send(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CollectionItemsListReducer.Action action) {
        invoke2(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CollectionItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((Store) this.receiver).send(p0);
    }
}
