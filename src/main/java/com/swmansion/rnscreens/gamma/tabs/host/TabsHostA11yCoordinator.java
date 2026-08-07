package com.swmansion.rnscreens.gamma.tabs.host;

import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostA11yCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostA11yCoordinator;", "", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "tabsScreenFragments", "", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "<init>", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;Ljava/util/List;)V", "setA11yPropertiesToTabItem", "", "menuItem", "Landroid/view/MenuItem;", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "setA11yPropertiesToAllTabItems", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHostA11yCoordinator {
    private final BottomNavigationView bottomNavigationView;
    private final List<TabsScreenFragment> tabsScreenFragments;

    public TabsHostA11yCoordinator(BottomNavigationView bottomNavigationView, List<TabsScreenFragment> tabsScreenFragments) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        Intrinsics.checkNotNullParameter(tabsScreenFragments, "tabsScreenFragments");
        this.bottomNavigationView = bottomNavigationView;
        this.tabsScreenFragments = tabsScreenFragments;
    }

    public final void setA11yPropertiesToTabItem(MenuItem menuItem, TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.bottomNavigationView.findViewById(menuItem.getItemId());
        menuItem.setContentDescription(tabsScreen.getTabBarItemAccessibilityLabel());
        navigationBarItemView.setTag(tabsScreen.getTabBarItemTestID());
    }

    public final void setA11yPropertiesToAllTabItems() {
        int i = 0;
        for (Object obj : this.tabsScreenFragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Menu menu = this.bottomNavigationView.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            setA11yPropertiesToTabItem(menu.getItem(i), ((TabsScreenFragment) obj).getTabsScreen());
            i = i2;
        }
    }
}
