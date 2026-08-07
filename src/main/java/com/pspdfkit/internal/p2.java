package com.pspdfkit.internal;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 {
    public static final r2 a(ot otVar) {
        otVar.getClass();
        int i = otVar.a;
        int i2 = otVar.c;
        return new r2(i, i2, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, 100), -1), otVar.s, otVar.t, otVar.u, otVar.v, otVar.w);
    }
}
