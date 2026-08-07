package com.box.android.browse.cpl.recents;

import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class RecentsReducer$build$3 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, RecentsReducer.Action.ChildActionableItemsListAction> {
    public static final RecentsReducer$build$3 INSTANCE = new RecentsReducer$build$3();

    RecentsReducer$build$3() {
        super(1, RecentsReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RecentsReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new RecentsReducer.Action.ChildActionableItemsListAction(p0);
    }
}
