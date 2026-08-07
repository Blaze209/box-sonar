package sdk.pendo.io.m4;

import com.google.api.client.json.Json;
import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.l4.f;
import sdk.pendo.io.s2.d;

/* JADX INFO: loaded from: classes4.dex */
final class b<T> implements f<T, c0> {
    private static final x c = x.a(Json.MEDIA_TYPE);
    private static final Charset d = Charset.forName("UTF-8");
    private final Gson a;
    private final TypeAdapter<T> b;

    b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // sdk.pendo.io.l4.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c0 convert(T t) throws IOException {
        d dVar = new d();
        sdk.pendo.io.h0.c cVarA = this.a.a((Writer) new OutputStreamWriter(dVar.outputStream(), d));
        this.b.a(cVarA, t);
        cVarA.close();
        return c0.a(c, dVar.g());
    }
}
