package com.pspdfkit.listeners;

import android.content.Context;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultLocalizationListener implements LocalizationListener {
    @Override // com.pspdfkit.listeners.LocalizationListener
    public String getLocalizedQuantityString(Context context, int i, Locale locale, View view, int i2, Object... objArr) {
        if (context != null) {
            return context.getResources().getQuantityString(i, i2, objArr);
        }
        throw new IllegalArgumentException("getLocalizedQuantityString called with null context!");
    }

    @Override // com.pspdfkit.listeners.LocalizationListener
    public String getLocalizedString(Context context, int i, Locale locale, View view) {
        if (context != null) {
            return context.getString(i);
        }
        throw new IllegalArgumentException("getLocalizedString called with null context!");
    }

    @Override // com.pspdfkit.listeners.LocalizationListener
    public String getLocalizedString(Context context, int i, Locale locale, View view, Object... objArr) {
        if (context != null) {
            return context.getString(i, objArr);
        }
        throw new IllegalArgumentException("getLocalizedString called with null context!");
    }
}
