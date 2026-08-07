package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;

/* JADX INFO: loaded from: classes11.dex */
public final class ToolbarWithNavBinding implements ViewBinding {
    public final TextView breadcrumbPlaceholderView;
    public final ToolbarWithOverlayWarning mainToolbar;
    public final ProgressBar navigationProgressBar;
    private final ToolbarWithOverlayWarning rootView;
    public final ConstraintLayout spinnerLayout;
    public final Spinner spinnerNav;

    private ToolbarWithNavBinding(ToolbarWithOverlayWarning toolbarWithOverlayWarning, TextView textView, ToolbarWithOverlayWarning toolbarWithOverlayWarning2, ProgressBar progressBar, ConstraintLayout constraintLayout, Spinner spinner) {
        this.rootView = toolbarWithOverlayWarning;
        this.breadcrumbPlaceholderView = textView;
        this.mainToolbar = toolbarWithOverlayWarning2;
        this.navigationProgressBar = progressBar;
        this.spinnerLayout = constraintLayout;
        this.spinnerNav = spinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ToolbarWithOverlayWarning getRoot() {
        return this.rootView;
    }

    public static ToolbarWithNavBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolbarWithNavBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.toolbar_with_nav, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolbarWithNavBinding bind(View view) {
        int i = R.id.breadcrumb_placeholder_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.breadcrumb_placeholder_view);
        if (textView != null) {
            ToolbarWithOverlayWarning toolbarWithOverlayWarning = (ToolbarWithOverlayWarning) view;
            i = R.id.navigation_progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.navigation_progress_bar);
            if (progressBar != null) {
                i = R.id.spinner_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.spinner_layout);
                if (constraintLayout != null) {
                    i = R.id.spinner_nav;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.spinner_nav);
                    if (spinner != null) {
                        return new ToolbarWithNavBinding(toolbarWithOverlayWarning, textView, toolbarWithOverlayWarning, progressBar, constraintLayout, spinner);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
