package sdk.pendo.io.v1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class f<T> extends k<T> {
    final ParameterizedType c;
    final Class<?> d;
    final Class<?> e;
    final sdk.pendo.io.p1.d<?> f;
    final Type g;
    final Type h;
    final Class<?> i;
    final Class<?> j;
    k<?> k;

    public f(j jVar, ParameterizedType parameterizedType) {
        super(jVar);
        this.c = parameterizedType;
        Class cls = (Class) parameterizedType.getRawType();
        this.d = cls;
        this.e = cls.isInterface() ? sdk.pendo.io.r1.d.class : cls;
        this.f = sdk.pendo.io.p1.d.a(this.e, sdk.pendo.io.r1.h.a);
        Type type = parameterizedType.getActualTypeArguments()[0];
        this.g = type;
        Type type2 = parameterizedType.getActualTypeArguments()[1];
        this.h = type2;
        this.i = (Class) (type instanceof Class ? type : ((ParameterizedType) type).getRawType());
        if (type2 instanceof Class) {
            this.j = (Class) type2;
        } else {
            this.j = (Class) ((ParameterizedType) type2).getRawType();
        }
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(sdk.pendo.io.r1.h.a(str, this.i), sdk.pendo.io.r1.h.a(obj2, this.j));
    }

    @Override // sdk.pendo.io.v1.k
    public Object b() {
        try {
            return this.e.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> a(String str) {
        if (this.k == null) {
            this.k = this.a.a(this.h);
        }
        return this.k;
    }

    @Override // sdk.pendo.io.v1.k
    public k<?> b(String str) {
        if (this.k == null) {
            this.k = this.a.a(this.h);
        }
        return this.k;
    }
}
