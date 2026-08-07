package com.pspdfkit.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rp {
    public final String a;
    public final float b;

    public rp(String str, float f) {
        str.getClass();
        this.a = str;
        this.b = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rp)) {
            return false;
        }
        rp rpVar = (rp) obj;
        return Intrinsics.areEqual(this.a, rpVar.a) && Float.compare(this.b, rpVar.b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "MeasurementLabelValue(label=" + this.a + ", value=" + this.b + ")";
    }
}
