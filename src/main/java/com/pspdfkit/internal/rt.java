package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rt {
    public final List<Integer> a;
    public final LinkedHashMap<Integer, Annotation> b;
    public final boolean c;

    public rt(List<Integer> list, LinkedHashMap<Integer, Annotation> linkedHashMap, boolean z) {
        list.getClass();
        this.a = list;
        this.b = linkedHashMap;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rt)) {
            return false;
        }
        rt rtVar = (rt) obj;
        return Intrinsics.areEqual(this.a, rtVar.a) && Intrinsics.areEqual(this.b, rtVar.b) && this.c == rtVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "OverlayRefreshComputation(overlayIds=" + this.a + ", visibleOverlayById=" + this.b + ", hasPageAnnotations=" + this.c + ")";
    }
}
