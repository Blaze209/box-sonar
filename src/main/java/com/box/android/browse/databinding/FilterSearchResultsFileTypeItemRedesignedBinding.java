package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FilterSearchResultsFileTypeItemRedesignedBinding implements ViewBinding {
    public final AppCompatCheckBox checkBox;
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final TextView text;

    private FilterSearchResultsFileTypeItemRedesignedBinding(RelativeLayout relativeLayout, AppCompatCheckBox appCompatCheckBox, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.checkBox = appCompatCheckBox;
        this.icon = imageView;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FilterSearchResultsFileTypeItemRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FilterSearchResultsFileTypeItemRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_search_results_file_type_item_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FilterSearchResultsFileTypeItemRedesignedBinding bind(View view) {
        int i = R.id.checkBox;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
        if (appCompatCheckBox != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FilterSearchResultsFileTypeItemRedesignedBinding((RelativeLayout) view, appCompatCheckBox, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
