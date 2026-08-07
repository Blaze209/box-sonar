package com.pspdfkit.internal;

import android.graphics.Point;
import android.util.Size;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class oy {
    public final Point a;
    public final Size b;

    public oy(Point point, Size size) {
        this.a = point;
        this.b = size;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oy)) {
            return false;
        }
        oy oyVar = (oy) obj;
        return Intrinsics.areEqual(this.a, oyVar.a) && Intrinsics.areEqual(this.b, oyVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "RegionRenderOptions(offset=" + this.a + ", fullPageSize=" + this.b + ")";
    }
}
