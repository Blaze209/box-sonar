package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.s;
import sdk.pendo.io.a0.t;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final u b = b(s.LAZILY_PARSED_NUMBER);
    private final t a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NumberTypeAdapter(t tVar) {
        this.a = tVar;
    }

    public static u a(t tVar) {
        return tVar == s.LAZILY_PARSED_NUMBER ? b : b(tVar);
    }

    private static u b(t tVar) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.NumberTypeAdapter.1
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                if (aVar.a() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
        b bVarT = aVar.t();
        int i = a.a[bVarT.ordinal()];
        if (i == 1) {
            aVar.q();
            return null;
        }
        if (i == 2 || i == 3) {
            return this.a.a(aVar);
        }
        throw new q("Expecting number, got: " + bVarT + "; at path " + aVar.getPath());
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Number number) throws IOException {
        cVar.a(number);
    }
}
