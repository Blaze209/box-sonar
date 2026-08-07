package sdk.pendo.io.x1;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T> extends sdk.pendo.io.c2.b<T, T> {
    private final Type b = (Type) sdk.pendo.io.w1.e.a((Class) sdk.pendo.io.z1.a.a((Type) getClass(), (Class<?>) b.class).get(b.class.getTypeParameters()[0]), Object.class);
    private final String c;

    protected b(String str) {
        this.c = str;
    }

    public final String c() {
        return this.c;
    }

    @Override // java.util.Map.Entry
    public final T setValue(T t) {
        throw new UnsupportedOperationException("Cannot alter Diff object.");
    }

    @Override // sdk.pendo.io.c2.b
    public final String toString() {
        return String.format("[%s: %s, %s]", this.c, a(), b());
    }
}
