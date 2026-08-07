package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;

/* JADX INFO: loaded from: classes4.dex */
final class a extends sdk.pendo.io.l4.f.a {
    private boolean a = true;

    /* JADX INFO: renamed from: sdk.pendo.io.l4.a$a, reason: collision with other inner class name */
    static final class C0411a implements sdk.pendo.io.l4.f<e0, e0> {
        static final C0411a a = new C0411a();

        C0411a() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) {
            try {
                return w.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    static final class b implements sdk.pendo.io.l4.f<c0, c0> {
        static final b a = new b();

        b() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 convert(c0 c0Var) {
            return c0Var;
        }
    }

    static final class c implements sdk.pendo.io.l4.f<e0, e0> {
        static final c a = new c();

        c() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) {
            return e0Var;
        }
    }

    static final class d implements sdk.pendo.io.l4.f<Object, String> {
        static final d a = new d();

        d() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements sdk.pendo.io.l4.f<e0, Unit> {
        static final e a = new e();

        e() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit convert(e0 e0Var) {
            e0Var.close();
            return Unit.INSTANCE;
        }
    }

    static final class f implements sdk.pendo.io.l4.f<e0, Void> {
        static final f a = new f();

        f() {
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    a() {
    }

    @Override // sdk.pendo.io.l4.f.a
    @Nullable
    public sdk.pendo.io.l4.f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (c0.class.isAssignableFrom(w.b(type))) {
            return b.a;
        }
        return null;
    }

    @Override // sdk.pendo.io.l4.f.a
    @Nullable
    public sdk.pendo.io.l4.f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        if (type == e0.class) {
            return w.a(annotationArr, (Class<? extends Annotation>) sdk.pendo.io.n4.w.class) ? c.a : C0411a.a;
        }
        if (type == Void.class) {
            return f.a;
        }
        if (!this.a || type != Unit.class) {
            return null;
        }
        try {
            return e.a;
        } catch (NoClassDefFoundError unused) {
            this.a = false;
            return null;
        }
    }
}
