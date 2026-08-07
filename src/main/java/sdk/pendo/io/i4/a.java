package sdk.pendo.io.i4;

import java.util.concurrent.Callable;
import sdk.pendo.io.a4.m;
import sdk.pendo.io.a4.n;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    static final p a = sdk.pendo.io.g4.a.e(new h());
    static final p b = sdk.pendo.io.g4.a.b(new b());
    static final p c = sdk.pendo.io.g4.a.c(new c());
    static final p d = n.b();
    static final p e = sdk.pendo.io.g4.a.d(new f());

    /* JADX INFO: renamed from: sdk.pendo.io.i4.a$a, reason: collision with other inner class name */
    static final class C0397a {
        static final p a = new sdk.pendo.io.a4.b();
    }

    static final class b implements Callable<p> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return C0397a.a;
        }
    }

    static final class c implements Callable<p> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return d.a;
        }
    }

    static final class d {
        static final p a = new sdk.pendo.io.a4.d();
    }

    static final class e {
        static final p a = new sdk.pendo.io.a4.e();
    }

    static final class f implements Callable<p> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return e.a;
        }
    }

    static final class g {
        static final p a = new m();
    }

    static final class h implements Callable<p> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return g.a;
        }
    }

    public static p a() {
        return sdk.pendo.io.g4.a.a(b);
    }

    public static p b() {
        return sdk.pendo.io.g4.a.b(c);
    }

    public static p c() {
        return sdk.pendo.io.g4.a.c(a);
    }

    public static p d() {
        return d;
    }
}
