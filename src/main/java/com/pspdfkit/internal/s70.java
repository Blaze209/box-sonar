package com.pspdfkit.internal;

import com.pspdfkit.internal.r4;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s70<T extends r4> extends o7<T> {
    public s70(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
    }

    public final BorderStylePreset x() {
        if (this.A.equals(AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.CLOUDY))) {
            return BorderStylePreset.CLOUDY;
        }
        return this.A.equals(AnnotationToolVariant.fromPreset(AnnotationToolVariant.Preset.DASHED)) ? BorderStylePreset.DASHED_3_3 : this.a.p.g;
    }
}
