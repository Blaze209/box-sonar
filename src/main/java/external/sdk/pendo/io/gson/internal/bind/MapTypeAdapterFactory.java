package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.n;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.b;
import sdk.pendo.io.c0.c;
import sdk.pendo.io.c0.e;
import sdk.pendo.io.c0.h;
import sdk.pendo.io.c0.k;

/* JADX INFO: loaded from: classes4.dex */
public final class MapTypeAdapterFactory implements u {
    private final c a;
    final boolean b;

    public MapTypeAdapterFactory(c cVar, boolean z) {
        this.a = cVar;
        this.b = z;
    }

    @Override // sdk.pendo.io.a0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
        Type typeB = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] typeArrB = b.b(typeB, b.e(typeB));
        return new Adapter(gson, typeArrB[0], a(gson, typeArrB[0]), typeArrB[1], gson.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(typeArrB[1])), this.a.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f : gson.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(type));
    }

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final TypeAdapter<K> a;
        private final TypeAdapter<V> b;
        private final h<? extends Map<K, V>> c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, h<? extends Map<K, V>> hVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.c = hVar;
        }

        private String a(i iVar) {
            if (!iVar.k()) {
                if (iVar.i()) {
                    return AbstractJsonLexerKt.NULL;
                }
                throw new AssertionError();
            }
            n nVarF = iVar.f();
            if (nVarF.p()) {
                return String.valueOf(nVarF.n());
            }
            if (nVarF.o()) {
                return Boolean.toString(nVarF.a());
            }
            if (nVarF.q()) {
                return nVarF.g();
            }
            throw new AssertionError();
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<K, V> a(sdk.pendo.io.h0.a aVar) throws IOException {
            sdk.pendo.io.h0.b bVarT = aVar.t();
            if (bVarT == sdk.pendo.io.h0.b.NULL) {
                aVar.q();
                return null;
            }
            Map<K, V> mapA = this.c.a();
            if (bVarT != sdk.pendo.io.h0.b.BEGIN_ARRAY) {
                aVar.b();
                while (aVar.i()) {
                    e.a.a(aVar);
                    K kA = this.a.a(aVar);
                    if (mapA.put(kA, this.b.a(aVar)) != null) {
                        throw new q("duplicate key: " + kA);
                    }
                }
                aVar.g();
                return mapA;
            }
            aVar.a();
            while (aVar.i()) {
                aVar.a();
                K kA2 = this.a.a(aVar);
                if (mapA.put(kA2, this.b.a(aVar)) != null) {
                    throw new q("duplicate key: " + kA2);
                }
                aVar.f();
            }
            aVar.f();
            return mapA;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.h0.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.k();
                return;
            }
            if (!MapTypeAdapterFactory.this.b) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.b.a(cVar, entry.getValue());
                }
                cVar.f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                i iVarA = this.a.a(entry2.getKey());
                arrayList.add(iVarA);
                arrayList2.add(entry2.getValue());
                z |= iVarA.h() || iVarA.j();
            }
            if (!z) {
                cVar.d();
                int size = arrayList.size();
                while (i < size) {
                    cVar.a(a((i) arrayList.get(i)));
                    this.b.a(cVar, (V) arrayList2.get(i));
                    i++;
                }
                cVar.f();
                return;
            }
            cVar.c();
            int size2 = arrayList.size();
            while (i < size2) {
                cVar.c();
                k.a((i) arrayList.get(i), cVar);
                this.b.a(cVar, (V) arrayList2.get(i));
                cVar.e();
                i++;
            }
            cVar.e();
        }
    }
}
