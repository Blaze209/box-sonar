package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;
import com.geniusscansdk.ui.BorderDetectionImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentDocumentScanReviewBinding implements ViewBinding {
    public final ConstraintLayout bottomBar;
    public final BorderDetectionImageView documentScanBorderDetection;
    public final Guideline middleGuideline;
    public final TextView retakeBtn;
    private final ConstraintLayout rootView;
    public final TextView usePhotoBtn;

    private FragmentDocumentScanReviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, BorderDetectionImageView borderDetectionImageView, Guideline guideline, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomBar = constraintLayout2;
        this.documentScanBorderDetection = borderDetectionImageView;
        this.middleGuideline = guideline;
        this.retakeBtn = textView;
        this.usePhotoBtn = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDocumentScanReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDocumentScanReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_document_scan_review, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDocumentScanReviewBinding bind(View view) {
        int i = R.id.bottom_bar;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.document_scan_border_detection;
            BorderDetectionImageView borderDetectionImageView = (BorderDetectionImageView) ViewBindings.findChildViewById(view, i);
            if (borderDetectionImageView != null) {
                i = R.id.middle_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.retake_btn;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.use_photo_btn;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentDocumentScanReviewBinding((ConstraintLayout) view, constraintLayout, borderDetectionImageView, guideline, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
