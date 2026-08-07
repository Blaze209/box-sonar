package zipkin2.internal;

/* JADX INFO: loaded from: classes6.dex */
public final class JsonEscaper {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private static final String U2028 = "\\u2028";
    private static final String U2029 = "\\u2029";

    /* JADX WARN: Code duplicated, block: B:19:0x002b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x002d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    public static CharSequence jsonEscape(CharSequence charSequence) {
        String str;
        int length = charSequence.length();
        if (length != 0) {
            StringBuilder sb = null;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt < 128) {
                    str = REPLACEMENT_CHARS[cCharAt];
                    if (str != null) {
                        if (i < i2) {
                            if (sb == null) {
                                sb = new StringBuilder(length);
                            }
                            sb.append(charSequence, i, i2);
                        }
                        if (sb == null) {
                            sb = new StringBuilder(length);
                        }
                        sb.append(str);
                        i = i2 + 1;
                    }
                } else {
                    if (cCharAt == 8232) {
                        str = U2028;
                    } else if (cCharAt == 8233) {
                        str = U2029;
                    }
                    if (i < i2) {
                        if (sb == null) {
                            sb = new StringBuilder(length);
                        }
                        sb.append(charSequence, i, i2);
                    }
                    if (sb == null) {
                        sb = new StringBuilder(length);
                    }
                    sb.append(str);
                    i = i2 + 1;
                }
            }
            if (sb != null) {
                if (i < length) {
                    sb.append(charSequence, i, length);
                }
                return sb;
            }
        }
        return charSequence;
    }

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static int jsonEscapedSizeInBytes(CharSequence charSequence) {
        int iUtf8SizeInBytes;
        int length = charSequence.length();
        boolean z = true;
        int length2 = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 8232 || cCharAt == 8233) {
                length2 += 5;
            } else if (cCharAt >= 128) {
                z = false;
            } else {
                String str = REPLACEMENT_CHARS[cCharAt];
                if (str != null) {
                    length2 += str.length() - 1;
                }
            }
        }
        if (z) {
            iUtf8SizeInBytes = charSequence.length();
        } else {
            iUtf8SizeInBytes = WriteBuffer.utf8SizeInBytes(charSequence);
        }
        return iUtf8SizeInBytes + length2;
    }
}
