package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowsesdkFragmentSearchRedesignedBinding implements ViewBinding {
    public final RecyclerView boxBrowsesdkItemsRecyclerView;
    public final CircularProgressIndicator boxBrowsesdkProgressBar;
    public final SwipeRefreshLayout boxBrowsesdkSwipeReresh;
    public final ImageView emptyFolderImage;
    public final LinearLayout emptyFolderLayout;
    public final TextView emptyFolderSubtext;
    public final TextView emptyFolderText;
    public final LinearLayout emptyFolderTextContainer;
    public final LinearLayout filterChipsContainer;
    public final LinearLayout filterResultsHeader;
    public final LinearLayout redesignedFilterButton;
    public final TextView resultsTextInFilesHeader;
    private final FrameLayout rootView;

    private BoxBrowsesdkFragmentSearchRedesignedBinding(FrameLayout frameLayout, RecyclerView recyclerView, CircularProgressIndicator circularProgressIndicator, SwipeRefreshLayout swipeRefreshLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView3) {
        this.rootView = frameLayout;
        this.boxBrowsesdkItemsRecyclerView = recyclerView;
        this.boxBrowsesdkProgressBar = circularProgressIndicator;
        this.boxBrowsesdkSwipeReresh = swipeRefreshLayout;
        this.emptyFolderImage = imageView;
        this.emptyFolderLayout = linearLayout;
        this.emptyFolderSubtext = textView;
        this.emptyFolderText = textView2;
        this.emptyFolderTextContainer = linearLayout2;
        this.filterChipsContainer = linearLayout3;
        this.filterResultsHeader = linearLayout4;
        this.redesignedFilterButton = linearLayout5;
        this.resultsTextInFilesHeader = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkFragmentSearchRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkFragmentSearchRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_fragment_search_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkFragmentSearchRedesignedBinding bind(View view) {
        int i = R.id.box_browsesdk_items_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.box_browsesdk_progress_bar;
            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
            if (circularProgressIndicator != null) {
                i = R.id.box_browsesdk_swipe_reresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                if (swipeRefreshLayout != null) {
                    i = R.id.empty_folder_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.empty_folder_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.empty_folder_subtext;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.empty_folder_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.empty_folder_text_container;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.filterChipsContainer;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.filterResultsHeader;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.redesignedFilterButton;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.resultsTextInFilesHeader;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new BoxBrowsesdkFragmentSearchRedesignedBinding((FrameLayout) view, recyclerView, circularProgressIndicator, swipeRefreshLayout, imageView, linearLayout, textView, textView2, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView3);
                                                    }
                                                }
                                            }
                                        }
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
