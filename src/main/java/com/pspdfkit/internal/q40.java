package com.pspdfkit.internal;

import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q40 {
    public final lm a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public p40 f;
    public int g;
    public final LinkedHashMap h = new LinkedHashMap();
    public final ArrayList i = new ArrayList();

    public q40(lm lmVar) {
        this.a = lmVar;
    }

    public final Size a(int i) {
        if (!this.h.containsKey(Integer.valueOf(i))) {
            p40 p40Var = this.f;
            p40 p40Var2 = null;
            if (p40Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnailBarThemeConfiguration");
                p40Var = null;
            }
            if (p40Var.c) {
                Size pageSize = this.a.getPageSize(i);
                pageSize.getClass();
                float f = pageSize.width / pageSize.height;
                LinkedHashMap linkedHashMap = this.h;
                Integer numValueOf = Integer.valueOf(i);
                p40 p40Var3 = this.f;
                if (p40Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailBarThemeConfiguration");
                    p40Var3 = null;
                }
                float f2 = p40Var3.b * f;
                p40 p40Var4 = this.f;
                if (p40Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailBarThemeConfiguration");
                } else {
                    p40Var2 = p40Var4;
                }
                linkedHashMap.put(numValueOf, new Size(f2, p40Var2.b));
            } else {
                LinkedHashMap linkedHashMap2 = this.h;
                Integer numValueOf2 = Integer.valueOf(i);
                p40 p40Var5 = this.f;
                if (p40Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailBarThemeConfiguration");
                    p40Var5 = null;
                }
                float f3 = p40Var5.a;
                p40 p40Var6 = this.f;
                if (p40Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnailBarThemeConfiguration");
                } else {
                    p40Var2 = p40Var6;
                }
                linkedHashMap2.put(numValueOf2, new Size(f3, p40Var2.b));
            }
        }
        return (Size) MapsKt.getValue(this.h, Integer.valueOf(i));
    }
}
