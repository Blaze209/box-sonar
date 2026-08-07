package com.box.android.cpl.mainphone;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.R;
import com.box.android.adapters.listitems.NavigationBarItem;
import com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment;
import com.box.android.common.extensions.MenuExtensionsKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: MainPhoneBrowseToolbarHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ*\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002JH\u0010\u0017\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00050\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u0019J\f\u0010\u001e\u001a\u00020\u001b*\u00020\u001fH\u0002¨\u0006 "}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneBrowseToolbarHelper;", "", "<init>", "()V", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "showCollectionMultiSelectDialog", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "currentActivity", "observeHierarchyUpdates", "onHierarchyUpdated", "Lkotlin/Function1;", "", "Lcom/box/android/adapters/listitems/NavigationBarItem;", "onHierarchyRefreshing", "", "mapToNavigationBarItem", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneBrowseToolbarHelper {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: MainPhoneBrowseToolbarHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MainPhoneReducer.HierarchyModelType.values().length];
            try {
                iArr[MainPhoneReducer.HierarchyModelType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MainPhoneReducer.HierarchyModelType.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MainPhoneReducer.HierarchyModelType.MY_COLLECTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public MainPhoneBrowseToolbarHelper() {
    }

    public final void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater, Store<MainPhoneReducer.State, MainPhoneReducer.Action> store) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        Intrinsics.checkNotNullParameter(store, "store");
        StoreKt.ifLet$default(store.scope(new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper.onCreateOptionsMenu.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((MainPhoneReducer.State) obj).getMoreOptionsMenu();
            }
        }), new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.onCreateOptionsMenu$lambda$0(menuInflater, menu, (Store) obj);
            }
        }, new Function0() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainPhoneBrowseToolbarHelper.onCreateOptionsMenu$lambda$1(menu);
            }
        }, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0(final MenuInflater menuInflater, final Menu menu, Store moreOptionsMenuStore) {
        Intrinsics.checkNotNullParameter(moreOptionsMenuStore, "moreOptionsMenuStore");
        menuInflater.inflate(R.menu.folder_fragment_menu, menu);
        StoreKt.observe$default(moreOptionsMenuStore, new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$onCreateOptionsMenu$2$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((MainPhoneReducer.MoreOptionsMenuState) obj).getDebugMenuVisible());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.onCreateOptionsMenu$lambda$0$0$0(menuInflater, menu, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        StoreKt.observe$default(moreOptionsMenuStore, new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$onCreateOptionsMenu$2$1$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((MainPhoneReducer.MoreOptionsMenuState) obj).getCollectionsMenuVisible());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.onCreateOptionsMenu$lambda$0$0$1(menu, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        StoreKt.observe$default(moreOptionsMenuStore, new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$onCreateOptionsMenu$2$1$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((MainPhoneReducer.MoreOptionsMenuState) obj).getMultiSelectVisible());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.onCreateOptionsMenu$lambda$0$0$2(menu, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0$0$0(MenuInflater menuInflater, Menu menu, boolean z) {
        if (z) {
            menuInflater.inflate(R.menu.debug, menu);
        } else {
            MenuExtensionsKt.disableMenuItem(menu, R.id.expire_token);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0$0$1(Menu menu, boolean z) {
        MenuExtensionsKt.enableMenuItem(menu, R.id.collections_menu_item, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$0$0$2(Menu menu, boolean z) {
        MenuExtensionsKt.enableMenuItem(menu, R.id.multi_select, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateOptionsMenu$lambda$1(Menu menu) {
        MenuExtensionsKt.disableMenuItem(menu, R.id.more_actions);
        return Unit.INSTANCE;
    }

    public final void onOptionsItemSelected(MenuItem item, Store<MainPhoneReducer.State, MainPhoneReducer.Action> store, AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(activity, "activity");
        int itemId = item.getItemId();
        if (itemId != R.id.collections_menu_item) {
            if (itemId != R.id.expire_token) {
                return;
            }
            store.send(MainPhoneReducer.Action.ExpireToken.INSTANCE);
        } else {
            FolderModel currentlyVisibleFolder = ((MainPhoneReducer.State) StoreKt.stateValue(store)).getCurrentlyVisibleFolder();
            if (currentlyVisibleFolder != null) {
                showCollectionMultiSelectDialog(currentlyVisibleFolder, activity);
            }
        }
    }

    private final void showCollectionMultiSelectDialog(ItemModel itemModel, AppCompatActivity currentActivity) {
        CollectionsMultiSelectDialogFragment.INSTANCE.newInstance(itemModel).show(currentActivity.getSupportFragmentManager(), CollectionsMultiSelectDialogFragment.TAG);
    }

    public final void observeHierarchyUpdates(Store<MainPhoneReducer.State, MainPhoneReducer.Action> store, final Function1<? super List<? extends NavigationBarItem>, Unit> onHierarchyUpdated, final Function1<? super Boolean, Unit> onHierarchyRefreshing) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onHierarchyUpdated, "onHierarchyUpdated");
        Intrinsics.checkNotNullParameter(onHierarchyRefreshing, "onHierarchyRefreshing");
        StoreKt.observe$default(store, new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper.observeHierarchyUpdates.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((MainPhoneReducer.State) obj).getHierarchy();
            }
        }, null, new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.observeHierarchyUpdates$lambda$0(onHierarchyUpdated, this, (List) obj);
            }
        }, 2, null);
        StoreKt.observe$default(store, new PropertyReference1Impl() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper.observeHierarchyUpdates.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((MainPhoneReducer.State) obj).getHierarchyRefreshing());
            }
        }, null, new Function1() { // from class: com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneBrowseToolbarHelper.observeHierarchyUpdates$lambda$1(onHierarchyRefreshing, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeHierarchyUpdates$lambda$0(Function1 function1, MainPhoneBrowseToolbarHelper mainPhoneBrowseToolbarHelper, List list) {
        if (list == null) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mainPhoneBrowseToolbarHelper.mapToNavigationBarItem((MainPhoneReducer.HierarchyModel) it.next()));
        }
        function1.invoke(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeHierarchyUpdates$lambda$1(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    private final NavigationBarItem mapToNavigationBarItem(MainPhoneReducer.HierarchyModel hierarchyModel) {
        int i = WhenMappings.$EnumSwitchMapping$0[hierarchyModel.getType().ordinal()];
        if (i == 1) {
            return new NavigationBarItem(2, hierarchyModel.getId(), hierarchyModel.getName());
        }
        if (i == 2) {
            return new NavigationBarItem(5, hierarchyModel.getId(), hierarchyModel.getName());
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new NavigationBarItem(6, "1", CommonBoxUtil.LS(R.string.my_collections));
    }
}
