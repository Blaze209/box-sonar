package sdk.pendo.io.x3;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.i;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes6.dex */
public final class f<T> extends sdk.pendo.io.x3.a<T, T> {
    final p b;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.h<T>, sdk.pendo.io.o3.b, Runnable {
        final sdk.pendo.io.k3.h<? super T> a;
        final p b;
        T c;
        Throwable d;

        a(sdk.pendo.io.k3.h<? super T> hVar, p pVar) {
            this.a = hVar;
            this.b = pVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(get());
        }

        @Override // sdk.pendo.io.k3.h
        public void onComplete() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this, this.b.a(this));
        }

        @Override // sdk.pendo.io.k3.h
        public void onError(Throwable th) {
            this.d = th;
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this, this.b.a(this));
        }

        @Override // sdk.pendo.io.k3.h
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.c(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.k3.h
        public void onSuccess(T t) {
            this.c = t;
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this, this.b.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.d;
            if (th != null) {
                this.d = null;
                this.a.onError(th);
                return;
            }
            T t = this.c;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.c = null;
                this.a.onSuccess(t);
            }
        }
    }

    public f(i<T> iVar, p pVar) {
        super(iVar);
        this.b = pVar;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super T> hVar) {
        this.a.a(new a(hVar, this.b));
    }
}
