package sdk.pendo.io.x0;

import java.util.LinkedHashMap;
import java.util.Map;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.a1.h;
import sdk.pendo.io.t0.e;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    protected sdk.pendo.io.k0.b a = new sdk.pendo.io.k0.b();
    private Map<String, Object> b = new LinkedHashMap();
    private String c;
    private String d;

    public String a() {
        if (this.d == null) {
            this.d = this.a.c(b());
        }
        return this.d;
    }

    public String b() {
        if (this.c == null) {
            this.c = sdk.pendo.io.n0.a.a((Map<String, ?>) this.b);
        }
        return this.c;
    }

    public String c(String str) {
        return h.b(this.b, str);
    }

    void d(String str) {
        this.d = str;
        String strB = this.a.b(str);
        this.c = strB;
        this.b = sdk.pendo.io.n0.a.a(strB);
    }

    public Long a(String str) {
        return h.a(this.b, str);
    }

    public Object b(String str) {
        return this.b.get(str);
    }

    public e a(String str, String str2) throws g {
        Map map = (Map) b(str);
        if (map == null) {
            return null;
        }
        e eVarA = e.a.a((Map<String, Object>) map, str2);
        if (eVarA.g() == null) {
            return eVarA;
        }
        throw new g(str + " header contains a private key, which it most definitely should not.");
    }
}
