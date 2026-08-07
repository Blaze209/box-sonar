package sdk.pendo.io.t0;

import java.io.Serializable;
import java.security.Key;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.a1.h;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements Serializable {
    private String a;
    private String b;
    private String c;
    private List<String> d;
    protected Map<String, Object> e;
    protected Key f;

    public static class a {
        public static b a(String str) {
            return a(sdk.pendo.io.n0.a.a(str));
        }

        public static b a(Map<String, Object> map) throws g {
            String strB = b.b(map, "kty");
            strB.hashCode();
            strB.hashCode();
            switch (strB) {
                case "EC":
                    return new sdk.pendo.io.t0.a(map);
                case "OKP":
                    return new c(map);
                case "RSA":
                    return new f(map);
                case "oct":
                    return new d(map);
                default:
                    throw new g("Unknown key type algorithm: '" + strB + "'");
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.t0.b$b, reason: collision with other inner class name */
    public enum EnumC0488b {
        INCLUDE_PRIVATE,
        INCLUDE_SYMMETRIC,
        PUBLIC_ONLY
    }

    protected b(Key key) {
        this.e = new LinkedHashMap();
        this.f = key;
    }

    public Key a() {
        return this.f;
    }

    protected abstract void a(Map<String, Object> map, EnumC0488b enumC0488b);

    public String b() {
        return this.b;
    }

    public abstract String c();

    public void c(String str) {
        this.a = str;
    }

    public String d() {
        return this.a;
    }

    public String getAlgorithm() {
        return this.c;
    }

    public String toString() {
        return getClass().getName() + a(EnumC0488b.PUBLIC_ONLY);
    }

    protected b(Map<String, Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.e = linkedHashMap;
        linkedHashMap.putAll(map);
        a("kty", "use", "kid", "alg", "key_ops");
        c(a(map, "use"));
        b(a(map, "kid"));
        a(a(map, "alg"));
        if (map.containsKey("key_ops")) {
            this.d = h.c(map, "key_ops");
        }
    }

    protected static String a(Map<String, Object> map, String str) {
        return h.d(map, str);
    }

    protected static String b(Map<String, Object> map, String str) {
        return a(map, str, true);
    }

    protected static String a(Map<String, Object> map, String str, boolean z) {
        String strA = a(map, str);
        if (strA == null && z) {
            throw new g("Missing required '" + str + "' parameter.");
        }
        return strA;
    }

    public void b(String str) {
        this.b = str;
    }

    protected void a(String str, Object obj, Map<String, Object> map) {
        if (obj != null) {
            map.put(str, obj);
        }
    }

    protected void a(String... strArr) {
        for (String str : strArr) {
            this.e.remove(str);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public Map<String, Object> a(EnumC0488b enumC0488b) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kty", c());
        a("kid", b(), linkedHashMap);
        a("use", d(), linkedHashMap);
        a("key_ops", this.d, linkedHashMap);
        a("alg", getAlgorithm(), linkedHashMap);
        a(linkedHashMap, enumC0488b);
        linkedHashMap.putAll(this.e);
        return linkedHashMap;
    }
}
