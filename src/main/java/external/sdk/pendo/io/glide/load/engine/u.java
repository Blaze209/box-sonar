package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class u implements e, e.a {
    private final f<?> a;
    private final e.a b;
    private volatile int c;
    private volatile b d;
    private volatile Object e;
    private volatile external.sdk.pendo.io.glide.load.model.b.a<?> f;
    private volatile c g;

    class a implements external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<Object> {
        final /* synthetic */ external.sdk.pendo.io.glide.load.model.b.a a;

        a(external.sdk.pendo.io.glide.load.model.b.a aVar) {
            this.a = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
        public void a(Object obj) {
            if (u.this.a(this.a)) {
                u.this.a(this.a, obj);
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
        public void a(Exception exc) {
            if (u.this.a(this.a)) {
                u.this.a(this.a, exc);
            }
        }
    }

    u(f<?> fVar, e.a aVar) {
        this.a = fVar;
        this.b = aVar;
    }

    private boolean a(Object obj) throws Throwable {
        Throwable th;
        long jA = sdk.pendo.io.y.g.a();
        boolean z = false;
        try {
            external.sdk.pendo.io.glide.load.data.b<T> bVarA = this.a.a(obj);
            Object objRewindAndGet = bVarA.rewindAndGet();
            sdk.pendo.io.e.d<X> dVarB = this.a.b(objRewindAndGet);
            d dVar = new d(dVarB, objRewindAndGet, this.a.i());
            c cVar = new c(this.f.a, this.a.l());
            external.sdk.pendo.io.glide.load.engine.cache.a aVarD = this.a.d();
            aVarD.put(cVar, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + cVar + ", data: " + obj + ", encoder: " + dVarB + ", duration: " + sdk.pendo.io.y.g.a(jA));
            }
            if (aVarD.get(cVar) != null) {
                this.g = cVar;
                this.d = new b(Collections.singletonList(this.f.a), this.a, this);
                this.f.c.cleanup();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.b.a(this.f.a, bVarA.rewindAndGet(), this.f.c, this.f.c.getDataSource(), this.f.a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.f.c.cleanup();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean c() {
        return this.c < this.a.g().size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        if (this.e != null) {
            Object obj = this.e;
            this.e = null;
            try {
                if (!a(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.d != null && this.d.b()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z && c()) {
            List<external.sdk.pendo.io.glide.load.model.b.a<?>> listG = this.a.g();
            int i = this.c;
            this.c = i + 1;
            this.f = listG.get(i);
            if (this.f != null && (this.a.e().a(this.f.c.getDataSource()) || this.a.c(this.f.c.getDataClass()))) {
                b(this.f);
                z = true;
            }
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public void cancel() {
        external.sdk.pendo.io.glide.load.model.b.a<?> aVar = this.f;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    private void b(external.sdk.pendo.io.glide.load.model.b.a<?> aVar) {
        this.f.c.loadData(this.a.j(), new a(aVar));
    }

    boolean a(external.sdk.pendo.io.glide.load.model.b.a<?> aVar) {
        external.sdk.pendo.io.glide.load.model.b.a<?> aVar2 = this.f;
        return aVar2 != null && aVar2 == aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.e.f fVar, Exception exc, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.e.a aVar2) {
        this.b.a(fVar, exc, aVar, this.f.c.getDataSource());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.e.f fVar, Object obj, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.e.a aVar2, sdk.pendo.io.e.f fVar2) {
        this.b.a(fVar, obj, aVar, this.f.c.getDataSource(), fVar);
    }

    void a(external.sdk.pendo.io.glide.load.model.b.a<?> aVar, Object obj) {
        sdk.pendo.io.h.a aVarE = this.a.e();
        if (obj != null && aVarE.a(aVar.c.getDataSource())) {
            this.e = obj;
            this.b.a();
        } else {
            e.a aVar2 = this.b;
            sdk.pendo.io.e.f fVar = aVar.a;
            external.sdk.pendo.io.glide.load.data.a<?> aVar3 = aVar.c;
            aVar2.a(fVar, obj, aVar3, aVar3.getDataSource(), this.g);
        }
    }

    void a(external.sdk.pendo.io.glide.load.model.b.a<?> aVar, Exception exc) {
        e.a aVar2 = this.b;
        c cVar = this.g;
        external.sdk.pendo.io.glide.load.data.a<?> aVar3 = aVar.c;
        aVar2.a(cVar, exc, aVar3, aVar3.getDataSource());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a() {
        throw new UnsupportedOperationException();
    }
}
