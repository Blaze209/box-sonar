package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public interface ThemeManagerBehavior {
    void applyAppThemeOrDefault(Context context, int i);

    void applyBackgroundColor(Window window, int i, Context context);

    int getAccentColor(int i, Context context);

    int getAppTheme();

    int getBackgroundColor(int i, Context context);

    int getTextColor(int i, Context context);

    boolean hasAppTheme();

    void setAppTheme(int i);
}
