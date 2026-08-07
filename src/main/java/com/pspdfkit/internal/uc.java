package com.pspdfkit.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import com.pspdfkit.internal.jni.NutrientNative;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import kotlin.jvm.functions.Function0;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class uc {
    public static Integer a;
    public static final String[] b = {MsalUtils.CHROME_PACKAGE, "com.google.android.webview", "com.android.webview"};

    public static boolean a(Context context, int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.density;
        return Math.min((int) (f / f2), (int) (((float) displayMetrics.heightPixels) / f2)) >= i;
    }

    public static int b(Context context) {
        long j;
        int iMin;
        Integer num = a;
        if (num != null) {
            return num.intValue();
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            j = memoryInfo.totalMem;
        } else {
            j = -1;
        }
        boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (j <= 805306368 || NutrientNative.getNumberOfCPUCores() <= 1) {
            iMin = 262144;
        } else if (j <= FileUtils.ONE_GB) {
            iMin = Math.min(displayMetrics.widthPixels * displayMetrics.heightPixels, 1048576);
        } else if (j <= CacheValidityPolicy.MAX_AGE) {
            iMin = Math.min(displayMetrics.widthPixels * displayMetrics.heightPixels, 2359296);
        } else if (z) {
            iMin = Math.min(displayMetrics.widthPixels * displayMetrics.heightPixels, 4194304);
        } else {
            iMin = displayMetrics.heightPixels * displayMetrics.widthPixels;
        }
        Integer numValueOf = Integer.valueOf(iMin);
        a = numValueOf;
        return numValueOf.intValue();
    }

    public static boolean c(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean d(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String[] strArr = b;
        for (int i = 0; i < 3; i++) {
            try {
                PackageInfo packageInfo = MAMPackageManagement.getPackageInfo(packageManager, strArr[i], 0);
                if (packageInfo != null && packageInfo.applicationInfo.enabled) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        try {
            a(context).destroy();
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static /* synthetic */ WebView f(Context context) {
        return new MAMWebView(context.createConfigurationContext(new Configuration()));
    }

    public static WebView a(final Context context) {
        return (WebView) s40.b(new Function0() { // from class: com.pspdfkit.internal.uc$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return uc.f(context);
            }
        });
    }

    public static boolean a(Resources resources, int i, int i2) {
        int dimension = (int) resources.getDimension(i);
        int dimension2 = (int) resources.getDimension(i2);
        int i3 = resources.getDisplayMetrics().widthPixels;
        float f = resources.getDisplayMetrics().heightPixels;
        float f2 = dimension2 * 1.05f;
        if (f <= f2) {
            return false;
        }
        float f3 = dimension * 1.05f;
        if (f <= f3) {
            return false;
        }
        float f4 = i3;
        return f4 > f3 && f4 > f2;
    }
}
