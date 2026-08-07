package external.sdk.pendo.io.glide.load.engine;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class m<Z> implements sdk.pendo.io.h.c<Z> {
    private final boolean a;
    private final boolean b;
    private final sdk.pendo.io.h.c<Z> c;
    private final a d;
    private final sdk.pendo.io.e.f e;
    private int f;
    private boolean g;

    interface a {
        void onResourceReleased(sdk.pendo.io.e.f fVar, m<?> mVar);
    }

    m(sdk.pendo.io.h.c<Z> cVar, boolean z, boolean z2, sdk.pendo.io.e.f fVar, a aVar) {
        this.c = (sdk.pendo.io.h.c) sdk.pendo.io.y.k.a(cVar);
        this.a = z;
        this.b = z2;
        this.e = fVar;
        this.d = (a) sdk.pendo.io.y.k.a(aVar);
    }

    synchronized void a() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    sdk.pendo.io.h.c<Z> b() {
        return this.c;
    }

    boolean c() {
        return this.a;
    }

    void d() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.d.onResourceReleased(this.e, this);
        }
    }

    @Override // sdk.pendo.io.h.c
    public Z get() {
        return this.c.get();
    }

    @Override // sdk.pendo.io.h.c
    public Class<Z> getResourceClass() {
        return this.c.getResourceClass();
    }

    @Override // sdk.pendo.io.h.c
    public int getSize() {
        return this.c.getSize();
    }

    @Override // sdk.pendo.io.h.c
    public synchronized void recycle() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
