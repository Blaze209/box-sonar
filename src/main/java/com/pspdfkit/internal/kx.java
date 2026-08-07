package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class kx {
    public static final PointF a(RectF rectF) {
        rectF.getClass();
        float f = 2;
        return new PointF((rectF.left + rectF.right) / f, (rectF.top + rectF.bottom) / f);
    }

    public static final boolean a(RectF rectF, RectF rectF2) {
        rectF.getClass();
        rectF2.getClass();
        return rectF.left <= rectF2.right && rectF.top >= rectF2.bottom && rectF2.left <= rectF.right && rectF2.top >= rectF.bottom;
    }

    public static final boolean a(RectF rectF, float f, float f2) {
        rectF.getClass();
        float f3 = rectF.left;
        if (f > rectF.right || f3 > f) {
            return false;
        }
        return f2 <= rectF.top && rectF.bottom <= f2;
    }
}
