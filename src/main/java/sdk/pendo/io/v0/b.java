package sdk.pendo.io.v0;

import external.sdk.pendo.io.jose4j.jwt.consumer.g;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    private Map<String, Object> a;
    private String b;

    private b(String str, g gVar) throws external.sdk.pendo.io.jose4j.jwt.consumer.c {
        this.b = str;
        try {
            this.a = new LinkedHashMap(sdk.pendo.io.n0.a.a(str));
        } catch (sdk.pendo.io.a1.g e) {
            throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Unable to parse what was expected to be the JWT Claim Set JSON: \"" + str + "\"", new external.sdk.pendo.io.jose4j.jwt.consumer.b.a(16, "Invalid JSON."), e, gVar);
        }
    }

    private String a(ClassCastException classCastException, Object obj) {
        return "(" + obj + " - " + classCastException.getMessage() + ")";
    }

    public d b() {
        return b("exp");
    }

    public d c() {
        return b("iat");
    }

    public String d() {
        return (String) a("iss", String.class);
    }

    public String e() {
        return (String) a("jti", String.class);
    }

    public d f() {
        return b("nbf");
    }

    public String g() {
        return this.b;
    }

    public String h() {
        return (String) a("sub", String.class);
    }

    public boolean i() {
        return c("aud");
    }

    public String j() {
        return sdk.pendo.io.n0.a.a((Map<String, ?>) this.a);
    }

    public String toString() {
        return "JWT Claims Set:" + this.a;
    }

    public List<String> a() throws c {
        Object obj = this.a.get("aud");
        if (obj instanceof String) {
            return Collections.singletonList((String) obj);
        }
        if ((obj instanceof List) || obj == null) {
            return a((List) obj, "aud");
        }
        throw new c("The value of the 'aud' claim is not an array of strings or a single string value.");
    }

    public d b(String str) throws c {
        Number number = (Number) a(str, Number.class);
        if (number instanceof BigInteger) {
            throw new c(number + " is unreasonable for a NumericDate");
        }
        if (number != null) {
            return d.b(number.longValue());
        }
        return null;
    }

    public boolean c(String str) {
        return a(str) != null;
    }

    public Object a(String str) {
        return this.a.get(str);
    }

    public <T> T a(String str, Class<T> cls) throws c {
        Object obj = this.a.get(str);
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new c("The value of the '" + str + "' claim is not the expected type " + a(e, obj), e);
        }
    }

    public static b a(String str, g gVar) {
        return new b(str, gVar);
    }

    private List<String> a(List list, String str) throws c {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            try {
                arrayList.add((String) obj);
            } catch (ClassCastException e) {
                throw new c("The array value of the '" + str + "' claim contains non string values " + a(e, obj), e);
            }
        }
        return arrayList;
    }
}
