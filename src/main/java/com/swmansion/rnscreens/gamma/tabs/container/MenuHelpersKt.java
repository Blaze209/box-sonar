package com.swmansion.rnscreens.gamma.tabs.container;

import android.view.Menu;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"menuItemIdForFragmentAtIndex", "", "fragmentIndex", "fragmentIndexForMenuItemId", "menuItemId", "getOrCreateMenuItemForFragmentAt", "Landroid/view/MenuItem;", "Landroid/view/Menu;", FirebaseAnalytics.Param.INDEX, "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MenuHelpersKt {
    public static final int menuItemIdForFragmentAtIndex(int i) {
        return i + 1;
    }

    public static final int fragmentIndexForMenuItemId(int i) {
        if (i >= 1) {
            return i - 1;
        }
        throw new IllegalStateException("[RNScreens] MenuItem id must not be less than 1".toString());
    }

    public static final MenuItem getOrCreateMenuItemForFragmentAt(Menu menu, int i, TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        MenuItem menuItemFindItem = menu.findItem(menuItemIdForFragmentAtIndex(i));
        if (menuItemFindItem != null) {
            return menuItemFindItem;
        }
        MenuItem menuItemAdd = menu.add(0, menuItemIdForFragmentAtIndex(i), 0, tabsScreen.getTabTitle());
        Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
        return menuItemAdd;
    }
}
