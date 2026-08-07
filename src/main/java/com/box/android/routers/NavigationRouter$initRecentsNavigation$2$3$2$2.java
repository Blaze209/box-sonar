package com.box.android.routers;

import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.recents.RecentsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NavigationRouter$initRecentsNavigation$2$3$2$2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, RecentsReducer.Action.ChildActionableItemsListAction> {
    public static final NavigationRouter$initRecentsNavigation$2$3$2$2 INSTANCE = new NavigationRouter$initRecentsNavigation$2$3$2$2();

    NavigationRouter$initRecentsNavigation$2$3$2$2() {
        super(1, RecentsReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RecentsReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new RecentsReducer.Action.ChildActionableItemsListAction(p0);
    }
}
