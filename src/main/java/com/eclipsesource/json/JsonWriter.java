package com.eclipsesource.json;

import java.io.IOException;
import java.io.Writer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
class JsonWriter {
    private static final int CONTROL_CHARACTERS_END = 31;
    protected final Writer writer;
    private static final char[] QUOT_CHARS = {'\\', '\"'};
    private static final char[] BS_CHARS = {'\\', '\\'};
    private static final char[] LF_CHARS = {'\\', 'n'};
    private static final char[] CR_CHARS = {'\\', 'r'};
    private static final char[] TAB_CHARS = {'\\', 't'};
    private static final char[] UNICODE_2028_CHARS = {'\\', AbstractJsonLexerKt.UNICODE_ESC, '2', '0', '2', '8'};
    private static final char[] UNICODE_2029_CHARS = {'\\', AbstractJsonLexerKt.UNICODE_ESC, '2', '0', '2', '9'};
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    JsonWriter(Writer writer) {
        this.writer = writer;
    }

    protected void writeLiteral(String str) throws IOException {
        this.writer.write(str);
    }

    protected void writeNumber(String str) throws IOException {
        this.writer.write(str);
    }

    protected void writeString(String str) throws IOException {
        this.writer.write(34);
        writeJsonString(str);
        this.writer.write(34);
    }

    protected void writeArrayOpen() throws IOException {
        this.writer.write(91);
    }

    protected void writeArrayClose() throws IOException {
        this.writer.write(93);
    }

    protected void writeArraySeparator() throws IOException {
        this.writer.write(44);
    }

    protected void writeObjectOpen() throws IOException {
        this.writer.write(123);
    }

    protected void writeObjectClose() throws IOException {
        this.writer.write(125);
    }

    protected void writeMemberName(String str) throws IOException {
        this.writer.write(34);
        writeJsonString(str);
        this.writer.write(34);
    }

    protected void writeMemberSeparator() throws IOException {
        this.writer.write(58);
    }

    protected void writeObjectSeparator() throws IOException {
        this.writer.write(44);
    }

    protected void writeJsonString(String str) throws IOException {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char[] replacementChars = getReplacementChars(str.charAt(i2));
            if (replacementChars != null) {
                this.writer.write(str, i, i2 - i);
                this.writer.write(replacementChars);
                i = i2 + 1;
            }
        }
        this.writer.write(str, i, length - i);
    }

    private static char[] getReplacementChars(char c) {
        if (c > '\\') {
            if (c < 8232 || c > 8233) {
                return null;
            }
            return c == 8232 ? UNICODE_2028_CHARS : UNICODE_2029_CHARS;
        }
        if (c == '\\') {
            return BS_CHARS;
        }
        if (c > '\"') {
            return null;
        }
        if (c == '\"') {
            return QUOT_CHARS;
        }
        if (c > 31) {
            return null;
        }
        if (c == '\n') {
            return LF_CHARS;
        }
        if (c == '\r') {
            return CR_CHARS;
        }
        if (c == '\t') {
            return TAB_CHARS;
        }
        char[] cArr = HEX_DIGITS;
        return new char[]{'\\', AbstractJsonLexerKt.UNICODE_ESC, '0', '0', cArr[(c >> 4) & 15], cArr[c & 15]};
    }
}
