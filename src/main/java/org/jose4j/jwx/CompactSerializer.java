package org.jose4j.jwx;

/* JADX INFO: loaded from: classes5.dex */
public class CompactSerializer {
    private static final String EMPTY_STRING = "";
    private static final String PERIOD_SEPARATOR = ".";
    private static final String PERIOD_SEPARATOR_REGEX = "\\.";

    public static String[] deserialize(String str) {
        String[] strArrSplit = str.split(PERIOD_SEPARATOR_REGEX);
        if (!str.endsWith(PERIOD_SEPARATOR)) {
            return strArrSplit;
        }
        String[] strArr = new String[strArrSplit.length + 1];
        System.arraycopy(strArrSplit, 0, strArr, 0, strArrSplit.length);
        strArr[strArrSplit.length] = "";
        return strArr;
    }

    public static String serialize(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                str = "";
            }
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(PERIOD_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
