package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class FeatureFlipsToggleFragmentBinding implements ViewBinding {
    public final ComposeView composeView;
    private final ConstraintLayout rootView;
    public final ToolbarBinding settingsToolbar;

    private FeatureFlipsToggleFragmentBinding(ConstraintLayout constraintLayout, ComposeView composeView, ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.composeView = composeView;
        this.settingsToolbar = toolbarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FeatureFlipsToggleFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureFlipsToggleFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.feature_flips_toggle_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FeatureFlipsToggleFragmentBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.compose_view;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.settingsToolbar))) != null) {
            return new FeatureFlipsToggleFragmentBinding((ConstraintLayout) view, composeView, ToolbarBinding.bind(viewFindChildViewById));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
