package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;
import com.box.android.browse.uidata.SquareRelativeLayout;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowsesdkMediaItemBinding implements ViewBinding {
    public final TextView boxBrowsesdkNameText;
    public final ImageView boxBrowsesdkThumbImage;
    public final AppCompatCheckBox boxItemCheckBox;
    public final SquareRelativeLayout boxItemMain;
    public final TextView metalineDescription;
    private final SquareRelativeLayout rootView;
    public final AppCompatImageButton secondaryAction;
    public final FrameLayout secondaryContainer;
    public final ProgressBar spinner;

    private BoxBrowsesdkMediaItemBinding(SquareRelativeLayout squareRelativeLayout, TextView textView, ImageView imageView, AppCompatCheckBox appCompatCheckBox, SquareRelativeLayout squareRelativeLayout2, TextView textView2, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, ProgressBar progressBar) {
        this.rootView = squareRelativeLayout;
        this.boxBrowsesdkNameText = textView;
        this.boxBrowsesdkThumbImage = imageView;
        this.boxItemCheckBox = appCompatCheckBox;
        this.boxItemMain = squareRelativeLayout2;
        this.metalineDescription = textView2;
        this.secondaryAction = appCompatImageButton;
        this.secondaryContainer = frameLayout;
        this.spinner = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SquareRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkMediaItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkMediaItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_media_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkMediaItemBinding bind(View view) {
        int i = R.id.box_browsesdk_name_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.box_browsesdk_thumb_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.boxItemCheckBox;
                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
                if (appCompatCheckBox != null) {
                    SquareRelativeLayout squareRelativeLayout = (SquareRelativeLayout) view;
                    i = R.id.metaline_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.secondaryAction;
                        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageButton != null) {
                            i = R.id.secondaryContainer;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.spinner;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    return new BoxBrowsesdkMediaItemBinding(squareRelativeLayout, textView, imageView, appCompatCheckBox, squareRelativeLayout, textView2, appCompatImageButton, frameLayout, progressBar);
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
