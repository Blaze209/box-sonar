package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.annotations.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public interface r4 extends f10 {
    Annotation a(int i, Matrix matrix, float f);

    default boolean a(Annotation annotation, Matrix matrix, float f) {
        return a(annotation, matrix, f, true);
    }

    boolean a(Annotation annotation, Matrix matrix, float f, boolean z);

    default boolean a(boolean z) {
        return false;
    }

    default boolean b() {
        return false;
    }

    boolean b(Annotation annotation, Matrix matrix, float f);

    default String d() {
        return null;
    }
}
