package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.projection.PdfProjection;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class wv implements PdfProjection {
    public final lm a;

    public wv(lm lmVar) {
        this.a = lmVar;
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final Matrix getNormalizedToRawTransformation(int i) {
        if (i >= 0) {
            lm lmVar = this.a;
            if (i < lmVar.s) {
                return lmVar.y.getPage(i).getPageInfo().getInversePageMatrix();
            }
        }
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "Transformation failed because of invalid page: %d", Integer.valueOf(i)));
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final Matrix getRawToNormalizedTransformation(int i) {
        if (i >= 0) {
            lm lmVar = this.a;
            if (i < lmVar.s) {
                return lmVar.y.getPage(i).getPageInfo().getPageMatrix();
            }
        }
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "Transformation failed because of invalid page: %d", Integer.valueOf(i)));
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final PointF toNormalizedPoint(PointF pointF, int i) {
        uw.a(pointF, "point", null);
        Matrix rawToNormalizedTransformation = getRawToNormalizedTransformation(i);
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        s60.a(pointF2, rawToNormalizedTransformation);
        return pointF2;
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final RectF toPdfRect(RectF rectF, int i) {
        uw.a(rectF, "rect", null);
        Matrix rawToNormalizedTransformation = getRawToNormalizedTransformation(i);
        RectF rectF2 = new RectF(rectF);
        float f = rectF2.bottom;
        float f2 = rectF2.top;
        if (f < f2) {
            rectF2.bottom = f2;
            rectF2.top = f;
        }
        rawToNormalizedTransformation.mapRect(rectF2);
        float f3 = rectF2.bottom;
        rectF2.bottom = rectF2.top;
        rectF2.top = f3;
        return rectF2;
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final PointF toRawPoint(PointF pointF, int i) {
        uw.a(pointF, "point", null);
        Matrix normalizedToRawTransformation = getNormalizedToRawTransformation(i);
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        s60.a(pointF2, normalizedToRawTransformation);
        return pointF2;
    }

    @Override // com.pspdfkit.projection.PdfProjection
    public final RectF toRawRect(RectF rectF, int i) {
        uw.a(rectF, "rect", null);
        Matrix normalizedToRawTransformation = getNormalizedToRawTransformation(i);
        RectF rectF2 = new RectF(rectF);
        float f = rectF2.bottom;
        float f2 = rectF2.top;
        if (f < f2) {
            rectF2.bottom = f2;
            rectF2.top = f;
        }
        normalizedToRawTransformation.mapRect(rectF2);
        float f3 = rectF2.bottom;
        rectF2.bottom = rectF2.top;
        rectF2.top = f3;
        return rectF2;
    }
}
