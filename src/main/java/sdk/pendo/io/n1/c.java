package sdk.pendo.io.n1;

import java.util.List;
import java.util.Map;
import sdk.pendo.io.r1.d;
import sdk.pendo.io.r1.g;
import sdk.pendo.io.r1.i;
import sdk.pendo.io.t1.e;
import sdk.pendo.io.v1.k;

/* JADX INFO: loaded from: classes4.dex */
public class c extends a {
    private final int b;
    private final k<?> c;

    public c() {
        this(-1, i.c.c);
    }

    private sdk.pendo.io.t1.a c() {
        return new sdk.pendo.io.t1.a(this.b);
    }

    @Override // sdk.pendo.io.n1.b
    public Object a() {
        return this.c.a();
    }

    @Override // sdk.pendo.io.n1.b
    public Object b() {
        return this.c.b();
    }

    public c(int i, k<?> kVar) {
        this.b = i;
        this.c = kVar;
    }

    @Override // sdk.pendo.io.n1.b
    public Object a(String str) {
        try {
            return c().a(str, this.c);
        } catch (e e) {
            throw new sdk.pendo.io.d1.e(e);
        }
    }

    @Override // sdk.pendo.io.n1.b
    public String b(Object obj) {
        if (obj instanceof Map) {
            return d.a((Map<String, ? extends Object>) obj, g.j);
        }
        if (obj instanceof List) {
            return sdk.pendo.io.r1.a.a((List<? extends Object>) obj, g.j);
        }
        throw new UnsupportedOperationException(obj.getClass().getName() + " can not be converted to JSON");
    }
}
