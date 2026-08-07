package sdk.pendo.io.k5;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static char[] a;
    private static int b;
    private static int c;
    private static String d;
    private static Map<Character, Integer> e;

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        a = charArray;
        b = charArray.length;
        c = 0;
        e = new HashMap(b);
        for (int i = 0; i < b; i++) {
            e.put(Character.valueOf(a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, a[(int) (j % ((long) b))]);
            j /= (long) b;
        } while (j > 0);
        return sb.toString();
    }

    public static String a() {
        String strA = a(new Date().getTime());
        if (!strA.equals(d)) {
            c = 0;
            d = strA;
            return strA;
        }
        StringBuilder sbAppend = new StringBuilder().append(strA).append(".");
        int i = c;
        c = i + 1;
        return sbAppend.append(a(i)).toString();
    }
}
