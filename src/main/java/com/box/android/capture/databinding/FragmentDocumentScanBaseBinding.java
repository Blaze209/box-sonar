package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.CaptureHistoryButtonView;
import com.box.android.capture.R;
import com.geniusscansdk.camera.DefaultFocusIndicator;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentDocumentScanBaseBinding implements ViewBinding {
    public final CaptureHistoryButtonView documentScanCaptureHistoryButton;
    public final TextView documentScanShutterButton;
    public final AppCompatImageButton documentScanThumbnailButton;
    public final Button documentScanUpload;
    public final DefaultFocusIndicator focusIndicator;
    public final Guideline guidelineBottomInset;
    private final ConstraintLayout rootView;

    private FragmentDocumentScanBaseBinding(ConstraintLayout constraintLayout, CaptureHistoryButtonView captureHistoryButtonView, TextView textView, AppCompatImageButton appCompatImageButton, Button button, DefaultFocusIndicator defaultFocusIndicator, Guideline guideline) {
        this.rootView = constraintLayout;
        this.documentScanCaptureHistoryButton = captureHistoryButtonView;
        this.documentScanShutterButton = textView;
        this.documentScanThumbnailButton = appCompatImageButton;
        this.documentScanUpload = button;
        this.focusIndicator = defaultFocusIndicator;
        this.guidelineBottomInset = guideline;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDocumentScanBaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDocumentScanBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_document_scan_base, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDocumentScanBaseBinding bind(View view) {
        int i = R.id.document_scan_capture_history_button;
        CaptureHistoryButtonView captureHistoryButtonView = (CaptureHistoryButtonView) ViewBindings.findChildViewById(view, i);
        if (captureHistoryButtonView != null) {
            i = R.id.document_scan_shutter_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.document_scan_thumbnail_button;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                if (appCompatImageButton != null) {
                    i = R.id.document_scan_upload;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.focus_indicator;
                        DefaultFocusIndicator defaultFocusIndicator = (DefaultFocusIndicator) ViewBindings.findChildViewById(view, i);
                        if (defaultFocusIndicator != null) {
                            i = R.id.guideline_bottom_inset;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                return new FragmentDocumentScanBaseBinding((ConstraintLayout) view, captureHistoryButtonView, textView, appCompatImageButton, button, defaultFocusIndicator, guideline);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
