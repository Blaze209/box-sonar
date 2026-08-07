package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutMenuTransfersLegacyBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ImageView transferIcon;
    public final FrameLayout transferMenuIndicatorContainer;
    public final ProgressBar transferMenuProgress;
    public final FrameLayout transferMenuProgressContainer;
    public final ImageView transferMenuStatusIndicator;

    private LayoutMenuTransfersLegacyBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ProgressBar progressBar, FrameLayout frameLayout3, ImageView imageView2) {
        this.rootView = frameLayout;
        this.transferIcon = imageView;
        this.transferMenuIndicatorContainer = frameLayout2;
        this.transferMenuProgress = progressBar;
        this.transferMenuProgressContainer = frameLayout3;
        this.transferMenuStatusIndicator = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMenuTransfersLegacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMenuTransfersLegacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_menu_transfers_legacy, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMenuTransfersLegacyBinding bind(View view) {
        int i = R.id.transfer_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.transfer_menu_indicator_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.transfer_menu_progress;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.transfer_menu_progress_container;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = R.id.transfer_menu_status_indicator;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            return new LayoutMenuTransfersLegacyBinding((FrameLayout) view, imageView, frameLayout, progressBar, frameLayout2, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
