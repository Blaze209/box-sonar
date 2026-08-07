package sdk.pendo.io.s4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.p;
import sdk.pendo.io.k3.q;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.l4.s;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends sdk.pendo.io.l4.c.a {
    private final p a;
    private final boolean b;

    private g(p pVar, boolean z) {
        this.a = pVar;
        this.b = z;
    }

    public static g a() {
        return new g(null, false);
    }

    @Override // sdk.pendo.io.l4.c.a
    public sdk.pendo.io.l4.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        Type typeA;
        boolean z;
        boolean z2;
        String str;
        Class<?> clsA = sdk.pendo.io.l4.c.a.a(type);
        if (clsA == sdk.pendo.io.k3.b.class) {
            return new f(Void.class, this.a, this.b, false, true, false, false, false, true);
        }
        boolean z3 = clsA == sdk.pendo.io.k3.d.class;
        boolean z4 = clsA == q.class;
        boolean z5 = clsA == sdk.pendo.io.k3.g.class;
        if (clsA != j.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z3) {
                str = "Flowable";
            } else if (z4) {
                str = "Single";
            } else {
                str = z5 ? "Maybe" : "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeA2 = sdk.pendo.io.l4.c.a.a(0, (ParameterizedType) type);
        Class<?> clsA2 = sdk.pendo.io.l4.c.a.a(typeA2);
        if (clsA2 == r.class) {
            if (!(typeA2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            typeA = sdk.pendo.io.l4.c.a.a(0, (ParameterizedType) typeA2);
            z2 = false;
            z = false;
        } else if (clsA2 != d.class) {
            typeA = typeA2;
            z = true;
            z2 = false;
        } else {
            if (!(typeA2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            typeA = sdk.pendo.io.l4.c.a.a(0, (ParameterizedType) typeA2);
            z2 = true;
            z = false;
        }
        return new f(typeA, this.a, this.b, z2, z, z3, z4, z5, false);
    }
}
