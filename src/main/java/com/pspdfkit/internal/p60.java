package com.pspdfkit.internal;

import com.pspdfkit.utils.Size;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p60 {
    public final int a;
    public final int b;
    public final Size c;

    public p60(int i, int i2, Size size) {
        size.getClass();
        this.a = i;
        this.b = i2;
        this.c = size;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p60)) {
            return false;
        }
        p60 p60Var = (p60) obj;
        return this.a == p60Var.a && this.b == p60Var.b && Intrinsics.areEqual(this.c, p60Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + nd.a(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        return "ThumbnailPosition(pageIndex=" + this.a + ", thumbnailPositionX=" + this.b + ", thumbnailSize=" + this.c + ")";
    }
}
