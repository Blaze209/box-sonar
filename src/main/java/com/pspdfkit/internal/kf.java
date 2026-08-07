package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class kf {
    public final o4.b a;
    public final int b;

    public kf(int i) {
        this.a = null;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kf)) {
            return false;
        }
        kf kfVar = (kf) obj;
        return this.a == kfVar.a && this.b == kfVar.b;
    }

    public final int hashCode() {
        o4.b bVar = this.a;
        return Integer.hashCode(this.b) + ((bVar == null ? 0 : bVar.hashCode()) * 31);
    }

    public final String toString() {
        return "EditModeHandle(scaleHandle=" + this.a + ", editHandle=" + this.b + ")";
    }

    public kf(o4.b bVar, int i) {
        this.a = (i & 1) != 0 ? null : bVar;
        this.b = -1;
    }
}
