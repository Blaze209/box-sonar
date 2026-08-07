package sdk.pendo.io.v1;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class c<T> extends k<T> {
    final Class<?> c;
    final Class<?> d;
    final sdk.pendo.io.p1.d<?> e;

    public c(j jVar, Class<?> cls) {
        super(jVar);
        this.c = cls;
        if (cls.isInterface()) {
            this.d = sdk.pendo.io.r1.a.class;
        } else {
            this.d = cls;
        }
        this.e = sdk.pendo.io.p1.d.a(this.d, sdk.pendo.io.r1.h.a);
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> b(String str) {
        return this.a.b;
    }

    @Override // sdk.pendo.io.v1.k
    public Object a() {
        return this.e.c();
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> a(String str) {
        return this.a.b;
    }
}
