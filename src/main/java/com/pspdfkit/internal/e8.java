package com.pspdfkit.internal;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e8 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Typeface e;
    public final Typeface f;
    public final Typeface g;

    public e8(int i, int i2, int i3, int i4, Typeface typeface, Typeface typeface2, Typeface typeface3) {
        typeface.getClass();
        typeface2.getClass();
        typeface3.getClass();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = typeface;
        this.f = typeface2;
        this.g = typeface3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e8)) {
            return false;
        }
        e8 e8Var = (e8) obj;
        return this.a == e8Var.a && this.b == e8Var.b && this.c == e8Var.c && this.d == e8Var.d && Intrinsics.areEqual(this.e, e8Var.e) && Intrinsics.areEqual(this.f, e8Var.f) && Intrinsics.areEqual(this.g, e8Var.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + nd.a(this.d, nd.a(this.c, nd.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31)) * 31)) * 31);
    }

    public final String toString() {
        return "BookmarkListItemStyling(dragHandleIcon=" + this.a + ", defaultTextColor=" + this.b + ", defaultSubTextColor=" + this.c + ", accentColor=" + this.d + ", labelsFontTypeface=" + this.e + ", titleFontTypeface=" + this.f + ", bodyFontTypeface=" + this.g + ")";
    }
}
