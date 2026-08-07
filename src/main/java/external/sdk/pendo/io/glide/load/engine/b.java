package external.sdk.pendo.io.glide.load.engine;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class b implements e, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<Object> {
    private final List<sdk.pendo.io.e.f> a;
    private final f<?> b;
    private final e.a c;
    private int d;
    private sdk.pendo.io.e.f e;
    private List<external.sdk.pendo.io.glide.load.model.b<File, ?>> f;
    private int g;
    private volatile external.sdk.pendo.io.glide.load.model.b.a<?> h;
    private File i;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean a() {
        return this.g < this.f.size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        sdk.pendo.io.z.b.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z = false;
                if (this.f != null && a()) {
                    this.h = null;
                    while (!z && a()) {
                        List<external.sdk.pendo.io.glide.load.model.b<File, ?>> list = this.f;
                        int i = this.g;
                        this.g = i + 1;
                        this.h = list.get(i).buildLoadData(this.i, this.b.n(), this.b.f(), this.b.i());
                        if (this.h != null && this.b.c(this.h.c.getDataClass())) {
                            this.h.c.loadData(this.b.j(), this);
                            z = true;
                        }
                    }
                    sdk.pendo.io.z.b.a();
                    return z;
                }
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 >= this.a.size()) {
                    sdk.pendo.io.z.b.a();
                    return false;
                }
                sdk.pendo.io.e.f fVar = this.a.get(this.d);
                File file = this.b.d().get(new c(fVar, this.b.l()));
                this.i = file;
                if (file != null) {
                    this.e = fVar;
                    this.f = this.b.a(file);
                    this.g = 0;
                }
            } catch (Throwable th) {
                sdk.pendo.io.z.b.a();
                throw th;
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public void cancel() {
        external.sdk.pendo.io.glide.load.model.b.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    b(List<sdk.pendo.io.e.f> list, f<?> fVar, e.a aVar) {
        this.d = -1;
        this.a = list;
        this.b = fVar;
        this.c = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
    public void a(Object obj) {
        this.c.a(this.e, obj, this.h.c, sdk.pendo.io.e.a.DATA_DISK_CACHE, this.e);
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
    public void a(Exception exc) {
        this.c.a(this.e, exc, this.h.c, sdk.pendo.io.e.a.DATA_DISK_CACHE);
    }
}
