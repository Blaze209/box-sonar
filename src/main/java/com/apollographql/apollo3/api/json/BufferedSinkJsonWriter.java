package com.apollographql.apollo3.api.json;

import com.apollographql.apollo3.api.Upload;
import com.apollographql.apollo3.api.json.internal.JsonScope;
import com.apollographql.apollo3.exception.JsonDataException;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.common.base.Ascii;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.BufferedSink;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: BufferedSinkJsonWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0001H\u0016J\b\u0010\u0019\u001a\u00020\u0001H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\b\u0010\u001f\u001a\u00020\u0001H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\u000e\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0001H\u0016J\u0018\u0010&\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020-H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020.H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020/H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u000200H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u000201H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/apollographql/apollo3/api/json/BufferedSinkJsonWriter;", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "sink", "Lokio/BufferedSink;", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT, "", "(Lokio/BufferedSink;Ljava/lang/String;)V", "deferredName", "path", "getPath", "()Ljava/lang/String;", "pathIndices", "", "pathNames", "", "[Ljava/lang/String;", "scopes", "separator", "getSeparator", "stackSize", "", "beforeName", "", "beforeValue", "beginArray", "beginObject", HeaderElements.CLOSE, "empty", "nonempty", "closeBracket", "endArray", "endObject", "flush", "jsonValue", "value", "name", "newline", "nullValue", "open", "openBracket", "peekScope", "pushScope", "newTop", "replaceTop", "topOfStack", "Lcom/apollographql/apollo3/api/Upload;", "Lcom/apollographql/apollo3/api/json/JsonNumber;", "", "", "", "writeDeferredName", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BufferedSinkJsonWriter implements JsonWriter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEX_ARRAY = "0123456789abcdef";
    private static final String[] REPLACEMENT_CHARS;
    private String deferredName;
    private final String indent;
    private final int[] pathIndices;
    private final String[] pathNames;
    private final int[] scopes;
    private final BufferedSink sink;
    private int stackSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BufferedSinkJsonWriter(BufferedSink sink) {
        this(sink, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(sink, "sink");
    }

    public BufferedSinkJsonWriter(BufferedSink sink, String str) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.indent = str;
        this.scopes = new int[256];
        this.pathNames = new String[256];
        this.pathIndices = new int[256];
        pushScope(6);
    }

    public /* synthetic */ BufferedSinkJsonWriter(BufferedSink bufferedSink, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bufferedSink, (i & 2) != 0 ? null : str);
    }

    private final String getSeparator() {
        String str = this.indent;
        return (str == null || str.length() == 0) ? ":" : ": ";
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public String getPath() {
        return CollectionsKt.joinToString$default(JsonScope.INSTANCE.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices), ".", null, null, 0, null, null, 62, null);
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter endArray() {
        return close(1, 2, "]");
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter endObject() {
        return close(3, 5, "}");
    }

    private final JsonWriter open(int empty, String openBracket) throws IOException {
        beforeValue();
        pushScope(empty);
        this.pathIndices[this.stackSize - 1] = 0;
        this.sink.writeUtf8(openBracket);
        return this;
    }

    private final JsonWriter close(int empty, int nonempty, String closeBracket) throws IOException {
        int iPeekScope = peekScope();
        if (iPeekScope != nonempty && iPeekScope != empty) {
            throw new IllegalStateException("Nesting problem.".toString());
        }
        if (this.deferredName != null) {
            throw new IllegalStateException(("Dangling name: " + this.deferredName).toString());
        }
        int i = this.stackSize;
        int i2 = i - 1;
        this.stackSize = i2;
        this.pathNames[i2] = null;
        int[] iArr = this.pathIndices;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        if (iPeekScope == nonempty) {
            newline();
        }
        this.sink.writeUtf8(closeBracket);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter name(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i = this.stackSize;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.".toString());
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Nesting problem.".toString());
        }
        this.deferredName = name;
        this.pathNames[i - 1] = name;
        return this;
    }

    private final void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            Companion companion = INSTANCE;
            BufferedSink bufferedSink = this.sink;
            String str = this.deferredName;
            Intrinsics.checkNotNull(str);
            companion.string(bufferedSink, str);
            this.deferredName = null;
        }
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        writeDeferredName();
        beforeValue();
        INSTANCE.string(this.sink, value);
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter nullValue() {
        return jsonValue(AbstractJsonLexerKt.NULL);
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(boolean value) {
        return jsonValue(value ? TelemetryEventStrings.Value.TRUE : "false");
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(("Numeric values must be finite, but was " + value).toString());
        }
        return jsonValue(String.valueOf(value));
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(int value) {
        return jsonValue(String.valueOf(value));
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(long value) {
        return jsonValue(String.valueOf(value));
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public JsonWriter value(JsonNumber value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return jsonValue(value.getValue());
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public BufferedSinkJsonWriter value(Upload value) {
        Intrinsics.checkNotNullParameter(value, "value");
        nullValue();
        return this;
    }

    public final JsonWriter jsonValue(String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(value);
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.".toString());
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.sink.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.scopes[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    private final void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.sink.writeByte(10);
        int i = this.stackSize;
        for (int i2 = 1; i2 < i; i2++) {
            this.sink.writeUtf8(this.indent);
        }
    }

    private final void beforeName() throws IOException {
        int iPeekScope = peekScope();
        if (iPeekScope == 5) {
            this.sink.writeByte(44);
        } else if (iPeekScope != 3) {
            throw new IllegalStateException("Nesting problem.".toString());
        }
        newline();
        replaceTop(4);
    }

    private final void beforeValue() throws IOException {
        int iPeekScope = peekScope();
        if (iPeekScope == 1) {
            replaceTop(2);
            newline();
            return;
        }
        if (iPeekScope == 2) {
            this.sink.writeByte(44);
            newline();
        } else if (iPeekScope == 4) {
            this.sink.writeUtf8(getSeparator());
            replaceTop(5);
        } else if (iPeekScope == 6) {
            replaceTop(7);
        } else {
            if (iPeekScope == 7) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            throw new IllegalStateException("Nesting problem.");
        }
    }

    private final int peekScope() {
        int i = this.stackSize;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.".toString());
        }
        return this.scopes[i - 1];
    }

    private final void pushScope(int newTop) {
        int i = this.stackSize;
        int[] iArr = this.scopes;
        if (i == iArr.length) {
            throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
        }
        this.stackSize = i + 1;
        iArr[i] = newTop;
    }

    private final void replaceTop(int topOfStack) {
        this.scopes[this.stackSize - 1] = topOfStack;
    }

    /* JADX INFO: compiled from: BufferedSinkJsonWriter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\f\u0010\r\u001a\u00020\u0004*\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/api/json/BufferedSinkJsonWriter$Companion;", "", "()V", "HEX_ARRAY", "", "REPLACEMENT_CHARS", "", "[Ljava/lang/String;", "string", "", "sink", "Lokio/BufferedSink;", "value", "hexString", "", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String hexString(byte b) {
            return new StringBuilder().append(BufferedSinkJsonWriter.HEX_ARRAY.charAt(b >>> 4)).append(BufferedSinkJsonWriter.HEX_ARRAY.charAt(b & Ascii.SI)).toString();
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0039  */
        public final void string(BufferedSink sink, String value) throws IOException {
            String str;
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(value, "value");
            String[] strArr = BufferedSinkJsonWriter.REPLACEMENT_CHARS;
            sink.writeByte(34);
            int length = value.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = value.charAt(i2);
                if (cCharAt < 128) {
                    str = strArr[cCharAt];
                    if (str != null) {
                        if (i < i2) {
                            sink.writeUtf8(value, i, i2);
                        }
                        sink.writeUtf8(str);
                        i = i2 + 1;
                    }
                } else {
                    if (cCharAt == 8232) {
                        str = "\\u2028";
                    } else if (cCharAt == 8233) {
                        str = "\\u2029";
                    }
                    if (i < i2) {
                        sink.writeUtf8(value, i, i2);
                    }
                    sink.writeUtf8(str);
                    i = i2 + 1;
                }
            }
            if (i < length) {
                sink.writeUtf8(value, i, length);
            }
            sink.writeByte(34);
        }
    }

    static {
        String[] strArr = new String[128];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u00" + INSTANCE.hexString((byte) i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        REPLACEMENT_CHARS = strArr;
    }
}
