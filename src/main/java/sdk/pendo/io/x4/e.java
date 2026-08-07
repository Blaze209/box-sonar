package sdk.pendo.io.x4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public class e implements sdk.pendo.io.v4.a {
    private final String a;
    private volatile sdk.pendo.io.v4.a b;
    private Boolean c;
    private Method d;
    private sdk.pendo.io.w4.a e;
    private Queue<sdk.pendo.io.w4.d> f;
    private final boolean g;

    public e(String str, Queue<sdk.pendo.io.w4.d> queue, boolean z) {
        this.a = str;
        this.f = queue;
        this.g = z;
    }

    private sdk.pendo.io.v4.a c() {
        if (this.e == null) {
            this.e = new sdk.pendo.io.w4.a(this, this.f);
        }
        return this.e;
    }

    @Override // sdk.pendo.io.v4.a
    public void a(String str) {
        b().a(str);
    }

    @Override // sdk.pendo.io.v4.a
    public void b(String str, Object obj) {
        b().b(str, obj);
    }

    public boolean d() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", sdk.pendo.io.w4.c.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    public boolean e() {
        return this.b instanceof b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a.equals(((e) obj).a);
    }

    public boolean f() {
        return this.b == null;
    }

    @Override // sdk.pendo.io.v4.a
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // sdk.pendo.io.v4.a
    public void a(String str, Object obj, Object obj2) {
        b().a(str, obj, obj2);
    }

    sdk.pendo.io.v4.a b() {
        if (this.b != null) {
            return this.b;
        }
        return this.g ? b.a : c();
    }

    @Override // sdk.pendo.io.v4.a
    public void a(String str, Throwable th) {
        b().a(str, th);
    }

    @Override // sdk.pendo.io.v4.a
    public void b(String str, Object obj, Object obj2) {
        b().b(str, obj, obj2);
    }

    @Override // sdk.pendo.io.v4.a
    public void a(String str, Object... objArr) {
        b().a(str, objArr);
    }

    @Override // sdk.pendo.io.v4.a
    public void b(String str, Object... objArr) {
        b().b(str, objArr);
    }

    @Override // sdk.pendo.io.v4.a
    public boolean a() {
        return b().a();
    }

    public void a(sdk.pendo.io.w4.c cVar) {
        if (d()) {
            try {
                this.d.invoke(this.b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void a(sdk.pendo.io.v4.a aVar) {
        this.b = aVar;
    }

    @Override // sdk.pendo.io.v4.a
    public void a(String str, Object obj) {
        b().a(str, obj);
    }
}
