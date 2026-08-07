package com.box.android.cpl.navigation;

import android.view.Menu;
import android.view.MenuInflater;
import com.box.android.R;
import com.box.android.common.extensions.MenuExtensionsKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: NavigationBrowseToolbarHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationBrowseToolbarHelper;", "", "<init>", "()V", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/navigation/NavigationReducer$State;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBrowseToolbarHelper {
    public static final int $stable = 0;

    @Inject
    public NavigationBrowseToolbarHelper() {
    }

    public final void onCreateOptionsMenu(final Menu menu, MenuInflater menuInflater, Store<NavigationReducer.State, NavigationReducer.Action> store) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        Intrinsics.checkNotNullParameter(store, "store");
        if (menu.findItem(R.id.recentItemsFilter) == null) {
            menuInflater.inflate(R.menu.recent_items_menu, menu);
        }
        Store<LocalState, NavigationReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationBrowseToolbarHelper.onCreateOptionsMenu.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getToolbarState();
            }
        });
        StoreKt.observe$default(storeScope, new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationBrowseToolbarHelper$onCreateOptionsMenu$2$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((NavigationReducer.ToolbarState) obj).getFilterIcon());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.navigation.NavigationBrowseToolbarHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBrowseToolbarHelper.onCreateOptionsMenu$lambda$0$0(menu, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        StoreKt.observe$default(storeScope, new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationBrowseToolbarHelper$onCreateOptionsMenu$2$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((NavigationReducer.ToolbarState) obj).getSortIcon());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.navigation.NavigationBrowseToolbarHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBrowseToolbarHelper.onCreateOptionsMenu$lambda$0$1(menu, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0$0(Menu menu, boolean z) {
        MenuExtensionsKt.enableMenuItem(menu, R.id.recentItemsFilter, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0$1(Menu menu, boolean z) {
        MenuExtensionsKt.enableMenuItem(menu, R.id.folder_sort, z);
        return Unit.INSTANCE;
    }
}
