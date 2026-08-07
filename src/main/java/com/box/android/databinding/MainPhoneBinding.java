package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes11.dex */
public final class MainPhoneBinding implements ViewBinding {
    public final RelativeLayout bottomOptionalsContainer;
    public final CoordinatorLayout coordinatorLayout;
    public final RelativeLayout fabMenuContainer;
    public final FrameLayout filesfragmentembedded1;
    public final AppBarLayout htabAppbar;
    public final FrameLayout mainToolbarContainer;
    public final ListView recentSearchesListView;
    private final CoordinatorLayout rootView;
    public final CoordinatorLayout snackbarContainer;

    private MainPhoneBinding(CoordinatorLayout coordinatorLayout, RelativeLayout relativeLayout, CoordinatorLayout coordinatorLayout2, RelativeLayout relativeLayout2, FrameLayout frameLayout, AppBarLayout appBarLayout, FrameLayout frameLayout2, ListView listView, CoordinatorLayout coordinatorLayout3) {
        this.rootView = coordinatorLayout;
        this.bottomOptionalsContainer = relativeLayout;
        this.coordinatorLayout = coordinatorLayout2;
        this.fabMenuContainer = relativeLayout2;
        this.filesfragmentembedded1 = frameLayout;
        this.htabAppbar = appBarLayout;
        this.mainToolbarContainer = frameLayout2;
        this.recentSearchesListView = listView;
        this.snackbarContainer = coordinatorLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static MainPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MainPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.main_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainPhoneBinding bind(View view) {
        int i = R.id.bottom_optionals_container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.bottom_optionals_container);
        if (relativeLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
            i = R.id.fab_menu_container;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.fab_menu_container);
            if (relativeLayout2 != null) {
                i = R.id.filesfragmentembedded1;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.filesfragmentembedded1);
                if (frameLayout != null) {
                    i = R.id.htab_appbar;
                    AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.htab_appbar);
                    if (appBarLayout != null) {
                        i = R.id.main_toolbar_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.main_toolbar_container);
                        if (frameLayout2 != null) {
                            i = R.id.recentSearchesListView;
                            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.recentSearchesListView);
                            if (listView != null) {
                                i = R.id.snackbar_container;
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.snackbar_container);
                                if (coordinatorLayout2 != null) {
                                    return new MainPhoneBinding(coordinatorLayout, relativeLayout, coordinatorLayout, relativeLayout2, frameLayout, appBarLayout, frameLayout2, listView, coordinatorLayout2);
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
