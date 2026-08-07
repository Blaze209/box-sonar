package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.FreeTextAnnotationConfiguration;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class hi extends h1<FreeTextAnnotationConfiguration.Builder> implements FreeTextAnnotationConfiguration.Builder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hi(Context context) {
        super(context, AnnotationTool.FREETEXT, AnnotationProperty.COLOR, AnnotationProperty.FILL_COLOR, AnnotationProperty.TEXT_SIZE, AnnotationProperty.ANNOTATION_ALPHA, AnnotationProperty.THICKNESS, AnnotationProperty.BORDER_STYLE, AnnotationProperty.LINE_ENDS, AnnotationProperty.ANNOTATION_NOTE, AnnotationProperty.FONT);
        context.getClass();
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        a();
        return new ii(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final FreeTextAnnotationConfiguration build() {
        a();
        return new ii(this.a);
    }
}
