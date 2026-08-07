package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class pu {
    public final lm a;
    public final int b;
    public final Matrix c;
    public final PointF d;
    public final float e;

    public pu(lm lmVar, int i, Matrix matrix, PointF pointF, float f) {
        this.a = lmVar;
        this.b = i;
        this.c = matrix;
        this.d = pointF;
        this.e = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pu)) {
            return false;
        }
        pu puVar = (pu) obj;
        return Intrinsics.areEqual(this.a, puVar.a) && this.b == puVar.b && Intrinsics.areEqual(this.c, puVar.c) && Intrinsics.areEqual(this.d, puVar.d) && Float.compare(this.e, puVar.e) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.e) + ((this.d.hashCode() + ((this.c.hashCode() + nd.a(this.b, this.a.hashCode() * 31, 31)) * 31)) * 31);
    }

    public final String toString() {
        return "PageTextBlockLookupRequest(document=" + this.a + ", pageIndex=" + this.b + ", pdfToPageViewMatrix=" + this.c + ", pdfPoint=" + this.d + ", tolerance=" + this.e + ")";
    }
}
