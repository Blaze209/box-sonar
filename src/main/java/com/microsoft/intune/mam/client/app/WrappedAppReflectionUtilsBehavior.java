package com.microsoft.intune.mam.client.app;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public interface WrappedAppReflectionUtilsBehavior {
    Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException;

    Method[] getDeclaredMethods(Class<?> cls);

    Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException;

    Method[] getMethods(Class<?> cls);
}
