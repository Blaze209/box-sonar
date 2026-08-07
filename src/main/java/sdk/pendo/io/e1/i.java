package sdk.pendo.io.e1;

import java.io.StringWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static String a(CharSequence... charSequenceArr) {
        CharSequence charSequence;
        if (charSequenceArr.length == 0) {
            return "";
        }
        if (charSequenceArr.length == 1) {
            charSequence = charSequenceArr[0];
        } else {
            int i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
                int length = charSequenceArr[i3].length();
                i2 += length;
                if (i != -2 && length > 0) {
                    i = i == -1 ? i3 : -2;
                }
            }
            if (i2 == 0) {
                return "";
            }
            if (i <= 0) {
                StringBuilder sb = new StringBuilder(i2);
                for (CharSequence charSequence2 : charSequenceArr) {
                    sb.append(charSequence2);
                }
                return sb.toString();
            }
            charSequence = charSequenceArr[i];
        }
        return charSequence.toString();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0040. Please report as an issue. */
    public static String a(String str, boolean z) {
        String str2;
        StringBuilder sb;
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length * 2);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 4095) {
                sb = new StringBuilder();
                str2 = "\\u";
            } else if (cCharAt > 255) {
                sb = new StringBuilder();
                str2 = "\\u0";
            } else {
                str2 = "\\u00";
                if (cCharAt > 127) {
                    sb = new StringBuilder();
                } else {
                    if (cCharAt < ' ') {
                        switch (cCharAt) {
                            case '\b':
                                stringWriter.write(92);
                                cCharAt = 'b';
                                break;
                            case '\t':
                                stringWriter.write(92);
                                cCharAt = 't';
                                break;
                            case '\n':
                                stringWriter.write(92);
                                cCharAt = 'n';
                                break;
                            case 11:
                            default:
                                if (cCharAt > 15) {
                                    sb = new StringBuilder();
                                } else {
                                    sb = new StringBuilder();
                                    str2 = "\\u000";
                                }
                                break;
                            case '\f':
                                stringWriter.write(92);
                                cCharAt = 'f';
                                break;
                            case '\r':
                                stringWriter.write(92);
                                cCharAt = 'r';
                                break;
                        }
                    } else {
                        int i2 = 34;
                        if (cCharAt != '\"') {
                            i2 = 39;
                            if (cCharAt != '\'') {
                                i2 = 47;
                                if (cCharAt != '/') {
                                    if (cCharAt == '\\') {
                                        stringWriter.write(92);
                                        stringWriter.write(92);
                                    }
                                }
                            } else {
                                if (z) {
                                }
                                stringWriter.write(i2);
                            }
                            stringWriter.write(92);
                            stringWriter.write(i2);
                        } else {
                            stringWriter.write(92);
                            stringWriter.write(i2);
                        }
                    }
                    stringWriter.write(cCharAt);
                }
            }
            stringWriter.write(sb.append(str2).append(a(cCharAt)).toString());
        }
        return stringWriter.toString();
    }

    public static String a(char c) {
        return Integer.toHexString(c).toUpperCase();
    }

    public static String a(String str, Iterable<?> iterable) {
        return a(str, "", iterable);
    }

    public static String a(String str, String str2, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append(str2);
        while (true) {
            sbAppend.append(it.next()).append(str2);
            if (!it.hasNext()) {
                return sb.toString();
            }
            sbAppend = sb.append(str).append(str2);
        }
    }

    public static <T extends CharSequence> T a(T t, String str, Object... objArr) {
        if (t == null || t.length() == 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    public static <T> T a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static boolean a(boolean... zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z && (i = i + 1) > 1) {
                return false;
            }
        }
        return 1 == i;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0092 A[PHI: r6
      0x0092: PHI (r6v5 int) = (r6v4 int), (r6v7 int), (r6v9 int), (r6v11 int), (r6v13 int), (r6v15 int), (r6v17 int) binds: [B:20:0x005a, B:22:0x005e, B:42:0x008b, B:41:0x0088, B:40:0x0085, B:39:0x0082, B:38:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringWriter stringWriter = new StringWriter(length);
        StringBuilder sb = new StringBuilder(4);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (z2) {
                sb.append(cCharAt);
                if (sb.length() == 4) {
                    try {
                        stringWriter.write((char) Integer.parseInt(sb.toString(), 16));
                        sb.setLength(0);
                        z = false;
                        z2 = false;
                    } catch (NumberFormatException e) {
                        throw new sdk.pendo.io.d1.h("Unable to parse unicode value: " + ((Object) sb), e);
                    }
                } else {
                    continue;
                }
            } else if (z) {
                int i2 = 34;
                if (cCharAt != '\"') {
                    i2 = 39;
                    if (cCharAt == '\'') {
                        stringWriter.write(i2);
                        z = false;
                    } else if (cCharAt != '\\') {
                        if (cCharAt == 'b') {
                            i2 = 8;
                        } else if (cCharAt == 'f') {
                            i2 = 12;
                        } else if (cCharAt == 'n') {
                            i2 = 10;
                        } else if (cCharAt == 'r') {
                            i2 = 13;
                        } else if (cCharAt == 't') {
                            i2 = 9;
                        } else if (cCharAt != 'u') {
                            z = false;
                            stringWriter.write(cCharAt);
                        } else {
                            z = false;
                            z2 = true;
                        }
                        stringWriter.write(i2);
                        z = false;
                    } else {
                        stringWriter.write(92);
                        z = false;
                    }
                } else {
                    stringWriter.write(i2);
                    z = false;
                }
            } else if (cCharAt == '\\') {
                z = true;
            } else {
                stringWriter.write(cCharAt);
            }
        }
        if (z) {
            stringWriter.write(92);
        }
        return stringWriter.toString();
    }
}
