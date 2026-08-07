package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.WavWriter;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.audio.AudioModeListeners;
import com.pspdfkit.ui.audio.AudioModeManager;

/* JADX INFO: loaded from: classes3.dex */
public final class y5 implements AudioModeListeners, AudioModeManager {
    public final PdfFragment b;
    public final t6 d;
    public final /* synthetic */ x5 a = new x5();
    public final i6 c = new i6(this);

    public y5(PdfFragment pdfFragment, a70 a70Var) {
        this.b = pdfFragment;
        this.d = new t6(this, a70Var);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void addAudioPlaybackModeChangeListener(AudioModeListeners.AudioPlaybackModeChangeListener audioPlaybackModeChangeListener) {
        audioPlaybackModeChangeListener.getClass();
        x5 x5Var = this.a;
        x5Var.getClass();
        audioPlaybackModeChangeListener.getClass();
        x5Var.a.a(audioPlaybackModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void addAudioRecordingModeChangeListener(AudioModeListeners.AudioRecordingModeChangeListener audioRecordingModeChangeListener) {
        audioRecordingModeChangeListener.getClass();
        x5 x5Var = this.a;
        x5Var.getClass();
        audioRecordingModeChangeListener.getClass();
        x5Var.b.a(audioRecordingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeManager
    public final boolean canPlay(SoundAnnotation soundAnnotation) {
        soundAnnotation.getClass();
        this.c.getClass();
        soundAnnotation.getClass();
        return soundAnnotation.hasAudioData() && WavWriter.INSTANCE.soundAnnotationSupportsWavExport(soundAnnotation);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeManager
    public final boolean canRecord(SoundAnnotation soundAnnotation) {
        soundAnnotation.getClass();
        this.d.getClass();
        soundAnnotation.getClass();
        return !soundAnnotation.hasAudioData();
    }

    @Override // com.pspdfkit.ui.audio.AudioModeManager
    public final void enterAudioPlaybackMode(SoundAnnotation soundAnnotation) {
        soundAnnotation.getClass();
        t6 t6Var = this.d;
        if (t6Var.e != null) {
            t6Var.exitAudioRecordingMode();
        }
        if (soundAnnotation.hasAudioData() && canPlay(soundAnnotation)) {
            i6 i6Var = this.c;
            Context contextRequireContext = this.b.requireContext();
            contextRequireContext.getClass();
            i6Var.a(contextRequireContext, soundAnnotation, true, 0);
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioModeManager
    public final void enterAudioRecordingMode(SoundAnnotation soundAnnotation) {
        soundAnnotation.getClass();
        i6 i6Var = this.c;
        if (i6Var.c != null) {
            i6Var.a(true);
        }
        this.d.getClass();
        if (soundAnnotation.hasAudioData()) {
            return;
        }
        t6 t6Var = this.d;
        Context contextRequireContext = this.b.requireContext();
        contextRequireContext.getClass();
        t6Var.a(contextRequireContext, soundAnnotation, false);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeManager
    public final void exitActiveAudioMode() {
        this.c.a(true);
        this.d.exitAudioRecordingMode();
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void removeAudioPlaybackModeChangeListener(AudioModeListeners.AudioPlaybackModeChangeListener audioPlaybackModeChangeListener) {
        audioPlaybackModeChangeListener.getClass();
        x5 x5Var = this.a;
        x5Var.getClass();
        audioPlaybackModeChangeListener.getClass();
        x5Var.a.b(audioPlaybackModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void removeAudioRecordingModeChangeListener(AudioModeListeners.AudioRecordingModeChangeListener audioRecordingModeChangeListener) {
        audioRecordingModeChangeListener.getClass();
        x5 x5Var = this.a;
        x5Var.getClass();
        audioRecordingModeChangeListener.getClass();
        x5Var.b.b(audioRecordingModeChangeListener);
    }
}
