package sdk.pendo.io.u3;

import java.util.concurrent.CountDownLatch;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d<T> extends CountDownLatch implements o<T>, sdk.pendo.io.o3.b {
    T a;
    Throwable b;
    sdk.pendo.io.o3.b c;
    volatile boolean d;

    public d() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                sdk.pendo.io.d4.e.a();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw sdk.pendo.io.d4.g.a(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.a;
        }
        throw sdk.pendo.io.d4.g.a(th);
    }

    @Override // sdk.pendo.io.o3.b
    public final void dispose() {
        this.d = true;
        sdk.pendo.io.o3.b bVar = this.c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // sdk.pendo.io.o3.b
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // sdk.pendo.io.k3.o
    public final void onComplete() {
        countDown();
    }

    @Override // sdk.pendo.io.k3.o
    public final void onSubscribe(sdk.pendo.io.o3.b bVar) {
        this.c = bVar;
        if (this.d) {
            bVar.dispose();
        }
    }
}
