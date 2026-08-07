package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBuildUtils {
    private MAMBuildUtils() {
    }

    public static boolean isDeveloperBuild() {
        try {
            return Class.forName("com.microsoft.intune.mam.BuildConfig").getField("DEVELOPER_BUILD").getBoolean(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }
}
