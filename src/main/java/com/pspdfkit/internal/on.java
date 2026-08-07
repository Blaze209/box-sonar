package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationConfiguration;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import java.util.EnumSet;
import kotlin.NotImplementedError;

/* JADX INFO: loaded from: classes3.dex */
public abstract class on implements AnnotationConfiguration {
    public abstract AnnotationConfiguration a(Context context);

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration
    public final boolean getForceDefaults() {
        throw new NotImplementedError(null, 1, null);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration
    public final EnumSet<AnnotationProperty> getSupportedProperties() {
        throw new NotImplementedError(null, 1, null);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration
    public final boolean isZIndexEditingEnabled() {
        throw new NotImplementedError(null, 1, null);
    }
}
