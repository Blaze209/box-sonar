package sdk.pendo.io.v1;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class i extends k<sdk.pendo.io.r1.c> {
    protected i(j jVar) {
        super(jVar);
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, Object obj2) {
        ((sdk.pendo.io.r1.a) obj).add(obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public Object b() {
        return new LinkedHashMap();
    }

    @Override // sdk.pendo.io.v1.k
    public Object a() {
        return new sdk.pendo.io.r1.a();
    }

    @Override // sdk.pendo.io.v1.k
    public k<sdk.pendo.io.r1.c> b(String str) {
        return this.a.c;
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public k<sdk.pendo.io.r1.c> a(String str) {
        return this.a.c;
    }
}
