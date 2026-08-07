package sdk.pendo.io.a1;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class h {
    public static Long a(Map<String, ?> map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            return Long.valueOf(((Number) obj).longValue());
        }
        return null;
    }

    public static String b(Map<String, Object> map, String str) {
        return (String) map.get(str);
    }

    public static List<String> c(Map<String, Object> map, String str) {
        return (List) map.get(str);
    }

    public static String d(Map<String, Object> map, String str) throws g {
        Object obj = map.get(str);
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            throw new g("'" + str + "' parameter was " + a(obj) + " type but is required to be a String.");
        }
    }

    public static String a(Object obj) {
        if (obj instanceof Number) {
            return "Number";
        }
        if (obj instanceof Boolean) {
            return "Boolean";
        }
        if (obj instanceof List) {
            return "Array";
        }
        if (obj instanceof Map) {
            return "Object";
        }
        return obj instanceof String ? "String" : "unknown";
    }
}
