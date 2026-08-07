package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class p<Data, ResourceType, Transcode> {
    private final Class<Data> a;
    private final Pools.Pool<List<Throwable>> b;
    private final List<? extends h<Data, ResourceType, Transcode>> c;
    private final String d;

    public p(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = pool;
        this.c = (List) sdk.pendo.io.y.k.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public sdk.pendo.io.h.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<Data> bVar, Options options, int i, int i2, h.a<ResourceType> aVar) {
        List<Throwable> list = (List) sdk.pendo.io.y.k.a(this.b.acquire());
        try {
            return a(bVar, options, i, i2, aVar, list);
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }

    private sdk.pendo.io.h.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<Data> bVar, Options options, int i, int i2, h.a<ResourceType> aVar, List<Throwable> list) throws n {
        int size = this.c.size();
        sdk.pendo.io.h.c<Transcode> cVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                cVarA = this.c.get(i3).a(bVar, i, i2, options, aVar);
            } catch (n e) {
                list.add(e);
            }
            if (cVarA != null) {
                break;
            }
        }
        if (cVarA != null) {
            return cVarA;
        }
        throw new n(this.d, new ArrayList(list));
    }
}
