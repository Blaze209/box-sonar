package sdk.pendo.io.f0;

import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sdk.pendo.io.a0.j;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static String a(Constructor<?> constructor) {
        StringBuilder sbAppend = new StringBuilder(constructor.getDeclaringClass().getName()).append(ColorSerializer.PREFIX).append(constructor.getDeclaringClass().getSimpleName()).append('(');
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                sbAppend.append(", ");
            }
            sbAppend.append(parameterTypes[i].getSimpleName());
        }
        return sbAppend.append(')').toString();
    }

    public static String b(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e) {
            return "Failed making constructor '" + a(constructor) + "' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
        }
    }

    public static void a(Field field) {
        try {
            field.setAccessible(true);
        } catch (Exception e) {
            throw new j("Failed making field '" + field.getDeclaringClass().getName() + "#" + field.getName() + "' accessible; either change its visibility or write a custom TypeAdapter for its declaring type", e);
        }
    }
}
