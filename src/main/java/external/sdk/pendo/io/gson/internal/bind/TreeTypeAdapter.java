package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import sdk.pendo.io.a0.g;
import sdk.pendo.io.a0.h;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.o;
import sdk.pendo.io.a0.p;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.k;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final p<T> a;
    private final h<T> b;
    final Gson c;
    private final sdk.pendo.io.g0.a<T> d;
    private final u e;
    private final TreeTypeAdapter<T>.b f = new b();
    private volatile TypeAdapter<T> g;

    private static final class SingleTypeFactory implements u {
        private final sdk.pendo.io.g0.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final p<?> d;
        private final h<?> e;

        SingleTypeFactory(Object obj, sdk.pendo.io.g0.a<?> aVar, boolean z, Class<?> cls) {
            p<?> pVar = obj instanceof p ? (p) obj : null;
            this.d = pVar;
            h<?> hVar = obj instanceof h ? (h) obj : null;
            this.e = hVar;
            sdk.pendo.io.c0.a.a((pVar == null && hVar == null) ? false : true);
            this.a = aVar;
            this.b = z;
            this.c = cls;
        }

        @Override // sdk.pendo.io.a0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
            boolean zIsAssignableFrom;
            sdk.pendo.io.g0.a<?> aVar2 = this.a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.b && this.a.b() == aVar.a());
            } else {
                zIsAssignableFrom = this.c.isAssignableFrom(aVar.a());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.d, this.e, gson, aVar, this);
            }
            return null;
        }
    }

    private final class b implements o, g {
        private b() {
        }
    }

    public TreeTypeAdapter(p<T> pVar, h<T> hVar, Gson gson, sdk.pendo.io.g0.a<T> aVar, u uVar) {
        this.a = pVar;
        this.b = hVar;
        this.c = gson;
        this.d = aVar;
        this.e = uVar;
    }

    public static u a(sdk.pendo.io.g0.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private TypeAdapter<T> b() {
        TypeAdapter<T> typeAdapter = this.g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> typeAdapterA = this.c.a(this.e, this.d);
        this.g = typeAdapterA;
        return typeAdapterA;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public T a(sdk.pendo.io.h0.a aVar) {
        if (this.b == null) {
            return b().a(aVar);
        }
        i iVarA = k.a(aVar);
        if (iVarA.i()) {
            return null;
        }
        return this.b.deserialize(iVarA, this.d.b(), this.f);
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, T t) throws IOException {
        p<T> pVar = this.a;
        if (pVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.k();
        } else {
            k.a(pVar.a(t, this.d.b(), this.f), cVar);
        }
    }
}
