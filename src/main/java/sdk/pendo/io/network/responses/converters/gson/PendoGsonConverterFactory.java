package sdk.pendo.io.network.responses.converters.gson;

import external.sdk.pendo.io.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Lazy;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.g0.a;
import sdk.pendo.io.l4.f;
import sdk.pendo.io.l4.s;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.w5.b;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoGsonConverterFactory extends f.a {
    private static final Lazy<k0> pendoGSON = b.a(k0.class);
    private final Gson mGson;

    private PendoGsonConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.mGson = gson;
    }

    public static PendoGsonConverterFactory create() {
        return create(pendoGSON.getValue().a());
    }

    @Override // sdk.pendo.io.l4.f.a
    public f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new PendoGsonRequestBodyConverter(this.mGson, this.mGson.a((a) a.a(type)));
    }

    @Override // sdk.pendo.io.l4.f.a
    public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        return new PendoGsonResponseBodyConverter(this.mGson.a((a) a.a(type)), type);
    }

    public static PendoGsonConverterFactory create(Gson gson) {
        return new PendoGsonConverterFactory(gson);
    }
}
