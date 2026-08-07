package com.google.android.material.navigation;

import androidx.appcompat.view.menu.MenuView;

/* JADX INFO: loaded from: classes12.dex */
public interface NavigationBarMenuItemView extends MenuView.ItemView {
    boolean isExpanded();

    boolean isOnlyVisibleWhenExpanded();

    void setExpanded(boolean z);

    void setOnlyShowWhenExpanded(boolean z);
}
