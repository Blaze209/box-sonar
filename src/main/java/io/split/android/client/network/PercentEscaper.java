package io.split.android.client.network;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String safeChars, boolean plusForSpace) {
        Utils.checkNotNull(safeChars);
        if (safeChars.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String str = safeChars + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (plusForSpace && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.plusForSpace = plusForSpace;
        this.safeOctets = createSafeOctets(str);
    }

    private static boolean[] createSafeOctets(String safeChars) {
        char[] charArray = safeChars.toCharArray();
        int iMax = -1;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    @Override // io.split.android.client.network.UnicodeEscaper
    protected int nextEscapeIndex(CharSequence csq, int index, int end) {
        Utils.checkNotNull(csq);
        while (index < end) {
            char cCharAt = csq.charAt(index);
            boolean[] zArr = this.safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            index++;
        }
        return index;
    }

    @Override // io.split.android.client.network.UnicodeEscaper
    public String escape(String s) {
        Utils.checkNotNull(s);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = s.charAt(i);
            boolean[] zArr = this.safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return escapeSlow(s, i);
            }
        }
        return s;
    }

    @Override // io.split.android.client.network.UnicodeEscaper
    protected char[] escape(int cp) {
        boolean[] zArr = this.safeOctets;
        if (cp < zArr.length && zArr[cp]) {
            return null;
        }
        if (cp == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (cp <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr[cp >>> 4], cArr[cp & 15]};
        }
        if (cp <= 2047) {
            char[] cArr2 = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr2[(cp >>> 10) | 12], cArr2[(cp >>> 6) & 15], '%', cArr2[((cp >>> 4) & 3) | 8], cArr2[cp & 15]};
        }
        if (cp <= 65535) {
            char[] cArr3 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'E', cArr3[cp >>> 12], '%', cArr3[((cp >>> 10) & 3) | 8], cArr3[(cp >>> 6) & 15], '%', cArr3[((cp >>> 4) & 3) | 8], cArr3[cp & 15]};
        }
        if (cp <= 1114111) {
            char[] cArr4 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'F', cArr4[(cp >>> 18) & 7], '%', cArr4[((cp >>> 16) & 3) | 8], cArr4[(cp >>> 12) & 15], '%', cArr4[((cp >>> 10) & 3) | 8], cArr4[(cp >>> 6) & 15], '%', cArr4[((cp >>> 4) & 3) | 8], cArr4[cp & 15]};
        }
        throw new IllegalArgumentException("Invalid unicode character value " + cp);
    }
}
