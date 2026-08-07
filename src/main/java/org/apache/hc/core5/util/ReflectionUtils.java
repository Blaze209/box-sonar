package org.apache.hc.core5.util;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectionUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void callSetter(Object obj, String str, Class<?> cls, Object obj2) {
        try {
            Method method = obj.getClass().getMethod("set" + str, cls);
            method.setAccessible(true);
            method.invoke(obj, obj2);
        } catch (Exception unused) {
        }
    }

    public static <T> T callGetter(Object obj, String str, Class<T> cls) {
        return (T) callGetter(obj, str, null, null, cls);
    }

    public static <T> T callGetter(Object obj, String str, Object obj2, Class<?> cls, Class<T> cls2) {
        try {
            Class<?> cls3 = obj.getClass();
            if (obj2 != null) {
                Method method = cls3.getMethod(PasskeyWebListener.GET_UNIQUE_KEY + str, cls);
                method.setAccessible(true);
                return cls2.cast(method.invoke(obj, obj2));
            }
            Method method2 = cls3.getMethod(PasskeyWebListener.GET_UNIQUE_KEY + str, new Class[0]);
            method2.setAccessible(true);
            return cls2.cast(method2.invoke(obj, new Object[0]));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int determineJRELevel() {
        String[] strArrSplit = System.getProperty("java.version").split("\\.");
        if (strArrSplit.length <= 0) {
            return 7;
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            if (i > 1) {
                return i;
            }
            if (i != 1 || strArrSplit.length <= 1) {
                return 7;
            }
            return Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return 7;
        }
    }
}
