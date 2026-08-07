package sdk.pendo.io.o3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    d(T t) {
        super(sdk.pendo.io.s3.b.a((Object) t, "value is null"));
    }

    protected abstract void a(T t);

    @Override // sdk.pendo.io.o3.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // sdk.pendo.io.o3.b
    public final boolean isDisposed() {
        return get() == null;
    }
}
