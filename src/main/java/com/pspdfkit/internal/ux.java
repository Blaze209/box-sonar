package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.RedactionAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class ux extends h1<RedactionAnnotationConfiguration.Builder> implements RedactionAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ux(Context context) {
        super(context, AnnotationTool.REDACTION, AnnotationProperty.COLOR, AnnotationProperty.FILL_COLOR, AnnotationProperty.OUTLINE_COLOR, AnnotationProperty.REPEAT_OVERLAY_TEXT, AnnotationProperty.OVERLAY_TEXT, AnnotationProperty.ANNOTATION_NOTE);
        context.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new vx(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final RedactionAnnotationConfiguration build() {
        a();
        return new vx(this.a);
    }
}
