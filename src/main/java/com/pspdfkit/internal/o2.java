package com.pspdfkit.internal;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o2 {
    public final int a;
    public final int b;
    public final int c;
    public final Typeface d;

    public o2(int i, int i2, int i3, Typeface typeface) {
        typeface.getClass();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = typeface;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.a == o2Var.a && this.b == o2Var.b && this.c == o2Var.c && Intrinsics.areEqual(this.d, o2Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + nd.a(this.c, nd.a(this.b, Integer.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        return "AnnotationListBottomBarStyling(backgroundColor=" + this.a + ", iconColor=" + this.b + ", editingIcon=" + this.c + ", titleFontTypeface=" + this.d + ")";
    }
}
