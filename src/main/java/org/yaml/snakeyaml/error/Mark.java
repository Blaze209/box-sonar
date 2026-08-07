package org.yaml.snakeyaml.error;

import java.io.Serializable;
import org.yaml.snakeyaml.scanner.Constant;

/* JADX INFO: loaded from: classes5.dex */
public final class Mark implements Serializable {
    private final int[] buffer;
    private final int column;
    private final int index;
    private final int line;
    private final String name;
    private final int pointer;

    private static int[] toCodePoints(char[] cArr) {
        int iCharCount = 0;
        int[] iArr = new int[Character.codePointCount(cArr, 0, cArr.length)];
        int i = 0;
        while (iCharCount < cArr.length) {
            int iCodePointAt = Character.codePointAt(cArr, iCharCount);
            iArr[i] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i++;
        }
        return iArr;
    }

    public Mark(String str, int i, int i2, int i3, char[] cArr, int i4) {
        this(str, i, i2, i3, toCodePoints(cArr), i4);
    }

    public Mark(String str, int i, int i2, int i3, int[] iArr, int i4) {
        this.name = str;
        this.index = i;
        this.line = i2;
        this.column = i3;
        this.buffer = iArr;
        this.pointer = i4;
    }

    private boolean isLineBreak(int i) {
        return Constant.NULL_OR_LINEBR.has(i);
    }

    public String get_snippet(int i, int i2) {
        String str;
        String str2;
        float f = (i2 / 2.0f) - 1.0f;
        int i3 = this.pointer;
        while (true) {
            str = " ... ";
            if (i3 <= 0 || isLineBreak(this.buffer[i3 - 1])) {
                str2 = "";
                break;
            }
            int i4 = i3 - 1;
            if (this.pointer - i4 > f) {
                i3 += 4;
                str2 = " ... ";
                break;
            }
            i3 = i4;
        }
        int i5 = this.pointer;
        while (true) {
            int[] iArr = this.buffer;
            if (i5 >= iArr.length || isLineBreak(iArr[i5])) {
                str = "";
                break;
            }
            int i6 = i5 + 1;
            if (i6 - this.pointer > f) {
                i5 -= 4;
                break;
            }
            i5 = i6;
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < i; i7++) {
            sb.append(" ");
        }
        sb.append(str2);
        for (int i8 = i3; i8 < i5; i8++) {
            sb.appendCodePoint(this.buffer[i8]);
        }
        sb.append(str);
        sb.append("\n");
        for (int i9 = 0; i9 < ((this.pointer + i) - i3) + str2.length(); i9++) {
            sb.append(" ");
        }
        sb.append("^");
        return sb.toString();
    }

    public String get_snippet() {
        return get_snippet(4, 75);
    }

    public String toString() {
        return " in " + this.name + ", line " + (this.line + 1) + ", column " + (this.column + 1) + ":\n" + get_snippet();
    }

    public String getName() {
        return this.name;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public int getPointer() {
        return this.pointer;
    }
}
