package external.sdk.pendo.io.gson.internal;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.a0.a;
import sdk.pendo.io.a0.b;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.b0.d;
import sdk.pendo.io.b0.e;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class Excluder implements u, Cloneable {
    public static final Excluder g = new Excluder();
    private boolean d;
    private double a = -1.0d;
    private int b = 136;
    private boolean c = true;
    private List<a> e = Collections.emptyList();
    private List<a> f = Collections.emptyList();

    private boolean b(Class<?> cls, boolean z) {
        Iterator<a> it = (z ? this.e : this.f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // sdk.pendo.io.a0.u
    public <T> TypeAdapter<T> a(final Gson gson, final sdk.pendo.io.g0.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        boolean zA = a(clsA);
        final boolean z = zA || b(clsA, true);
        final boolean z2 = zA || b(clsA, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: external.sdk.pendo.io.gson.internal.Excluder.1
                private TypeAdapter<T> a;

                private TypeAdapter<T> b() {
                    TypeAdapter<T> typeAdapter = this.a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> typeAdapterA = gson.a(Excluder.this, aVar);
                    this.a = typeAdapterA;
                    return typeAdapterA;
                }

                @Override // external.sdk.pendo.io.gson.TypeAdapter
                public T a(sdk.pendo.io.h0.a aVar2) throws IOException {
                    if (!z2) {
                        return b().a(aVar2);
                    }
                    aVar2.z();
                    return null;
                }

                @Override // external.sdk.pendo.io.gson.TypeAdapter
                public void a(c cVar, T t) throws IOException {
                    if (z) {
                        cVar.k();
                    } else {
                        b().a(cVar, t);
                    }
                }
            };
        }
        return null;
    }

    public Excluder b() {
        Excluder excluderClone = clone();
        excluderClone.d = true;
        return excluderClone;
    }

    private boolean b(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) || d(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(Class<?> cls) {
        if (this.a == -1.0d || a((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return (!this.c && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Field field, boolean z) {
        sdk.pendo.io.b0.a aVar;
        if ((this.b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.a != -1.0d && !a((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.d && ((aVar = (sdk.pendo.io.b0.a) field.getAnnotation(sdk.pendo.io.b0.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.c && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<a> list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        b bVar = new b(field);
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.value() <= this.a;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.value() > this.a;
    }

    private boolean a(d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }
}
