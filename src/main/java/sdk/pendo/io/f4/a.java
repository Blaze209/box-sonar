package sdk.pendo.io.f4;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d4.f;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> implements o<T>, sdk.pendo.io.o3.b {
    final AtomicReference<sdk.pendo.io.o3.b> a = new AtomicReference<>();

    protected void a() {
    }

    @Override // sdk.pendo.io.o3.b
    public final void dispose() {
        sdk.pendo.io.r3.b.a(this.a);
    }

    @Override // sdk.pendo.io.o3.b
    public final boolean isDisposed() {
        return this.a.get() == sdk.pendo.io.r3.b.DISPOSED;
    }

    @Override // sdk.pendo.io.k3.o
    public final void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (f.a(this.a, bVar, getClass())) {
            a();
        }
    }
}
