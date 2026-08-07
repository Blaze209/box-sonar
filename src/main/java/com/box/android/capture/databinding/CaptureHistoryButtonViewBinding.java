package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryButtonViewBinding implements ViewBinding {
    public final ImageView captureHistoryEmpty;
    public final ShapeableImageView captureHistoryThumbnail;
    public final ImageView errorIndicator;
    public final TextView numOfUploadsInProgress;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;

    private CaptureHistoryButtonViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, TextView textView, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.captureHistoryEmpty = imageView;
        this.captureHistoryThumbnail = shapeableImageView;
        this.errorIndicator = imageView2;
        this.numOfUploadsInProgress = textView;
        this.progressBar = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CaptureHistoryButtonViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CaptureHistoryButtonViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.capture_history_button_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CaptureHistoryButtonViewBinding bind(View view) {
        int i = R.id.capture_history_empty;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.capture_history_thumbnail;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
            if (shapeableImageView != null) {
                i = R.id.error_indicator;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.num_of_uploads_in_progress;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            return new CaptureHistoryButtonViewBinding((ConstraintLayout) view, imageView, shapeableImageView, imageView2, textView, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
