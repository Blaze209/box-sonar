package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutContainerBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootViewGroup;

    private LayoutContainerBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.fragmentContainer = fragmentContainerView;
        this.rootViewGroup = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_container, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutContainerBinding bind(View view) {
        int i = R.id.fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new LayoutContainerBinding(constraintLayout, fragmentContainerView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
