package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.CaptureHistoryButtonView;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentCameraPreviewBinding implements ViewBinding {
    public final ConstraintLayout caprureCameraParent;
    public final PreviewView captureCameraPreview;
    public final AppCompatImageButton captureCameraSwitchButton;
    public final CaptureHistoryButtonView captureHistoryButton;
    public final AppCompatImageButton captureShutterButton;
    public final Guideline guidelineBottomInset;
    private final ConstraintLayout rootView;

    private FragmentCameraPreviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, PreviewView previewView, AppCompatImageButton appCompatImageButton, CaptureHistoryButtonView captureHistoryButtonView, AppCompatImageButton appCompatImageButton2, Guideline guideline) {
        this.rootView = constraintLayout;
        this.caprureCameraParent = constraintLayout2;
        this.captureCameraPreview = previewView;
        this.captureCameraSwitchButton = appCompatImageButton;
        this.captureHistoryButton = captureHistoryButtonView;
        this.captureShutterButton = appCompatImageButton2;
        this.guidelineBottomInset = guideline;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCameraPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCameraPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_camera_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCameraPreviewBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.capture_camera_preview;
        PreviewView previewView = (PreviewView) ViewBindings.findChildViewById(view, i);
        if (previewView != null) {
            i = R.id.capture_camera_switch_button;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.capture_history_button;
                CaptureHistoryButtonView captureHistoryButtonView = (CaptureHistoryButtonView) ViewBindings.findChildViewById(view, i);
                if (captureHistoryButtonView != null) {
                    i = R.id.capture_shutter_button;
                    AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton2 != null) {
                        i = R.id.guideline_bottom_inset;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            return new FragmentCameraPreviewBinding(constraintLayout, constraintLayout, previewView, appCompatImageButton, captureHistoryButtonView, appCompatImageButton2, guideline);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
