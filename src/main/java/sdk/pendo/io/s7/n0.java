package sdk.pendo.io.s7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import sdk.pendo.io.PendoInternal;

/* JADX INFO: loaded from: classes5.dex */
public class n0 {
    private static final Object a = new Object();

    public static void a(String str, String str2) {
        synchronized (a) {
            if (str2 != null) {
                SharedPreferences sharedPreferencesA = a(str);
                if (sharedPreferencesA != null) {
                    sharedPreferencesA.edit().remove(str2).apply();
                }
            }
        }
    }

    public static Set<String> b(String str, String str2) {
        synchronized (a) {
            SharedPreferences sharedPreferencesA = a(str);
            if (sharedPreferencesA == null) {
                return null;
            }
            return sharedPreferencesA.getStringSet(str2, null);
        }
    }

    public static SharedPreferences a(String str) {
        Context contextO = PendoInternal.o();
        synchronized (a) {
            try {
                if (contextO == null) {
                    return null;
                }
                return contextO.getSharedPreferences(str, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, int i) {
        synchronized (a) {
            SharedPreferences sharedPreferencesA = a(str);
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt(str2, i).commit();
            }
        }
    }

    public static void a(String str, String str2, long j) {
        synchronized (a) {
            SharedPreferences sharedPreferencesA = a(str);
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putLong(str2, j).commit();
            }
        }
    }

    public static void a(String str, String str2, String str3, boolean z) {
        synchronized (a) {
            SharedPreferences sharedPreferencesA = a(str);
            if (sharedPreferencesA != null && (z || !sharedPreferencesA.contains(str2))) {
                sharedPreferencesA.edit().putString(str2, str3).commit();
            }
        }
    }

    public static void a(String str, String str2, Set<String> set, boolean z) {
        synchronized (a) {
            SharedPreferences sharedPreferencesA = a(str);
            if (sharedPreferencesA != null && (z || !sharedPreferencesA.contains(str2))) {
                sharedPreferencesA.edit().putStringSet(str2, set).apply();
            }
        }
    }
}
