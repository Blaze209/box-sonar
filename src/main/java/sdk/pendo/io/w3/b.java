package sdk.pendo.io.w3;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T, C extends Collection<? super T>> extends sdk.pendo.io.w3.a<T, C> {
    final int c;
    final int d;
    final Callable<C> e;

    static final class a<T, C extends Collection<? super T>> implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super C> a;
        final Callable<C> b;
        final int c;
        C d;
        sdk.pendo.io.j3.c e;
        boolean f;
        int g;

        a(sdk.pendo.io.j3.b<? super C> bVar, int i, Callable<C> callable) {
            this.a = bVar;
            this.c = i;
            this.b = callable;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.e, cVar)) {
                this.e = cVar;
                this.a.a(this);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.e.cancel();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            C c = this.d;
            if (c != null && !c.isEmpty()) {
                this.a.onNext(c);
            }
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.f) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.f = true;
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            C c = this.d;
            if (c == null) {
                try {
                    c = (C) sdk.pendo.io.s3.b.a(this.b.call(), "The bufferSupplier returned a null buffer");
                    this.d = c;
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.g + 1;
            if (i != this.c) {
                this.g = i;
                return;
            }
            this.g = 0;
            this.d = null;
            this.a.onNext(c);
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                this.e.request(sdk.pendo.io.d4.d.b(j, this.c));
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.w3.b$b, reason: collision with other inner class name */
    static final class C0506b<T, C extends Collection<? super T>> extends AtomicLong implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c, sdk.pendo.io.q3.d {
        final sdk.pendo.io.j3.b<? super C> a;
        final Callable<C> b;
        final int c;
        final int d;
        sdk.pendo.io.j3.c g;
        boolean h;
        int i;
        volatile boolean j;
        long k;
        final AtomicBoolean f = new AtomicBoolean();
        final ArrayDeque<C> e = new ArrayDeque<>();

        C0506b(sdk.pendo.io.j3.b<? super C> bVar, int i, int i2, Callable<C> callable) {
            this.a = bVar;
            this.c = i;
            this.d = i2;
            this.b = callable;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.g, cVar)) {
                this.g = cVar;
                this.a.a(this);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.j = true;
            this.g.cancel();
        }

        @Override // sdk.pendo.io.q3.d
        public boolean getAsBoolean() {
            return this.j;
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            long j = this.k;
            if (j != 0) {
                sdk.pendo.io.d4.d.c(this, j);
            }
            sdk.pendo.io.d4.m.a(this.a, this.e, this, this);
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.h) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.h = true;
            this.e.clear();
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.e;
            int i = this.i;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((C) ((Collection) sdk.pendo.io.s3.b.a(this.b.call(), "The bufferSupplier returned a null buffer")));
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            C cPeek = arrayDeque.peek();
            if (cPeek != null && cPeek.size() + 1 == this.c) {
                arrayDeque.poll();
                cPeek.add(t);
                this.k++;
                this.a.onNext(cPeek);
            }
            Iterator<C> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().add(t);
            }
            if (i2 == this.d) {
                i2 = 0;
            }
            this.i = i2;
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            long jB;
            if (!sdk.pendo.io.c4.c.b(j) || sdk.pendo.io.d4.m.b(j, this.a, this.e, this, this)) {
                return;
            }
            if (this.f.get() || !this.f.compareAndSet(false, true)) {
                jB = sdk.pendo.io.d4.d.b(this.d, j);
            } else {
                jB = sdk.pendo.io.d4.d.a(this.c, sdk.pendo.io.d4.d.b(this.d, j - 1));
            }
            this.g.request(jB);
        }
    }

    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super C> a;
        final Callable<C> b;
        final int c;
        final int d;
        C e;
        sdk.pendo.io.j3.c f;
        boolean g;
        int h;

        c(sdk.pendo.io.j3.b<? super C> bVar, int i, int i2, Callable<C> callable) {
            this.a = bVar;
            this.c = i;
            this.d = i2;
            this.b = callable;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.f, cVar)) {
                this.f = cVar;
                this.a.a(this);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            this.f.cancel();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            C c = this.e;
            this.e = null;
            if (c != null) {
                this.a.onNext(c);
            }
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            if (this.g) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.g = true;
            this.e = null;
            this.a.onError(th);
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            C c = this.e;
            int i = this.h;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) sdk.pendo.io.s3.b.a(this.b.call(), "The bufferSupplier returned a null buffer");
                    this.e = c;
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.c) {
                    this.e = null;
                    this.a.onNext(c);
                }
            }
            if (i2 == this.d) {
                i2 = 0;
            }
            this.h = i2;
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.f.request(sdk.pendo.io.d4.d.b(this.d, j));
                    return;
                }
                this.f.request(sdk.pendo.io.d4.d.a(sdk.pendo.io.d4.d.b(j, this.c), sdk.pendo.io.d4.d.b(this.d - this.c, j - 1)));
            }
        }
    }

    public b(sdk.pendo.io.k3.d<T> dVar, int i, int i2, Callable<C> callable) {
        super(dVar);
        this.c = i;
        this.d = i2;
        this.e = callable;
    }

    @Override // sdk.pendo.io.k3.d
    public void b(sdk.pendo.io.j3.b<? super C> bVar) {
        int i = this.c;
        int i2 = this.d;
        if (i == i2) {
            this.b.a((sdk.pendo.io.k3.e) new a(bVar, i, this.e));
        } else if (i2 > i) {
            this.b.a((sdk.pendo.io.k3.e) new c(bVar, this.c, this.d, this.e));
        } else {
            this.b.a((sdk.pendo.io.k3.e) new C0506b(bVar, this.c, this.d, this.e));
        }
    }
}
