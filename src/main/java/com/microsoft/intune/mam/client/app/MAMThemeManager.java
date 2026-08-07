package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMThemeManager {
    private MAMThemeManager() {
    }

    public static void setAppTheme(int i) {
        ((ThemeManagerBehavior) MAMComponents.get(ThemeManagerBehavior.class)).setAppTheme(i);
    }
}
