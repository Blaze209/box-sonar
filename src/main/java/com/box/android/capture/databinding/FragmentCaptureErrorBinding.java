package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentCaptureErrorBinding implements ViewBinding {
    public final TextView captureErrorButton;
    public final AppCompatImageButton captureErrorClose;
    public final ImageView captureErrorIcon;
    public final ConstraintLayout captureErrorParent;
    public final TextView captureErrorReason;
    public final TextView captureErrorTitle;
    private final ConstraintLayout rootView;

    private FragmentCaptureErrorBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageButton appCompatImageButton, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.captureErrorButton = textView;
        this.captureErrorClose = appCompatImageButton;
        this.captureErrorIcon = imageView;
        this.captureErrorParent = constraintLayout2;
        this.captureErrorReason = textView2;
        this.captureErrorTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCaptureErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCaptureErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_capture_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCaptureErrorBinding bind(View view) {
        int i = R.id.capture_error_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.capture_error_close;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.capture_error_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.capture_error_reason;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.capture_error_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new FragmentCaptureErrorBinding(constraintLayout, textView, appCompatImageButton, imageView, constraintLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
