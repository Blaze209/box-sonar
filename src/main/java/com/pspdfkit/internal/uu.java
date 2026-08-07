package com.pspdfkit.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class uu {
    public final int a;
    public final m40 b;
    public final int c;

    public uu() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uu)) {
            return false;
        }
        uu uuVar = (uu) obj;
        return this.a == uuVar.a && Intrinsics.areEqual(this.b, uuVar.b) && this.c == uuVar.c;
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        m40 m40Var = this.b;
        return Integer.hashCode(this.c) + ((iHashCode + (m40Var == null ? 0 : m40Var.hashCode())) * 31);
    }

    public final String toString() {
        return "PageViewScheme(maximumRenderPixelCount=" + this.a + ", state=" + this.b + ", backgroundColor=" + this.c + ")";
    }

    public uu(int i) {
        this.a = 0;
        this.b = null;
        this.c = -1;
    }

    public uu(int i, m40 m40Var, int i2) {
        this.a = i;
        this.b = m40Var;
        this.c = i2;
    }
}
