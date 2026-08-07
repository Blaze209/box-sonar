package sdk.pendo.io.t;

import androidx.collection.ArrayMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.y.j;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    private final AtomicReference<j> a = new AtomicReference<>();
    private final ArrayMap<j, List<Class<?>>> b = new ArrayMap<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        j andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new j(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = this.b.get(andSet);
        }
        this.a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new j(cls, cls2, cls3), list);
        }
    }
}
