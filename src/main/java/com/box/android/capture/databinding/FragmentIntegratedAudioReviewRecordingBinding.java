package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.ui.PlayerControlView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.wavevisualizer.ReviewVisualizer;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentIntegratedAudioReviewRecordingBinding implements ViewBinding {
    public final PlayerControlView audioPlayer;
    public final TextView audioRecordingDiscard;
    public final TextView audioRecordingSave;
    public final ConstraintLayout bottomBar;
    public final TextView elapsedTime;
    public final Guideline middleGuideline;
    private final ConstraintLayout rootView;
    public final ReviewVisualizer waveVisualizer;

    private FragmentIntegratedAudioReviewRecordingBinding(ConstraintLayout constraintLayout, PlayerControlView playerControlView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3, Guideline guideline, ReviewVisualizer reviewVisualizer) {
        this.rootView = constraintLayout;
        this.audioPlayer = playerControlView;
        this.audioRecordingDiscard = textView;
        this.audioRecordingSave = textView2;
        this.bottomBar = constraintLayout2;
        this.elapsedTime = textView3;
        this.middleGuideline = guideline;
        this.waveVisualizer = reviewVisualizer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentIntegratedAudioReviewRecordingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentIntegratedAudioReviewRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_integrated_audio_review_recording, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentIntegratedAudioReviewRecordingBinding bind(View view) {
        int i = R.id.audio_player;
        PlayerControlView playerControlView = (PlayerControlView) ViewBindings.findChildViewById(view, i);
        if (playerControlView != null) {
            i = R.id.audio_recording_discard;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.audio_recording_save;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.bottom_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.elapsed_time;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.middle_guideline;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.wave_visualizer;
                                ReviewVisualizer reviewVisualizer = (ReviewVisualizer) ViewBindings.findChildViewById(view, i);
                                if (reviewVisualizer != null) {
                                    return new FragmentIntegratedAudioReviewRecordingBinding((ConstraintLayout) view, playerControlView, textView, textView2, constraintLayout, textView3, guideline, reviewVisualizer);
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
