package sdk.pendo.io.v1;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class e<T> extends k<T> {
    final Class<?> c;
    final Class<?> d;
    final sdk.pendo.io.p1.d<?> e;

    public e(j jVar, Class<?> cls) {
        super(jVar);
        this.c = cls;
        if (cls.isInterface()) {
            this.d = sdk.pendo.io.r1.d.class;
        } else {
            this.d = cls;
        }
        this.e = sdk.pendo.io.p1.d.a(this.d, sdk.pendo.io.r1.h.a);
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public Object b() {
        return this.e.c();
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> a(String str) {
        return this.a.b;
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> b(String str) {
        return this.a.b;
    }
}
