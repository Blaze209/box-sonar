package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.box.android.base.databinding.BoxPreviewsdkViewPageNumberBinding;
import com.box.android.capture.R;
import com.geniusscansdk.ui.BorderDetectionImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentDocumentScanEditBinding implements ViewBinding {
    public final BorderDetectionImageView borderDetectionImage;
    public final BoxPreviewsdkViewPageNumberBinding pageCounter;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final ViewPager2 scannedPages;

    private FragmentDocumentScanEditBinding(ConstraintLayout constraintLayout, BorderDetectionImageView borderDetectionImageView, BoxPreviewsdkViewPageNumberBinding boxPreviewsdkViewPageNumberBinding, ConstraintLayout constraintLayout2, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.borderDetectionImage = borderDetectionImageView;
        this.pageCounter = boxPreviewsdkViewPageNumberBinding;
        this.root = constraintLayout2;
        this.scannedPages = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDocumentScanEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDocumentScanEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_document_scan_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDocumentScanEditBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.border_detection_image;
        BorderDetectionImageView borderDetectionImageView = (BorderDetectionImageView) ViewBindings.findChildViewById(view, i);
        if (borderDetectionImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.page_counter))) != null) {
            BoxPreviewsdkViewPageNumberBinding boxPreviewsdkViewPageNumberBindingBind = BoxPreviewsdkViewPageNumberBinding.bind(viewFindChildViewById);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.scanned_pages;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
            if (viewPager2 != null) {
                return new FragmentDocumentScanEditBinding(constraintLayout, borderDetectionImageView, boxPreviewsdkViewPageNumberBindingBind, constraintLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
