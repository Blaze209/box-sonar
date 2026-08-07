package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class CodePrinter {
    private static final int LITERAL_CHAR_MAX_SIZE = 6;
    private int offset;
    private String lineTerminator = System.lineSeparator();
    private int indentStep = 4;
    private int indentTabSize = 8;
    private char[] buffer = new char[4096];

    CodePrinter() {
    }

    private int add_area(int i) {
        int iEnsure_area = ensure_area(i);
        this.offset = i + iEnsure_area;
        return iEnsure_area;
    }

    private static char digit_to_hex_letter(int i) {
        return (char) (i < 10 ? i + 48 : i + 55);
    }

    private int ensure_area(int i) {
        int i2 = this.offset;
        int i3 = i + i2;
        char[] cArr = this.buffer;
        if (i3 > cArr.length) {
            int length = cArr.length * 2;
            if (i3 <= length) {
                i3 = length;
            }
            char[] cArr2 = new char[i3];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.buffer = cArr2;
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0038  */
    private int put_string_literal_char(int i, int i2, boolean z) {
        if (i2 == 12) {
            i2 = 102;
        } else {
            if (i2 != 13) {
                if (i2 != 34) {
                    if (i2 != 39) {
                        switch (i2) {
                            case 8:
                                i2 = 98;
                                break;
                            case 9:
                                i2 = 116;
                                break;
                            case 10:
                                i2 = 110;
                                break;
                            default:
                                z = false;
                                break;
                        }
                    } else {
                        z = !z;
                    }
                }
                if (z) {
                    char[] cArr = this.buffer;
                    cArr[i] = '\\';
                    cArr[i + 1] = (char) i2;
                    return i + 2;
                }
                if (32 > i2 && i2 <= 126) {
                    this.buffer[i] = (char) i2;
                    return i + 1;
                }
                char[] cArr2 = this.buffer;
                cArr2[i] = '\\';
                cArr2[i + 1] = AbstractJsonLexerKt.UNICODE_ESC;
                cArr2[i + 2] = digit_to_hex_letter((i2 >> 12) & 15);
                this.buffer[i + 3] = digit_to_hex_letter((i2 >> 8) & 15);
                this.buffer[i + 4] = digit_to_hex_letter((i2 >> 4) & 15);
                this.buffer[i + 5] = digit_to_hex_letter(i2 & 15);
                return i + 6;
            }
            i2 = 114;
        }
        z = true;
        if (z) {
            char[] cArr3 = this.buffer;
            cArr3[i] = '\\';
            cArr3[i + 1] = (char) i2;
            return i + 2;
        }
        if (32 > i2) {
        }
        char[] cArr4 = this.buffer;
        cArr4[i] = '\\';
        cArr4[i + 1] = AbstractJsonLexerKt.UNICODE_ESC;
        cArr4[i + 2] = digit_to_hex_letter((i2 >> 12) & 15);
        this.buffer[i + 3] = digit_to_hex_letter((i2 >> 8) & 15);
        this.buffer[i + 4] = digit_to_hex_letter((i2 >> 4) & 15);
        this.buffer[i + 5] = digit_to_hex_letter(i2 & 15);
        return i + 6;
    }

    public void clear() {
        this.offset = 0;
    }

    public void erase(int i, int i2) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.offset - i2);
        this.offset -= i2 - i;
    }

    public int getIndentStep() {
        return this.indentStep;
    }

    public int getIndentTabSize() {
        return this.indentTabSize;
    }

    public int getLastChar() {
        int i = this.offset;
        if (i == 0) {
            return -1;
        }
        return this.buffer[i - 1];
    }

    public String getLineTerminator() {
        return this.lineTerminator;
    }

    public int getOffset() {
        return this.offset;
    }

    public void indent(int i) {
        int i2;
        int i3 = this.indentStep * i;
        int i4 = this.indentTabSize;
        if (i4 <= 0) {
            i2 = 0;
        } else {
            int i5 = i3 / i4;
            i3 = (i3 % i4) + i5;
            i2 = i5;
        }
        int iAdd_area = add_area(i3);
        int i6 = i2 + iAdd_area;
        int i7 = i3 + iAdd_area;
        while (iAdd_area != i6) {
            this.buffer[iAdd_area] = '\t';
            iAdd_area++;
        }
        while (iAdd_area != i7) {
            this.buffer[iAdd_area] = ' ';
            iAdd_area++;
        }
    }

    public void line(int i, String str) {
        indent(i);
        p(str);
        nl();
    }

    public void nl() {
        p(getLineTerminator());
    }

    public void p(char c) {
        this.buffer[add_area(1)] = c;
    }

    public void qchar(int i) {
        int iEnsure_area = ensure_area(8);
        this.buffer[iEnsure_area] = '\'';
        int iPut_string_literal_char = put_string_literal_char(iEnsure_area + 1, i, false);
        this.buffer[iPut_string_literal_char] = '\'';
        this.offset = iPut_string_literal_char + 1;
    }

    public void qstring(String str) {
        int length = str.length();
        int iEnsure_area = ensure_area((length * 6) + 2);
        this.buffer[iEnsure_area] = '\"';
        int iPut_string_literal_char = iEnsure_area + 1;
        for (int i = 0; i != length; i++) {
            iPut_string_literal_char = put_string_literal_char(iPut_string_literal_char, str.charAt(i), true);
        }
        this.buffer[iPut_string_literal_char] = '\"';
        this.offset = iPut_string_literal_char + 1;
    }

    public void setIndentStep(int i) {
        this.indentStep = i;
    }

    public void setIndentTabSize(int i) {
        this.indentTabSize = i;
    }

    public void setLineTerminator(String str) {
        this.lineTerminator = str;
    }

    public String toString() {
        return new String(this.buffer, 0, this.offset);
    }

    public void p(int i) {
        p(Integer.toString(i));
    }

    public void p(String str) {
        int length = str.length();
        str.getChars(0, length, this.buffer, add_area(length));
    }

    public final void p(char[] cArr) {
        p(cArr, 0, cArr.length);
    }

    public void p(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        System.arraycopy(cArr, i, this.buffer, add_area(i3), i3);
    }
}
