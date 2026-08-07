package external.sdk.pendo.io.glide.load.data;

import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final external.sdk.pendo.io.glide.load.data.b.a<?> b = new a();
    private final Map<Class<?>, external.sdk.pendo.io.glide.load.data.b.a<?>> a = new HashMap();

    class a implements external.sdk.pendo.io.glide.load.data.b.a<Object> {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public external.sdk.pendo.io.glide.load.data.b<Object> build(Object obj) {
            return new b(obj);
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    private static final class b implements external.sdk.pendo.io.glide.load.data.b<Object> {
        private final Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // external.sdk.pendo.io.glide.load.data.b
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.b
        public Object rewindAndGet() {
            return this.a;
        }
    }

    public synchronized <T> external.sdk.pendo.io.glide.load.data.b<T> a(T t) {
        external.sdk.pendo.io.glide.load.data.b.a<?> aVar;
        k.a(t);
        aVar = this.a.get(t.getClass());
        if (aVar == null) {
            for (external.sdk.pendo.io.glide.load.data.b.a<?> aVar2 : this.a.values()) {
                if (aVar2.getDataClass().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = b;
        }
        return (external.sdk.pendo.io.glide.load.data.b<T>) aVar.build(t);
    }

    public synchronized void a(external.sdk.pendo.io.glide.load.data.b.a<?> aVar) {
        this.a.put(aVar.getDataClass(), aVar);
    }
}
