package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public final HashMap<AnnotationTriggerEvent, Action> a;

    public p() {
        this((Object) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(p.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return Intrinsics.areEqual(this.a, ((p) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public p(int i) {
        this.a = new HashMap<>(i);
    }

    public p(Object obj) {
        this.a = new HashMap<>(0);
    }

    public p(Map<AnnotationTriggerEvent, ? extends Action> map) {
        HashMap<AnnotationTriggerEvent, Action> map2 = new HashMap<>(map.size());
        this.a = map2;
        map2.putAll(map);
    }
}
