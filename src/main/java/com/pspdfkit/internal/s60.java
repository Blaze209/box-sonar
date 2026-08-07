package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class s60 {
    public static final float[] a = new float[2];

    public static float a(float f, Matrix matrix) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        return a(matrix2) * f;
    }

    public static void a(RectF rectF, Matrix matrix) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        float f = rectF.bottom;
        rectF.bottom = rectF.top;
        rectF.top = f;
    }

    public static Matrix a(RectF rectF, RectF rectF2) {
        float fWidth = rectF.width() / rectF2.width();
        float fHeight = rectF.height() / rectF2.height();
        if (Float.isInfinite(fWidth) || Float.isNaN(fWidth) || Float.isInfinite(fHeight) || Float.isNaN(fHeight)) {
            fWidth = 1.0f;
            fHeight = 1.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fWidth, fHeight);
        matrix.postTranslate(rectF.left - (rectF2.left * fWidth), rectF.bottom - (rectF2.bottom * fHeight));
        return matrix;
    }

    public static void a(PointF pointF, Matrix matrix) {
        float[] fArr = a;
        synchronized (fArr) {
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix.mapPoints(fArr);
            pointF.x = fArr[0];
            pointF.y = fArr[1];
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr[0];
    }
}
