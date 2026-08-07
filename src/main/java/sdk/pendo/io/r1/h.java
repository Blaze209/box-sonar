package sdk.pendo.io.r1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class h {
    public static final a a = new a();

    public static class a implements sdk.pendo.io.p1.j {
        @Override // sdk.pendo.io.p1.j
        public boolean a(Field field, Method method) {
            sdk.pendo.io.s1.a aVar = (sdk.pendo.io.s1.a) method.getAnnotation(sdk.pendo.io.s1.a.class);
            return aVar == null || !aVar.value();
        }
    }

    public static Object a(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (!cls.isAssignableFrom(obj.getClass())) {
            if (!cls.isPrimitive()) {
                if (cls.isEnum()) {
                    return Enum.valueOf(cls, obj.toString());
                }
                if (cls == Integer.class) {
                    return obj instanceof Number ? Integer.valueOf(((Number) obj).intValue()) : Integer.valueOf(obj.toString());
                }
                if (cls == Long.class) {
                    return obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : Long.valueOf(obj.toString());
                }
                if (cls == Short.class) {
                    return obj instanceof Number ? Short.valueOf(((Number) obj).shortValue()) : Short.valueOf(obj.toString());
                }
                if (cls == Byte.class) {
                    return obj instanceof Number ? Byte.valueOf(((Number) obj).byteValue()) : Byte.valueOf(obj.toString());
                }
                if (cls == Float.class) {
                    return obj instanceof Number ? Float.valueOf(((Number) obj).floatValue()) : Float.valueOf(obj.toString());
                }
                if (cls == Double.class) {
                    return obj instanceof Number ? Double.valueOf(((Number) obj).doubleValue()) : Double.valueOf(obj.toString());
                }
                if (cls == Character.class) {
                    String string = cls.toString();
                    if (string.length() > 0) {
                        return Character.valueOf(string.charAt(0));
                    }
                }
                throw new RuntimeException("Object: Can not Convert " + obj.getClass().getName() + " to " + cls.getName());
            }
            if (!(obj instanceof Number)) {
                if (cls == Integer.TYPE) {
                    return Integer.valueOf(obj.toString());
                }
                if (cls == Short.TYPE) {
                    return Short.valueOf(obj.toString());
                }
                if (cls == Long.TYPE) {
                    return Long.valueOf(obj.toString());
                }
                if (cls == Byte.TYPE) {
                    return Byte.valueOf(obj.toString());
                }
                if (cls == Float.TYPE) {
                    return Float.valueOf(obj.toString());
                }
                if (cls == Double.TYPE) {
                    return Double.valueOf(obj.toString());
                }
                if (cls == Character.TYPE) {
                    String string2 = cls.toString();
                    if (string2.length() > 0) {
                        return Character.valueOf(string2.charAt(0));
                    }
                } else if (cls == Boolean.TYPE) {
                    return (Boolean) obj;
                }
                throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to " + cls.getName());
            }
        }
        return obj;
    }

    public static String b(String str) {
        int length = str.length();
        char[] cArr = new char[length + 2];
        cArr[0] = 'i';
        cArr[1] = 's';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[2] = cCharAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 2] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String a(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[3] = cCharAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }
}
