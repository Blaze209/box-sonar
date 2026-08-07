package sdk.pendo.io.s7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class f0 {

    class a implements sdk.pendo.io.q3.b<Long, Long, Long> {
        a() {
        }

        @Override // sdk.pendo.io.q3.b
        public Long a(Long l, Long l2) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    class b implements sdk.pendo.io.q3.j<Long> {
        final /* synthetic */ AtomicBoolean a;

        b(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            return !this.a.get();
        }
    }

    public static sdk.pendo.io.k3.j<Long> a(AtomicBoolean atomicBoolean, long j, TimeUnit timeUnit) {
        return sdk.pendo.io.k3.j.d(j, timeUnit).a(new b(atomicBoolean)).a(new a());
    }
}
