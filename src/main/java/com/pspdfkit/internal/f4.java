package com.pspdfkit.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f4 {
    public final int a;
    public final int b;
    public final String c;

    public f4(int i) {
        this.a = i;
        this.c = null;
        this.b = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f4)) {
            return false;
        }
        f4 f4Var = (f4) obj;
        return this.a == f4Var.a && Intrinsics.areEqual(this.c, f4Var.c);
    }

    public final int hashCode() {
        int i = this.a * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        String str = this.c;
        if (str != null) {
            return "FormElement(fieldName=" + str + ")";
        }
        return "Annotation(objectNumber=" + this.a + ",generationNumber=" + this.b + ")";
    }

    public f4(String str) {
        str.getClass();
        this.a = 0;
        this.c = str;
        this.b = 0;
    }

    public f4(String str, int i, int i2) {
        this.a = i;
        this.c = str;
        this.b = i2;
    }
}
