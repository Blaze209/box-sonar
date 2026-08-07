package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class FileFolderMenuHeaderRedesignedBinding implements ViewBinding {
    public final LinearLayout container;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView title;

    private FileFolderMenuHeaderRedesignedBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.container = linearLayout2;
        this.icon = imageView;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FileFolderMenuHeaderRedesignedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FileFolderMenuHeaderRedesignedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.file_folder_menu_header_redesigned, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FileFolderMenuHeaderRedesignedBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new FileFolderMenuHeaderRedesignedBinding(linearLayout, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
