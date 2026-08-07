package com.pspdfkit.internal;

import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.EraserToolConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public final class mg extends g1<EraserToolConfiguration.Builder> implements EraserToolConfiguration.Builder {
    public mg() {
        super(AnnotationProperty.THICKNESS);
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final EraserToolConfiguration build() {
        j1 j1Var = this.a;
        i1<Float> i1Var = i1.k;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        if (((Float) obj) == null) {
            j1 j1Var2 = this.a;
            Float fValueOf = Float.valueOf(13.0f);
            j1Var2.getClass();
            j1Var2.a.put(i1Var, fValueOf);
        }
        j1 j1Var3 = this.a;
        i1<Float> i1Var2 = i1.l;
        j1Var3.getClass();
        Object obj2 = j1Var3.a.get(i1Var2);
        if (((Float) (obj2 != null ? obj2 : null)) == null) {
            j1 j1Var4 = this.a;
            Float fValueOf2 = Float.valueOf(1.0f);
            j1Var4.getClass();
            j1Var4.a.put(i1Var2, fValueOf2);
        }
        return new kg(this.a);
    }
}
