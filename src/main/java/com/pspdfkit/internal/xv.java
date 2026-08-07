package com.pspdfkit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class xv {
    public float a;
    public float b;
    public float c;
    public float d;

    public xv(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xv)) {
            return false;
        }
        xv xvVar = (xv) obj;
        return Float.compare(this.a, xvVar.a) == 0 && Float.compare(this.b, xvVar.b) == 0 && Float.compare(this.c, xvVar.c) == 0 && Float.compare(this.d, xvVar.d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + kv.a(this.c, kv.a(this.b, Float.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        return "PdfRect(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ")";
    }

    public /* synthetic */ xv(int i) {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
