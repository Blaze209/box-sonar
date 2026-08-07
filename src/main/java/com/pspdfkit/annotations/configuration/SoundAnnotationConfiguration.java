package com.pspdfkit.annotations.configuration;

import com.pspdfkit.internal.f30;

/* JADX INFO: loaded from: classes3.dex */
public interface SoundAnnotationConfiguration extends AnnotationConfiguration {

    public interface Builder extends AnnotationConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        SoundAnnotationConfiguration build();

        Builder setAudioRecordingSampleRate(int i);

        Builder setAudioRecordingTimeLimit(int i);
    }

    static Builder builder() {
        return new f30();
    }

    int getAudioRecordingTimeLimit();

    int getRecordingSampleRate();
}
