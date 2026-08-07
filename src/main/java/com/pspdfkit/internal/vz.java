package com.pspdfkit.internal;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class vz {
    public static final void a(RectF rectF, float f, float f2, Path path) {
        rectF.getClass();
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = rectF.right;
        float f6 = rectF.bottom;
        float fMax = Math.max(0.0f, Math.min(f, (f5 - f3) / 2.0f));
        float fMax2 = Math.max(0.0f, Math.min(f2, (f6 - f4) / 2.0f));
        Path path2 = path == null ? new Path() : path;
        if (fMax == 0.0f && fMax2 == 0.0f) {
            path2.moveTo(f3, f6);
            path2.lineTo(f3, f4);
            path2.lineTo(f5, f4);
            path2.lineTo(f5, f6);
            path2.close();
            return;
        }
        float f7 = 1 - 0.5522847f;
        float f8 = fMax * f7;
        float f9 = fMax2 * f7;
        float f10 = f3 + fMax;
        path2.moveTo(f10, f6);
        float f11 = f3 + f8;
        float f12 = f6 - f9;
        float f13 = f4 + fMax2;
        path2.cubicTo(f11, f6, f3, f12, f3, f13);
        path2.lineTo(f3, f13);
        float f14 = f4 + f9;
        path2.cubicTo(f3, f14, f11, f4, f10, f4);
        float f15 = f5 - fMax;
        path2.lineTo(f15, f4);
        float f16 = f5 - f8;
        path2.cubicTo(f16, f4, f5, f14, f5, f13);
        path2.lineTo(f5, f6 - fMax2);
        path2.cubicTo(f5, f12, f16, f6, f15, f6);
        path2.lineTo(f10, f6);
        path2.close();
    }
}
