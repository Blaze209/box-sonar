package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.media3.ui.DefaultTimeBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxPreviewsdkCustomControlsAudioBinding implements ViewBinding {
    public final TextView exoDuration;
    public final AppCompatImageButton exoNext;
    public final AppCompatImageButton exoPlayPause;
    public final TextView exoPosition;
    public final AppCompatImageButton exoPrev;
    public final DefaultTimeBar exoProgress;
    private final LinearLayout rootView;

    private BoxPreviewsdkCustomControlsAudioBinding(LinearLayout linearLayout, TextView textView, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, TextView textView2, AppCompatImageButton appCompatImageButton3, DefaultTimeBar defaultTimeBar) {
        this.rootView = linearLayout;
        this.exoDuration = textView;
        this.exoNext = appCompatImageButton;
        this.exoPlayPause = appCompatImageButton2;
        this.exoPosition = textView2;
        this.exoPrev = appCompatImageButton3;
        this.exoProgress = defaultTimeBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BoxPreviewsdkCustomControlsAudioBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BoxPreviewsdkCustomControlsAudioBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.box_previewsdk_custom_controls_audio, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BoxPreviewsdkCustomControlsAudioBinding bind(View view) {
        int i = R.id.exo_duration;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.exo_next;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton != null) {
                i = R.id.exo_play_pause;
                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                if (appCompatImageButton2 != null) {
                    i = R.id.exo_position;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.exo_prev;
                        AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageButton3 != null) {
                            i = R.id.exo_progress;
                            DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(view, i);
                            if (defaultTimeBar != null) {
                                return new BoxPreviewsdkCustomControlsAudioBinding((LinearLayout) view, textView, appCompatImageButton, appCompatImageButton2, textView2, appCompatImageButton3, defaultTimeBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
