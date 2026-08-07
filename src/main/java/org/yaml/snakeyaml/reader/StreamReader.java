package org.yaml.snakeyaml.reader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.scanner.Constant;

/* JADX INFO: loaded from: classes5.dex */
public class StreamReader {
    private static final int BUFFER_SIZE = 1025;
    private final char[] buffer;
    private int column;
    private int dataLength;
    private int[] dataWindow;
    private int documentIndex;
    private boolean eof;
    private int index;
    private int line;
    private String name;
    private int pointer;
    private final Reader stream;

    public static boolean isPrintable(int i) {
        if ((i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133) {
            return true;
        }
        if (i >= 160 && i <= 55295) {
            return true;
        }
        if (i < 57344 || i > 65533) {
            return i >= 65536 && i <= 1114111;
        }
        return true;
    }

    public StreamReader(String str) {
        this(new StringReader(str));
        this.name = "'string'";
    }

    public StreamReader(Reader reader) {
        this.pointer = 0;
        this.index = 0;
        this.documentIndex = 0;
        this.line = 0;
        this.column = 0;
        if (reader == null) {
            throw new NullPointerException("Reader must be provided.");
        }
        this.name = "'reader'";
        this.dataWindow = new int[0];
        this.dataLength = 0;
        this.stream = reader;
        this.eof = false;
        this.buffer = new char[1025];
    }

    public static boolean isPrintable(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!isPrintable(iCodePointAt)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return true;
    }

    public Mark getMark() {
        return new Mark(this.name, this.index, this.line, this.column, this.dataWindow, this.pointer);
    }

    public void forward() {
        forward(1);
    }

    public void forward(int i) {
        for (int i2 = 0; i2 < i && ensureEnoughData(); i2++) {
            int[] iArr = this.dataWindow;
            int i3 = this.pointer;
            this.pointer = i3 + 1;
            int i4 = iArr[i3];
            moveIndices(1);
            if (Constant.LINEBR.has(i4) || (i4 == 13 && ensureEnoughData() && this.dataWindow[this.pointer] != 10)) {
                this.line++;
                this.column = 0;
            } else if (i4 != 65279) {
                this.column++;
            }
        }
    }

    public int peek() {
        if (ensureEnoughData()) {
            return this.dataWindow[this.pointer];
        }
        return 0;
    }

    public int peek(int i) {
        if (ensureEnoughData(i)) {
            return this.dataWindow[this.pointer + i];
        }
        return 0;
    }

    public String prefix(int i) {
        if (i == 0) {
            return "";
        }
        if (ensureEnoughData(i)) {
            return new String(this.dataWindow, this.pointer, i);
        }
        int[] iArr = this.dataWindow;
        int i2 = this.pointer;
        return new String(iArr, i2, Math.min(i, this.dataLength - i2));
    }

    public String prefixForward(int i) {
        String strPrefix = prefix(i);
        this.pointer += i;
        moveIndices(i);
        this.column += i;
        return strPrefix;
    }

    private boolean ensureEnoughData() {
        return ensureEnoughData(0);
    }

    private boolean ensureEnoughData(int i) {
        if (!this.eof && this.pointer + i >= this.dataLength) {
            update();
        }
        return this.pointer + i < this.dataLength;
    }

    private void update() {
        try {
            int i = this.stream.read(this.buffer, 0, 1024);
            if (i > 0) {
                int i2 = this.dataLength;
                int i3 = this.pointer;
                int i4 = i2 - i3;
                this.dataWindow = Arrays.copyOfRange(this.dataWindow, i3, i2 + i);
                if (Character.isHighSurrogate(this.buffer[i - 1])) {
                    if (this.stream.read(this.buffer, i, 1) == -1) {
                        this.eof = true;
                    } else {
                        i++;
                    }
                }
                int i5 = 32;
                int iCharCount = 0;
                while (iCharCount < i) {
                    int iCodePointAt = Character.codePointAt(this.buffer, iCharCount);
                    this.dataWindow[i4] = iCodePointAt;
                    if (isPrintable(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    } else {
                        iCharCount = i;
                        i5 = iCodePointAt;
                    }
                    i4++;
                }
                this.dataLength = i4;
                this.pointer = 0;
                if (i5 != 32) {
                    throw new ReaderException(this.name, i4 - 1, i5, "special characters are not allowed");
                }
                return;
            }
            this.eof = true;
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public int getColumn() {
        return this.column;
    }

    private void moveIndices(int i) {
        this.index += i;
        this.documentIndex += i;
    }

    public int getDocumentIndex() {
        return this.documentIndex;
    }

    public void resetDocumentIndex() {
        this.documentIndex = 0;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }
}
