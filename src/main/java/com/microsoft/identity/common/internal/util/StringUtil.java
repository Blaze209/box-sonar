package com.microsoft.identity.common.internal.util;

import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.logging.Logger;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class StringUtil {
    private static final String TAG = "StringUtil";

    private StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean containsSubString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(str2);
    }

    public static String convertSetToString(Set<String> set, String str) {
        if (set == null || set.isEmpty() || str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static String join(char c, Iterable<String> iterable) {
        StringBuilder sb = new StringBuilder();
        char c2 = 0;
        for (String str : iterable) {
            if (c2 != 0) {
                sb.append(c2);
            }
            sb.append(str);
            c2 = c;
        }
        return sb.toString();
    }

    public static Map.Entry<String, String> getTenantInfo(String str) {
        String str2;
        String str3;
        String str4 = TAG + ":getTenantInfo";
        String[] strArrSplit = str.split("\\.");
        if (2 == strArrSplit.length && !StringExtensions.isNullOrBlank(strArrSplit[0]) && !StringExtensions.isNullOrBlank(strArrSplit[1])) {
            str2 = strArrSplit[0];
            str3 = strArrSplit[1];
        } else {
            Logger.warn(str4, "We had a home account id that could not be split correctly, We expected it to split into 2 parts but instead we had " + strArrSplit.length + " when splitting the string on dot ('.')");
            Logger.warnPII(str4, "We had a home account id that could not be split correctly, Its value was: '" + str + "', and we expected it to split into 2 parts but instead we had " + strArrSplit.length + " when splitting the string on dot ('.')");
            str2 = null;
            str3 = null;
        }
        return new AbstractMap.SimpleEntry(str2, str3);
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str != str2) {
            return str != null && str.equalsIgnoreCase(str2);
        }
        return true;
    }
}
