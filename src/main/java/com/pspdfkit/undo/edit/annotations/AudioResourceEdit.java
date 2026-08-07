package com.pspdfkit.undo.edit.annotations;

import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.EmbeddedAudioSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AudioResourceEdit;", "Lcom/pspdfkit/undo/edit/annotations/AnnotationEdit;", "annotation", "Lcom/pspdfkit/annotations/SoundAnnotation;", "<init>", "(Lcom/pspdfkit/annotations/SoundAnnotation;)V", "audioData", "Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "getAudioData", "()Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "setAudioData", "(Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioResourceEdit extends AnnotationEdit {
    public static final int $stable = 8;
    private EmbeddedAudioSource audioData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioResourceEdit(SoundAnnotation soundAnnotation) {
        super(soundAnnotation.getPageIndex(), soundAnnotation.getObjectNumber());
        soundAnnotation.getClass();
        byte[] audioData = soundAnnotation.getAudioData();
        if (audioData != null) {
            this.audioData = new EmbeddedAudioSource(audioData, soundAnnotation.getAudioEncoding(), soundAnnotation.getSampleRate(), soundAnnotation.getSampleSize(), soundAnnotation.getChannels(), (String) null);
        } else {
            this.audioData = null;
        }
    }

    public final EmbeddedAudioSource getAudioData() {
        return this.audioData;
    }

    public final void setAudioData(EmbeddedAudioSource embeddedAudioSource) {
        this.audioData = embeddedAudioSource;
    }
}
