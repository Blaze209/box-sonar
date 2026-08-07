package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public final class o70 {
    public static final pu a(au auVar, int i, int i2) {
        m40 state = auVar.getState();
        if (state == null) {
            return null;
        }
        Matrix matrixA = auVar.a((Matrix) null);
        PointF pointF = new PointF(i, i2);
        Matrix matrix = new Matrix();
        matrixA.invert(matrix);
        s60.a(pointF, matrix);
        Context context = auVar.getContext();
        context.getClass();
        return new pu(state.a, state.b, new Matrix(matrixA), new PointF(pointF.x, pointF.y), (int) un.a(context, 1, 4));
    }
}
