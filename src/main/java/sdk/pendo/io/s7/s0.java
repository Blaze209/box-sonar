package sdk.pendo.io.s7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.Locale;
import sdk.pendo.io.PendoInternal;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 {
    private static final Object a = new Object();
    private static volatile Resources b;

    private static String a(String str) {
        int i;
        int iIndexOf = str.indexOf("/");
        return (iIndexOf == -1 || (i = iIndexOf + 1) >= str.length()) ? str : str.substring(i);
    }

    public static String b() {
        Locale localeA = a();
        return localeA != null ? localeA.toString() : "";
    }

    public static Resources c() {
        Resources resources;
        Resources resources2 = b;
        if (resources2 != null) {
            return resources2;
        }
        synchronized (a) {
            resources = b;
            if (resources == null) {
                resources = PendoInternal.o().getResources();
                b = resources;
            }
        }
        return resources;
    }

    public static String a(Bitmap bitmap) {
        return e1.a(Bitmap.CompressFormat.JPEG, 10, bitmap);
    }

    public static int b(String str) {
        String strA = a(str);
        if (str.startsWith("android:id")) {
            int identifier = Resources.getSystem().getIdentifier(strA, "id", "android");
            if (identifier != 0) {
                return identifier;
            }
            return -1;
        }
        int identifier2 = c().getIdentifier(strA, "id", PendoInternal.o().getPackageName());
        if (identifier2 != 0) {
            return identifier2;
        }
        return -1;
    }

    public static Locale a() {
        Context contextO = PendoInternal.o();
        if (contextO == null || contextO.getResources() == null || contextO.getResources().getConfiguration() == null || contextO.getResources().getConfiguration().locale == null) {
            return null;
        }
        return contextO.getResources().getConfiguration().locale;
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if ((str != null && str2 == null) || (str == null && str2 != null)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        if (a(str).equals(a(str2))) {
            return (str.contains(":id/") && str2.contains(":id/")) ? false : true;
        }
        return false;
    }

    public static String a(int i) {
        if (i != 1) {
            return i != 2 ? "Undefined" : "Landscape";
        }
        return "Portrait";
    }
}
