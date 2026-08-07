package external.sdk.pendo.io.mozilla.javascript;

import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 168;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    private void append(char c) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c;
        this.sourceTop = i2 + 1;
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:147:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:182:0x0271  */
    /* JADX WARN: Code duplicated, block: B:184:0x0279  */
    /* JADX WARN: Code duplicated, block: B:186:0x027f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0287  */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0200, code lost:
    
        if (1 != getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x022d, code lost:
    
        if (39 == getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x023c, code lost:
    
        if (39 == getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02db, code lost:
    
        if (83 != getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:184:0x0279, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String decompile(java.lang.String r17, int r18, external.sdk.pendo.io.mozilla.javascript.UintMap r19) {
        /*
            Method dump skipped, instruction units count: 1068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Decompiler.decompile(java.lang.String, int, external.sdk.pendo.io.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, null);
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        char[] cArr = this.sourceBuffer;
        int length = cArr.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.sourceTop);
        this.sourceBuffer = cArr2;
    }

    private static int printSourceNumber(String str, int i, StringBuilder sb) {
        int i2;
        char cCharAt = str.charAt(i);
        int i3 = i + 1;
        double dLongBitsToDouble = 0.0d;
        if (cCharAt == 'S') {
            dLongBitsToDouble = sb != null ? str.charAt(i3) : 0.0d;
            i2 = i + 2;
        } else {
            if (cCharAt != 'J' && cCharAt != 'D') {
                throw new RuntimeException();
            }
            if (sb != null) {
                long jCharAt = (((long) str.charAt(i3)) << 48) | (((long) str.charAt(i + 2)) << 32) | (((long) str.charAt(i + 3)) << 16) | ((long) str.charAt(i + 4));
                dLongBitsToDouble = cCharAt == 'J' ? jCharAt : Double.longBitsToDouble(jCharAt);
            }
            i2 = i + 5;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(dLongBitsToDouble, 10));
        }
        return i2;
    }

    private static int printSourceString(String str, int i, boolean z, StringBuilder sb) {
        int iCharAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & iCharAt) != 0) {
            iCharAt = ((iCharAt & 32767) << 16) | str.charAt(i2);
            i2 = i + 2;
        }
        if (sb != null) {
            String strSubstring = str.substring(i2, i2 + iCharAt);
            if (z) {
                sb.append('\"');
                sb.append(ScriptRuntime.escapeString(strSubstring));
                sb.append('\"');
            } else {
                sb.append(strSubstring);
            }
        }
        return i2 + iCharAt;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    void addEOL(int i) {
        if (i < 0 || i > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append((char) 1);
    }

    void addName(String str) {
        addToken(39);
        appendString(str);
    }

    void addNumber(double d) {
        char c;
        int i;
        addToken(40);
        long j = (long) d;
        if (j != d) {
            long jDoubleToLongBits = Double.doubleToLongBits(d);
            append('D');
            append((char) (jDoubleToLongBits >> 48));
            append((char) (jDoubleToLongBits >> 32));
            append((char) (jDoubleToLongBits >> 16));
            i = (int) jDoubleToLongBits;
        } else {
            if (j < 0) {
                Kit.codeBug();
            }
            if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                c = 'S';
            } else {
                append('J');
                append((char) (j >> 48));
                append((char) (j >> 32));
                c = (char) (j >> 16);
            }
            append(c);
            i = (int) j;
        }
        append((char) i);
    }

    void addRegexp(String str, String str2) {
        addToken(48);
        appendString("/" + str + '/' + str2);
    }

    void addString(String str) {
        addToken(41);
        appendString(str);
    }

    void addToken(int i) {
        if (i < 0 || i > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    int getCurrentOffset() {
        return this.sourceTop;
    }

    String getEncodedSource() {
        return sourceToString(0);
    }

    int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append((char) 168);
        return currentOffset;
    }

    int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        if (i != 4) {
            addToken(110);
            append((char) i);
        }
        return currentOffset;
    }
}
