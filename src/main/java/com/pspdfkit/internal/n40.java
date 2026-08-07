package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n40 {
    public static final boolean a(m40 m40Var, Annotation annotation) {
        m40Var.getClass();
        annotation.getClass();
        return m40Var.k.contains(annotation.getType()) || m40Var.l.contains(annotation) || !ww.h(annotation);
    }

    public static final m40 a(m40 m40Var, List<Integer> list) {
        m40Var.getClass();
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Number) obj).intValue() != Integer.MIN_VALUE) {
                arrayList.add(obj);
            }
        }
        List listSorted = CollectionsKt.sorted(CollectionsKt.distinct(arrayList));
        return Intrinsics.areEqual(m40Var.n, listSorted) ? m40Var : m40.a(m40Var, false, null, 0.0f, false, false, null, null, listSorted, 8191);
    }
}
