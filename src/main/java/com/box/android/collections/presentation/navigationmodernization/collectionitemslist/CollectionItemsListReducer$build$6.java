package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionItemsListReducer$build$6 extends FunctionReferenceImpl implements Function2<ItemId.Remote, ItemReducer.Action, CollectionItemsListReducer.Action.ItemAction> {
    public static final CollectionItemsListReducer$build$6 INSTANCE = new CollectionItemsListReducer$build$6();

    CollectionItemsListReducer$build$6() {
        super(2, CollectionItemsListReducer.Action.ItemAction.class, "<init>", "<init>(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final CollectionItemsListReducer.Action.ItemAction invoke(ItemId.Remote p0, ItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new CollectionItemsListReducer.Action.ItemAction(p0, p1);
    }
}
