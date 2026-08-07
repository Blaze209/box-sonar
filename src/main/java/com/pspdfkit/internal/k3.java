package com.pspdfkit.internal;

import androidx.collection.SparseArrayCompat;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k3 {
    public final SparseArrayCompat<Object> a;
    public final LinkedHashSet b;
    public a c;
    public boolean d;
    public boolean e;

    public interface a {
        void a(int i, Object obj, Object obj2);
    }

    public k3(int i) {
        SparseArrayCompat<Object> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = sparseArrayCompat;
        this.b = linkedHashSet;
    }

    public final synchronized boolean a(int i) {
        return this.a.get(i) != null;
    }

    public final synchronized void b() {
        a();
        this.d = false;
    }

    public final synchronized Set<Integer> c() {
        return CollectionsKt.toSet(this.b);
    }

    public final SparseArrayCompat<Object> d() {
        return this.a;
    }

    public final synchronized boolean e() {
        return !this.b.isEmpty();
    }

    public final boolean equals(Object obj) {
        return a(obj, SetsKt.emptySet());
    }

    public final synchronized boolean f() {
        return this.d;
    }

    public final int hashCode() {
        return a((Set<Integer>) null);
    }

    public final String toString() {
        this.a.size();
        return "AnnotationPropertyMap{" + this.a.toString() + "}";
    }

    public final void a(int i, Object obj, boolean z) {
        synchronized (this) {
            Object obj2 = this.a.get(i);
            if (!Intrinsics.areEqual(obj2, obj)) {
                SparseArrayCompat<Object> sparseArrayCompat = this.a;
                if (obj == null) {
                    sparseArrayCompat.remove(i);
                } else {
                    sparseArrayCompat.put(i, obj);
                }
                if (!this.e && z) {
                    this.b.add(Integer.valueOf(i));
                    this.d = true;
                    a aVar = this.c;
                    if (aVar != null) {
                        aVar.a(i, obj2, obj);
                    }
                }
            }
        }
    }

    public final synchronized void a() {
        this.b.clear();
    }

    public final int a(Set<Integer> set) {
        SparseArrayCompat<Object> sparseArrayCompat = this.a;
        int size = sparseArrayCompat.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArrayCompat.keyAt(i);
            Object objValueAt = sparseArrayCompat.valueAt(i);
            if (set == null || !set.contains(Integer.valueOf(iKeyAt))) {
                iHashCode = objValueAt.hashCode() + (((iHashCode * 37) + iKeyAt) * 37);
            }
        }
        return iHashCode;
    }

    public final boolean a(Object obj, Set<Integer> set) {
        set.getClass();
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k3)) {
            return false;
        }
        k3 k3Var = (k3) obj;
        if (this.a.size() != k3Var.a.size()) {
            return false;
        }
        SparseArrayCompat<Object> sparseArrayCompat = this.a;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArrayCompat.keyAt(i);
            Object objValueAt = sparseArrayCompat.valueAt(i);
            if (!set.contains(Integer.valueOf(iKeyAt)) && objValueAt != k3Var.a.get(iKeyAt) && !Intrinsics.areEqual(objValueAt, k3Var.a.get(iKeyAt))) {
                return false;
            }
        }
        return true;
    }
}
