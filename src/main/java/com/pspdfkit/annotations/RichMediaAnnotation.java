package com.pspdfkit.annotations;

import com.pspdfkit.internal.j3;

/* JADX INFO: loaded from: classes3.dex */
public class RichMediaAnnotation extends MediaAnnotation {
    public RichMediaAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z, str);
    }

    @Override // com.pspdfkit.annotations.LinkAnnotation, com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.RICHMEDIA;
    }
}
