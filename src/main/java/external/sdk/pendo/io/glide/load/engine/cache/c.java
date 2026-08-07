package external.sdk.pendo.io.glide.load.engine.cache;

import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public interface c {

    public interface a {
        void onResourceRemoved(sdk.pendo.io.h.c<?> cVar);
    }

    void clearMemory();

    sdk.pendo.io.h.c<?> put(f fVar, sdk.pendo.io.h.c<?> cVar);

    sdk.pendo.io.h.c<?> remove(f fVar);

    void setResourceRemovedListener(a aVar);

    void trimMemory(int i);
}
