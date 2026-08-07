package sdk.pendo.io.p1;

import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    protected static HashMap<Class<?>, LinkedHashSet<Class<?>>> a = new HashMap<>();
    protected static HashMap<Class<?>, HashMap<String, String>> b = new HashMap<>();

    static {
        a(Object.class, h.class);
        a(Object.class, g.class);
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        synchronized (a) {
            LinkedHashSet<Class<?>> linkedHashSet = a.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                a.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
