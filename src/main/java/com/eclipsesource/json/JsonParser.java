package com.eclipsesource.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes13.dex */
public class JsonParser {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int MAX_NESTING_LEVEL = 1000;
    private static final int MIN_BUFFER_SIZE = 10;
    private char[] buffer;
    private int bufferOffset;
    private StringBuilder captureBuffer;
    private int captureStart;
    private int current;
    private int fill;
    private final JsonHandler<Object, Object> handler;
    private int index;
    private int line;
    private int lineOffset;
    private int nestingLevel;
    private Reader reader;

    public JsonParser(JsonHandler<?, ?> jsonHandler) {
        if (jsonHandler == null) {
            throw new NullPointerException("handler is null");
        }
        this.handler = jsonHandler;
        jsonHandler.parser = this;
    }

    public void parse(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        try {
            parse(new StringReader(str), Math.max(10, Math.min(1024, str.length())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void parse(Reader reader) throws IOException {
        parse(reader, 1024);
    }

    public void parse(Reader reader, int i) throws IOException {
        if (reader == null) {
            throw new NullPointerException("reader is null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("buffersize is zero or negative");
        }
        this.reader = reader;
        this.buffer = new char[i];
        this.bufferOffset = 0;
        this.index = 0;
        this.fill = 0;
        this.line = 1;
        this.lineOffset = 0;
        this.current = 0;
        this.captureStart = -1;
        read();
        skipWhiteSpace();
        readValue();
        skipWhiteSpace();
        if (!isEndOfText()) {
            throw error("Unexpected character");
        }
    }

    private void readValue() throws IOException {
        int i = this.current;
        if (i == 34) {
            readString();
            return;
        }
        if (i != 45) {
            if (i == 91) {
                readArray();
                return;
            }
            if (i == 102) {
                readFalse();
                return;
            }
            if (i == 110) {
                readNull();
                return;
            }
            if (i == 116) {
                readTrue();
                return;
            } else if (i == 123) {
                readObject();
                return;
            } else {
                switch (i) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        throw expected("value");
                }
            }
        }
        readNumber();
    }

    private void readArray() throws IOException {
        Object objStartArray = this.handler.startArray();
        read();
        int i = this.nestingLevel + 1;
        this.nestingLevel = i;
        if (i > 1000) {
            throw error("Nesting too deep");
        }
        skipWhiteSpace();
        if (readChar(AbstractJsonLexerKt.END_LIST)) {
            this.nestingLevel--;
            this.handler.endArray(objStartArray);
            return;
        }
        do {
            skipWhiteSpace();
            this.handler.startArrayValue(objStartArray);
            readValue();
            this.handler.endArrayValue(objStartArray);
            skipWhiteSpace();
        } while (readChar(AbstractJsonLexerKt.COMMA));
        if (!readChar(AbstractJsonLexerKt.END_LIST)) {
            throw expected("',' or ']'");
        }
        this.nestingLevel--;
        this.handler.endArray(objStartArray);
    }

    private void readObject() throws IOException {
        Object objStartObject = this.handler.startObject();
        read();
        int i = this.nestingLevel + 1;
        this.nestingLevel = i;
        if (i > 1000) {
            throw error("Nesting too deep");
        }
        skipWhiteSpace();
        if (readChar(AbstractJsonLexerKt.END_OBJ)) {
            this.nestingLevel--;
            this.handler.endObject(objStartObject);
            return;
        }
        do {
            skipWhiteSpace();
            this.handler.startObjectName(objStartObject);
            String name = readName();
            this.handler.endObjectName(objStartObject, name);
            skipWhiteSpace();
            if (!readChar(AbstractJsonLexerKt.COLON)) {
                throw expected("':'");
            }
            skipWhiteSpace();
            this.handler.startObjectValue(objStartObject, name);
            readValue();
            this.handler.endObjectValue(objStartObject, name);
            skipWhiteSpace();
        } while (readChar(AbstractJsonLexerKt.COMMA));
        if (!readChar(AbstractJsonLexerKt.END_OBJ)) {
            throw expected("',' or '}'");
        }
        this.nestingLevel--;
        this.handler.endObject(objStartObject);
    }

    private String readName() throws IOException {
        if (this.current != 34) {
            throw expected("name");
        }
        return readStringInternal();
    }

    private void readNull() throws IOException {
        this.handler.startNull();
        read();
        readRequiredChar(AbstractJsonLexerKt.UNICODE_ESC);
        readRequiredChar('l');
        readRequiredChar('l');
        this.handler.endNull();
    }

    private void readTrue() throws IOException {
        this.handler.startBoolean();
        read();
        readRequiredChar('r');
        readRequiredChar(AbstractJsonLexerKt.UNICODE_ESC);
        readRequiredChar('e');
        this.handler.endBoolean(true);
    }

    private void readFalse() throws IOException {
        this.handler.startBoolean();
        read();
        readRequiredChar('a');
        readRequiredChar('l');
        readRequiredChar('s');
        readRequiredChar('e');
        this.handler.endBoolean(false);
    }

    private void readRequiredChar(char c) throws IOException {
        if (!readChar(c)) {
            throw expected("'" + c + "'");
        }
    }

    private void readString() throws IOException {
        this.handler.startString();
        this.handler.endString(readStringInternal());
    }

    private String readStringInternal() throws IOException {
        read();
        startCapture();
        while (true) {
            int i = this.current;
            if (i == 34) {
                String strEndCapture = endCapture();
                read();
                return strEndCapture;
            }
            if (i == 92) {
                pauseCapture();
                readEscape();
                startCapture();
            } else {
                if (i < 32) {
                    throw expected("valid string character");
                }
                read();
            }
        }
    }

    private void readEscape() throws IOException {
        read();
        int i = this.current;
        if (i == 34 || i == 47 || i == 92) {
            this.captureBuffer.append((char) i);
        } else if (i == 98) {
            this.captureBuffer.append('\b');
        } else if (i == 102) {
            this.captureBuffer.append('\f');
        } else if (i == 110) {
            this.captureBuffer.append('\n');
        } else if (i == 114) {
            this.captureBuffer.append('\r');
        } else if (i == 116) {
            this.captureBuffer.append('\t');
        } else if (i == 117) {
            char[] cArr = new char[4];
            for (int i2 = 0; i2 < 4; i2++) {
                read();
                if (!isHexDigit()) {
                    throw expected("hexadecimal digit");
                }
                cArr[i2] = (char) this.current;
            }
            this.captureBuffer.append((char) Integer.parseInt(new String(cArr), 16));
        } else {
            throw expected("valid escape sequence");
        }
        read();
    }

    private void readNumber() throws IOException {
        this.handler.startNumber();
        startCapture();
        readChar(Soundex.SILENT_MARKER);
        int i = this.current;
        if (!readDigit()) {
            throw expected("digit");
        }
        if (i != 48) {
            while (readDigit()) {
            }
        }
        readFraction();
        readExponent();
        this.handler.endNumber(endCapture());
    }

    private boolean readFraction() throws IOException {
        if (!readChar('.')) {
            return false;
        }
        if (!readDigit()) {
            throw expected("digit");
        }
        while (readDigit()) {
        }
        return true;
    }

    private boolean readExponent() throws IOException {
        if (!readChar('e') && !readChar('E')) {
            return false;
        }
        if (!readChar('+')) {
            readChar(Soundex.SILENT_MARKER);
        }
        if (!readDigit()) {
            throw expected("digit");
        }
        while (readDigit()) {
        }
        return true;
    }

    private boolean readChar(char c) throws IOException {
        if (this.current != c) {
            return false;
        }
        read();
        return true;
    }

    private boolean readDigit() throws IOException {
        if (!isDigit()) {
            return false;
        }
        read();
        return true;
    }

    private void skipWhiteSpace() throws IOException {
        while (isWhiteSpace()) {
            read();
        }
    }

    private void read() throws IOException {
        int i = this.index;
        int i2 = this.fill;
        if (i == i2) {
            int i3 = this.captureStart;
            if (i3 != -1) {
                this.captureBuffer.append(this.buffer, i3, i2 - i3);
                this.captureStart = 0;
            }
            this.bufferOffset += this.fill;
            Reader reader = this.reader;
            char[] cArr = this.buffer;
            int i4 = reader.read(cArr, 0, cArr.length);
            this.fill = i4;
            this.index = 0;
            if (i4 == -1) {
                this.current = -1;
                this.index = 1;
                return;
            }
        }
        if (this.current == 10) {
            this.line++;
            this.lineOffset = this.bufferOffset + this.index;
        }
        char[] cArr2 = this.buffer;
        int i5 = this.index;
        this.index = i5 + 1;
        this.current = cArr2[i5];
    }

    private void startCapture() {
        if (this.captureBuffer == null) {
            this.captureBuffer = new StringBuilder();
        }
        this.captureStart = this.index - 1;
    }

    private void pauseCapture() {
        int i = this.current == -1 ? this.index : this.index - 1;
        StringBuilder sb = this.captureBuffer;
        char[] cArr = this.buffer;
        int i2 = this.captureStart;
        sb.append(cArr, i2, i - i2);
        this.captureStart = -1;
    }

    private String endCapture() {
        int i = this.captureStart;
        int i2 = this.index - 1;
        this.captureStart = -1;
        if (this.captureBuffer.length() > 0) {
            this.captureBuffer.append(this.buffer, i, i2 - i);
            String string = this.captureBuffer.toString();
            this.captureBuffer.setLength(0);
            return string;
        }
        return new String(this.buffer, i, i2 - i);
    }

    Location getLocation() {
        int i = (this.bufferOffset + this.index) - 1;
        return new Location(i, this.line, (i - this.lineOffset) + 1);
    }

    private ParseException expected(String str) {
        if (isEndOfText()) {
            return error("Unexpected end of input");
        }
        return error("Expected " + str);
    }

    private ParseException error(String str) {
        return new ParseException(str, getLocation());
    }

    private boolean isWhiteSpace() {
        int i = this.current;
        return i == 32 || i == 9 || i == 10 || i == 13;
    }

    private boolean isDigit() {
        int i = this.current;
        return i >= 48 && i <= 57;
    }

    private boolean isHexDigit() {
        int i = this.current;
        if (i >= 48 && i <= 57) {
            return true;
        }
        if (i < 97 || i > 102) {
            return i >= 65 && i <= 70;
        }
        return true;
    }

    private boolean isEndOfText() {
        return this.current == -1;
    }
}
