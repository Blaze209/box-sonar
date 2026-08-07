package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x30 {
    public final List<StampPickerItem> a;
    public final PointF b;
    public final int c;
    public final boolean d;

    public x30() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x30)) {
            return false;
        }
        x30 x30Var = (x30) obj;
        return Intrinsics.areEqual(this.a, x30Var.a) && Intrinsics.areEqual(this.b, x30Var.b) && this.c == x30Var.c && this.d == x30Var.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        PointF pointF = this.b;
        return Boolean.hashCode(this.d) + nd.a(this.c, (iHashCode + (pointF == null ? 0 : pointF.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "StampData(items=" + this.a + ", touchedPoint=" + this.b + ", pageIndex=" + this.c + ", isCustomCreatorOpen=" + this.d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x30(List<? extends StampPickerItem> list, PointF pointF, int i, boolean z) {
        list.getClass();
        this.a = list;
        this.b = pointF;
        this.c = i;
        this.d = z;
    }

    public /* synthetic */ x30(int i) {
        this(CollectionsKt.emptyList(), null, -1, false);
    }
}
