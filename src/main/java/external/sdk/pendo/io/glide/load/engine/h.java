package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class h<DataType, ResourceType, Transcode> {
    private final Class<DataType> a;
    private final List<? extends sdk.pendo.io.e.i<DataType, ResourceType>> b;
    private final sdk.pendo.io.q.a<ResourceType, Transcode> c;
    private final Pools.Pool<List<Throwable>> d;
    private final String e;

    interface a<ResourceType> {
        sdk.pendo.io.h.c<ResourceType> a(sdk.pendo.io.h.c<ResourceType> cVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends sdk.pendo.io.e.i<DataType, ResourceType>> list, sdk.pendo.io.q.a<ResourceType, Transcode> aVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = list;
        this.c = aVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public sdk.pendo.io.h.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options, a<ResourceType> aVar) {
        return this.c.transcode(aVar.a(a(bVar, i, i2, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    private sdk.pendo.io.h.c<ResourceType> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options) {
        List<Throwable> list = (List) sdk.pendo.io.y.k.a(this.d.acquire());
        try {
            return a(bVar, i, i2, options, list);
        } finally {
            this.d.release(list);
        }
    }

    private sdk.pendo.io.h.c<ResourceType> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options, List<Throwable> list) throws n {
        int size = this.b.size();
        sdk.pendo.io.h.c<ResourceType> cVarDecode = null;
        for (int i3 = 0; i3 < size; i3++) {
            sdk.pendo.io.e.i<DataType, ResourceType> iVar = this.b.get(i3);
            try {
                if (iVar.handles(bVar.rewindAndGet(), options)) {
                    cVarDecode = iVar.decode(bVar.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + iVar, e);
                }
                list.add(e);
            }
            if (cVarDecode != null) {
                break;
            }
        }
        if (cVarDecode != null) {
            return cVarDecode;
        }
        throw new n(this.e, new ArrayList(list));
    }
}
