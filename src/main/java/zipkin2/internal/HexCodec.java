package zipkin2.internal;

/* JADX INFO: loaded from: classes6.dex */
public final class HexCodec {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static long lowerHexToUnsignedLong(String str) {
        int length = str.length();
        if (length < 1 || length > 32) {
            throw isntLowerHexLong(str);
        }
        return lowerHexToUnsignedLong(str, length > 16 ? length - 16 : 0);
    }

    public static long lowerHexToUnsignedLong(String str, int i) {
        int i2;
        int iMin = Math.min(i + 16, str.length());
        long j = 0;
        while (i < iMin) {
            char cCharAt = str.charAt(i);
            long j2 = j << 4;
            if (cCharAt >= '0' && cCharAt <= '9') {
                i2 = cCharAt - '0';
            } else {
                if (cCharAt < 'a' || cCharAt > 'f') {
                    throw isntLowerHexLong(str);
                }
                i2 = cCharAt - 'W';
            }
            j = j2 | ((long) i2);
            i++;
        }
        return j;
    }

    static NumberFormatException isntLowerHexLong(String str) {
        throw new NumberFormatException(str + " should be a 1 to 32 character lower-hex string with no prefix");
    }

    HexCodec() {
    }
}
