package sdk.pendo.io.r3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.d4.g;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements sdk.pendo.io.o3.b, a {
    List<sdk.pendo.io.o3.b> a;
    volatile boolean b;

    void a(List<sdk.pendo.io.o3.b> list) {
        if (list == null) {
            return;
        }
        Iterator<sdk.pendo.io.o3.b> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
    public boolean b(sdk.pendo.io.o3.b bVar) {
        List<sdk.pendo.io.o3.b> list;
        sdk.pendo.io.s3.b.a(bVar, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (!this.b && (list = this.a) != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // sdk.pendo.io.r3.a
    public boolean c(sdk.pendo.io.o3.b bVar) {
        sdk.pendo.io.s3.b.a(bVar, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List linkedList = this.a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.a = linkedList;
                    }
                    linkedList.add(bVar);
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
            List<sdk.pendo.io.o3.b> list = this.a;
            this.a = null;
            a(list);
        }
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.b;
    }

    @Override // sdk.pendo.io.r3.a
    public boolean a(sdk.pendo.io.o3.b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }
}
