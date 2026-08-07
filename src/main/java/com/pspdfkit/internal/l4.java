package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l4 {
    public static void a(Matrix matrix, PointF pointF) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        s60.a(pointF, matrix2);
    }
}
