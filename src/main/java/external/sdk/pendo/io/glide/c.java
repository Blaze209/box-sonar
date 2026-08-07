package external.sdk.pendo.io.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private final Map<Class<?>, Object> a;

    static final class a {
        private final Map<Class<?>, Object> a = new HashMap();

        a() {
        }

        c a() {
            return new c(this);
        }
    }

    c(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class<Object> cls) {
        return this.a.containsKey(cls);
    }
}
