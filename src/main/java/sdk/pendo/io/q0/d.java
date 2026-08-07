package sdk.pendo.io.q0;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.q0.a;

/* JADX INFO: loaded from: classes4.dex */
public class d<A extends a> {
    private final sdk.pendo.io.v4.a a;
    private String b;
    private final Map<String, A> c = new LinkedHashMap();

    public d(String str, Class<A> cls) {
        this.b = str;
        this.a = sdk.pendo.io.v4.b.a(getClass().getName() + "->" + cls.getSimpleName());
    }

    public A a(String str) throws sdk.pendo.io.a1.e {
        A a = this.c.get(str);
        if (a != null) {
            return a;
        }
        throw new sdk.pendo.io.a1.e(str + " is an unknown, unsupported or unavailable " + this.b + " algorithm (not one of " + a() + ").");
    }

    public void b(A a) {
        String strC = a.c();
        if (!a(a)) {
            this.a.a("{} is unavailable so will not be registered for {} algorithms.", strC, this.b);
        } else {
            this.c.put(strC, a);
            this.a.a("{} registered for {} algorithm {}", a, this.b, strC);
        }
    }

    public Set<String> a() {
        return Collections.unmodifiableSet(this.c.keySet());
    }

    private boolean a(A a) {
        try {
            return a.d();
        } catch (Throwable th) {
            this.a.a("Unexpected problem checking for availability of " + a.c() + " algorithm: " + sdk.pendo.io.a1.b.a(th));
            return false;
        }
    }
}
