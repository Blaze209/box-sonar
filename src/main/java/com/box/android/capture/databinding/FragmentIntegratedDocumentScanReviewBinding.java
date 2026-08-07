package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;
import com.geniusscansdk.ui.BorderDetectionImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentIntegratedDocumentScanReviewBinding implements ViewBinding {
    public final ConstraintLayout bottomBar;
    public final TextView cancelCrop;
    public final Group croppingButtons;
    public final BorderDetectionImageView documentScanBorderDetection;
    public final BorderDetectionImageView documentScanCropBorderDetection;
    public final ConstraintLayout documentScanReviewEditBar;
    public final TextView doneCrop;
    public final Guideline middleGuideline;
    public final TextView retakeBtn;
    public final Group reviewButtons;
    private final ConstraintLayout rootView;
    public final TextView usePhotoBtn;

    private FragmentIntegratedDocumentScanReviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, Group group, BorderDetectionImageView borderDetectionImageView, BorderDetectionImageView borderDetectionImageView2, ConstraintLayout constraintLayout3, TextView textView2, Guideline guideline, TextView textView3, Group group2, TextView textView4) {
        this.rootView = constraintLayout;
        this.bottomBar = constraintLayout2;
        this.cancelCrop = textView;
        this.croppingButtons = group;
        this.documentScanBorderDetection = borderDetectionImageView;
        this.documentScanCropBorderDetection = borderDetectionImageView2;
        this.documentScanReviewEditBar = constraintLayout3;
        this.doneCrop = textView2;
        this.middleGuideline = guideline;
        this.retakeBtn = textView3;
        this.reviewButtons = group2;
        this.usePhotoBtn = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentIntegratedDocumentScanReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentIntegratedDocumentScanReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_integrated_document_scan_review, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentIntegratedDocumentScanReviewBinding bind(View view) {
        int i = R.id.bottom_bar;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancel_crop;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cropping_buttons;
                Group group = (Group) ViewBindings.findChildViewById(view, i);
                if (group != null) {
                    i = R.id.document_scan_border_detection;
                    BorderDetectionImageView borderDetectionImageView = (BorderDetectionImageView) ViewBindings.findChildViewById(view, i);
                    if (borderDetectionImageView != null) {
                        i = R.id.document_scan_crop_border_detection;
                        BorderDetectionImageView borderDetectionImageView2 = (BorderDetectionImageView) ViewBindings.findChildViewById(view, i);
                        if (borderDetectionImageView2 != null) {
                            i = R.id.document_scan_review_edit_bar;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.done_crop;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.middle_guideline;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline != null) {
                                        i = R.id.retake_btn;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.review_buttons;
                                            Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                                            if (group2 != null) {
                                                i = R.id.use_photo_btn;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new FragmentIntegratedDocumentScanReviewBinding((ConstraintLayout) view, constraintLayout, textView, group, borderDetectionImageView, borderDetectionImageView2, constraintLayout2, textView2, guideline, textView3, group2, textView4);
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
