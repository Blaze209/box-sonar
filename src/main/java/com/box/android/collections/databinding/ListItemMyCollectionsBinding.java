package com.box.android.collections.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.collections.R;

/* JADX INFO: loaded from: classes10.dex */
public final class ListItemMyCollectionsBinding implements ViewBinding {
    public final ImageView myCollectionsIcon;
    public final AppCompatImageButton myCollectionsMenu;
    public final TextView myCollectionsTitle;
    private final ConstraintLayout rootView;

    private ListItemMyCollectionsBinding(ConstraintLayout constraintLayout, ImageView imageView, AppCompatImageButton appCompatImageButton, TextView textView) {
        this.rootView = constraintLayout;
        this.myCollectionsIcon = imageView;
        this.myCollectionsMenu = appCompatImageButton;
        this.myCollectionsTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ListItemMyCollectionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ListItemMyCollectionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.list_item_my_collections, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ListItemMyCollectionsBinding bind(View view) {
        int i = R.id.my_collections_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.my_collections_menu;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.my_collections_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ListItemMyCollectionsBinding((ConstraintLayout) view, imageView, appCompatImageButton, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
