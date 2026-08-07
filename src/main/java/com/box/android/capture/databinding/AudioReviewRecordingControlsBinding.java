package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.ui.DefaultTimeBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class AudioReviewRecordingControlsBinding implements ViewBinding {
    public final LinearLayout audioPlayerControllerRoot;
    public final AppCompatImageButton exoFfwd;
    public final AppCompatImageButton exoPlayPause;
    public final DefaultTimeBar exoProgress;
    public final AppCompatImageButton exoRew;
    public final Guideline guidelineCenter;
    public final TextView playerDuration;
    public final TextView playerPosition;
    private final LinearLayout rootView;

    private AudioReviewRecordingControlsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, DefaultTimeBar defaultTimeBar, AppCompatImageButton appCompatImageButton3, Guideline guideline, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.audioPlayerControllerRoot = linearLayout2;
        this.exoFfwd = appCompatImageButton;
        this.exoPlayPause = appCompatImageButton2;
        this.exoProgress = defaultTimeBar;
        this.exoRew = appCompatImageButton3;
        this.guidelineCenter = guideline;
        this.playerDuration = textView;
        this.playerPosition = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AudioReviewRecordingControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AudioReviewRecordingControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.audio_review_recording_controls, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AudioReviewRecordingControlsBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.exo_ffwd;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.exo_play_pause;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.exo_progress;
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(view, i);
                if (defaultTimeBar != null) {
                    i = R.id.exo_rew;
                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton3 != null) {
                        i = R.id.guideline_center;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            i = R.id.player_duration;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.player_position;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new AudioReviewRecordingControlsBinding(linearLayout, linearLayout, appCompatImageButton, appCompatImageButton2, defaultTimeBar, appCompatImageButton3, guideline, textView, textView2);
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
