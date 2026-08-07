package sdk.pendo.io.w3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class m<T, U> extends sdk.pendo.io.w3.a<T, T> {
    final sdk.pendo.io.j3.a<? extends U> c;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        final AtomicLong b = new AtomicLong();
        final AtomicReference<sdk.pendo.io.j3.c> c = new AtomicReference<>();
        final a<T>.C0509a e = new C0509a();
        final sdk.pendo.io.d4.c d = new sdk.pendo.io.d4.c();

        /* JADX INFO: renamed from: sdk.pendo.io.w3.m$a$a, reason: collision with other inner class name */
        final class C0509a extends AtomicReference<sdk.pendo.io.j3.c> implements sdk.pendo.io.k3.e<Object> {
            C0509a() {
            }

            @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
            public void a(sdk.pendo.io.j3.c cVar) {
                sdk.pendo.io.c4.c.a(this, cVar, Long.MAX_VALUE);
            }

            @Override // sdk.pendo.io.j3.b
            public void onComplete() {
                sdk.pendo.io.c4.c.a(a.this.c);
                a aVar = a.this;
                sdk.pendo.io.d4.h.a(aVar.a, aVar, aVar.d);
            }

            @Override // sdk.pendo.io.j3.b
            public void onError(Throwable th) {
                sdk.pendo.io.c4.c.a(a.this.c);
                a aVar = a.this;
                sdk.pendo.io.d4.h.a((sdk.pendo.io.j3.b<?>) aVar.a, th, (AtomicInteger) aVar, aVar.d);
            }

            @Override // sdk.pendo.io.j3.b
            public void onNext(Object obj) {
                sdk.pendo.io.c4.c.a(this);
                onComplete();
            }
        }

        a(sdk.pendo.io.j3.b<? super T> bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            sdk.pendo.io.c4.c.a(this.c, this.b, cVar);
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            sdk.pendo.io.c4.c.a(this.c);
            sdk.pendo.io.c4.c.a(this.e);
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            sdk.pendo.io.c4.c.a(this.e);
            sdk.pendo.io.d4.h.a(this.a, this, this.d);
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            sdk.pendo.io.c4.c.a(this.e);
            sdk.pendo.io.d4.h.a((sdk.pendo.io.j3.b<?>) this.a, th, (AtomicInteger) this, this.d);
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            sdk.pendo.io.d4.h.a(this.a, t, this, this.d);
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            sdk.pendo.io.c4.c.a(this.c, this.b, j);
        }
    }

    public m(sdk.pendo.io.k3.d<T> dVar, sdk.pendo.io.j3.a<? extends U> aVar) {
        super(dVar);
        this.c = aVar;
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        a aVar = new a(bVar);
        bVar.a(aVar);
        this.c.a(aVar.e);
        this.b.a((sdk.pendo.io.k3.e) aVar);
    }
}
