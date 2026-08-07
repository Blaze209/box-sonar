package sdk.pendo.io.m4;

import external.sdk.pendo.io.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.l4.f;
import sdk.pendo.io.l4.s;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends f.a {
    private final Gson a;

    private a(Gson gson) {
        this.a = gson;
    }

    public static a a() {
        return a(new Gson());
    }

    @Override // sdk.pendo.io.l4.f.a
    public f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.a, this.a.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(type)));
    }

    @Override // sdk.pendo.io.l4.f.a
    public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.a, this.a.a((sdk.pendo.io.g0.a) sdk.pendo.io.g0.a.a(type)));
    }

    public static a a(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }
}
