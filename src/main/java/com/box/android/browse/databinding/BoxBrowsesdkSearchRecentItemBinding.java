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
public final class BoxBrowsesdkSearchRecentItemBinding implements ViewBinding {
    public final ImageView close;
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final TextView text;

    private BoxBrowsesdkSearchRecentItemBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = relativeLayout;
        this.close = imageView;
        this.icon = imageView2;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkSearchRecentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkSearchRecentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_search_recent_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkSearchRecentItemBinding bind(View view) {
        int i = R.id.close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new BoxBrowsesdkSearchRecentItemBinding((RelativeLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
