package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001¨\u0006\u0006"}, d2 = {"scopeActionableItemsList", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseReducerKt {

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.BrowseReducerKt$scopeActionableItemsList$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, BrowseReducer.Action.ChildActionableItemsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, BrowseReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final BrowseReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new BrowseReducer.Action.ChildActionableItemsListAction(p0);
        }
    }

    public static final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> scopeActionableItemsList(Store<BrowseReducer.State, BrowseReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseReducerKt.scopeActionableItemsList.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BrowseReducer.State) obj).getActionableItemsListState();
            }
        }, AnonymousClass2.INSTANCE);
    }
}
