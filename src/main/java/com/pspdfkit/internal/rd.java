package com.pspdfkit.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rd {
    public final boolean a;
    public final List<ld> b;
    public final boolean c;
    public final boolean d;

    public rd() {
        this(0);
    }

    public static rd a(rd rdVar, boolean z, List list, boolean z2, boolean z3, int i) {
        if ((i & 1) != 0) {
            z = rdVar.a;
        }
        if ((i & 2) != 0) {
            list = rdVar.b;
        }
        if ((i & 4) != 0) {
            z2 = rdVar.c;
        }
        if ((i & 8) != 0) {
            z3 = rdVar.d;
        }
        rdVar.getClass();
        list.getClass();
        return new rd(z, list, z2, z3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rd)) {
            return false;
        }
        rd rdVar = (rd) obj;
        return this.a == rdVar.a && Intrinsics.areEqual(this.b, rdVar.b) && this.c == rdVar.c && this.d == rdVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + mv.a(this.c, lv.a(this.b, Boolean.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        return "DocumentInfoState(isReadOnly=" + this.a + ", list=" + this.b + ", isInEditingMode=" + this.c + ", savedFailed=" + this.d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public rd(boolean z, List<? extends ld> list, boolean z2, boolean z3) {
        list.getClass();
        this.a = z;
        this.b = list;
        this.c = z2;
        this.d = z3;
    }

    public /* synthetic */ rd(int i) {
        this(true, CollectionsKt.emptyList(), false, false);
    }
}
