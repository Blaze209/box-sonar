package com.pspdfkit.ui.navigation;

/* JADX INFO: loaded from: classes3.dex */
public interface PageNavigator {
    void beginNavigation();

    void endNavigation();

    NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> getNavigationHistory();

    int getPageCount();

    int getPageIndex();

    void setPageIndex(int i);

    void setPageIndex(int i, boolean z);
}
