package sdk.pendo.io.y3;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class l<T> extends sdk.pendo.io.k3.j<T> {
    final Callable<? extends Throwable> a;

    public l(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        try {
            th = (Throwable) sdk.pendo.io.s3.b.a(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            sdk.pendo.io.p3.b.b(th);
        }
        sdk.pendo.io.r3.c.a(th, oVar);
    }
}
