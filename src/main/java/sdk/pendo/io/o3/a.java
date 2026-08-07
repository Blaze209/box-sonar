package sdk.pendo.io.o3;

import java.util.ArrayList;
import sdk.pendo.io.d4.g;
import sdk.pendo.io.d4.k;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements b, sdk.pendo.io.r3.a {
    k<b> a;
    volatile boolean b;

    void a(k<b> kVar) {
        if (kVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : kVar.a()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new sdk.pendo.io.p3.a(arrayList);
            }
            throw g.a((Throwable) arrayList.get(0));
        }
    }

    @Override // sdk.pendo.io.r3.a
    public boolean b(b bVar) {
        k<b> kVar;
        sdk.pendo.io.s3.b.a(bVar, "disposables is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (!this.b && (kVar = this.a) != null && kVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // sdk.pendo.io.r3.a
    public boolean c(b bVar) {
        sdk.pendo.io.s3.b.a(bVar, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    k<b> kVar = this.a;
                    if (kVar == null) {
                        kVar = new k<>();
                        this.a = kVar;
                    }
                    kVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            k<b> kVar = this.a;
            this.a = null;
            a(kVar);
        }
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.b;
    }

    @Override // sdk.pendo.io.r3.a
    public boolean a(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }
}
