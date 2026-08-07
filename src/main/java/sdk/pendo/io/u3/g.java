package sdk.pendo.io.u3;

import sdk.pendo.io.d4.m;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g<T, U, V> extends i implements o<T>, sdk.pendo.io.d4.j<U, V> {
    protected final o<? super V> b;
    protected final sdk.pendo.io.t3.f<U> c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected Throwable f;

    public g(o<? super V> oVar, sdk.pendo.io.t3.f<U> fVar) {
        this.b = oVar;
        this.c = fVar;
    }

    @Override // sdk.pendo.io.d4.j
    public abstract void a(o<? super V> oVar, U u);

    @Override // sdk.pendo.io.d4.j
    public final boolean a() {
        return this.e;
    }

    @Override // sdk.pendo.io.d4.j
    public final boolean b() {
        return this.d;
    }

    @Override // sdk.pendo.io.d4.j
    public final Throwable c() {
        return this.f;
    }

    public final boolean d() {
        return this.a.getAndIncrement() == 0;
    }

    protected final void a(U u, boolean z, sdk.pendo.io.o3.b bVar) {
        o<? super V> oVar = this.b;
        sdk.pendo.io.t3.f<U> fVar = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            a(oVar, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            fVar.offer(u);
            if (!d()) {
                return;
            }
        }
        m.a(fVar, oVar, z, bVar, this);
    }

    @Override // sdk.pendo.io.d4.j
    public final int a(int i) {
        return this.a.addAndGet(i);
    }
}
