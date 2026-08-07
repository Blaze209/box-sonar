package sdk.pendo.io.r3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.o3.b {
    public f() {
    }

    public f(sdk.pendo.io.o3.b bVar) {
        lazySet(bVar);
    }

    public boolean a(sdk.pendo.io.o3.b bVar) {
        return b.a((AtomicReference<sdk.pendo.io.o3.b>) this, bVar);
    }

    public boolean b(sdk.pendo.io.o3.b bVar) {
        return b.b(this, bVar);
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return b.a(get());
    }
}
