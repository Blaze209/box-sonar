package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LinkAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public final class lq implements nf.a {
    @Override // com.pspdfkit.internal.nf.a
    public final boolean a(Annotation annotation) {
        annotation.getClass();
        return annotation instanceof LinkAnnotation;
    }
}
