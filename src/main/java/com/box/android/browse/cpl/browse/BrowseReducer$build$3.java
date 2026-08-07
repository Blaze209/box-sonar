package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseReducer$build$3 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, BrowseReducer.Action.ChildActionableItemsListAction> {
    public static final BrowseReducer$build$3 INSTANCE = new BrowseReducer$build$3();

    BrowseReducer$build$3() {
        super(1, BrowseReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BrowseReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BrowseReducer.Action.ChildActionableItemsListAction(p0);
    }
}
