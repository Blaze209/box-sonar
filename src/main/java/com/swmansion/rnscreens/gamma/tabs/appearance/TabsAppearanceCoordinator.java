package com.swmansion.rnscreens.gamma.tabs.appearance;

import android.content.Context;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swmansion.rnscreens.gamma.tabs.container.MenuHelpersKt;
import com.swmansion.rnscreens.gamma.tabs.container.TabsContainer;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsAppearanceCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J/\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearanceCoordinator;", "", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "tabsScreenFragments", "", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "<init>", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;Ljava/util/List;)V", "appearanceApplicator", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearanceApplicator;", "updateTabAppearance", "", "context", "Landroid/content/Context;", "tabsContainer", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "updateMenuItems", "tabsAppearance", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;", "updateMenuItemAppearance", "menuItem", "Landroid/view/MenuItem;", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "appearance", "updateMenuItemAppearance$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsAppearanceCoordinator {
    private final TabsAppearanceApplicator appearanceApplicator;
    private final BottomNavigationView bottomNavigationView;
    private final List<TabsScreenFragment> tabsScreenFragments;

    public TabsAppearanceCoordinator(BottomNavigationView bottomNavigationView, List<TabsScreenFragment> tabsScreenFragments) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        Intrinsics.checkNotNullParameter(tabsScreenFragments, "tabsScreenFragments");
        this.bottomNavigationView = bottomNavigationView;
        this.tabsScreenFragments = tabsScreenFragments;
        this.appearanceApplicator = new TabsAppearanceApplicator(bottomNavigationView);
    }

    public final void updateTabAppearance(Context context, TabsContainer tabsContainer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tabsContainer, "tabsContainer");
        TabsAppearance appearance$react_native_screens_release = tabsContainer.getSelectedTab$react_native_screens_release().getTabsScreen().getAppearance$react_native_screens_release();
        this.appearanceApplicator.updateSharedAppearance(context, appearance$react_native_screens_release, tabsContainer.getTabBarHidden$react_native_screens_release());
        updateMenuItems(context, appearance$react_native_screens_release);
        this.appearanceApplicator.updateFontStyles(context, appearance$react_native_screens_release);
    }

    private final void updateMenuItems(Context context, TabsAppearance tabsAppearance) {
        int i = 0;
        for (Object obj : this.tabsScreenFragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TabsScreenFragment tabsScreenFragment = (TabsScreenFragment) obj;
            int iMenuItemIdForFragmentAtIndex = MenuHelpersKt.menuItemIdForFragmentAtIndex(i);
            MenuItem menuItemFindItem = this.bottomNavigationView.getMenu().findItem(iMenuItemIdForFragmentAtIndex);
            if (menuItemFindItem == null) {
                throw new IllegalStateException(("[RNScreens] Missing MenuItem for id: " + iMenuItemIdForFragmentAtIndex).toString());
            }
            if (menuItemFindItem.getItemId() != iMenuItemIdForFragmentAtIndex) {
                throw new IllegalStateException("[RNScreens] Illegal state: menu items are shuffled".toString());
            }
            updateMenuItemAppearance$react_native_screens_release(context, menuItemFindItem, tabsScreenFragment.getTabsScreen(), tabsAppearance);
            i = i2;
        }
    }

    public final void updateMenuItemAppearance$react_native_screens_release(Context context, MenuItem menuItem, TabsScreen tabsScreen, TabsAppearance appearance) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        this.appearanceApplicator.updateMenuItemAppearance(menuItem, tabsScreen);
        this.appearanceApplicator.updateBadgeAppearance$react_native_screens_release(context, menuItem, tabsScreen, appearance);
    }
}
