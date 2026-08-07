package com.horcrux.svg;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes14.dex */
class ViewBox {
    private static final int MOS_MEET = 0;
    private static final int MOS_NONE = 2;
    private static final int MOS_SLICE = 1;

    ViewBox() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0097  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c6  */
    static Matrix getTransform(RectF rectF, RectF rectF2, String str, int i) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = rectF.left;
        double d7 = rectF.top;
        double dWidth = rectF.width();
        double dHeight = rectF.height();
        double d8 = rectF2.left;
        double d9 = rectF2.top;
        double dWidth2 = rectF2.width();
        double dHeight2 = rectF2.height();
        double dMax = dWidth2 / dWidth;
        double d10 = dHeight2 / dHeight;
        double d11 = d8 - (d6 * dMax);
        double d12 = d9 - (d7 * d10);
        if (i == 2) {
            dMax = Math.min(dMax, d10);
            if (dMax > 1.0d) {
                d3 = d11 - (((dWidth2 / dMax) - dWidth) / 2.0d);
                d5 = (dHeight2 / dMax) - dHeight;
            } else {
                d3 = d11 - ((dWidth2 - (dWidth * dMax)) / 2.0d);
                d5 = dHeight2 - (dHeight * dMax);
            }
            d4 = d12 - (d5 / 2.0d);
            d10 = dMax;
        } else {
            if (!str.equals("none") && i == 0) {
                dMax = Math.min(dMax, d10);
            } else if (!str.equals("none") && i == 1) {
                dMax = Math.max(dMax, d10);
            } else {
                d = d8 - (d6 * dMax);
                d2 = d9 - (d7 * d10);
                if (str.contains("xMid")) {
                    d += (dWidth2 - (dWidth * dMax)) / 2.0d;
                }
                if (str.contains("xMax")) {
                    d += dWidth2 - (dWidth * dMax);
                }
                d3 = d;
                if (str.contains("YMid")) {
                    d2 += (dHeight2 - (dHeight * d10)) / 2.0d;
                }
                d4 = d2;
                if (str.contains("YMax")) {
                    d4 += dHeight2 - (dHeight * d10);
                }
            }
            d10 = dMax;
            d = d8 - (d6 * dMax);
            d2 = d9 - (d7 * d10);
            if (str.contains("xMid")) {
                d += (dWidth2 - (dWidth * dMax)) / 2.0d;
            }
            if (str.contains("xMax")) {
                d += dWidth2 - (dWidth * dMax);
            }
            d3 = d;
            if (str.contains("YMid")) {
                d2 += (dHeight2 - (dHeight * d10)) / 2.0d;
            }
            d4 = d2;
            if (str.contains("YMax")) {
                d4 += dHeight2 - (dHeight * d10);
            }
        }
        double d13 = d3;
        double d14 = d4;
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d13, (float) d14);
        matrix.preScale((float) dMax, (float) d10);
        return matrix;
    }
}
