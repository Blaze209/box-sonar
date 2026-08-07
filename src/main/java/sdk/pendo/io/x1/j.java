package sdk.pendo.io.x1;

/* JADX INFO: loaded from: classes6.dex */
public class j {
    private static volatile k d = k.u;
    private final StringBuffer a;
    private final Object b;
    private final k c;

    public j(Object obj, k kVar) {
        this(obj, kVar, null);
    }

    public static k b() {
        return d;
    }

    public j a(String str, Object obj) {
        this.c.a(this.a, str, obj, (Boolean) null);
        return this;
    }

    public Object c() {
        return this.b;
    }

    public StringBuffer d() {
        return this.a;
    }

    public k e() {
        return this.c;
    }

    public String toString() {
        if (c() == null) {
            d().append(e().e());
        } else {
            this.c.b(d(), c());
        }
        return d().toString();
    }

    public j(Object obj, k kVar, StringBuffer stringBuffer) {
        kVar = kVar == null ? b() : kVar;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.a = stringBuffer;
        this.c = kVar;
        this.b = obj;
        kVar.d(stringBuffer, obj);
    }

    public String a() {
        return toString();
    }
}
