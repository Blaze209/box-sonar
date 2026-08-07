package sdk.pendo.io.n0;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.o0.e;
import sdk.pendo.io.p0.c;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final sdk.pendo.io.p0.a a = new C0425a();

    /* JADX INFO: renamed from: sdk.pendo.io.n0.a$a, reason: collision with other inner class name */
    class C0425a implements sdk.pendo.io.p0.a {
        C0425a() {
        }

        @Override // sdk.pendo.io.p0.a
        public Map a() {
            return new b();
        }

        @Override // sdk.pendo.io.p0.a
        public List b() {
            return new ArrayList();
        }
    }

    static class b extends LinkedHashMap<String, Object> {
        b() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object put(String str, Object obj) {
            if (containsKey(str)) {
                throw new IllegalArgumentException("An entry for '" + str + "' already exists. Names must be unique.");
            }
            return super.put(str, obj);
        }
    }

    public static Map<String, Object> a(String str) throws g {
        try {
            Object objA = new sdk.pendo.io.p0.b().a(str, a);
            if (objA != null) {
                return (Map) objA;
            }
            throw new g("Parsing returned null");
        } catch (ClassCastException e) {
            throw new g("Expecting a JSON object at the root but " + e, e);
        } catch (IllegalArgumentException | c e2) {
            throw new g("Parsing error: " + e2, e2);
        }
    }

    public static String a(Map<String, ?> map) {
        return e.a(map);
    }
}
