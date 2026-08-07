package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class TasksLayoutBinding implements ViewBinding {
    public final RecyclerView boxBrowsesdkItemsRecyclerView;
    public final ProgressBar boxBrowsesdkProgressBar;
    public final SwipeRefreshLayout boxBrowsesdkSwipeReresh;
    public final ImageView emptyFolderImage;
    public final NestedScrollView emptyFolderLayout;
    public final TextView emptyFolderSubtext;
    public final TextView emptyFolderText;
    public final LinearLayout emptyFolderTextContainer;
    private final FrameLayout rootView;

    private TasksLayoutBinding(FrameLayout frameLayout, RecyclerView recyclerView, ProgressBar progressBar, SwipeRefreshLayout swipeRefreshLayout, ImageView imageView, NestedScrollView nestedScrollView, TextView textView, TextView textView2, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.boxBrowsesdkItemsRecyclerView = recyclerView;
        this.boxBrowsesdkProgressBar = progressBar;
        this.boxBrowsesdkSwipeReresh = swipeRefreshLayout;
        this.emptyFolderImage = imageView;
        this.emptyFolderLayout = nestedScrollView;
        this.emptyFolderSubtext = textView;
        this.emptyFolderText = textView2;
        this.emptyFolderTextContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TasksLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TasksLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.tasks_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TasksLayoutBinding bind(View view) {
        int i = R.id.box_browsesdk_items_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.box_browsesdk_items_recycler_view);
        if (recyclerView != null) {
            i = R.id.box_browsesdk_progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.box_browsesdk_progress_bar);
            if (progressBar != null) {
                i = R.id.box_browsesdk_swipe_reresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, R.id.box_browsesdk_swipe_reresh);
                if (swipeRefreshLayout != null) {
                    i = R.id.empty_folder_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_folder_image);
                    if (imageView != null) {
                        i = R.id.empty_folder_layout;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.empty_folder_layout);
                        if (nestedScrollView != null) {
                            i = R.id.empty_folder_subtext;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.empty_folder_subtext);
                            if (textView != null) {
                                i = R.id.empty_folder_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.empty_folder_text);
                                if (textView2 != null) {
                                    i = R.id.empty_folder_text_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.empty_folder_text_container);
                                    if (linearLayout != null) {
                                        return new TasksLayoutBinding((FrameLayout) view, recyclerView, progressBar, swipeRefreshLayout, imageView, nestedScrollView, textView, textView2, linearLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
