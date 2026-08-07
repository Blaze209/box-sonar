package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentDocumentScanBinding implements ViewBinding {
    public final AppCompatImageButton documentScanCloseButton;
    public final AppCompatImageButton documentScanFlashButton;
    public final TextView documentScanFolderLabel;
    public final ConstraintLayout documentScanTopBar;
    public final LinearLayout documentScanUploadFolderButton;
    public final ImageView folderIcon;
    private final ConstraintLayout rootView;

    private FragmentDocumentScanBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.documentScanCloseButton = appCompatImageButton;
        this.documentScanFlashButton = appCompatImageButton2;
        this.documentScanFolderLabel = textView;
        this.documentScanTopBar = constraintLayout2;
        this.documentScanUploadFolderButton = linearLayout;
        this.folderIcon = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDocumentScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDocumentScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_document_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDocumentScanBinding bind(View view) {
        int i = R.id.document_scan_close_button;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.document_scan_flash_button;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.document_scan_folder_label;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.document_scan_top_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.document_scan_upload_folder_button;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.folder_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                return new FragmentDocumentScanBinding((ConstraintLayout) view, appCompatImageButton, appCompatImageButton2, textView, constraintLayout, linearLayout, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
