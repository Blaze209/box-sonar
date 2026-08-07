package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.util.ArrayList;
import sdk.pendo.io.a0.s;
import sdk.pendo.io.a0.t;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.c0.g;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final u c = b(s.DOUBLE);
    private final Gson a;
    private final t b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private ObjectTypeAdapter(Gson gson, t tVar) {
        this.a = gson;
        this.b = tVar;
    }

    public static u a(t tVar) {
        return tVar == s.DOUBLE ? c : b(tVar);
    }

    private static u b(final t tVar) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.ObjectTypeAdapter.1
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                if (aVar.a() == Object.class) {
                    return new ObjectTypeAdapter(gson, tVar);
                }
                return null;
            }
        };
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public Object a(sdk.pendo.io.h0.a aVar) throws IOException {
        switch (a.a[aVar.t().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.i()) {
                    arrayList.add(a(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                g gVar = new g();
                aVar.b();
                while (aVar.i()) {
                    gVar.put(aVar.p(), a(aVar));
                }
                aVar.g();
                return gVar;
            case 3:
                return aVar.r();
            case 4:
                return this.b.a(aVar);
            case 5:
                return Boolean.valueOf(aVar.l());
            case 6:
                aVar.q();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.k();
            return;
        }
        TypeAdapter typeAdapterA = this.a.a((Class) obj.getClass());
        if (!(typeAdapterA instanceof ObjectTypeAdapter)) {
            typeAdapterA.a(cVar, obj);
        } else {
            cVar.d();
            cVar.f();
        }
    }
}
