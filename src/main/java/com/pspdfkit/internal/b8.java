package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class b8 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public b8(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b8)) {
            return false;
        }
        b8 b8Var = (b8) obj;
        return this.a == b8Var.a && this.b == b8Var.b && this.c == b8Var.c && this.d == b8Var.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + nd.a(this.c, nd.a(this.b, Integer.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        return "BookmarkListBottomBarStyling(backgroundColor=" + this.a + ", addIcon=" + this.b + ", editingIcon=" + this.c + ", iconColor=" + this.d + ")";
    }
}
