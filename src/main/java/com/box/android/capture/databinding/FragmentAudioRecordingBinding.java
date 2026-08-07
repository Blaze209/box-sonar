package com.box.android.capture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.wavevisualizer.RecordingVisualizer;

/* JADX INFO: loaded from: classes10.dex */
public final class FragmentAudioRecordingBinding implements ViewBinding {
    public final Button audioRecordingDone;
    public final Group audioRecordingExtendedControls;
    public final ConstraintLayout audioRecordingTopBar;
    public final AppCompatImageButton audioRecordingTrash;
    public final AppCompatImageButton captureCloseButton;
    public final LinearLayout changeUploadFolderButton;
    public final View divider;
    public final TextView elapsedTime;
    public final ImageView folderIcon;
    public final TextView folderLabel;
    public final ImageView image;
    public final TextView message;
    public final Group noRecordingLayout;
    public final ImageView recordingButton;
    public final TextView recordingMessage;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final RecordingVisualizer waveVisualizer;

    private FragmentAudioRecordingBinding(ConstraintLayout constraintLayout, Button button, Group group, ConstraintLayout constraintLayout2, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, LinearLayout linearLayout, View view, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, Group group2, ImageView imageView3, TextView textView4, TextView textView5, RecordingVisualizer recordingVisualizer) {
        this.rootView = constraintLayout;
        this.audioRecordingDone = button;
        this.audioRecordingExtendedControls = group;
        this.audioRecordingTopBar = constraintLayout2;
        this.audioRecordingTrash = appCompatImageButton;
        this.captureCloseButton = appCompatImageButton2;
        this.changeUploadFolderButton = linearLayout;
        this.divider = view;
        this.elapsedTime = textView;
        this.folderIcon = imageView;
        this.folderLabel = textView2;
        this.image = imageView2;
        this.message = textView3;
        this.noRecordingLayout = group2;
        this.recordingButton = imageView3;
        this.recordingMessage = textView4;
        this.title = textView5;
        this.waveVisualizer = recordingVisualizer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAudioRecordingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAudioRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_audio_recording, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAudioRecordingBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.audio_recording_done;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.audio_recording_extended_controls;
            Group group = (Group) ViewBindings.findChildViewById(view, i);
            if (group != null) {
                i = R.id.audio_recording_top_bar;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.audio_recording_trash;
                    AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton != null) {
                        i = R.id.capture_close_button;
                        AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageButton2 != null) {
                            i = R.id.change_upload_folder_button;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                                i = R.id.elapsed_time;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.folder_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.folder_label;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.message;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.no_recording_layout;
                                                    Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                                                    if (group2 != null) {
                                                        i = R.id.recording_button;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.recording_message;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.title;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.wave_visualizer;
                                                                    RecordingVisualizer recordingVisualizer = (RecordingVisualizer) ViewBindings.findChildViewById(view, i);
                                                                    if (recordingVisualizer != null) {
                                                                        return new FragmentAudioRecordingBinding((ConstraintLayout) view, button, group, constraintLayout, appCompatImageButton, appCompatImageButton2, linearLayout, viewFindChildViewById, textView, imageView, textView2, imageView2, textView3, group2, imageView3, textView4, textView5, recordingVisualizer);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
