package com.box.android.browse.cpl.itemsList;

import com.box.android.base.cpl.ItemThumbnailReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemReducer$build$3 extends FunctionReferenceImpl implements Function1<ItemThumbnailReducer.Action, ItemReducer.Action.ThumbnailAction> {
    public static final ItemReducer$build$3 INSTANCE = new ItemReducer$build$3();

    ItemReducer$build$3() {
        super(1, ItemReducer.Action.ThumbnailAction.class, "<init>", "<init>(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemReducer.Action.ThumbnailAction invoke(ItemThumbnailReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemReducer.Action.ThumbnailAction(p0);
    }
}
