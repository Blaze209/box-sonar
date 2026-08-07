package com.box.android.browse.cpl.offlined;

import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class OfflinedReducer$build$3 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, OfflinedReducer.Action.ChildActionableItemsListAction> {
    public static final OfflinedReducer$build$3 INSTANCE = new OfflinedReducer$build$3();

    OfflinedReducer$build$3() {
        super(1, OfflinedReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final OfflinedReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new OfflinedReducer.Action.ChildActionableItemsListAction(p0);
    }
}
