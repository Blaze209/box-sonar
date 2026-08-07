package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class tw {
    public List<List<PointF>> a = new ArrayList();
    public List<RectF> b = new ArrayList();

    public static RectF a(List list) {
        if (list.isEmpty()) {
            return new RectF();
        }
        Iterator it = list.iterator();
        float fMax = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        float fMax2 = Float.MIN_VALUE;
        while (it.hasNext()) {
            PointF pointF = (PointF) it.next();
            fMin = Math.min(fMin, pointF.x);
            fMin2 = Math.min(fMin2, pointF.y);
            fMax = Math.max(fMax, pointF.x);
            fMax2 = Math.max(fMax2, pointF.y);
        }
        return new RectF(fMin, fMin2, fMax, fMax2);
    }

    public static PointF a(PointF pointF, PointF pointF2, PointF pointF3, float f, boolean z) {
        float f2 = f * f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        for (int i = 0; i < 10; i++) {
            float f5 = (f3 + f4) / 2.0f;
            float f6 = pointF.x;
            float f7 = ((pointF2.x - f6) * f5) + f6;
            float f8 = pointF.y;
            boolean z2 = a(new PointF(f7, ((pointF2.y - f8) * f5) + f8), pointF3) <= f2;
            if (!z ? !z2 : z2) {
                f3 = f5;
            } else {
                f4 = f5;
            }
        }
        float f9 = (f3 + f4) / 2.0f;
        float f10 = pointF.x;
        float f11 = ((pointF2.x - f10) * f9) + f10;
        float f12 = pointF.y;
        return new PointF(f11, ((pointF2.y - f12) * f9) + f12);
    }

    public static float a(PointF pointF, PointF pointF2) {
        pointF.getClass();
        pointF2.getClass();
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return (f2 * f2) + (f * f);
    }
}
