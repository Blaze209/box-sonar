package sdk.pendo.io.c0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final Map<Type, sdk.pendo.io.a0.e<?>> a;
    private final boolean b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ Type a;

        a(Type type) {
            this.a = type;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new sdk.pendo.io.a0.j("Invalid EnumMap type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new sdk.pendo.io.a0.j("Invalid EnumMap type: " + this.a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements sdk.pendo.io.c0.h<T> {
        b() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: sdk.pendo.io.c0.c$c, reason: collision with other inner class name */
    class C0357c<T> implements sdk.pendo.io.c0.h<T> {
        C0357c() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements sdk.pendo.io.c0.h<T> {
        d() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements sdk.pendo.io.c0.h<T> {
        e() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements sdk.pendo.io.c0.h<T> {
        f() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new sdk.pendo.io.c0.g();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements sdk.pendo.io.c0.h<T> {
        private final sdk.pendo.io.c0.l a = sdk.pendo.io.c0.l.a();
        final /* synthetic */ Class b;

        g(Class cls) {
            this.b = cls;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            try {
                return (T) this.a.b(this.b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.b + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            throw new sdk.pendo.io.a0.j(this.a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ sdk.pendo.io.a0.e a;
        final /* synthetic */ Type b;

        i(sdk.pendo.io.a0.e eVar, Type type) {
            this.a = eVar;
            this.b = type;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ sdk.pendo.io.a0.e a;
        final /* synthetic */ Type b;

        j(sdk.pendo.io.a0.e eVar, Type type) {
            this.a = eVar;
            this.b = type;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            throw new sdk.pendo.io.a0.j(this.a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ Constructor a;

        l(Constructor constructor) {
            this.a = constructor;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            try {
                return (T) this.a.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements sdk.pendo.io.c0.h<T> {
        m() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements sdk.pendo.io.c0.h<T> {
        final /* synthetic */ Type a;

        n(Type type) {
            this.a = type;
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new sdk.pendo.io.a0.j("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new sdk.pendo.io.a0.j("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class o<T> implements sdk.pendo.io.c0.h<T> {
        o() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class p<T> implements sdk.pendo.io.c0.h<T> {
        p() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class q<T> implements sdk.pendo.io.c0.h<T> {
        q() {
        }

        @Override // sdk.pendo.io.c0.h
        public T a() {
            return (T) new ArrayList();
        }
    }

    public c(Map<Type, sdk.pendo.io.a0.e<?>> map, boolean z) {
        this.a = map;
        this.b = z;
    }

    private <T> sdk.pendo.io.c0.h<T> b(Class<? super T> cls) {
        return this.b ? new g(cls) : new h("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> sdk.pendo.io.c0.h<T> a(sdk.pendo.io.g0.a<T> aVar) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        sdk.pendo.io.a0.e<?> eVar = this.a.get(typeB);
        if (eVar != null) {
            return new i(eVar, typeB);
        }
        sdk.pendo.io.a0.e<?> eVar2 = this.a.get(clsA);
        if (eVar2 != null) {
            return new j(eVar2, typeB);
        }
        sdk.pendo.io.c0.h<T> hVarA = a(clsA);
        if (hVarA != null) {
            return hVarA;
        }
        sdk.pendo.io.c0.h<T> hVarA2 = a(typeB, clsA);
        return hVarA2 != null ? hVarA2 : b(clsA);
    }

    public String toString() {
        return this.a.toString();
    }

    private <T> sdk.pendo.io.c0.h<T> a(Class<? super T> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            String strB = sdk.pendo.io.f0.a.b(declaredConstructor);
            return strB != null ? new k(strB) : new l(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> sdk.pendo.io.c0.h<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new m();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new n(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new o();
            }
            return Queue.class.isAssignableFrom(cls) ? new p() : new q();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == EnumMap.class) {
            return new a(type);
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new b();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new C0357c();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new d();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(sdk.pendo.io.g0.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new f() : new e();
    }
}
