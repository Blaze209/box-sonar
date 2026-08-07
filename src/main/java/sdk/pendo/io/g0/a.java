package sdk.pendo.io.g0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sdk.pendo.io.c0.b;

/* JADX INFO: loaded from: classes4.dex */
public class a<T> {
    final Class<? super T> a;
    final Type b;
    final int c;

    protected a() {
        Type typeB = b(getClass());
        this.b = typeB;
        this.a = (Class<? super T>) b.e(typeB);
        this.c = typeB.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.h(this.b);
    }

    a(Type type) {
        Type typeB = b.b((Type) sdk.pendo.io.c0.a.a(type));
        this.b = typeB;
        this.a = (Class<? super T>) b.e(typeB);
        this.c = typeB.hashCode();
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final Type b() {
        return this.b;
    }

    public final Class<? super T> a() {
        return this.a;
    }
}
