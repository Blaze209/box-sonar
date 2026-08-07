package com.microsoft.intune.mam.client;

/* JADX INFO: loaded from: classes3.dex */
public final class InterfaceComponentsAccess {
    private static ComponentsContainer sComponents;

    public static void initialize(ComponentsContainer componentsContainer) {
        sComponents = componentsContainer;
    }

    public static <T> T get(Class<T> cls) {
        return (T) sComponents.get(cls);
    }

    public static boolean isInitialized() {
        return sComponents != null;
    }

    private InterfaceComponentsAccess() {
    }
}
