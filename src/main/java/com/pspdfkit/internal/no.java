package com.pspdfkit.internal;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import com.pspdfkit.listeners.DefaultLocalizationListener;
import com.pspdfkit.listeners.LocalizationListener;
import com.pspdfkit.utils.PdfLog;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class no {
    public static String a(final Context context, final int i, final int i2, Object... objArr) throws Exception {
        if (lo.a == null) {
            lo.a = new DefaultLocalizationListener();
        }
        LocalizationListener localizationListener = lo.a;
        localizationListener.getClass();
        final View view = null;
        final String localizedQuantityString = localizationListener.getLocalizedQuantityString(context, i, a(context), null, i2, objArr);
        PdfLog.v("Nutri.LocalizationUtils", new Callable() { // from class: com.pspdfkit.internal.no$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return no.a(context, i, i2, localizedQuantityString, view);
            }
        });
        return localizedQuantityString;
    }

    public static String b(Context context) {
        return DateFormat.getDateFormat(context).format(Calendar.getInstance().getTime());
    }

    public static String c(Context context) {
        java.text.DateFormat dateFormat = DateFormat.getDateFormat(context);
        java.text.DateFormat timeFormat = DateFormat.getTimeFormat(context);
        Date time = Calendar.getInstance().getTime();
        return dateFormat.format(time) + ", " + timeFormat.format(time);
    }

    public static String d(Context context) {
        return DateFormat.getTimeFormat(context).format(Calendar.getInstance().getTime());
    }

    public static String a(Context context, int i, View view) {
        if (lo.a == null) {
            lo.a = new DefaultLocalizationListener();
        }
        LocalizationListener localizationListener = lo.a;
        localizationListener.getClass();
        return localizationListener.getLocalizedString(context, i, a(context), view);
    }

    public static String a(Context context, int i, View view, Object... objArr) {
        if (lo.a == null) {
            lo.a = new DefaultLocalizationListener();
        }
        LocalizationListener localizationListener = lo.a;
        localizationListener.getClass();
        return localizationListener.getLocalizedString(context, i, a(context), view, objArr);
    }

    public static Locale a(Context context) {
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public static String a(Context context, int i, int i2, String str, View view) throws Exception {
        return String.format(Locale.getDefault(), "Localize qty [%s][%d] to [%s] / [%s].", context.getResources().getResourceEntryName(i), Integer.valueOf(i2), str, view);
    }
}
