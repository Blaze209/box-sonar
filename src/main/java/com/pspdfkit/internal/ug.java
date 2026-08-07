package com.pspdfkit.internal;

import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.FileAnnotationConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public final class ug extends g1<FileAnnotationConfiguration.Builder> implements FileAnnotationConfiguration.Builder {
    public ug() {
        super(AnnotationProperty.ANNOTATION_NOTE);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final AnnotationConfiguration build() {
        return new vg(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final FileAnnotationConfiguration build() {
        return new vg(this.a);
    }
}
