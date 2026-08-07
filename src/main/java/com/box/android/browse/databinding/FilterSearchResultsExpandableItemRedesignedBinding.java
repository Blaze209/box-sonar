package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FilterSearchResultsExpandableItemRedesignedBinding implements ViewBinding {
    public final ImageView expand;
    private final RelativeLayout rootView;
    public final ImageView selected;
    public final TextView text;

    private FilterSearchResultsExpandableItemRedesignedBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = relativeLayout;
        this.expand = imageView;
        this.selected = imageView2;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FilterSearchResultsExpandableItemRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FilterSearchResultsExpandableItemRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_search_results_expandable_item_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FilterSearchResultsExpandableItemRedesignedBinding bind(View view) {
        int i = R.id.expand;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.selected;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FilterSearchResultsExpandableItemRedesignedBinding((RelativeLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
