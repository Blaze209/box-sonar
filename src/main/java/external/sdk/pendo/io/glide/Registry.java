package external.sdk.pendo.io.glide;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.engine.h;
import external.sdk.pendo.io.glide.load.engine.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e.i;
import sdk.pendo.io.t.f;

/* JADX INFO: loaded from: classes4.dex */
public class Registry {
    private final external.sdk.pendo.io.glide.load.model.c a;
    private final sdk.pendo.io.t.a b;
    private final sdk.pendo.io.t.e c;
    private final f d;
    private final external.sdk.pendo.io.glide.load.data.c e;
    private final sdk.pendo.io.q.b f;
    private final sdk.pendo.io.t.b g;
    private final sdk.pendo.io.t.d h = new sdk.pendo.io.t.d();
    private final sdk.pendo.io.t.c i = new sdk.pendo.io.t.c();
    private final Pools.Pool<List<Throwable>> j;

    public static final class NoImageHeaderParserException extends a {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends a {
        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<external.sdk.pendo.io.glide.load.model.b<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    public static class NoResultEncoderAvailableException extends a {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends a {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> poolB = sdk.pendo.io.z.a.b();
        this.j = poolB;
        this.a = new external.sdk.pendo.io.glide.load.model.c(poolB);
        this.b = new sdk.pendo.io.t.a();
        this.c = new sdk.pendo.io.t.e();
        this.d = new f();
        this.e = new external.sdk.pendo.io.glide.load.data.c();
        this.f = new sdk.pendo.io.q.b();
        this.g = new sdk.pendo.io.t.b();
        a(Arrays.asList("Animation", com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    public <TResource> Registry a(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.d.a(cls, resourceEncoder);
        return this;
    }

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        Class<Data> cls4;
        Class<TResource> cls5;
        Class<Transcode> cls6;
        p<Data, TResource, Transcode> pVarA = this.i.a(cls, cls2, cls3);
        p<Data, TResource, Transcode> pVar = null;
        if (this.i.a(pVarA)) {
            return null;
        }
        if (pVarA != null) {
            return pVarA;
        }
        List<h<Data, TResource, Transcode>> listA = a(cls, cls2, cls3);
        if (listA.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            pVar = new p<>(cls4, cls5, cls6, listA, this.j);
        }
        this.i.a(cls4, cls5, cls6, pVar);
        return pVar;
    }

    public <Model, TResource, Transcode> List<Class<?>> c(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.c.b(it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, i<Data, TResource> iVar) {
        a("legacy_append", cls, cls2, iVar);
        return this;
    }

    public <X> external.sdk.pendo.io.glide.load.data.b<X> b(X x) {
        return this.e.a(x);
    }

    public <X> sdk.pendo.io.e.d<X> c(X x) {
        sdk.pendo.io.e.d<X> dVarA = this.b.a(x.getClass());
        if (dVarA != null) {
            return dVarA;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.l.d<Model, Data> dVar) {
        this.a.a(cls, cls2, dVar);
        return this;
    }

    public boolean b(sdk.pendo.io.h.c<?> cVar) {
        return this.d.a(cVar.getResourceClass()) != null;
    }

    public <Data> Registry a(Class<Data> cls, sdk.pendo.io.e.d<Data> dVar) {
        this.b.a(cls, dVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, i<Data, TResource> iVar) {
        this.c.a(str, iVar, cls, cls2);
        return this;
    }

    private <Data, TResource, Transcode> List<h<Data, TResource, Transcode>> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new h(cls, cls4, cls5, this.c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.g.a();
        if (listA.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listA;
    }

    public <Model> List<external.sdk.pendo.io.glide.load.model.b<Model, ?>> a(Model model) {
        return this.a.b(model);
    }

    public <X> ResourceEncoder<X> a(sdk.pendo.io.h.c<X> cVar) {
        ResourceEncoder<X> resourceEncoderA = this.d.a(cVar.getResourceClass());
        if (resourceEncoderA != null) {
            return resourceEncoderA;
        }
        throw new NoResultEncoderAvailableException(cVar.getResourceClass());
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry a(external.sdk.pendo.io.glide.load.data.b.a<?> aVar) {
        this.e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, sdk.pendo.io.q.a<TResource, Transcode> aVar) {
        this.f.a(cls, cls2, aVar);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.c.a(arrayList);
        return this;
    }
}
