package sdk.pendo.io.w1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static final String a = String.valueOf('.');
    public static final String b = String.valueOf('$');
    private static final Map<String, Class<?>> c;
    private static final Map<Class<?>, Class<?>> d;
    private static final Map<Class<?>, Class<?>> e;
    private static final Map<String, String> f;
    private static final Map<String, String> g;

    static {
        HashMap map = new HashMap();
        c = map;
        Class cls = Boolean.TYPE;
        map.put(TypedValues.Custom.S_BOOLEAN, cls);
        map.put("byte", Byte.TYPE);
        map.put("char", Character.TYPE);
        map.put("short", Short.TYPE);
        Class cls2 = Integer.TYPE;
        map.put("int", cls2);
        Class cls3 = Long.TYPE;
        map.put("long", cls3);
        map.put("double", Double.TYPE);
        Class cls4 = Float.TYPE;
        map.put(TypedValues.Custom.S_FLOAT, cls4);
        map.put("void", Void.TYPE);
        HashMap map2 = new HashMap();
        d = map2;
        map2.put(cls, Boolean.class);
        map2.put(Byte.TYPE, Byte.class);
        map2.put(Character.TYPE, Character.class);
        map2.put(Short.TYPE, Short.class);
        map2.put(cls2, Integer.class);
        map2.put(cls3, Long.class);
        map2.put(Double.TYPE, Double.class);
        map2.put(cls4, Float.class);
        Class cls5 = Void.TYPE;
        map2.put(cls5, cls5);
        e = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Class<?> cls6 = (Class) entry.getKey();
            Class<?> cls7 = (Class) entry.getValue();
            if (!cls6.equals(cls7)) {
                e.put(cls7, cls6);
            }
        }
        HashMap map3 = new HashMap();
        map3.put("int", "I");
        map3.put(TypedValues.Custom.S_BOOLEAN, "Z");
        map3.put(TypedValues.Custom.S_FLOAT, "F");
        map3.put("long", "J");
        map3.put("short", ExifInterface.LATITUDE_SOUTH);
        map3.put("byte", "B");
        map3.put("double", "D");
        map3.put("char", "C");
        HashMap map4 = new HashMap();
        for (Map.Entry entry2 : map3.entrySet()) {
            map4.put(entry2.getValue(), entry2.getKey());
        }
        f = Collections.unmodifiableMap(map3);
        g = Collections.unmodifiableMap(map4);
    }

    public static String a(Class<?> cls) {
        return cls == null ? "" : a(cls.getName());
    }

    public static boolean b(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || c(cls);
    }

    public static boolean c(Class<?> cls) {
        return e.containsKey(cls);
    }

    public static Class<?> d(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : d.get(cls);
    }

    public static Class<?> e(Class<?> cls) {
        return e.get(cls);
    }

    public static String a(String str) {
        if (g.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map<String, String> map = g;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iIndexOf = str.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb);
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return a(cls, cls2, true);
    }

    public static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = d(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = e(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class cls3 = Integer.TYPE;
        if (cls3.equals(cls)) {
            return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        Class cls4 = Long.TYPE;
        if (cls4.equals(cls)) {
            return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        }
        Class cls5 = Float.TYPE;
        if (cls5.equals(cls)) {
            return Double.TYPE.equals(cls2);
        }
        if (Character.TYPE.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Short.TYPE.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Byte.TYPE.equals(cls)) {
            return Short.TYPE.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
        }
        return false;
    }
}
