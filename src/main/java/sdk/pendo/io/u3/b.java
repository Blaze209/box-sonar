package sdk.pendo.io.u3;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> extends AtomicInteger implements sdk.pendo.io.t3.b<T> {
    @Override // sdk.pendo.io.t3.g
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
