package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.NoteAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class wr extends h1<NoteAnnotationConfiguration.Builder> implements NoteAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr(Context context) {
        super(context, AnnotationTool.NOTE, AnnotationProperty.COLOR, AnnotationProperty.NOTE_ICON);
        context.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new xr(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final NoteAnnotationConfiguration build() {
        a();
        return new xr(this.a);
    }
}
