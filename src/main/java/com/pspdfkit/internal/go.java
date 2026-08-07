package com.pspdfkit.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class go<T> implements Iterable<T> {
    public final CopyOnWriteArrayList<T> a;
    public final a<T> b;

    public interface a<T> {
        void a(go<T> goVar);
    }

    public go() {
        this(null);
    }

    public final void a(T t) {
        a<T> aVar;
        uw.a(t, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        synchronized (this.a) {
            if (this.a.addIfAbsent(t) && (aVar = this.b) != null) {
                aVar.a(this);
            }
        }
    }

    public final void addFirst(T t) {
        uw.a(t, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        synchronized (this.a) {
            if (this.a.contains(t)) {
                return;
            }
            this.a.add(0, t);
        }
    }

    public final void b(T t) {
        a<T> aVar;
        uw.a(t, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        synchronized (this.a) {
            if (this.a.remove(t) && (aVar = this.b) != null) {
                aVar.a(this);
            }
        }
    }

    public final void clear() {
        synchronized (this.a) {
            if (!this.a.isEmpty()) {
                this.a.clear();
                a<T> aVar = this.b;
                if (aVar != null) {
                    aVar.a(this);
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        Iterator<T> it;
        synchronized (this.a) {
            it = this.a.iterator();
        }
        return it;
    }

    public go(a<T> aVar) {
        this.a = new CopyOnWriteArrayList<>();
        this.b = aVar;
    }
}
