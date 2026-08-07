package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class ActivityFilterSearchResults2Binding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final RelativeLayout rootView;

    private ActivityFilterSearchResults2Binding(RelativeLayout relativeLayout, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.fragmentContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFilterSearchResults2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFilterSearchResults2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_filter_search_results2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFilterSearchResults2Binding bind(View view) {
        int i = R.id.fragmentContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            return new ActivityFilterSearchResults2Binding((RelativeLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
