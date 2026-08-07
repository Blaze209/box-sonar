package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentVideoReviewBinding implements ViewBinding {
    public final ConstraintLayout bottomBar;
    public final Guideline middleGuideline;
    private final ConstraintLayout rootView;
    public final PlayerView videoPlayer;
    public final TextView videoRecordingDiscard;
    public final TextView videoRecordingSave;

    private FragmentVideoReviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, PlayerView playerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomBar = constraintLayout2;
        this.middleGuideline = guideline;
        this.videoPlayer = playerView;
        this.videoRecordingDiscard = textView;
        this.videoRecordingSave = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVideoReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVideoReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_video_review, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVideoReviewBinding bind(View view) {
        int i = R.id.bottom_bar;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.middle_guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.video_player;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i);
                if (playerView != null) {
                    i = R.id.video_recording_discard;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.video_recording_save;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentVideoReviewBinding((ConstraintLayout) view, constraintLayout, guideline, playerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
