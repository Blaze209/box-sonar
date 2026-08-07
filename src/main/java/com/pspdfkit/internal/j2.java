package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j2<T> implements Comparator {
    public final /* synthetic */ i2 a;
    public final /* synthetic */ ArrayList b;

    public j2(i2 i2Var, ArrayList arrayList) {
        this.a = i2Var;
        this.b = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int iCompare = this.a.compare(t, t2);
        if (iCompare != 0) {
            return iCompare;
        }
        return ComparisonsKt.compareValues(Integer.valueOf(this.b.indexOf((Annotation) t)), Integer.valueOf(this.b.indexOf((Annotation) t2)));
    }
}
