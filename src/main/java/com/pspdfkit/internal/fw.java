package com.pspdfkit.internal;

import com.pspdfkit.annotations.AnnotationType;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class fw {
    @JvmStatic
    public static final String a(AnnotationType annotationType) {
        annotationType.getClass();
        return "annotation_rendering(" + annotationType.name() + ")";
    }
}
