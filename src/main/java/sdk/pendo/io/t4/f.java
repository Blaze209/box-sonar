package sdk.pendo.io.t4;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: Add missing generic type declarations: [R] */
    class a<R> implements j<R> {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        @Override // sdk.pendo.io.q3.j
        public boolean test(R r) {
            return r.equals(this.a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class b<R> implements sdk.pendo.io.q3.b<R, R, Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.q3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(R r, R r2) {
            return Boolean.valueOf(r2.equals(r));
        }
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.k3.j<R> jVar) {
        return new d<>(jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R> sdk.pendo.io.k3.j<Boolean> b(sdk.pendo.io.k3.j<R> jVar, sdk.pendo.io.q3.h<R, R> hVar) {
        return sdk.pendo.io.k3.j.a(jVar.c(1L).c((sdk.pendo.io.q3.h<? super R, ? extends R>) hVar), jVar.b(1L), new b()).d(c.a).a((j) c.b);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.k3.j<R> jVar, @Nonnull sdk.pendo.io.q3.h<R, R> hVar) {
        sdk.pendo.io.u4.a.a(jVar, "lifecycle == null");
        sdk.pendo.io.u4.a.a(hVar, "correspondingEvents == null");
        return a(b((sdk.pendo.io.k3.j) jVar.i(), (sdk.pendo.io.q3.h) hVar));
    }

    private static <R> sdk.pendo.io.k3.j<R> b(sdk.pendo.io.k3.j<R> jVar, R r) {
        return jVar.a(new a(r));
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.k3.j<R> jVar, @Nonnull R r) {
        sdk.pendo.io.u4.a.a(jVar, "lifecycle == null");
        sdk.pendo.io.u4.a.a(r, "event == null");
        return a(b(jVar, r));
    }
}
