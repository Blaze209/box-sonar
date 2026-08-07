package sdk.pendo.io.v1;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class h<T> extends k<T> {
    Class<T> c;

    public h(j jVar, Class<T> cls) {
        super(jVar);
        this.c = cls;
    }

    @Override // sdk.pendo.io.v1.k
    public k<T> a(String str) {
        return this;
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public Object b() {
        try {
            return this.c.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // sdk.pendo.io.v1.k
    public k<T> b(String str) {
        return this;
    }

    @Override // sdk.pendo.io.v1.k
    public Object a() {
        try {
            return this.c.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }
}
