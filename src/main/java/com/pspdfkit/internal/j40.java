package com.pspdfkit.internal;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j40 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Drawable f;

    public j40(int i, int i2, int i3, int i4, int i5, Drawable drawable) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = drawable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j40)) {
            return false;
        }
        j40 j40Var = (j40) obj;
        return this.a == j40Var.a && this.b == j40Var.b && this.c == j40Var.c && this.d == j40Var.d && this.e == j40Var.e && Intrinsics.areEqual(this.f, j40Var.f);
    }

    public final int hashCode() {
        int iA = nd.a(this.e, nd.a(this.d, nd.a(this.c, nd.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31);
        Drawable drawable = this.f;
        return iA + (drawable == null ? 0 : drawable.hashCode());
    }

    public final String toString() {
        return "StampPickerStyling(primaryColor=" + this.a + ", textColor=" + this.b + ", hintColor=" + this.c + ", customStampAcceptIconBackgroundColor=" + this.d + ", customStampAcceptIconColor=" + this.e + ", customStampAcceptIcon=" + this.f + ")";
    }
}
