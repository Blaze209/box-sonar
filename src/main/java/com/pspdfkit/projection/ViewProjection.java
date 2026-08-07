package com.pspdfkit.projection;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewProjection {
    Matrix getPageToViewTransformation(int i, Matrix matrix);

    Matrix getViewToPageTransformation(int i, Matrix matrix);

    void toPdfPoint(PointF pointF, int i);

    void toPdfRect(RectF rectF, int i);

    void toViewPoint(PointF pointF, int i);

    void toViewRect(RectF rectF, int i);
}
