package external.sdk.pendo.io.glide.load.engine.cache;

import sdk.pendo.io.e.f;
import sdk.pendo.io.y.h;

/* JADX INFO: loaded from: classes4.dex */
public class LruResourceCache extends h<f, sdk.pendo.io.h.c<?>> implements c {
    private c.a listener;

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public /* bridge */ /* synthetic */ sdk.pendo.io.h.c put(f fVar, sdk.pendo.io.h.c cVar) {
        return (sdk.pendo.io.h.c) super.put(fVar, cVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public /* bridge */ /* synthetic */ sdk.pendo.io.h.c remove(f fVar) {
        return (sdk.pendo.io.h.c) super.remove(fVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void setResourceRemovedListener(c.a aVar) {
        this.listener = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void trimMemory(int i) {
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.y.h
    public int getSize(sdk.pendo.io.h.c<?> cVar) {
        return cVar == null ? super.getSize((Object) null) : cVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.y.h
    public void onItemEvicted(f fVar, sdk.pendo.io.h.c<?> cVar) {
        c.a aVar = this.listener;
        if (aVar == null || cVar == null) {
            return;
        }
        aVar.onResourceRemoved(cVar);
    }
}
