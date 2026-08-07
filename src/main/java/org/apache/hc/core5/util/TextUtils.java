package org.apache.hc.core5.util;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class TextUtils {
    public static byte castAsByte(int i) {
        if ((i < 32 || i > 126) && ((i < 160 || i > 255) && i != 9)) {
            return (byte) 63;
        }
        return (byte) i;
    }

    private TextUtils() {
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return length(charSequence) == 0;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length = length(charSequence);
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static boolean containsBlanks(CharSequence charSequence) {
        int length = length(charSequence);
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static boolean isAllASCII(CharSequence charSequence) {
        int length = length(charSequence);
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }
}
