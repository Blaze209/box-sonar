package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowsesdkListItemBinding implements ViewBinding {
    public final TextView boxBrowsesdkNameText;
    public final ShapeableImageView boxBrowsesdkThumbImage;
    public final AppCompatCheckBox boxItemCheckBox;
    public final FrameLayout boxItemMain;
    public final TextView metalineDescription;
    private final FrameLayout rootView;
    public final AppCompatImageButton secondaryAction;
    public final FrameLayout secondaryContainer;
    public final CircularProgressIndicator spinner;

    private BoxBrowsesdkListItemBinding(FrameLayout frameLayout, TextView textView, ShapeableImageView shapeableImageView, AppCompatCheckBox appCompatCheckBox, FrameLayout frameLayout2, TextView textView2, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout3, CircularProgressIndicator circularProgressIndicator) {
        this.rootView = frameLayout;
        this.boxBrowsesdkNameText = textView;
        this.boxBrowsesdkThumbImage = shapeableImageView;
        this.boxItemCheckBox = appCompatCheckBox;
        this.boxItemMain = frameLayout2;
        this.metalineDescription = textView2;
        this.secondaryAction = appCompatImageButton;
        this.secondaryContainer = frameLayout3;
        this.spinner = circularProgressIndicator;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BoxBrowsesdkListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxBrowsesdkListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_browsesdk_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxBrowsesdkListItemBinding bind(View view) {
        int i = R.id.box_browsesdk_name_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.box_browsesdk_thumb_image;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
            if (shapeableImageView != null) {
                i = R.id.boxItemCheckBox;
                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
                if (appCompatCheckBox != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.metaline_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.secondaryAction;
                        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageButton != null) {
                            i = R.id.secondaryContainer;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null) {
                                i = R.id.spinner;
                                CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
                                if (circularProgressIndicator != null) {
                                    return new BoxBrowsesdkListItemBinding(frameLayout, textView, shapeableImageView, appCompatCheckBox, frameLayout, textView2, appCompatImageButton, frameLayout2, circularProgressIndicator);
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
