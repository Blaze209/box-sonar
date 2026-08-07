package com.pspdfkit.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ny {
    public final boolean a;
    public final boolean b;
    public final Function0<Unit> c;

    public ny(boolean z, boolean z2, Function0<Unit> function0) {
        this.a = z;
        this.b = z2;
        this.c = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ny)) {
            return false;
        }
        ny nyVar = (ny) obj;
        return this.a == nyVar.a && this.b == nyVar.b && Intrinsics.areEqual(this.c, nyVar.c);
    }

    public final int hashCode() {
        int iA = mv.a(this.b, Boolean.hashCode(this.a) * 31, 31);
        Function0<Unit> function0 = this.c;
        return iA + (function0 == null ? 0 : function0.hashCode());
    }

    public final String toString() {
        return "RefreshPageRenderingRequest(renderPageLayout=" + this.a + ", forceRenderNotVisiblePages=" + this.b + ", callback=" + this.c + ")";
    }
}
