package com.pspdfkit.annotations.appearance;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.providers.DataProvider;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface AppearanceStreamGenerator {

    public enum AppearanceStreamGenerationOptions {
        FLATTEN,
        PRINT
    }

    DataProvider getDataProviderForAnnotation(Annotation annotation, EnumSet<AppearanceStreamGenerationOptions> enumSet);

    boolean shouldUseGeneratorForAnnotation(Annotation annotation);
}
