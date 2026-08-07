package sdk.pendo.io.l1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class b extends c {
    private final a f;

    b(a aVar) {
        this.f = aVar;
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        if (c(str, obj, gVar)) {
            if (this.f.b()) {
                a(this.f.a().get(0).intValue(), str, obj, gVar);
                return;
            }
            Iterator<Integer> it = this.f.a().iterator();
            while (it.hasNext()) {
                a(it.next().intValue(), str, obj, gVar);
            }
        }
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return this.f.b();
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return this.f.toString();
    }
}
