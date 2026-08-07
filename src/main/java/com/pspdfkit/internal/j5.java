package com.pspdfkit.internal;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j5<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((fo) t).c()), Integer.valueOf(((fo) t2).c()));
    }
}
