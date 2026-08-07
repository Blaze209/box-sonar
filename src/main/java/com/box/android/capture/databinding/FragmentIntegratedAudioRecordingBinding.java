package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.CaptureHistoryButtonView;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.wavevisualizer.RecordingVisualizer;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentIntegratedAudioRecordingBinding implements ViewBinding {
    public final Button audioRecordingDone;
    public final Group audioRecordingExtendedControls;
    public final AppCompatImageButton audioRecordingTrash;
    public final CaptureHistoryButtonView captureHistoryButton;
    public final View divider;
    public final TextView elapsedTime;
    public final Guideline guidelineBottomInset;
    public final ImageView image;
    public final TextView message;
    public final Group noRecordingLayout;
    public final ImageView recordingButton;
    public final TextView recordingMessage;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final RecordingVisualizer waveVisualizer;

    private FragmentIntegratedAudioRecordingBinding(ConstraintLayout constraintLayout, Button button, Group group, AppCompatImageButton appCompatImageButton, CaptureHistoryButtonView captureHistoryButtonView, View view, TextView textView, Guideline guideline, ImageView imageView, TextView textView2, Group group2, ImageView imageView2, TextView textView3, TextView textView4, RecordingVisualizer recordingVisualizer) {
        this.rootView = constraintLayout;
        this.audioRecordingDone = button;
        this.audioRecordingExtendedControls = group;
        this.audioRecordingTrash = appCompatImageButton;
        this.captureHistoryButton = captureHistoryButtonView;
        this.divider = view;
        this.elapsedTime = textView;
        this.guidelineBottomInset = guideline;
        this.image = imageView;
        this.message = textView2;
        this.noRecordingLayout = group2;
        this.recordingButton = imageView2;
        this.recordingMessage = textView3;
        this.title = textView4;
        this.waveVisualizer = recordingVisualizer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentIntegratedAudioRecordingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentIntegratedAudioRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_integrated_audio_recording, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentIntegratedAudioRecordingBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.audio_recording_done;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.audio_recording_extended_controls;
            Group group = (Group) ViewBindings.findChildViewById(view, i);
            if (group != null) {
                i = R.id.audio_recording_trash;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                if (appCompatImageButton != null) {
                    i = R.id.capture_history_button;
                    CaptureHistoryButtonView captureHistoryButtonView = (CaptureHistoryButtonView) ViewBindings.findChildViewById(view, i);
                    if (captureHistoryButtonView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                        i = R.id.elapsed_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.guideline_bottom_inset;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.message;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.no_recording_layout;
                                        Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                                        if (group2 != null) {
                                            i = R.id.recording_button;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.recording_message;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.wave_visualizer;
                                                        RecordingVisualizer recordingVisualizer = (RecordingVisualizer) ViewBindings.findChildViewById(view, i);
                                                        if (recordingVisualizer != null) {
                                                            return new FragmentIntegratedAudioRecordingBinding((ConstraintLayout) view, button, group, appCompatImageButton, captureHistoryButtonView, viewFindChildViewById, textView, guideline, imageView, textView2, group2, imageView2, textView3, textView4, recordingVisualizer);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
