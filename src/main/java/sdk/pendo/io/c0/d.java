package sdk.pendo.io.c0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final int a = a();

    private static int a() {
        return b(System.getProperty("java.version"));
    }

    static int b(String str) {
        int iC = c(str);
        if (iC == -1) {
            iC = a(str);
        }
        if (iC == -1) {
            return 6;
        }
        return iC;
    }

    private static int c(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i = Integer.parseInt(strArrSplit[0]);
            return (i != 1 || strArrSplit.length <= 1) ? i : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean b() {
        return a >= 9;
    }
}
