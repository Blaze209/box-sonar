package com.pspdfkit.internal;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class lx {
    public static boolean a(RectF rectF, RectF rectF2) {
        return Math.abs(rectF.left - rectF2.left) < 1.0E-4f && Math.abs(rectF.top - rectF2.top) < 1.0E-4f && Math.abs(rectF.right - rectF2.right) < 1.0E-4f && Math.abs(rectF.bottom - rectF2.bottom) < 1.0E-4f;
    }
}
