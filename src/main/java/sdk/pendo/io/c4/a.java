package sdk.pendo.io.c4;

import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.t3.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> extends AtomicInteger implements d<T> {
    @Override // sdk.pendo.io.t3.g
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
