package sdk.pendo.io.s7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class u0 {
    private static final Object a = new Object();
    private static volatile String b;

    public static synchronized Boolean a(Context context, int i) {
        try {
            try {
                Bundle bundle = MAMPackageManagement.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
                if (bundle != null) {
                    return Boolean.valueOf(bundle.getBoolean(context.getString(i)));
                }
            } catch (PackageManager.NameNotFoundException e) {
                PendoLogger.i(e, e.getMessage(), new Object[0]);
            }
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
        }
        return Boolean.FALSE;
    }

    public static boolean b(Context context) {
        return a(context, R.string.pnd_debug_log).booleanValue();
    }

    private static SharedPreferences c() {
        return PendoInternal.o().getSharedPreferences("insert_settings", 0);
    }

    public static String a(Context context) {
        return b(context, R.string.pnd_device_url);
    }

    private static SharedPreferences.Editor b() {
        return c().edit();
    }

    public static boolean c(Context context) {
        return a(context, R.string.pnd_write_backend_response_to_file).booleanValue();
    }

    public static String a(int i) {
        return s0.c().getString(i);
    }

    public static String b(Context context, int i) {
        try {
            Bundle bundle = MAMPackageManagement.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(context.getString(i));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            PendoLogger.i(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String a() {
        String strA;
        String str = b;
        if (str != null) {
            return str;
        }
        synchronized (a) {
            strA = b;
            if (strA == null) {
                strA = a(R.string.pnd_sdk_version);
                b = strA;
            }
        }
        return strA;
    }

    public static void b(String str, String str2) {
        b().putString(str, str2).apply();
    }

    public static String a(String str, String str2) {
        return c().getString(str, str2);
    }
}
