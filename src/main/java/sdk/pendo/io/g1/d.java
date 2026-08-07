package sdk.pendo.io.g1;

import com.pspdfkit.analytics.Analytics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.j1.e;
import sdk.pendo.io.j1.f;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static final Map<String, Class> a;

    static {
        HashMap map = new HashMap();
        map.put("avg", sdk.pendo.io.j1.b.class);
        map.put("stddev", e.class);
        map.put("sum", f.class);
        map.put("min", sdk.pendo.io.j1.d.class);
        map.put("max", sdk.pendo.io.j1.c.class);
        map.put("concat", sdk.pendo.io.k1.a.class);
        map.put(Analytics.Data.LENGTH, sdk.pendo.io.k1.b.class);
        map.put("size", sdk.pendo.io.k1.b.class);
        map.put("append", sdk.pendo.io.h1.a.class);
        a = Collections.unmodifiableMap(map);
    }

    public static c a(String str) {
        Class cls = a.get(str);
        if (cls == null) {
            throw new sdk.pendo.io.d1.f("Function with name: " + str + " does not exist.");
        }
        try {
            return (c) cls.newInstance();
        } catch (Exception e) {
            throw new sdk.pendo.io.d1.f("Function of name: " + str + " cannot be created", e);
        }
    }
}
