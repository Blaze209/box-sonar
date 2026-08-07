package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import com.pspdfkit.internal.mr;

/* JADX INFO: loaded from: classes3.dex */
public class UnknownAnnotation extends Annotation {
    private final AnnotationType type;

    public UnknownAnnotation(NativeAnnotationType nativeAnnotationType, j3 j3Var, boolean z) {
        super(j3Var, z);
        this.type = mr.a(nativeAnnotationType);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return this.type;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }
}
