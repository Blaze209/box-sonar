package com.pspdfkit.utils;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.internal.ip;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfUtils {
    public static RectF boundingBoxFromLines(List<List<PointF>> list, float f) {
        Iterator<List<PointF>> it = list.iterator();
        boolean z = false;
        float fMin = Float.MAX_VALUE;
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin2 = Float.MAX_VALUE;
        while (it.hasNext()) {
            for (PointF pointF : it.next()) {
                fMin = Math.min(pointF.x, fMin);
                fMin2 = Math.min(pointF.y, fMin2);
                fMax2 = Math.max(pointF.x, fMax2);
                fMax = Math.max(pointF.y, fMax);
                z = true;
            }
        }
        if (!z) {
            return new RectF();
        }
        RectF rectF = new RectF(fMin, fMax, fMax2, fMin2);
        float f2 = f / 2.0f;
        rectF.left -= f2;
        rectF.top += f2;
        rectF.right += f2;
        rectF.bottom -= f2;
        return rectF;
    }

    public static RectF createPdfRectUnion(List<RectF> list) {
        return ip.a(list);
    }
}
