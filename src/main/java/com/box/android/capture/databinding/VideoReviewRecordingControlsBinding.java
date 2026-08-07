package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.ui.DefaultTimeBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class VideoReviewRecordingControlsBinding implements ViewBinding {
    public final TextView exoDuration;
    public final ImageButton exoFfwd;
    public final ImageButton exoPlayPause;
    public final TextView exoPosition;
    public final DefaultTimeBar exoProgress;
    public final ImageButton exoRew;
    public final Guideline guidelineCenter;
    private final FrameLayout rootView;

    private VideoReviewRecordingControlsBinding(FrameLayout frameLayout, TextView textView, ImageButton imageButton, ImageButton imageButton2, TextView textView2, DefaultTimeBar defaultTimeBar, ImageButton imageButton3, Guideline guideline) {
        this.rootView = frameLayout;
        this.exoDuration = textView;
        this.exoFfwd = imageButton;
        this.exoPlayPause = imageButton2;
        this.exoPosition = textView2;
        this.exoProgress = defaultTimeBar;
        this.exoRew = imageButton3;
        this.guidelineCenter = guideline;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VideoReviewRecordingControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VideoReviewRecordingControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.video_review_recording_controls, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VideoReviewRecordingControlsBinding bind(View view) {
        int i = R.id.exo_duration;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.exo_ffwd;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                i = R.id.exo_play_pause;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton2 != null) {
                    i = R.id.exo_position;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.exo_progress;
                        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(view, i);
                        if (defaultTimeBar != null) {
                            i = R.id.exo_rew;
                            ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i);
                            if (imageButton3 != null) {
                                i = R.id.guideline_center;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline != null) {
                                    return new VideoReviewRecordingControlsBinding((FrameLayout) view, textView, imageButton, imageButton2, textView2, defaultTimeBar, imageButton3, guideline);
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
