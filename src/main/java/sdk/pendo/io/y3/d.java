package sdk.pendo.io.y3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class d<T> extends sdk.pendo.io.k3.j<T> {
    final sdk.pendo.io.k3.l<T> a;

    static final class a<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.k<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;

        a(sdk.pendo.io.k3.o<? super T> oVar) {
            this.a = oVar;
        }

        public void a(Throwable th) {
            if (b(th)) {
                return;
            }
            sdk.pendo.io.g4.a.b(th);
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.a.onError(th);
                return true;
            } finally {
                dispose();
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return sdk.pendo.io.r3.b.a(get());
        }

        @Override // sdk.pendo.io.k3.c
        public void onNext(T t) {
            if (t == null) {
                a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.a.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }

        @Override // sdk.pendo.io.k3.k
        public void a(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.b(this, bVar);
        }
    }

    public d(sdk.pendo.io.k3.l<T> lVar) {
        this.a = lVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            aVar.a(th);
        }
    }
}
