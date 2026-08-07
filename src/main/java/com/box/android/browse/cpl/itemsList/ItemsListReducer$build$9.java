package com.box.android.browse.cpl.itemsList;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemsListReducer$build$9 extends FunctionReferenceImpl implements Function2<ItemId.Remote, ItemReducer.Action, ItemsListReducer.Action.ItemAction> {
    public static final ItemsListReducer$build$9 INSTANCE = new ItemsListReducer$build$9();

    ItemsListReducer$build$9() {
        super(2, ItemsListReducer.Action.ItemAction.class, "<init>", "<init>(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ItemsListReducer.Action.ItemAction invoke(ItemId.Remote p0, ItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new ItemsListReducer.Action.ItemAction(p0, p1);
    }
}
