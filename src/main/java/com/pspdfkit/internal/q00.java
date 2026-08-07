package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class q00 {
    public final int a;
    public final int b;

    public q00(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i < 0) {
            throw new IllegalArgumentException(("Selection start must be >= 0, got " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("Selection end must be >= start, got start=" + i + " end=" + i2).toString());
        }
    }

    public final boolean a() {
        return this.a == this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q00)) {
            return false;
        }
        q00 q00Var = (q00) obj;
        return this.a == q00Var.a && this.b == q00Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Selection(start=" + this.a + ", end=" + this.b + ")";
    }
}
