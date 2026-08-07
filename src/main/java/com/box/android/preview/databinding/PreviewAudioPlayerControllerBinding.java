package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.ui.PlayerControlView;
import androidx.viewbinding.ViewBinding;
import com.box.android.preview.R;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewAudioPlayerControllerBinding implements ViewBinding {
    public final PlayerControlView playerNew;
    private final PlayerControlView rootView;

    private PreviewAudioPlayerControllerBinding(PlayerControlView playerControlView, PlayerControlView playerControlView2) {
        this.rootView = playerControlView;
        this.playerNew = playerControlView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public PlayerControlView getRoot() {
        return this.rootView;
    }

    public static PreviewAudioPlayerControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreviewAudioPlayerControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.preview_audio_player_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PreviewAudioPlayerControllerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        PlayerControlView playerControlView = (PlayerControlView) view;
        return new PreviewAudioPlayerControllerBinding(playerControlView, playerControlView);
    }
}
