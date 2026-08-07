package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes4.dex */
final class q<Z> implements sdk.pendo.io.h.c<Z>, sdk.pendo.io.z.a.f {
    private static final Pools.Pool<q<?>> e = sdk.pendo.io.z.a.a(20, new a());
    private final sdk.pendo.io.z.c a = sdk.pendo.io.z.c.a();
    private sdk.pendo.io.h.c<Z> b;
    private boolean c;
    private boolean d;

    class a implements sdk.pendo.io.z.a.d<q<?>> {
        a() {
        }

        @Override // sdk.pendo.io.z.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q<?> a() {
            return new q<>();
        }
    }

    q() {
    }

    private void a(sdk.pendo.io.h.c<Z> cVar) {
        this.d = false;
        this.c = true;
        this.b = cVar;
    }

    @Override // sdk.pendo.io.z.a.f
    public sdk.pendo.io.z.c b() {
        return this.a;
    }

    synchronized void c() {
        this.a.b();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            recycle();
        }
    }

    @Override // sdk.pendo.io.h.c
    public Z get() {
        return this.b.get();
    }

    @Override // sdk.pendo.io.h.c
    public Class<Z> getResourceClass() {
        return this.b.getResourceClass();
    }

    @Override // sdk.pendo.io.h.c
    public int getSize() {
        return this.b.getSize();
    }

    @Override // sdk.pendo.io.h.c
    public synchronized void recycle() {
        this.a.b();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            a();
        }
    }

    private void a() {
        this.b = null;
        e.release(this);
    }

    static <Z> q<Z> b(sdk.pendo.io.h.c<Z> cVar) {
        q<Z> qVar = (q) sdk.pendo.io.y.k.a(e.acquire());
        qVar.a(cVar);
        return qVar;
    }
}
