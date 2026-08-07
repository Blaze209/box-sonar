package sdk.pendo.io.z3;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.t3.f;

/* JADX INFO: loaded from: classes6.dex */
public final class a<T> implements f<T> {
    private final AtomicReference<C0542a<T>> a = new AtomicReference<>();
    private final AtomicReference<C0542a<T>> b = new AtomicReference<>();

    /* JADX INFO: renamed from: sdk.pendo.io.z3.a$a, reason: collision with other inner class name */
    static final class C0542a<E> extends AtomicReference<C0542a<E>> {
        private E a;

        C0542a() {
        }

        C0542a(E e) {
            a(e);
        }

        public E a() {
            E eB = b();
            a((Object) null);
            return eB;
        }

        public E b() {
            return this.a;
        }

        public C0542a<E> c() {
            return get();
        }

        public void a(C0542a<E> c0542a) {
            lazySet(c0542a);
        }

        public void a(E e) {
            this.a = e;
        }
    }

    public a() {
        C0542a<T> c0542a = new C0542a<>();
        a(c0542a);
        b(c0542a);
    }

    C0542a<T> a() {
        return this.b.get();
    }

    C0542a<T> b() {
        return this.b.get();
    }

    C0542a<T> c() {
        return this.a.get();
    }

    @Override // sdk.pendo.io.t3.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // sdk.pendo.io.t3.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // sdk.pendo.io.t3.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0542a<T> c0542a = new C0542a<>(t);
        b(c0542a).a(c0542a);
        return true;
    }

    @Override // sdk.pendo.io.t3.f, sdk.pendo.io.t3.g
    public T poll() {
        C0542a<T> c0542aA = a();
        C0542a<T> c0542aC = c0542aA.c();
        if (c0542aC == null) {
            if (c0542aA == c()) {
                return null;
            }
            do {
                c0542aC = c0542aA.c();
            } while (c0542aC == null);
        }
        T tA = c0542aC.a();
        a(c0542aC);
        return tA;
    }

    void a(C0542a<T> c0542a) {
        this.b.lazySet(c0542a);
    }

    C0542a<T> b(C0542a<T> c0542a) {
        return this.a.getAndSet(c0542a);
    }
}
