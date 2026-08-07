package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineThemeManagerBehavior extends ThemeManagerBehaviorBase implements ThemeManagerBehavior {
    private int mAppTheme = 0;

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public void setAppTheme(int i) {
        this.mAppTheme = i;
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public int getAppTheme() {
        return this.mAppTheme;
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public void applyAppThemeOrDefault(Context context, int i) {
        int i2 = this.mAppTheme;
        if (i2 != 0) {
            context.setTheme(i2);
        } else {
            context.setTheme(i);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public boolean hasAppTheme() {
        return this.mAppTheme != 0;
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public void applyBackgroundColor(Window window, int i, Context context) {
        applyBackgroundColor(window, getBackgroundColor(i, context));
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public int getTextColor(int i, Context context) {
        return hasAppTheme() ? getTextColor(context, getAppTheme()) : i;
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public int getAccentColor(int i, Context context) {
        return hasAppTheme() ? getAccentColor(context, getAppTheme()) : i;
    }

    @Override // com.microsoft.intune.mam.client.app.ThemeManagerBehavior
    public int getBackgroundColor(int i, Context context) {
        return hasAppTheme() ? getBackgroundColor(context, getAppTheme()) : i;
    }
}
