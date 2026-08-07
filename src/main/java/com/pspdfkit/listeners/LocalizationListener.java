package com.pspdfkit.listeners;

import android.content.Context;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public interface LocalizationListener {
    String getLocalizedQuantityString(Context context, int i, Locale locale, View view, int i2, Object... objArr);

    String getLocalizedString(Context context, int i, Locale locale, View view);

    String getLocalizedString(Context context, int i, Locale locale, View view, Object... objArr);
}
