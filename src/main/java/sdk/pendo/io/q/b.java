package sdk.pendo.io.q;

import external.sdk.pendo.io.glide.load.resource.transcode.UnitTranscoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private final List<a<?, ?>> a = new ArrayList();

    private static final class a<Z, R> {
        final Class<Z> a;
        final Class<R> b;
        final sdk.pendo.io.q.a<Z, R> c;

        a(Class<Z> cls, Class<R> cls2, sdk.pendo.io.q.a<Z, R> aVar) {
            this.a = cls;
            this.b = cls2;
            this.c = aVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <Z, R> sdk.pendo.io.q.a<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.get();
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2)) {
                return (sdk.pendo.io.q.a<Z, R>) aVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, sdk.pendo.io.q.a<Z, R> aVar) {
        this.a.add(new a<>(cls, cls2, aVar));
    }
}
