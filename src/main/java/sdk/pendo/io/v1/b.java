package sdk.pendo.io.v1;

import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> extends k<T> {
    public static k<Date> c = new a(null);

    class a extends sdk.pendo.io.v1.a<Date> {
        a(j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Date a(Object obj) {
            return sdk.pendo.io.p1.g.a(obj);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.v1.b$b, reason: collision with other inner class name */
    public static class C0501b<T> extends k<T> {
        final Class<T> c;
        final sdk.pendo.io.p1.d<T> d;
        final HashMap<String, sdk.pendo.io.p1.b> e;

        public C0501b(j jVar, Class<T> cls) {
            super(jVar);
            this.c = cls;
            sdk.pendo.io.p1.d<T> dVarA = sdk.pendo.io.p1.d.a(cls, sdk.pendo.io.r1.h.a);
            this.d = dVarA;
            this.e = dVarA.b();
        }

        @Override // sdk.pendo.io.v1.k
        public void a(Object obj, String str, Object obj2) {
            this.d.a(obj, str, obj2);
        }

        @Override // sdk.pendo.io.v1.k
        public Object b() {
            return this.d.c();
        }

        @Override // sdk.pendo.io.v1.k
        public k<?> a(String str) {
            sdk.pendo.io.p1.b bVar = this.e.get(str);
            if (bVar != null) {
                return this.a.a(bVar.a());
            }
            throw new RuntimeException("Can not find Array '" + str + "' field in " + this.c);
        }

        @Override // sdk.pendo.io.v1.k
        public k<?> b(String str) {
            sdk.pendo.io.p1.b bVar = this.e.get(str);
            if (bVar != null) {
                return this.a.a(bVar.a());
            }
            throw new RuntimeException("Can not find Object '" + str + "' field in " + this.c);
        }
    }
}
