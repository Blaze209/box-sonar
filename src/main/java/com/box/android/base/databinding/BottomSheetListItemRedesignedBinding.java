package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class BottomSheetListItemRedesignedBinding implements ViewBinding {
    public final FrameLayout iconContainer;
    public final ImageView itemIcon;
    public final ProgressBar loadingSpinner;
    private final RelativeLayout rootView;
    public final TextView title;

    private BottomSheetListItemRedesignedBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, TextView textView) {
        this.rootView = relativeLayout;
        this.iconContainer = frameLayout;
        this.itemIcon = imageView;
        this.loadingSpinner = progressBar;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetListItemRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetListItemRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_list_item_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetListItemRedesignedBinding bind(View view) {
        int i = R.id.icon_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.item_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.loading_spinner;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new BottomSheetListItemRedesignedBinding((RelativeLayout) view, frameLayout, imageView, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
