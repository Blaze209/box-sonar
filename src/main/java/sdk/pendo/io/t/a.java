package sdk.pendo.io.t;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    private final List<C0487a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: sdk.pendo.io.t.a$a, reason: collision with other inner class name */
    private static final class C0487a<T> {
        private final Class<T> a;
        final sdk.pendo.io.e.d<T> b;

        C0487a(Class<T> cls, sdk.pendo.io.e.d<T> dVar) {
            this.a = cls;
            this.b = dVar;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, sdk.pendo.io.e.d<T> dVar) {
        this.a.add(new C0487a<>(cls, dVar));
    }

    public synchronized <T> sdk.pendo.io.e.d<T> a(Class<T> cls) {
        for (C0487a<?> c0487a : this.a) {
            if (c0487a.a(cls)) {
                return (sdk.pendo.io.e.d<T>) c0487a.b;
            }
        }
        return null;
    }
}
