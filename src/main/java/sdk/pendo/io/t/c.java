package sdk.pendo.io.t;

import androidx.collection.ArrayMap;
import external.sdk.pendo.io.glide.load.engine.h;
import external.sdk.pendo.io.glide.load.engine.p;
import external.sdk.pendo.io.glide.load.resource.transcode.UnitTranscoder;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.y.j;

/* JADX INFO: loaded from: classes5.dex */
public class c {
    private static final p<?, ?, ?> c = new p<>(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    private final ArrayMap<j, p<?, ?, ?>> a = new ArrayMap<>();
    private final AtomicReference<j> b = new AtomicReference<>();

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        p<Data, TResource, Transcode> pVar;
        j jVarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            pVar = (p) this.a.get(jVarB);
        }
        this.b.set(jVarB);
        return pVar;
    }

    public boolean a(p<?, ?, ?> pVar) {
        return c.equals(pVar);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, p<?, ?, ?> pVar) {
        synchronized (this.a) {
            ArrayMap<j, p<?, ?, ?>> arrayMap = this.a;
            j jVar = new j(cls, cls2, cls3);
            if (pVar == null) {
                pVar = c;
            }
            arrayMap.put(jVar, pVar);
        }
    }
}
