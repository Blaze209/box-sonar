package sdk.pendo.io.network.responses.converters.gson;

import com.google.api.client.json.Json;
import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.h0.c;
import sdk.pendo.io.l4.f;
import sdk.pendo.io.s2.d;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoGsonRequestBodyConverter<T> implements f<T, c0> {
    public static final x JSON_MEDIA_TYPE = x.c(Json.MEDIA_TYPE);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> mAdapter;
    private final Gson mGson;

    public PendoGsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.mGson = gson;
        this.mAdapter = typeAdapter;
    }

    @Override // sdk.pendo.io.l4.f
    public c0 convert(T t) throws IOException {
        d dVar = new d();
        c cVarA = this.mGson.a((Writer) new OutputStreamWriter(dVar.outputStream(), UTF_8));
        this.mAdapter.a(cVarA, t);
        cVarA.close();
        return c0.a(JSON_MEDIA_TYPE, dVar.g());
    }
}
