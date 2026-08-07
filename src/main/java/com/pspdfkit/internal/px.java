package com.pspdfkit.internal;

import com.pspdfkit.internal.nx;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public final class px<T extends nx> {
    public final int a;
    public final ArrayDeque b;

    public interface a<T> {
        T create();
    }

    public px(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxNumberOfRecycledItems must be >= 0");
        }
        this.a = i;
        this.b = new ArrayDeque(i);
    }

    public final T a(a<T> aVar) {
        synchronized (this.b) {
            if (this.b.isEmpty()) {
                return aVar.create();
            }
            return (T) this.b.pop();
        }
    }

    public final void a(T t) {
        t.recycle();
        synchronized (this.b) {
            this.b.push(t);
            while (this.b.size() > this.a) {
                this.b.pop();
            }
        }
    }
}
