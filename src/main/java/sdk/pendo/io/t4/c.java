package sdk.pendo.io.t4;

import java.util.concurrent.CancellationException;
import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes5.dex */
final class c {
    static final sdk.pendo.io.q3.h<Throwable, Boolean> a = new a();
    static final j<Boolean> b = new b();
    static final sdk.pendo.io.q3.h<Object, sdk.pendo.io.k3.b> c = new C0489c();

    class a implements sdk.pendo.io.q3.h<Throwable, Boolean> {
        a() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Throwable th) {
            if (th instanceof e) {
                return Boolean.TRUE;
            }
            sdk.pendo.io.p3.b.a(th);
            return Boolean.FALSE;
        }
    }

    class b implements j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.t4.c$c, reason: collision with other inner class name */
    class C0489c implements sdk.pendo.io.q3.h<Object, sdk.pendo.io.k3.b> {
        C0489c() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.k3.b apply(Object obj) {
            return sdk.pendo.io.k3.b.a(new CancellationException());
        }
    }
}
