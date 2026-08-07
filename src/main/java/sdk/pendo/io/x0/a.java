package sdk.pendo.io.x0;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static String[] a(String str) {
        String[] strArrSplit = str.split("\\.");
        if (!str.endsWith(".")) {
            return strArrSplit;
        }
        String[] strArr = new String[strArrSplit.length + 1];
        System.arraycopy(strArrSplit, 0, strArr, 0, strArrSplit.length);
        strArr[strArrSplit.length] = "";
        return strArr;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                str = "";
            }
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
