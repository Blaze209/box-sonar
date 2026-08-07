package sdk.pendo.io.w1;

import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    private static final Pattern a = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static boolean a(CharSequence charSequence, char... cArr) {
        if (!a(charSequence) && !b.a(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = length - 1;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == cCharAt) {
                        if (!Character.isHighSurrogate(cCharAt) || i4 == i2) {
                            return true;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean b(CharSequence charSequence, char... cArr) {
        if (charSequence != null && cArr != null) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == cCharAt) {
                        if (!Character.isHighSurrogate(cCharAt) || i4 == i2) {
                            return false;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            int i = 0;
            while (i <= length2) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (c.a(charSequence3, true, i, charSequence4, 0, length)) {
                    return true;
                }
                i++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return false;
    }

    public static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        return a(charSequence, charSequence2, false);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return c.a(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
    }

    public static int b(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            if (i < 0) {
                i = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            int i2 = i;
            while (i2 < length) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (c.a(charSequence3, true, i2, charSequence4, 0, charSequence2.length())) {
                    return i2;
                }
                i2++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return -1;
    }

    public static int a(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return c.a(charSequence, charSequence2, i);
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String a(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        return length > 8192 ? a(str, i, String.valueOf(c)) : a(c, length).concat(str);
    }

    public static String a(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (a(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return a(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String a(char c, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return a(str.charAt(0), i);
        }
        int i2 = length * i;
        if (length == 1) {
            return a(str.charAt(0), i);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char cCharAt = str.charAt(0);
        char cCharAt2 = str.charAt(1);
        char[] cArr = new char[i2];
        for (int i4 = (i * 2) - 2; i4 >= 0; i4 -= 2) {
            cArr[i4] = cCharAt;
            cArr[i4 + 1] = cCharAt2;
        }
        return new String(cArr);
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, -1);
    }

    public static String a(String str, String str2, String str3, int i) {
        return a(str, str2, str3, i, false);
    }

    private static String a(String str, String str2, String str3, int i, boolean z) {
        if (a(str) || a(str2) || str3 == null || i == 0) {
            return str;
        }
        if (z) {
            str2 = str2.toLowerCase();
        }
        int i2 = 0;
        int iB = z ? b(str, str2, 0) : a(str, str2, 0);
        if (iB == -1) {
            return str;
        }
        int length = str2.length();
        StringBuilder sb = new StringBuilder(str.length() + (Math.max(str3.length() - length, 0) * (i < 0 ? 16 : Math.min(i, 64))));
        while (iB != -1) {
            sb.append((CharSequence) str, i2, iB).append(str3);
            i2 = iB + length;
            i--;
            if (i == 0) {
                break;
            }
            iB = z ? b(str, str2, i2) : a(str, str2, i2);
        }
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }
}
