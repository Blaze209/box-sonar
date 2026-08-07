package com.pspdfkit.projection;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfProjection {
    Matrix getNormalizedToRawTransformation(int i);

    Matrix getRawToNormalizedTransformation(int i);

    PointF toNormalizedPoint(PointF pointF, int i);

    RectF toPdfRect(RectF rectF, int i);

    PointF toRawPoint(PointF pointF, int i);

    RectF toRawRect(RectF rectF, int i);
}
