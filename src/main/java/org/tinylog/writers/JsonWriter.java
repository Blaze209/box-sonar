package org.tinylog.writers;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.pattern.FormatPatternParser;
import org.tinylog.pattern.Token;
import org.tinylog.provider.InternalLogger;
import org.tinylog.writers.raw.ByteArrayWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonWriter extends AbstractFileBasedWriter {
    private static final int BUFFER_SIZE = 1024;
    private static final String FIELD_PREFIX = "field.";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final byte[] bracketCloseBytes;
    private final byte[] bracketOpenBytes;
    private StringBuilder builder;
    private final byte[] carriageReturnBytes;
    private final int characterSize;
    private final Charset charset;
    private final byte[] charsetHeaderBytes;
    private final byte[] commaBytes;
    private final Map<String, Token> fields;
    private boolean firstEntry;
    private final boolean lineDelimitedJson;
    private final byte[] lineFeedBytes;
    private final byte[] newLineBytes;
    private final byte[] spaceBytes;
    private final byte[] tabulatorBytes;
    private int truncateSize;
    private final ByteArrayWriter writer;

    public JsonWriter() throws IOException {
        this(Collections.emptyMap());
    }

    public JsonWriter(Map<String, String> map) throws IOException {
        super(map);
        String fileName = getFileName();
        String stringValue = getStringValue("format");
        boolean booleanValue = getBooleanValue("append");
        boolean booleanValue2 = getBooleanValue("buffered");
        boolean booleanValue3 = getBooleanValue("writingthread");
        Charset charset = getCharset();
        this.charset = charset;
        this.writer = createByteArrayWriter(fileName, booleanValue, booleanValue2, false, false, charset);
        this.fields = createTokens(map);
        boolean z = true;
        if (stringValue == null || JsonFactory.FORMAT_NAME_JSON.equalsIgnoreCase(stringValue)) {
            this.lineDelimitedJson = false;
        } else if ("LDJSON".equalsIgnoreCase(stringValue)) {
            this.lineDelimitedJson = true;
        } else {
            this.lineDelimitedJson = false;
            InternalLogger.log(Level.WARN, "Illegal format for JSON writer: " + stringValue);
        }
        byte[] charsetHeader = getCharsetHeader(charset);
        this.charsetHeaderBytes = charsetHeader;
        byte[] bArrRemoveHeader = removeHeader("\n".getBytes(charset), charsetHeader.length);
        this.lineFeedBytes = bArrRemoveHeader;
        byte[] bArrRemoveHeader2 = removeHeader(StringUtils.CR.getBytes(charset), charsetHeader.length);
        this.carriageReturnBytes = bArrRemoveHeader2;
        this.newLineBytes = removeHeader(NEW_LINE.getBytes(charset), charsetHeader.length);
        byte[] bArrRemoveHeader3 = removeHeader(" ".getBytes(charset), charsetHeader.length);
        this.spaceBytes = bArrRemoveHeader3;
        byte[] bArrRemoveHeader4 = removeHeader("\t".getBytes(charset), charsetHeader.length);
        this.tabulatorBytes = bArrRemoveHeader4;
        byte[] bArrRemoveHeader5 = removeHeader(",".getBytes(charset), charsetHeader.length);
        this.commaBytes = bArrRemoveHeader5;
        byte[] bArrRemoveHeader6 = removeHeader("[".getBytes(charset), charsetHeader.length);
        this.bracketOpenBytes = bArrRemoveHeader6;
        byte[] bArrRemoveHeader7 = removeHeader("]".getBytes(charset), charsetHeader.length);
        this.bracketCloseBytes = bArrRemoveHeader7;
        int length = bArrRemoveHeader.length;
        this.characterSize = length;
        if (length != bArrRemoveHeader2.length || length != bArrRemoveHeader3.length || length != bArrRemoveHeader4.length || length != bArrRemoveHeader5.length || length != bArrRemoveHeader6.length || length != bArrRemoveHeader7.length) {
            throw new IllegalArgumentException("Invalid charset " + charset.displayName() + ". All ASCII characters must have the same number of bytes.");
        }
        if (booleanValue3) {
            this.builder = new StringBuilder();
        }
        if (!this.lineDelimitedJson && !prepareStandardJsonFile()) {
            z = false;
        }
        this.firstEntry = z;
        this.truncateSize = 0;
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) throws IOException {
        StringBuilder sb = this.builder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder();
            addJsonObject(logEntry, sb2);
            synchronized (this.writer) {
                internalWrite(sb2.toString().getBytes(this.charset));
            }
            return;
        }
        sb.setLength(0);
        addJsonObject(logEntry, this.builder);
        internalWrite(this.builder.toString().getBytes(this.charset));
    }

    @Override // org.tinylog.writers.Writer
    public void flush() throws IOException {
        if (this.builder == null) {
            synchronized (this.writer) {
                internalFlush();
            }
            return;
        }
        internalFlush();
    }

    @Override // org.tinylog.writers.Writer
    public void close() throws IOException {
        if (this.builder == null) {
            synchronized (this.writer) {
                internalClose();
            }
            return;
        }
        internalClose();
    }

    @Override // org.tinylog.writers.Writer
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        EnumSet enumSetNoneOf = EnumSet.noneOf(LogEntryValue.class);
        Iterator<Token> it = this.fields.values().iterator();
        while (it.hasNext()) {
            enumSetNoneOf.addAll(it.next().getRequiredLogEntryValues());
        }
        return enumSetNoneOf;
    }

    private void addJsonObject(LogEntry logEntry, StringBuilder sb) {
        if (!this.lineDelimitedJson) {
            sb.append(NEW_LINE);
            sb.append('\t');
        }
        sb.append("{");
        if (!this.lineDelimitedJson) {
            sb.append(NEW_LINE);
        }
        int i = 0;
        Token[] tokenArr = (Token[]) this.fields.values().toArray(new Token[0]);
        String[] strArr = (String[]) this.fields.keySet().toArray(new String[0]);
        while (i < tokenArr.length) {
            if (!this.lineDelimitedJson) {
                sb.append("\t\t");
            }
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append("\": \"");
            int length = sb.length();
            tokenArr[i].render(logEntry, sb);
            escapeCharacter("\\", "\\\\", sb, length);
            escapeCharacter("\"", "\\\"", sb, length);
            String str = NEW_LINE;
            escapeCharacter(str, "\\n", sb, length);
            escapeCharacter("\t", "\\t", sb, length);
            escapeCharacter("\b", "\\b", sb, length);
            escapeCharacter("\f", "\\f", sb, length);
            escapeCharacter("\n", "\\n", sb, length);
            escapeCharacter(StringUtils.CR, "\\r", sb, length);
            sb.append('\"');
            i++;
            if (i < this.fields.size()) {
                sb.append(",");
                if (this.lineDelimitedJson) {
                    sb.append(' ');
                } else {
                    sb.append(str);
                }
            }
        }
        if (!this.lineDelimitedJson) {
            sb.append(NEW_LINE).append('\t');
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        if (this.lineDelimitedJson) {
            sb.append(NEW_LINE);
        }
    }

    private void internalWrite(byte[] bArr) throws IOException {
        int i = this.truncateSize;
        if (i > 0) {
            this.writer.truncate(i);
            this.truncateSize = 0;
        }
        if (this.firstEntry) {
            this.firstEntry = false;
        } else if (!this.lineDelimitedJson) {
            ByteArrayWriter byteArrayWriter = this.writer;
            byte[] bArr2 = this.commaBytes;
            byteArrayWriter.write(bArr2, 0, bArr2.length);
        }
        this.writer.write(bArr, 0, bArr.length);
    }

    private void internalFlush() throws IOException {
        int length = 0;
        if (!this.lineDelimitedJson) {
            ByteArrayWriter byteArrayWriter = this.writer;
            byte[] bArr = this.newLineBytes;
            byteArrayWriter.write(bArr, 0, bArr.length);
            ByteArrayWriter byteArrayWriter2 = this.writer;
            byte[] bArr2 = this.bracketCloseBytes;
            byteArrayWriter2.write(bArr2, 0, bArr2.length);
        }
        this.writer.flush();
        if (!this.lineDelimitedJson) {
            length = this.bracketCloseBytes.length + this.newLineBytes.length;
        }
        this.truncateSize = length;
    }

    private void internalClose() throws IOException {
        internalFlush();
        this.writer.close();
    }

    private void escapeCharacter(String str, String str2, StringBuilder sb, int i) {
        int iIndexOf = sb.indexOf(str, i);
        while (iIndexOf != -1) {
            sb.replace(iIndexOf, str.length() + iIndexOf, str2);
            iIndexOf = sb.indexOf(str, iIndexOf + str2.length());
        }
    }

    private boolean isWhitespace(byte[] bArr, int i) {
        return isPresent(bArr, i, this.lineFeedBytes) || isPresent(bArr, i, this.carriageReturnBytes) || isPresent(bArr, i, this.spaceBytes) || isPresent(bArr, i, this.tabulatorBytes);
    }

    private boolean isPresent(byte[] bArr, int i, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean prepareStandardJsonFile() throws IOException {
        byte[] bArr = new byte[1024];
        boolean z = false;
        int tail = this.writer.readTail(bArr, 0, 1024);
        if (tail > this.charsetHeaderBytes.length) {
            int i = tail - this.characterSize;
            int i2 = tail;
            while (i >= this.charsetHeaderBytes.length) {
                if (isPresent(bArr, i, this.bracketCloseBytes)) {
                    z = true;
                } else if (!z) {
                    continue;
                } else {
                    if (!isWhitespace(bArr, i)) {
                        this.writer.truncate(tail - i2);
                        return isPresent(bArr, i, this.bracketOpenBytes);
                    }
                    i2 = i;
                }
                i -= this.characterSize;
            }
            throw new IOException("Invalid JSON file. The file is missing a closing bracket for the array.");
        }
        ByteArrayWriter byteArrayWriter = this.writer;
        byte[] bArr2 = this.bracketOpenBytes;
        byteArrayWriter.write(bArr2, 0, bArr2.length);
        return true;
    }

    private static byte[] removeHeader(byte[] bArr, int i) {
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    private static Map<String, Token> createTokens(Map<String, String> map) {
        FormatPatternParser formatPatternParser = new FormatPatternParser(map.get("exception"));
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().toLowerCase(Locale.ROOT).startsWith(FIELD_PREFIX)) {
                map2.put(entry.getKey().substring(FIELD_PREFIX.length()), formatPatternParser.parse(entry.getValue()));
            }
        }
        return map2;
    }
}
