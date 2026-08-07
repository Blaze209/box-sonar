package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.app.offline.OfflineWrappedAppReflectionUtilsBehavior;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class WrappedAppReflectionUtils {
    static WrappedAppReflectionUtilsBehavior mBehavior;

    private WrappedAppReflectionUtils() {
    }

    private static WrappedAppReflectionUtilsBehavior getBehavior() {
        WrappedAppReflectionUtilsBehavior wrappedAppReflectionUtilsBehavior = mBehavior;
        if (wrappedAppReflectionUtilsBehavior != null) {
            return wrappedAppReflectionUtilsBehavior;
        }
        try {
            WrappedAppReflectionUtilsBehavior wrappedAppReflectionUtilsBehavior2 = (WrappedAppReflectionUtilsBehavior) MAMComponents.get(WrappedAppReflectionUtilsBehavior.class);
            mBehavior = wrappedAppReflectionUtilsBehavior2;
            return wrappedAppReflectionUtilsBehavior2;
        } catch (NoClassDefFoundError unused) {
            return new OfflineWrappedAppReflectionUtilsBehavior();
        }
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return getBehavior().getDeclaredMethod(cls, str, clsArr);
    }

    public static Method[] getDeclaredMethods(Class<?> cls) {
        return getBehavior().getDeclaredMethods(cls);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return getBehavior().getMethod(cls, str, clsArr);
    }

    public static Method[] getMethods(Class<?> cls) {
        return getBehavior().getMethods(cls);
    }
}
