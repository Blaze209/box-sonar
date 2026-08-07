package sdk.pendo.io.p1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    protected Field a;
    protected Method b;
    protected Method c;
    protected int d;
    protected Class<?> e;
    protected Type f;
    protected String g;

    public b(Class<?> cls, Field field, j jVar) {
        this.g = field.getName();
        int modifiers = field.getModifiers();
        if ((modifiers & 136) > 0) {
            return;
        }
        if ((modifiers & 1) > 0) {
            this.a = field;
        }
        try {
            this.b = cls.getDeclaredMethod(a.c(field.getName()), field.getType());
        } catch (Exception unused) {
        }
        boolean zEquals = field.getType().equals(Boolean.TYPE);
        String name = field.getName();
        try {
            this.c = cls.getDeclaredMethod(zEquals ? a.b(name) : a.a(name), new Class[0]);
        } catch (Exception unused2) {
        }
        if (this.c == null && zEquals) {
            try {
                this.c = cls.getDeclaredMethod(a.a(field.getName()), new Class[0]);
            } catch (Exception unused3) {
            }
        }
        if (this.a == null && this.c == null && this.b == null) {
            return;
        }
        Method method = this.c;
        if (method != null && !jVar.a(field, method)) {
            this.c = null;
        }
        Method method2 = this.b;
        if (method2 != null && !jVar.a(field, method2)) {
            this.b = null;
        }
        if (this.c == null && this.b == null && this.a == null) {
            return;
        }
        this.e = field.getType();
        this.f = field.getGenericType();
    }

    public Type a() {
        return this.f;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public Class<?> d() {
        return this.e;
    }

    public boolean e() {
        return this.e.isEnum();
    }

    public boolean f() {
        return this.b == null && this.c == null;
    }

    public boolean g() {
        return (this.a == null && this.c == null) ? false : true;
    }

    public boolean h() {
        return (this.a == null && this.c == null && this.b == null) ? false : true;
    }

    public boolean i() {
        return (this.a == null && this.c == null) ? false : true;
    }
}
