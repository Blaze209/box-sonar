package com.pspdfkit.internal;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Typeface f;
    public final Typeface g;
    public final Typeface h;

    public r2(int i, int i2, int i3, int i4, int i5, Typeface typeface, Typeface typeface2, Typeface typeface3) {
        typeface.getClass();
        typeface2.getClass();
        typeface3.getClass();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = typeface;
        this.g = typeface2;
        this.h = typeface3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r2)) {
            return false;
        }
        r2 r2Var = (r2) obj;
        return this.a == r2Var.a && this.b == r2Var.b && this.c == r2Var.c && this.d == r2Var.d && this.e == r2Var.e && Intrinsics.areEqual(this.f, r2Var.f) && Intrinsics.areEqual(this.g, r2Var.g) && Intrinsics.areEqual(this.h, r2Var.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + nd.a(this.e, nd.a(this.d, nd.a(this.c, nd.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AnnotationListItemStyling(backgroundColor=" + this.a + ", defaultTextColor=" + this.b + ", defaultInfoTextColor=" + this.c + ", dragHandleIcon=" + this.d + ", dragHandleIconColor=" + this.e + ", labelsFontTypeface=" + this.f + ", titleFontTypeface=" + this.g + ", bodyFontTypeface=" + this.h + ")";
    }
}
