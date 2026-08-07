package com.squareup.moshi.adapters;

import com.squareup.moshi.JsonDataException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes3.dex */
final class Iso8601Utils {
    static final String GMT_ID = "GMT";
    static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("GMT");

    Iso8601Utils() {
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder("yyyy-MM-ddThh:mm:ss.sssZ".length());
        padInt(sb, gregorianCalendar.get(1), "yyyy".length());
        sb.append(Soundex.SILENT_MARKER);
        padInt(sb, gregorianCalendar.get(2) + 1, "MM".length());
        sb.append(Soundex.SILENT_MARKER);
        padInt(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), "hh".length());
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(AbstractJsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(13), "ss".length());
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), "sss".length());
        sb.append('Z');
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x015f, B:50:0x00e2, B:51:0x00fa, B:52:0x00fb, B:54:0x0107, B:57:0x0110, B:59:0x012b, B:62:0x013a, B:63:0x015a, B:65:0x015d, B:68:0x018e, B:69:0x0195), top: B:73:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00d7 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x015f, B:50:0x00e2, B:51:0x00fa, B:52:0x00fb, B:54:0x0107, B:57:0x0110, B:59:0x012b, B:62:0x013a, B:63:0x015a, B:65:0x015d, B:68:0x018e, B:69:0x0195), top: B:73:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00db  */
    /* JADX WARN: Code duplicated, block: B:65:0x015d A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x015f, B:50:0x00e2, B:51:0x00fa, B:52:0x00fb, B:54:0x0107, B:57:0x0110, B:59:0x012b, B:62:0x013a, B:63:0x015a, B:65:0x015d, B:68:0x018e, B:69:0x0195), top: B:73:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:68:0x018e A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0196, blocks: (B:3:0x000a, B:6:0x0017, B:8:0x0023, B:9:0x0025, B:11:0x0034, B:13:0x003a, B:17:0x004b, B:19:0x005b, B:20:0x005d, B:22:0x0069, B:23:0x006c, B:25:0x0072, B:29:0x007c, B:34:0x008c, B:36:0x0094, B:41:0x00c9, B:43:0x00cf, B:45:0x00d7, B:66:0x015f, B:50:0x00e2, B:51:0x00fa, B:52:0x00fb, B:54:0x0107, B:57:0x0110, B:59:0x012b, B:62:0x013a, B:63:0x015a, B:65:0x015d, B:68:0x018e, B:69:0x0195), top: B:73:0x000a }] */
    public static Date parse(String str) {
        int i;
        int iPow;
        int i2;
        int i3;
        char cCharAt;
        String strSubstring;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int i4 = parseInt(str, 0, 4);
            int i5 = checkOffset(str, 4, Soundex.SILENT_MARKER) ? 5 : 4;
            int i6 = i5 + 2;
            int i7 = parseInt(str, i5, i6);
            if (checkOffset(str, i6, Soundex.SILENT_MARKER)) {
                i6 = i5 + 3;
            }
            int i8 = i6 + 2;
            int i9 = parseInt(str, i6, i8);
            boolean zCheckOffset = checkOffset(str, i8, 'T');
            if (!zCheckOffset && str.length() <= i8) {
                return new GregorianCalendar(i4, i7 - 1, i9).getTime();
            }
            if (zCheckOffset) {
                int i10 = i6 + 5;
                int i11 = parseInt(str, i6 + 3, i10);
                if (checkOffset(str, i10, AbstractJsonLexerKt.COLON)) {
                    i10 = i6 + 6;
                }
                int i12 = i10 + 2;
                int i13 = parseInt(str, i10, i12);
                if (checkOffset(str, i12, AbstractJsonLexerKt.COLON)) {
                    i12 = i10 + 3;
                }
                if (str.length() <= i12 || (cCharAt2 = str.charAt(i12)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i = i11;
                    i8 = i12;
                    i2 = i13;
                    iPow = 0;
                } else {
                    int i14 = i12 + 2;
                    i3 = parseInt(str, i12, i14);
                    if (i3 > 59 && i3 < 63) {
                        i3 = 59;
                    }
                    if (checkOffset(str, i14, '.')) {
                        int i15 = i12 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i12 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i12 + 6);
                        iPow = (int) (Math.pow(10.0d, 3 - (iMin - i15)) * ((double) parseInt(str, i15, iMin)));
                        i2 = i13;
                        i = i11;
                        i8 = iIndexOfNonDigit;
                    } else {
                        i = i11;
                        i8 = i14;
                        i2 = i13;
                        iPow = 0;
                    }
                }
                if (str.length() > i8) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i8);
                if (cCharAt == 'Z') {
                    timeZone = TIMEZONE_Z;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i8);
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = TIMEZONE_Z;
                    } else {
                        String str2 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                        String id = timeZone2.getID();
                        if (!id.equals(str2) && !id.replace(":", "").equals(str2)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i4);
                gregorianCalendar.set(2, i7 - 1);
                gregorianCalendar.set(5, i9);
                gregorianCalendar.set(11, i);
                gregorianCalendar.set(12, i2);
                gregorianCalendar.set(13, i3);
                gregorianCalendar.set(14, iPow);
                return gregorianCalendar.getTime();
            }
            i = 0;
            iPow = 0;
            i2 = 0;
            i3 = 0;
            if (str.length() > i8) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i8);
            if (cCharAt == 'Z') {
                timeZone = TIMEZONE_Z;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i8);
                if (!"+0000".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    timeZone = TIMEZONE_Z;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, i4);
            gregorianCalendar2.set(2, i7 - 1);
            gregorianCalendar2.set(5, i9);
            gregorianCalendar2.set(11, i);
            gregorianCalendar2.set(12, i2);
            gregorianCalendar2.set(13, i3);
            gregorianCalendar2.set(14, iPow);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new JsonDataException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
