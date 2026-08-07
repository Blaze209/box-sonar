package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class f<Transcode> {
    private final List<external.sdk.pendo.io.glide.load.model.b.a<?>> a = new ArrayList();
    private final List<sdk.pendo.io.e.f> b = new ArrayList();
    private external.sdk.pendo.io.glide.b c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private g.e h;
    private Options i;
    private Map<Class<?>, Transformation<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private sdk.pendo.io.e.f n;
    private sdk.pendo.io.c.b o;
    private sdk.pendo.io.h.a p;
    private boolean q;
    private boolean r;

    f() {
    }

    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    sdk.pendo.io.i.a b() {
        return this.c.a();
    }

    List<sdk.pendo.io.e.f> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<external.sdk.pendo.io.glide.load.model.b.a<?>> listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                external.sdk.pendo.io.glide.load.model.b.a<?> aVar = listG.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    external.sdk.pendo.io.glide.load.engine.cache.a d() {
        return this.h.a();
    }

    sdk.pendo.io.h.a e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List<external.sdk.pendo.io.glide.load.model.b.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listA = this.c.g().a(this.d);
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                external.sdk.pendo.io.glide.load.model.b.a<?> aVarBuildLoadData = ((external.sdk.pendo.io.glide.load.model.b) listA.get(i)).buildLoadData(this.d, this.e, this.f, this.i);
                if (aVarBuildLoadData != null) {
                    this.a.add(aVarBuildLoadData);
                }
            }
        }
        return this.a;
    }

    Class<?> h() {
        return this.d.getClass();
    }

    Options i() {
        return this.i;
    }

    sdk.pendo.io.c.b j() {
        return this.o;
    }

    List<Class<?>> k() {
        return this.c.g().c(this.d.getClass(), this.g, this.k);
    }

    sdk.pendo.io.e.f l() {
        return this.n;
    }

    Class<?> m() {
        return this.k;
    }

    int n() {
        return this.e;
    }

    boolean o() {
        return this.r;
    }

    <Data> p<Data, ?, Transcode> a(Class<Data> cls) {
        return this.c.g().b(cls, this.g, this.k);
    }

    <X> sdk.pendo.io.e.d<X> b(X x) {
        return this.c.g().c(x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    List<external.sdk.pendo.io.glide.load.model.b<File, ?>> a(File file) {
        return this.c.g().a(file);
    }

    <Z> Transformation<Z> b(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation) this.j.get(cls);
        if (transformation == null) {
            for (Map.Entry<Class<?>, Transformation<?>> entry : this.j.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (this.j.isEmpty() && this.q) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return UnitTransformation.get();
    }

    <Z> ResourceEncoder<Z> a(sdk.pendo.io.h.c<Z> cVar) {
        return this.c.g().a((sdk.pendo.io.h.c) cVar);
    }

    boolean b(sdk.pendo.io.h.c<?> cVar) {
        return this.c.g().b(cVar);
    }

    <T> external.sdk.pendo.io.glide.load.data.b<T> a(T t) {
        return this.c.g().b(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.e.f fVar, int i, int i2, sdk.pendo.io.h.a aVar, Class<?> cls, Class<R> cls2, sdk.pendo.io.c.b bVar2, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, g.e eVar) {
        this.c = bVar;
        this.d = obj;
        this.n = fVar;
        this.e = i;
        this.f = i2;
        this.p = aVar;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = bVar2;
        this.i = options;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    boolean a(sdk.pendo.io.e.f fVar) {
        List<external.sdk.pendo.io.glide.load.model.b.a<?>> listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (listG.get(i).a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
