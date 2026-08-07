package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class BottomSheetItemListingBinding implements ViewBinding {
    public final ImageView emptyImage;
    public final ConstraintLayout emptyItemLayout;
    public final TextView emptySubtext;
    public final TextView emptyText;
    public final CoordinatorLayout listingRoot;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerView;
    private final CoordinatorLayout rootView;

    private BottomSheetItemListingBinding(CoordinatorLayout coordinatorLayout, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, CoordinatorLayout coordinatorLayout2, ProgressBar progressBar, RecyclerView recyclerView) {
        this.rootView = coordinatorLayout;
        this.emptyImage = imageView;
        this.emptyItemLayout = constraintLayout;
        this.emptySubtext = textView;
        this.emptyText = textView2;
        this.listingRoot = coordinatorLayout2;
        this.progressBar = progressBar;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetItemListingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetItemListingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_item_listing, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetItemListingBinding bind(View view) {
        int i = R.id.empty_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.empty_item_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.empty_subtext;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.empty_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                        i = R.id.progress_bar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                return new BottomSheetItemListingBinding(coordinatorLayout, imageView, constraintLayout, textView, textView2, coordinatorLayout, progressBar, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
