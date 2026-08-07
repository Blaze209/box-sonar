package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class LayoutReviewPhotoBinding implements ViewBinding {
    public final View bottomBarContainer;
    public final Guideline guideline;
    public final ImageView photoPreview;
    public final Button retake;
    private final ConstraintLayout rootView;
    public final LinearLayout usePhoto;

    private LayoutReviewPhotoBinding(ConstraintLayout constraintLayout, View view, Guideline guideline, ImageView imageView, Button button, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.bottomBarContainer = view;
        this.guideline = guideline;
        this.photoPreview = imageView;
        this.retake = button;
        this.usePhoto = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutReviewPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutReviewPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_review_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutReviewPhotoBinding bind(View view) {
        int i = R.id.bottom_bar_container;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.photo_preview;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.retake;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.use_photo;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            return new LayoutReviewPhotoBinding((ConstraintLayout) view, viewFindChildViewById, guideline, imageView, button, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
