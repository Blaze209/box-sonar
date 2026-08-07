package sdk.pendo.io.m4;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import sdk.pendo.io.a0.j;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.l4.f;

/* JADX INFO: loaded from: classes4.dex */
final class c<T> implements f<e0, T> {
    private final Gson a;
    private final TypeAdapter<T> b;

    c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // sdk.pendo.io.l4.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(e0 e0Var) {
        sdk.pendo.io.h0.a aVarA = this.a.a(e0Var.c());
        try {
            T tA = this.b.a(aVarA);
            if (aVarA.t() != sdk.pendo.io.h0.b.END_DOCUMENT) {
                throw new j("JSON document was not fully consumed.");
            }
            e0Var.close();
            return tA;
        } catch (Throwable th) {
            e0Var.close();
            throw th;
        }
    }
}
