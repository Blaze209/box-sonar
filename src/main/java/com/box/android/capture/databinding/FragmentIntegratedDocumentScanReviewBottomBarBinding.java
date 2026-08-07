package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentIntegratedDocumentScanReviewBottomBarBinding implements ViewBinding {
    public final AppCompatImageButton colorFilter;
    public final AppCompatImageButton cropImage;
    private final View rootView;
    public final AppCompatImageButton rotateImage;

    private FragmentIntegratedDocumentScanReviewBottomBarBinding(View view, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, AppCompatImageButton appCompatImageButton3) {
        this.rootView = view;
        this.colorFilter = appCompatImageButton;
        this.cropImage = appCompatImageButton2;
        this.rotateImage = appCompatImageButton3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static FragmentIntegratedDocumentScanReviewBottomBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.fragment_integrated_document_scan_review_bottom_bar, viewGroup);
        return bind(viewGroup);
    }

    public static FragmentIntegratedDocumentScanReviewBottomBarBinding bind(View view) {
        int i = R.id.color_filter;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.crop_image;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.rotate_image;
                AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                if (appCompatImageButton3 != null) {
                    return new FragmentIntegratedDocumentScanReviewBottomBarBinding(view, appCompatImageButton, appCompatImageButton2, appCompatImageButton3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
