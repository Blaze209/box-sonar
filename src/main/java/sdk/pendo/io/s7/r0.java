package sdk.pendo.io.s7;

import java.lang.reflect.Field;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 {
    static Field a(String str, Class cls) throws NoSuchFieldException {
        if (str == null || cls == null) {
            PendoLogger.e("can't call findField with null objects", new Object[0]);
            return null;
        }
        for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found for class " + cls);
    }

    private static Object b(String str, Object obj) throws NoSuchFieldException {
        if (obj == null) {
            return null;
        }
        Field fieldA = a(str, (Class) obj.getClass());
        fieldA.setAccessible(true);
        return fieldA.get(obj);
    }

    public static Object a(String str, Object obj) {
        try {
            return b(str, obj);
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder("field name: ");
            if (str == null) {
                str = "";
            }
            PendoLogger.e(e, message, sb.append(str).toString());
            return null;
        }
    }
}
