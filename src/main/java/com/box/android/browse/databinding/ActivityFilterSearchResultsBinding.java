package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class ActivityFilterSearchResultsBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    public final Toolbar mainToolbar;
    private final RelativeLayout rootView;

    private ActivityFilterSearchResultsBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, Toolbar toolbar) {
        this.rootView = relativeLayout;
        this.fragmentContainer = frameLayout;
        this.mainToolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFilterSearchResultsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFilterSearchResultsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_filter_search_results, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFilterSearchResultsBinding bind(View view) {
        int i = R.id.fragmentContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.mainToolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
            if (toolbar != null) {
                return new ActivityFilterSearchResultsBinding((RelativeLayout) view, frameLayout, toolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
