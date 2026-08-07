package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class tm {
    public static final tm c = new tm(0, 0);
    public final int a;
    public final int b;

    public tm(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size not allowed. width was " + i + ", height was " + i2 + ".");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tm)) {
            return false;
        }
        tm tmVar = (tm) obj;
        return this.a == tmVar.a && this.b == tmVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "InternalSize(width=" + this.a + ", height=" + this.b + ")";
    }
}
