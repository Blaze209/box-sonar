package sdk.pendo.io.t;

import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    private static final class a<T> {
        private final Class<T> a;
        final ResourceEncoder<T> b;

        a(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.a = cls;
            this.b = resourceEncoder;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        this.a.add(new a<>(cls, resourceEncoder));
    }

    public synchronized <Z> ResourceEncoder<Z> a(Class<Z> cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.a.get(i);
            if (aVar.a(cls)) {
                return (ResourceEncoder<Z>) aVar.b;
            }
        }
        return null;
    }
}
