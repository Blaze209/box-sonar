package com.pspdfkit.annotations.configuration;

import android.content.Context;
import com.pspdfkit.internal.wr;

/* JADX INFO: loaded from: classes3.dex */
public interface NoteAnnotationConfiguration extends AnnotationColorConfiguration, AnnotationNoteIconConfiguration {

    public interface Builder extends AnnotationColorConfiguration.Builder<Builder>, AnnotationNoteIconConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        NoteAnnotationConfiguration build();
    }

    static Builder builder(Context context) {
        return new wr(context);
    }
}
