package com.pspdfkit.internal;

import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.SoundAnnotationConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public final class f30 extends g1<SoundAnnotationConfiguration.Builder> implements SoundAnnotationConfiguration.Builder {
    public f30() {
        super(AnnotationProperty.ANNOTATION_NOTE);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        return new g30(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.SoundAnnotationConfiguration.Builder
    public final SoundAnnotationConfiguration.Builder setAudioRecordingSampleRate(int i) {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.H;
        Integer numValueOf = Integer.valueOf(i);
        j1Var.getClass();
        j1Var.a.put(i1Var, numValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.SoundAnnotationConfiguration.Builder
    public final SoundAnnotationConfiguration.Builder setAudioRecordingTimeLimit(int i) {
        j1 j1Var = this.a;
        i1<Integer> i1Var = i1.G;
        Integer numValueOf = Integer.valueOf(i);
        j1Var.getClass();
        j1Var.a.put(i1Var, numValueOf);
        return this;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final SoundAnnotationConfiguration build() {
        return new g30(this.a);
    }
}
