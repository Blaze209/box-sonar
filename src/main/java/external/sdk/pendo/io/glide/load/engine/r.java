package external.sdk.pendo.io.glide.load.engine;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class r implements e, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<Object> {
    private final e.a a;
    private final f<?> b;
    private int c;
    private int d = -1;
    private sdk.pendo.io.e.f e;
    private List<external.sdk.pendo.io.glide.load.model.b<File, ?>> f;
    private int g;
    private volatile external.sdk.pendo.io.glide.load.model.b.a<?> h;
    private File i;
    private s j;

    r(f<?> fVar, e.a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    private boolean a() {
        return this.g < this.f.size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        sdk.pendo.io.z.b.a("ResourceCacheGenerator.startNext");
        try {
            List<sdk.pendo.io.e.f> listC = this.b.c();
            boolean z = false;
            if (listC.isEmpty()) {
                sdk.pendo.io.z.b.a();
                return false;
            }
            List<Class<?>> listK = this.b.k();
            if (listK.isEmpty()) {
                if (!File.class.equals(this.b.m())) {
                    throw new IllegalStateException("Failed to find any load path from " + this.b.h() + " to " + this.b.m());
                }
                sdk.pendo.io.z.b.a();
                return false;
            }
            while (true) {
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
                if (i2 >= listK.size()) {
                    int i3 = this.c + 1;
                    this.c = i3;
                    if (i3 >= listC.size()) {
                        sdk.pendo.io.z.b.a();
                        return false;
                    }
                    this.d = 0;
                }
                sdk.pendo.io.e.f fVar = listC.get(this.c);
                Class<?> cls = listK.get(this.d);
                this.j = new s(this.b.b(), fVar, this.b.l(), this.b.n(), this.b.f(), this.b.b((Class) cls), cls, this.b.i());
                File file = this.b.d().get(this.j);
                this.i = file;
                if (file != null) {
                    this.e = fVar;
                    this.f = this.b.a(file);
                    this.g = 0;
                }
            }
        } catch (Throwable th) {
            sdk.pendo.io.z.b.a();
            throw th;
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public void cancel() {
        external.sdk.pendo.io.glide.load.model.b.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
    public void a(Object obj) {
        this.a.a(this.e, obj, this.h.c, sdk.pendo.io.e.a.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
    public void a(Exception exc) {
        this.a.a(this.j, exc, this.h.c, sdk.pendo.io.e.a.RESOURCE_DISK_CACHE);
    }
}
