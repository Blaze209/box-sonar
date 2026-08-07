package sdk.pendo.io.l1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class g implements sdk.pendo.io.e1.d {
    private static final sdk.pendo.io.e1.c j = new sdk.pendo.io.e1.c();
    private final sdk.pendo.io.d1.a a;
    private final Object b;
    private final Object c;
    private final sdk.pendo.io.e1.g d;
    private final Object e;
    private final List<sdk.pendo.io.e1.h> f;
    private final boolean h;
    private final HashMap<sdk.pendo.io.e1.g, Object> g = new HashMap<>();
    private int i = 0;

    private static class a implements sdk.pendo.io.d1.c.b {
        private final int a;
        private final String b;
        private final Object c;

        private a(int i, String str, Object obj) {
            this.a = i;
            this.b = str;
            this.c = obj;
        }
    }

    public g(sdk.pendo.io.e1.g gVar, Object obj, sdk.pendo.io.d1.a aVar, boolean z) {
        sdk.pendo.io.e1.i.a(gVar, "path can not be null", new Object[0]);
        sdk.pendo.io.e1.i.a(obj, "root can not be null", new Object[0]);
        sdk.pendo.io.e1.i.a(aVar, "configuration can not be null", new Object[0]);
        this.h = z;
        this.d = gVar;
        this.e = obj;
        this.a = aVar;
        this.b = aVar.f().a();
        this.c = aVar.f().a();
        this.f = new ArrayList();
    }

    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj) {
        if (this.h) {
            this.f.add(hVar);
        }
        this.a.f().a(this.b, this.i, obj);
        this.a.f().a(this.c, this.i, str);
        this.i++;
        if (a().d().isEmpty()) {
            return;
        }
        int i = this.i - 1;
        Iterator<sdk.pendo.io.d1.c> it = a().d().iterator();
        while (it.hasNext()) {
            if (sdk.pendo.io.d1.c.a.ABORT == it.next().a(new a(i, str, obj))) {
                throw j;
            }
        }
    }

    public HashMap<sdk.pendo.io.e1.g, Object> b() {
        return this.g;
    }

    public boolean c() {
        return this.h;
    }

    public sdk.pendo.io.n1.b d() {
        return this.a.f();
    }

    public Set<sdk.pendo.io.d1.i> e() {
        return this.a.e();
    }

    public Object f() {
        return this.e;
    }

    @Override // sdk.pendo.io.e1.d
    public <T> T getPath() {
        if (this.i != 0) {
            return (T) this.c;
        }
        throw new sdk.pendo.io.d1.k("No results for path: " + this.d.toString());
    }

    @Override // sdk.pendo.io.e1.d
    public <T> T getValue() {
        return (T) a(true);
    }

    @Override // sdk.pendo.io.e1.d
    public sdk.pendo.io.d1.a a() {
        return this.a;
    }

    @Override // sdk.pendo.io.e1.d
    public <T> T a(boolean z) {
        if (!this.d.c()) {
            return (T) this.b;
        }
        if (this.i == 0) {
            throw new sdk.pendo.io.d1.k("No results for path: " + this.d.toString());
        }
        int iD = d().d(this.b);
        T t = iD > 0 ? (T) d().a(this.b, iD - 1) : null;
        return (t == null || !z) ? t : (T) d().g(t);
    }
}
