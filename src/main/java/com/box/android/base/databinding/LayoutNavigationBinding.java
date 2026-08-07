package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;
import com.box.android.base.presentation.views.TogglableViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutNavigationBinding implements ViewBinding {
    public final TabLayout navigationTabLayout;
    public final TogglableViewPager navigationTabViewPager;
    private final TogglableViewPager rootView;

    private LayoutNavigationBinding(TogglableViewPager togglableViewPager, TabLayout tabLayout, TogglableViewPager togglableViewPager2) {
        this.rootView = togglableViewPager;
        this.navigationTabLayout = tabLayout;
        this.navigationTabViewPager = togglableViewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TogglableViewPager getRoot() {
        return this.rootView;
    }

    public static LayoutNavigationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutNavigationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_navigation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutNavigationBinding bind(View view) {
        int i = R.id.navigation_tab_layout;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
        if (tabLayout != null) {
            TogglableViewPager togglableViewPager = (TogglableViewPager) view;
            return new LayoutNavigationBinding(togglableViewPager, tabLayout, togglableViewPager);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
