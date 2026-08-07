package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowsesdkFragmentBrowseBinding implements ViewBinding {
    public final ImageView boxBrowsesdkFolderEmpty;
    public final RecyclerView boxBrowsesdkItemsRecyclerView;
    public final ProgressBar boxBrowsesdkProgressBar;
    public final SwipeRefreshLayout boxBrowsesdkSwipeReresh;
    private final FrameLayout rootView;

    private BoxBrowsesdkFragmentBrowseBinding(FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, ProgressBar progressBar, SwipeRefreshLayout swipeRefreshLayout) {
        this.rootView = frameLayout;
        this.boxBrowsesdkFolderEmpty = imageView;
        this.boxBrowsesdkItemsRecyclerView = recyclerView;
        this.boxBrowsesdkProgressBar = progressBar;
        this.boxBrowsesdkSwipeReresh = swipeRefreshLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkFragmentBrowseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkFragmentBrowseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_fragment_browse, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkFragmentBrowseBinding bind(View view) {
        int i = R.id.box_browsesdk_folder_empty;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.box_browsesdk_items_recycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.box_browsesdk_progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.box_browsesdk_swipe_reresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                    if (swipeRefreshLayout != null) {
                        return new BoxBrowsesdkFragmentBrowseBinding((FrameLayout) view, imageView, recyclerView, progressBar, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
