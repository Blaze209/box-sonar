package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineWrappedAppReflectionUtilsBehavior implements WrappedAppReflectionUtilsBehavior {
    @Override // com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior
    public Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return cls.getDeclaredMethod(str, clsArr);
    }

    @Override // com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior
    public Method[] getDeclaredMethods(Class<?> cls) {
        return cls.getDeclaredMethods();
    }

    @Override // com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior
    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return cls.getMethod(str, clsArr);
    }

    @Override // com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior
    public Method[] getMethods(Class<?> cls) {
        return cls.getMethods();
    }
}
