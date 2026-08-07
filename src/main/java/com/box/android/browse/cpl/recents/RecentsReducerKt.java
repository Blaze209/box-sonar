package com.box.android.browse.cpl.recents;

import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.cpl.Store;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: RecentsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"scopeActionableItemsList", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "updateRecentsFilter", ViewProps.FILTER, "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RecentsReducerKt {

    /* JADX INFO: renamed from: com.box.android.browse.cpl.recents.RecentsReducerKt$scopeActionableItemsList$2, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, RecentsReducer.Action.ChildActionableItemsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, RecentsReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final RecentsReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new RecentsReducer.Action.ChildActionableItemsListAction(p0);
        }
    }

    public static final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> scopeActionableItemsList(Store<RecentsReducer.State, RecentsReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsReducerKt.scopeActionableItemsList.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((RecentsReducer.State) obj).getActionableItemsListState();
            }
        }, AnonymousClass2.INSTANCE);
    }

    public static final RecentsReducer.Action updateRecentsFilter(ItemsFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        return new RecentsReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(new ItemsListReducer.Action.FilesConfig(new FilesDisplayConfigReducer.Action.FilterSelected(filter))));
    }
}
