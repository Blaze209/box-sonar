package com.pspdfkit.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public final class wo {
    public static final void a(vo voVar, Context context, float f, float f2, float f3) {
        voVar.getClass();
        context.getClass();
        float fE = voVar.e();
        float f4 = voVar.f();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = f4 - TypedValue.applyDimension(1, 20.0f, displayMetrics);
        if (voVar.e) {
            boolean z = voVar.h;
            voVar.h = true;
            if (voVar.d) {
                if (!z) {
                    voVar.c();
                    voVar.a(f, f2, fE, fApplyDimension, f3);
                    return;
                } else if (!voVar.p) {
                    voVar.b(f, f2, fE, fApplyDimension, f3);
                    return;
                } else {
                    voVar.j = f;
                    voVar.k = f2;
                    return;
                }
            }
            b50 b50Var = voVar.c;
            b50Var.k = fE;
            b50Var.l = fApplyDimension;
            b50Var.d = f3;
            b50Var.b.invalidate();
            voVar.c.a(f, f2);
            b50 b50Var2 = voVar.c;
            b50Var2.k = voVar.f;
            b50Var2.l = voVar.g;
        }
    }
}
