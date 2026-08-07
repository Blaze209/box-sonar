package com.pspdfkit.internal;

import android.graphics.ColorMatrix;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class um {
    public static final Lazy a = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.um$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return um.a();
        }
    });

    public static final ColorMatrix a() {
        return new ColorMatrix(new float[]{-0.574f, 1.43f, 0.144f, 0.0f, 0.0f, 0.426f, 0.42999998f, 0.144f, 0.0f, 0.0f, 0.426f, 1.43f, -0.85599995f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }
}
