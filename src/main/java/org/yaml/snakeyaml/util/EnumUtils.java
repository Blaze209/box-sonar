package org.yaml.snakeyaml.util;

/* JADX INFO: loaded from: classes5.dex */
public class EnumUtils {
    public static <T extends Enum<T>> T findEnumInsensitiveCase(Class<T> cls, String str) {
        for (T t : cls.getEnumConstants()) {
            if (t.name().compareToIgnoreCase(str) == 0) {
                return t;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cls.getCanonicalName() + "." + str);
    }
}
