package com.apollographql.apollo3.api.json;

import com.apollographql.apollo3.api.json.internal.JsonScope;
import com.apollographql.apollo3.exception.JsonDataException;
import com.apollographql.apollo3.exception.JsonEncodingException;
import com.facebook.react.devsupport.StackTraceHelper;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: BufferedSourceJsonReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 G2\u00020\u0001:\u0001GB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0001H\u0016J\b\u0010\u0018\u001a\u00020\u0001H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u0001H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020#H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00107\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020\u001aH\u0016J\u0016\u0010@\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fH\u0016J\u0010\u0010B\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u00020\u001aH\u0016J\u0010\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/apollographql/apollo3/api/json/BufferedSourceJsonReader;", "Lcom/apollographql/apollo3/api/json/JsonReader;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "indexStack", "", "indexStackSize", "", "pathIndices", "pathNames", "", "", "[Ljava/lang/String;", "peeked", "peekedLong", "", "peekedNumberLength", "peekedString", StackTraceHelper.STACK_KEY, "stackSize", "beginArray", "beginObject", HeaderElements.CLOSE, "", "doPeek", "endArray", "endObject", "getPath", "", "", "getPathAsString", "hasNext", "", "isLiteral", "c", "", "nextBoolean", "nextDouble", "", "nextInt", "nextLong", "nextName", "nextNonWhitespace", "throwOnEof", "nextNull", "", "nextNumber", "Lcom/apollographql/apollo3/api/json/JsonNumber;", "nextQuotedValue", "runTerminator", "Lokio/ByteString;", "nextString", "nextUnquotedValue", "peek", "Lcom/apollographql/apollo3/api/json/JsonReader$Token;", "peekKeyword", "peekNumber", "push", "newTop", "readEscapeCharacter", "rewind", "selectName", "names", "skipQuotedValue", "skipUnquotedValue", "skipValue", "throwSyntaxError", "message", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BufferedSourceJsonReader implements JsonReader {
    public static final int MAX_STACK_SIZE = 256;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Buffer buffer;
    private final int[] indexStack;
    private int indexStackSize;
    private final int[] pathIndices;
    private final String[] pathNames;
    private int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final BufferedSource source;
    private final int[] stack;
    private int stackSize;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.INSTANCE.encodeUtf8("'\\");
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.INSTANCE.encodeUtf8("\"\\");
    private static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.INSTANCE.encodeUtf8("{}[]:, \n\t\r/\\;#=");

    public BufferedSourceJsonReader(BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.buffer = source.getBuffer();
        int[] iArr = new int[256];
        iArr[0] = 6;
        this.stack = iArr;
        this.stackSize = 1;
        this.pathNames = new String[256];
        this.pathIndices = new int[256];
        int[] iArr2 = new int[256];
        iArr2[0] = 0;
        this.indexStack = iArr2;
        this.indexStackSize = 1;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonReader beginArray() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if ((numValueOf != null ? numValueOf.intValue() : doPeek()) == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return this;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonReader endArray() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if ((numValueOf != null ? numValueOf.intValue() : doPeek()) == 4) {
            int i = this.stackSize;
            this.stackSize = i - 1;
            int[] iArr = this.pathIndices;
            int i2 = i - 2;
            iArr[i2] = iArr[i2] + 1;
            this.peeked = 0;
            return this;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonReader beginObject() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if ((numValueOf != null ? numValueOf.intValue() : doPeek()) == 1) {
            push(3);
            this.peeked = 0;
            int i = this.indexStackSize;
            this.indexStackSize = i + 1;
            this.indexStack[i] = 0;
            return this;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonReader endObject() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if ((numValueOf != null ? numValueOf.intValue() : doPeek()) == 2) {
            int i = this.stackSize;
            int i2 = i - 1;
            this.stackSize = i2;
            this.pathNames[i2] = null;
            int[] iArr = this.pathIndices;
            int i3 = i - 2;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            this.indexStackSize--;
            return this;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public boolean hasNext() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        return (iIntValue == 2 || iIntValue == 4) ? false : true;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    /* JADX INFO: renamed from: peek */
    public JsonReader.Token getPeekedToken() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        switch (numValueOf != null ? numValueOf.intValue() : doPeek()) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
                return JsonReader.Token.NAME;
            case 15:
                return JsonReader.Token.LONG;
            case 16:
                return JsonReader.Token.NUMBER;
            case 17:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private final int doPeek() throws EOFException {
        int[] iArr = this.stack;
        int i = this.stackSize;
        int i2 = iArr[i - 1];
        switch (i2) {
            case 1:
                iArr[i - 1] = 2;
                break;
            case 2:
                int iNextNonWhitespace = nextNonWhitespace(true);
                this.buffer.readByte();
                char c = (char) iNextNonWhitespace;
                if (c == ']') {
                    this.peeked = 4;
                    return 4;
                }
                if (c != ',') {
                    throwSyntaxError("Unterminated array");
                    throw new KotlinNothingValueException();
                }
                break;
            case 3:
            case 5:
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iNextNonWhitespace2 = nextNonWhitespace(true);
                    this.buffer.readByte();
                    char c2 = (char) iNextNonWhitespace2;
                    if (c2 == '}') {
                        this.peeked = 2;
                        return 2;
                    }
                    if (c2 != ',') {
                        throwSyntaxError("Unterminated object");
                        throw new KotlinNothingValueException();
                    }
                }
                char cNextNonWhitespace = (char) nextNonWhitespace(true);
                if (cNextNonWhitespace == '\"') {
                    this.buffer.readByte();
                    this.peeked = 13;
                    return 13;
                }
                if (cNextNonWhitespace != '}') {
                    throwSyntaxError("Unexpected character: " + cNextNonWhitespace);
                    throw new KotlinNothingValueException();
                }
                if (i2 != 5) {
                    this.buffer.readByte();
                    this.peeked = 2;
                    return 2;
                }
                throwSyntaxError("Expected name");
                throw new KotlinNothingValueException();
            case 4:
                iArr[i - 1] = 5;
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (((char) iNextNonWhitespace3) != ':') {
                    throwSyntaxError("Expected ':'");
                    throw new KotlinNothingValueException();
                }
                break;
            case 6:
                iArr[i - 1] = 7;
                break;
            case 7:
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                throwSyntaxError("Malformed JSON");
                throw new KotlinNothingValueException();
            default:
                if (i2 == 8) {
                    throw new IllegalStateException("JsonReader is closed".toString());
                }
                break;
        }
        char cNextNonWhitespace2 = (char) nextNonWhitespace(true);
        if (cNextNonWhitespace2 == ']') {
            if (i2 == 1) {
                this.buffer.readByte();
                this.peeked = 4;
                return 4;
            }
            throwSyntaxError("Unexpected value");
            throw new KotlinNothingValueException();
        }
        if (cNextNonWhitespace2 == ';' || cNextNonWhitespace2 == ',' || cNextNonWhitespace2 == '\'') {
            throwSyntaxError("Unexpected value");
            throw new KotlinNothingValueException();
        }
        if (cNextNonWhitespace2 == '\"') {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        }
        if (cNextNonWhitespace2 == '[') {
            this.buffer.readByte();
            this.peeked = 3;
            return 3;
        }
        if (cNextNonWhitespace2 == '{') {
            this.buffer.readByte();
            this.peeked = 1;
            return 1;
        }
        int iPeekKeyword = peekKeyword();
        if (iPeekKeyword != 0) {
            return iPeekKeyword;
        }
        int iPeekNumber = peekNumber();
        if (iPeekNumber != 0) {
            return iPeekNumber;
        }
        if (!isLiteral((char) this.buffer.getByte(0L))) {
            throwSyntaxError("Expected value");
            throw new KotlinNothingValueException();
        }
        throwSyntaxError("Malformed JSON");
        throw new KotlinNothingValueException();
    }

    private final int peekKeyword() throws EOFException {
        String str;
        String str2;
        int i;
        byte b = this.buffer.getByte(0L);
        if (b == 116 || b == 84) {
            str = TelemetryEventStrings.Value.TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = AbstractJsonLexerKt.NULL;
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            long j = i2;
            if (!this.source.request(1 + j)) {
                return 0;
            }
            byte b2 = this.buffer.getByte(j);
            if (b2 != ((byte) str.charAt(i2)) && b2 != ((byte) str2.charAt(i2))) {
                return 0;
            }
        }
        long j2 = length;
        if (this.source.request(1 + j2) && isLiteral((char) this.buffer.getByte(j2))) {
            return 0;
        }
        this.buffer.skip(j2);
        this.peeked = i;
        return i;
    }

    private final int peekNumber() throws EOFException {
        long j;
        int i;
        boolean z = true;
        int i2 = 0;
        char c = 0;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            j = i2;
            if (!this.source.request(1 + j)) {
                i = 0;
                break;
            }
            byte b = this.buffer.getByte(j);
            char c2 = (char) b;
            i = 0;
            if (c2 == '-') {
                if (c != 0) {
                    if (c != 5) {
                        return 0;
                    }
                    c = 6;
                } else {
                    c = 1;
                    z2 = true;
                }
            } else if (c2 == '+') {
                if (c != 5) {
                    return 0;
                }
                c = 6;
            } else if (c2 == 'e' || c2 == 'E') {
                if (c != 2 && c != 4) {
                    return 0;
                }
                c = 5;
            } else if (c2 == '.') {
                if (c != 2) {
                    return 0;
                }
                c = 3;
            } else {
                if (b < 48 || b > 57) {
                    if (!isLiteral(c2)) {
                        break;
                    }
                    return 0;
                }
                if (c == 0 || c == 1) {
                    j2 = -(b - 48);
                    c = 2;
                } else if (c != 2) {
                    if (c == 3) {
                        c = 4;
                    } else if (c == 5 || c == 6) {
                        c = 7;
                    }
                } else {
                    if (j2 == 0) {
                        return 0;
                    }
                    long j3 = (((long) 10) * j2) - ((long) (b - 48));
                    z = (((j2 > (-922337203685477580L) ? 1 : (j2 == (-922337203685477580L) ? 0 : -1)) > 0) && z) || (j2 == -922337203685477580L && j3 < j2);
                    j2 = j3;
                }
            }
            i2++;
        }
        if (c == 2 && z && (j2 != Long.MIN_VALUE || z2)) {
            if (!z2) {
                j2 = -j2;
            }
            this.peekedLong = j2;
            this.buffer.skip(j);
            this.peeked = 15;
            return 15;
        }
        if (c != 2 && c != 4 && c != 7) {
            return i;
        }
        this.peekedNumberLength = i2;
        this.peeked = 16;
        return 16;
    }

    private final boolean isLiteral(char c) {
        if (c != '/' && c != '\\' && c != ';' && c != '#' && c != '=') {
            return !(c == '{' || c == '}' || c == '[' || c == ']' || c == ':' || c == ',' || c == ' ' || c == '\t' || c == '\r' || c == '\n');
        }
        throwSyntaxError("Unexpected character: " + c);
        throw new KotlinNothingValueException();
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public String nextName() throws IOException {
        String strNextQuotedValue;
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        switch (numValueOf != null ? numValueOf.intValue() : doPeek()) {
            case 12:
                strNextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                break;
            case 13:
                strNextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                break;
            case 14:
                strNextQuotedValue = nextUnquotedValue();
                break;
            default:
                throw new JsonDataException("Expected a name but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public String nextString() throws IOException {
        Integer numValueOf = Integer.valueOf(this.peeked);
        String strValueOf = null;
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        if (iIntValue == 15) {
            strValueOf = String.valueOf(this.peekedLong);
        } else if (iIntValue != 16) {
            switch (iIntValue) {
                case 8:
                    strValueOf = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                    break;
                case 9:
                    strValueOf = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                    break;
                case 10:
                    strValueOf = nextUnquotedValue();
                    break;
                case 11:
                    String str = this.peekedString;
                    if (str != null) {
                        this.peekedString = null;
                        strValueOf = str;
                    }
                    break;
                default:
                    throw new JsonDataException("Expected a string but was " + getPeekedToken() + " at path " + getPathAsString());
            }
        } else {
            strValueOf = this.buffer.readUtf8(this.peekedNumberLength);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return strValueOf;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public boolean nextBoolean() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        if (iIntValue == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iIntValue == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public Void nextNull() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if ((numValueOf != null ? numValueOf.intValue() : doPeek()) == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + getPeekedToken() + " at path " + getPathAsString());
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public double nextDouble() {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        if (iIntValue == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this.peekedLong;
        }
        if (iIntValue == 16) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (iIntValue == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (iIntValue == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (iIntValue == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iIntValue != 11) {
            throw new JsonDataException("Expected a double but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        this.peeked = 11;
        try {
            String str = this.peekedString;
            Intrinsics.checkNotNull(str);
            double d = Double.parseDouble(str);
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + d + " at path " + getPathAsString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return d;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPathAsString());
        }
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public long nextLong() throws IOException {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        if (iIntValue == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this.peekedLong;
        }
        if (iIntValue == 16) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (iIntValue == 9 || iIntValue == 8) {
            String strNextQuotedValue = nextQuotedValue(iIntValue == 9 ? DOUBLE_QUOTE_OR_SLASH : SINGLE_QUOTE_OR_SLASH);
            this.peekedString = strNextQuotedValue;
            try {
                Intrinsics.checkNotNull(strNextQuotedValue);
                long j = Long.parseLong(strNextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i2 = this.stackSize - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        } else if (iIntValue != 11) {
            throw new JsonDataException("Expected a long but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        this.peeked = 11;
        try {
            String str = this.peekedString;
            Intrinsics.checkNotNull(str);
            double d = Double.parseDouble(str);
            long j2 = (long) d;
            if (j2 != d) {
                throw new JsonDataException("Expected a long but was " + this.peekedString + " at path " + getPathAsString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr3[i3] = iArr3[i3] + 1;
            return j2;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.peekedString + " at path " + getPathAsString());
        }
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public JsonNumber nextNumber() throws IOException {
        String strNextString = nextString();
        Intrinsics.checkNotNull(strNextString);
        return new JsonNumber(strNextString);
    }

    private final String nextQuotedValue(ByteString runTerminator) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.source.indexOfElement(runTerminator);
            if (jIndexOfElement == -1) {
                throwSyntaxError("Unterminated string");
                throw new KotlinNothingValueException();
            }
            if (this.buffer.getByte(jIndexOfElement) != 92) {
                if (sb == null) {
                    String utf8 = this.buffer.readUtf8(jIndexOfElement);
                    this.buffer.readByte();
                    return utf8;
                }
                sb.append(this.buffer.readUtf8(jIndexOfElement));
                this.buffer.readByte();
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "{\n        builder.append…uilder.toString()\n      }");
                return string;
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.buffer.readUtf8(jIndexOfElement));
            this.buffer.readByte();
            sb.append(readEscapeCharacter());
        }
    }

    private final String nextUnquotedValue() throws IOException {
        long jIndexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        return jIndexOfElement != -1 ? buffer.readUtf8(jIndexOfElement) : buffer.readUtf8();
    }

    private final void skipQuotedValue(ByteString runTerminator) throws IOException {
        while (true) {
            long jIndexOfElement = this.source.indexOfElement(runTerminator);
            if (jIndexOfElement == -1) {
                throwSyntaxError("Unterminated string");
                throw new KotlinNothingValueException();
            }
            if (this.buffer.getByte(jIndexOfElement) == 92) {
                this.buffer.skip(jIndexOfElement + 1);
                readEscapeCharacter();
            } else {
                this.buffer.skip(jIndexOfElement + 1);
                return;
            }
        }
    }

    private final void skipUnquotedValue() throws IOException {
        long jIndexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public int nextInt() throws IOException {
        Integer numValueOf = Integer.valueOf(this.peeked);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : doPeek();
        if (iIntValue == 15) {
            long j = this.peekedLong;
            int i = (int) j;
            if (j != i) {
                throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iIntValue == 16) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (iIntValue == 9 || iIntValue == 8) {
            String strNextQuotedValue = nextQuotedValue(iIntValue == 9 ? DOUBLE_QUOTE_OR_SLASH : SINGLE_QUOTE_OR_SLASH);
            this.peekedString = strNextQuotedValue;
            try {
                Intrinsics.checkNotNull(strNextQuotedValue);
                int i3 = Integer.parseInt(strNextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iIntValue != 11) {
            throw new JsonDataException("Expected an int but was " + getPeekedToken() + " at path " + getPathAsString());
        }
        this.peeked = 11;
        try {
            String str = this.peekedString;
            Intrinsics.checkNotNull(str);
            double d = Double.parseDouble(str);
            int i5 = (int) d;
            if (i5 != d) {
                throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPathAsString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPathAsString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public void skipValue() throws IOException {
        int i = 0;
        do {
            Integer numValueOf = Integer.valueOf(this.peeked);
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            switch (numValueOf != null ? numValueOf.intValue() : doPeek()) {
                case 1:
                    push(3);
                    i++;
                    break;
                case 2:
                    this.stackSize--;
                    i--;
                    break;
                case 3:
                    push(1);
                    i++;
                    break;
                case 4:
                    this.stackSize--;
                    i--;
                    break;
                case 8:
                case 12:
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                    break;
                case 9:
                case 13:
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                    break;
                case 10:
                case 14:
                    skipUnquotedValue();
                    break;
                case 16:
                    this.buffer.skip(this.peekedNumberLength);
                    break;
            }
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pathNames[i2 - 1] = AbstractJsonLexerKt.NULL;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public int selectName(List<String> names) throws IOException {
        Intrinsics.checkNotNullParameter(names, "names");
        if (names.isEmpty()) {
            return -1;
        }
        while (hasNext()) {
            String strNextName = nextName();
            int i = this.indexStack[this.indexStackSize - 1];
            if (Intrinsics.areEqual(names.get(i), strNextName)) {
                int[] iArr = this.indexStack;
                int i2 = this.indexStackSize;
                iArr[i2 - 1] = i + 1;
                if (iArr[i2 - 1] == names.size()) {
                    this.indexStack[this.indexStackSize - 1] = 0;
                }
                return i;
            }
            int i3 = i;
            while (true) {
                i3++;
                if (i3 == names.size()) {
                    i3 = 0;
                }
                if (i3 == i) {
                    break;
                }
                if (Intrinsics.areEqual(names.get(i3), strNextName)) {
                    int[] iArr2 = this.indexStack;
                    int i4 = this.indexStackSize;
                    iArr2[i4 - 1] = i3 + 1;
                    if (iArr2[i4 - 1] == names.size()) {
                        this.indexStack[this.indexStackSize - 1] = 0;
                    }
                    return i3;
                }
            }
            skipValue();
        }
        return -1;
    }

    private final void push(int newTop) {
        int i = this.stackSize;
        int[] iArr = this.stack;
        if (i == iArr.length) {
            throw new JsonDataException("Nesting too deep at " + getPath());
        }
        this.stackSize = i + 1;
        iArr[i] = newTop;
    }

    private final int nextNonWhitespace(boolean throwOnEof) throws EOFException {
        int i = 0;
        while (true) {
            long j = i;
            if (!this.source.request(j + 1)) {
                if (throwOnEof) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            i++;
            byte b = this.buffer.getByte(j);
            if (b != 9 && b != 10 && b != 13 && b != 32) {
                this.buffer.skip(((long) i) - 1);
                if (b != 35) {
                    if (b != 47 || !this.source.request(2L)) {
                        return b;
                    }
                    throwSyntaxError("Malformed JSON");
                    throw new KotlinNothingValueException();
                }
                throwSyntaxError("Malformed JSON");
                throw new KotlinNothingValueException();
            }
        }
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public List<Object> getPath() {
        return JsonScope.INSTANCE.getPath(this.stackSize, this.stack, this.pathNames, this.pathIndices);
    }

    private final String getPathAsString() {
        return CollectionsKt.joinToString$default(getPath(), ".", null, null, 0, null, null, 62, null);
    }

    private final char readEscapeCharacter() throws EOFException {
        int i;
        if (!this.source.request(1L)) {
            throwSyntaxError("Unterminated escape sequence");
            throw new KotlinNothingValueException();
        }
        char c = (char) this.buffer.readByte();
        if (c != 'u') {
            if (c == 't') {
                return '\t';
            }
            if (c == 'b') {
                return '\b';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == '\n' || c == '\'' || c == '\"' || c == '\\' || c == '/') {
                return c;
            }
            throwSyntaxError("Invalid escape sequence: \\" + c);
            throw new KotlinNothingValueException();
        }
        if (!this.source.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c2 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.buffer.getByte(i2);
            char c3 = (char) (c2 << 4);
            if (b >= 48 && b <= 57) {
                i = b - 48;
            } else if (b >= 97 && b <= 102) {
                i = b - 87;
            } else {
                if (b < 65 || b > 70) {
                    throwSyntaxError("\\u" + this.buffer.readUtf8(4L));
                    throw new KotlinNothingValueException();
                }
                i = b - 55;
            }
            c2 = (char) (c3 + i);
        }
        this.buffer.skip(4L);
        return c2;
    }

    @Override // com.apollographql.apollo3.api.json.JsonReader
    public void rewind() {
        throw new IllegalStateException("BufferedSourceJsonReader cannot rewind.".toString());
    }

    private final Void throwSyntaxError(String message) {
        throw new JsonEncodingException(message + " at path " + getPath());
    }
}
