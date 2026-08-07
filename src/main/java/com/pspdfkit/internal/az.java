package com.pspdfkit.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class az {
    public final int a;
    public final v7 b;
    public final float c;
    public final Rect d;

    public az() {
        this(0);
    }

    public static az a(az azVar, int i, v7 v7Var, int i2) {
        if ((i2 & 2) != 0) {
            v7Var = azVar.b;
        }
        return new az(i, v7Var, azVar.c, azVar.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        return this.a == azVar.a && Intrinsics.areEqual(this.b, azVar.b) && Float.compare(this.c, azVar.c) == 0 && Intrinsics.areEqual(this.d, azVar.d);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        v7 v7Var = this.b;
        int iA = kv.a(this.c, (iHashCode + (v7Var == null ? 0 : v7Var.hashCode())) * 31, 31);
        Rect rect = this.d;
        return iA + (rect != null ? rect.hashCode() : 0);
    }

    public final String toString() {
        return "RenderingState(state=" + this.a + ", bitmap=" + this.b + ", zoom=" + this.c + ", viewportUnscaled=" + this.d + ")";
    }

    public az(int i, v7 v7Var, float f, Rect rect) {
        this.a = i;
        this.b = v7Var;
        this.c = f;
        this.d = rect;
    }

    public /* synthetic */ az(int i) {
        this(0, null, 0.0f, null);
    }
}
