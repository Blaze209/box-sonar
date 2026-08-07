package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;
import com.box.android.browse.views.AppSearchView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes10.dex */
public final class LayoutMainNavigationBinding implements ViewBinding {
    public final FloatingActionButton addFab;
    public final RelativeLayout addFabContainer;
    public final BottomNavigationView bottomNavigation;
    public final RelativeLayout bottomOptionalsContainer;
    public final CoordinatorLayout coordinatorLayout;
    public final RelativeLayout fabMenuContainer;
    public final FrameLayout filesfragmentembedded1;
    public final AppBarLayout htabAppbar;
    public final Toolbar mainToolbar;
    public final ListView recentSearchesListView;
    private final CoordinatorLayout rootView;
    public final FrameLayout searchLayout;
    public final AppSearchView searchView;
    public final CoordinatorLayout snackbarContainer;

    private LayoutMainNavigationBinding(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, RelativeLayout relativeLayout, BottomNavigationView bottomNavigationView, RelativeLayout relativeLayout2, CoordinatorLayout coordinatorLayout2, RelativeLayout relativeLayout3, FrameLayout frameLayout, AppBarLayout appBarLayout, Toolbar toolbar, ListView listView, FrameLayout frameLayout2, AppSearchView appSearchView, CoordinatorLayout coordinatorLayout3) {
        this.rootView = coordinatorLayout;
        this.addFab = floatingActionButton;
        this.addFabContainer = relativeLayout;
        this.bottomNavigation = bottomNavigationView;
        this.bottomOptionalsContainer = relativeLayout2;
        this.coordinatorLayout = coordinatorLayout2;
        this.fabMenuContainer = relativeLayout3;
        this.filesfragmentembedded1 = frameLayout;
        this.htabAppbar = appBarLayout;
        this.mainToolbar = toolbar;
        this.recentSearchesListView = listView;
        this.searchLayout = frameLayout2;
        this.searchView = appSearchView;
        this.snackbarContainer = coordinatorLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMainNavigationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMainNavigationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_main_navigation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMainNavigationBinding bind(View view) {
        int i = R.id.add_fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
        if (floatingActionButton != null) {
            i = R.id.add_fab_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.bottom_navigation;
                BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, i);
                if (bottomNavigationView != null) {
                    i = R.id.bottom_optionals_container;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                        i = R.id.fab_menu_container;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.filesfragmentembedded1;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.htab_appbar;
                                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
                                if (appBarLayout != null) {
                                    i = R.id.mainToolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                    if (toolbar != null) {
                                        i = R.id.recentSearchesListView;
                                        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                        if (listView != null) {
                                            i = R.id.searchLayout;
                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout2 != null) {
                                                i = R.id.search_view;
                                                AppSearchView appSearchView = (AppSearchView) ViewBindings.findChildViewById(view, i);
                                                if (appSearchView != null) {
                                                    i = R.id.snackbar_container;
                                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) ViewBindings.findChildViewById(view, i);
                                                    if (coordinatorLayout2 != null) {
                                                        return new LayoutMainNavigationBinding(coordinatorLayout, floatingActionButton, relativeLayout, bottomNavigationView, relativeLayout2, coordinatorLayout, relativeLayout3, frameLayout, appBarLayout, toolbar, listView, frameLayout2, appSearchView, coordinatorLayout2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
