package external.sdk.pendo.io.glide.load.resource;

import sdk.pendo.io.h.c;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleResource<T> implements c<T> {
    protected final T data;

    public SimpleResource(T t) {
        this.data = (T) k.a(t);
    }

    @Override // sdk.pendo.io.h.c
    public final T get() {
        return this.data;
    }

    @Override // sdk.pendo.io.h.c
    public Class<T> getResourceClass() {
        return (Class<T>) this.data.getClass();
    }

    @Override // sdk.pendo.io.h.c
    public final int getSize() {
        return 1;
    }

    @Override // sdk.pendo.io.h.c
    public void recycle() {
    }
}
