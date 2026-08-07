package com.pspdfkit.internal;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class qu {
    public final int a;
    public final RectF b;

    public qu(int i, RectF rectF) {
        this.a = i;
        this.b = rectF;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qu)) {
            return false;
        }
        qu quVar = (qu) obj;
        return this.a == quVar.a && Intrinsics.areEqual(this.b, quVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "PageTextBlockResolution(pageIndex=" + this.a + ", rect=" + this.b + ")";
    }
}
