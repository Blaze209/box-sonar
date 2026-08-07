package com.pspdfkit.annotations.configuration;

import com.pspdfkit.internal.ug;

/* JADX INFO: loaded from: classes3.dex */
public interface FileAnnotationConfiguration extends AnnotationConfiguration {

    public interface Builder extends AnnotationConfiguration.Builder<Builder> {
        @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
        FileAnnotationConfiguration build();
    }

    static Builder builder() {
        return new ug();
    }
}
