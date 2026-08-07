package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.R;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;

/* JADX INFO: loaded from: classes9.dex */
public final class ToolbarBinding implements ViewBinding {
    private final ToolbarWithOverlayWarning rootView;
    public final ToolbarWithOverlayWarning toolbar;

    private ToolbarBinding(ToolbarWithOverlayWarning toolbarWithOverlayWarning, ToolbarWithOverlayWarning toolbarWithOverlayWarning2) {
        this.rootView = toolbarWithOverlayWarning;
        this.toolbar = toolbarWithOverlayWarning2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ToolbarWithOverlayWarning getRoot() {
        return this.rootView;
    }

    public static ToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolbarBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ToolbarWithOverlayWarning toolbarWithOverlayWarning = (ToolbarWithOverlayWarning) view;
        return new ToolbarBinding(toolbarWithOverlayWarning, toolbarWithOverlayWarning);
    }
}
