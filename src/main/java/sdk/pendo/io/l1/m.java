package sdk.pendo.io.l1;

import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class m implements sdk.pendo.io.d1.l.a {
    private static final sdk.pendo.io.v4.a e = sdk.pendo.io.v4.b.a((Class<?>) m.class);
    private final Object a;
    private final Object b;
    private final sdk.pendo.io.d1.a c;
    private final HashMap<sdk.pendo.io.e1.g, Object> d;

    public m(Object obj, Object obj2, sdk.pendo.io.d1.a aVar, HashMap<sdk.pendo.io.e1.g, Object> map) {
        this.a = obj;
        this.b = obj2;
        this.c = aVar;
        this.d = map;
    }

    @Override // sdk.pendo.io.d1.l.a
    public sdk.pendo.io.d1.a a() {
        return this.c;
    }

    @Override // sdk.pendo.io.d1.l.a
    public Object b() {
        return this.b;
    }

    @Override // sdk.pendo.io.d1.l.a
    public Object c() {
        return this.a;
    }

    public HashMap<sdk.pendo.io.e1.g, Object> d() {
        return this.d;
    }

    public Object a(sdk.pendo.io.e1.g gVar) {
        if (!gVar.b()) {
            return gVar.a(this.a, this.b, this.c).getValue();
        }
        if (this.d.containsKey(gVar)) {
            e.a("Using cached result for root path: " + gVar.toString());
            return this.d.get(gVar);
        }
        Object obj = this.b;
        Object value = gVar.a(obj, obj, this.c).getValue();
        this.d.put(gVar, value);
        return value;
    }
}
