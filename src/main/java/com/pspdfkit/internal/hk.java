package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.InkAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class hk extends h1<InkAnnotationConfiguration.Builder> implements InkAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk(Context context) {
        super(context, AnnotationTool.INK, AnnotationProperty.COLOR, AnnotationProperty.FILL_COLOR, AnnotationProperty.THICKNESS, AnnotationProperty.ANNOTATION_NOTE, AnnotationProperty.ANNOTATION_ALPHA);
        context.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new ik(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final InkAnnotationConfiguration build() {
        a();
        return new ik(this.a);
    }
}
