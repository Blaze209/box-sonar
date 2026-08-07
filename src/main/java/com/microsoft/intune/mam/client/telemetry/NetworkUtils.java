package com.microsoft.intune.mam.client.telemetry;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.SystemClock;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkUtils {
    private NetworkUtils() {
    }

    public static long measureDNSLookupTime(String str) {
        if (str == null) {
            return -1L;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            InetAddress.getByName(new URL(str).getHost());
        } catch (IOException unused) {
        } catch (Throwable th) {
            SystemClock.elapsedRealtime();
            throw th;
        }
        return SystemClock.elapsedRealtime() - jElapsedRealtime;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo != null ? activeNetworkInfo.isConnected() : false) && !isNetworkDisabledByOptimizations(context);
    }

    private static boolean isNetworkDisabledByOptimizations(Context context) {
        return ((UsageStatsManager) context.getSystemService(UsageStatsManager.class)).isAppInactive(context.getPackageName()) || ((PowerManager) context.getSystemService(PowerManager.class)).isDeviceIdleMode();
    }
}
