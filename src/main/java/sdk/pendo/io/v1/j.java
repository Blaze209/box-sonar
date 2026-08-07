package sdk.pendo.io.v1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class j {
    private final ConcurrentHashMap<Type, k<?>> a;
    public k<sdk.pendo.io.r1.c> b;
    public k<sdk.pendo.io.r1.c> c;

    public j() {
        ConcurrentHashMap<Type, k<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.a = concurrentHashMap;
        concurrentHashMap.put(Date.class, b.c);
        concurrentHashMap.put(int[].class, a.c);
        concurrentHashMap.put(Integer[].class, a.d);
        concurrentHashMap.put(short[].class, a.c);
        concurrentHashMap.put(Short[].class, a.d);
        concurrentHashMap.put(long[].class, a.k);
        concurrentHashMap.put(Long[].class, a.l);
        concurrentHashMap.put(byte[].class, a.g);
        concurrentHashMap.put(Byte[].class, a.h);
        concurrentHashMap.put(char[].class, a.i);
        concurrentHashMap.put(Character[].class, a.j);
        concurrentHashMap.put(float[].class, a.m);
        concurrentHashMap.put(Float[].class, a.n);
        concurrentHashMap.put(double[].class, a.o);
        concurrentHashMap.put(Double[].class, a.p);
        concurrentHashMap.put(boolean[].class, a.q);
        concurrentHashMap.put(Boolean[].class, a.r);
        this.b = new g(this);
        this.c = new i(this);
        concurrentHashMap.put(sdk.pendo.io.r1.c.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.r1.b.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.r1.a.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.r1.d.class, this.b);
    }

    public <T> k<T> a(Class<T> cls) {
        k<T> eVar;
        k<T> hVar = (k) this.a.get(cls);
        if (hVar != null) {
            return hVar;
        }
        if (cls instanceof Class) {
            if (Map.class.isAssignableFrom(cls) || List.class.isAssignableFrom(cls)) {
                hVar = new h<>(this, cls);
            }
            if (hVar != null) {
                this.a.put(cls, hVar);
                return hVar;
            }
        }
        if (cls.isArray()) {
            eVar = new a.q<>(this, cls);
        } else if (List.class.isAssignableFrom(cls)) {
            eVar = new c<>(this, cls);
        } else {
            eVar = Map.class.isAssignableFrom(cls) ? new e<>(this, cls) : new b.C0501b<>(this, cls);
        }
        this.a.putIfAbsent(cls, eVar);
        return eVar;
    }

    public <T> k<T> a(ParameterizedType parameterizedType) {
        k<T> fVar = (k) this.a.get(parameterizedType);
        if (fVar != null) {
            return fVar;
        }
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            fVar = new d<>(this, parameterizedType);
        } else if (Map.class.isAssignableFrom(cls)) {
            fVar = new f<>(this, parameterizedType);
        }
        this.a.putIfAbsent(parameterizedType, fVar);
        return fVar;
    }

    public <T> k<T> a(Type type) {
        return type instanceof ParameterizedType ? a((ParameterizedType) type) : a((Class) type);
    }

    public <T> void a(Class<T> cls, k<T> kVar) {
        this.a.put(cls, kVar);
    }
}
