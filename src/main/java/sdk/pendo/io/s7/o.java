package sdk.pendo.io.s7;

import android.graphics.Typeface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import sdk.pendo.io.PendoInternal;

/* JADX INFO: loaded from: classes5.dex */
public final class o {
    private static final File a = new File("/system/etc/fonts.xml");
    private static final File b = new File("/system/etc/system_fonts.xml");
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static ArrayList<String> e = new ArrayList<>();
    private static boolean f = false;

    public static boolean a(String str) {
        try {
            String[] list = PendoInternal.o().getAssets().list("fonts");
            if (list.length <= 0) {
                return true;
            }
            for (String str2 : list) {
                if ((str2.endsWith(".ttf") || str2.endsWith(".otf") || str2.endsWith(".ttc")) && !e.contains(str)) {
                    e.add("fonts/" + str2);
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Typeface b(String str) {
        String str2;
        if (e.size() == 0 && !f) {
            f = true;
            a("");
        }
        int i = 0;
        while (true) {
            if (i >= e.size()) {
                str2 = "";
                break;
            }
            String[] strArrSplit = e.get(i).split("/");
            String str3 = strArrSplit[strArrSplit.length - 1];
            if (str3.equals(str + ".ttf") || str3.equals(str + ".otf") || str3.equals(str + ".ttc")) {
                str2 = e.get(i);
                break;
            }
            i++;
        }
        if (str2.equals("")) {
            return null;
        }
        return Typeface.createFromAsset(PendoInternal.o().getAssets(), str2);
    }
}
