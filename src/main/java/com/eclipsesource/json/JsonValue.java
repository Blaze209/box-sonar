package com.eclipsesource.json;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public abstract class JsonValue implements Serializable {

    @Deprecated
    public static final JsonValue TRUE = new JsonLiteral(TelemetryEventStrings.Value.TRUE);

    @Deprecated
    public static final JsonValue FALSE = new JsonLiteral("false");

    @Deprecated
    public static final JsonValue NULL = new JsonLiteral(AbstractJsonLexerKt.NULL);

    public boolean isArray() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isFalse() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isTrue() {
        return false;
    }

    abstract void write(JsonWriter jsonWriter) throws IOException;

    JsonValue() {
    }

    @Deprecated
    public static JsonValue readFrom(Reader reader) throws IOException {
        return Json.parse(reader);
    }

    @Deprecated
    public static JsonValue readFrom(String str) {
        return Json.parse(str);
    }

    @Deprecated
    public static JsonValue valueOf(int i) {
        return Json.value(i);
    }

    @Deprecated
    public static JsonValue valueOf(long j) {
        return Json.value(j);
    }

    @Deprecated
    public static JsonValue valueOf(float f) {
        return Json.value(f);
    }

    @Deprecated
    public static JsonValue valueOf(double d) {
        return Json.value(d);
    }

    @Deprecated
    public static JsonValue valueOf(String str) {
        return Json.value(str);
    }

    @Deprecated
    public static JsonValue valueOf(boolean z) {
        return Json.value(z);
    }

    public JsonObject asObject() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    public JsonArray asArray() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    public int asInt() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public long asLong() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public float asFloat() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public double asDouble() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public String asString() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    public boolean asBoolean() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public void writeTo(Writer writer) throws IOException {
        writeTo(writer, WriterConfig.MINIMAL);
    }

    public void writeTo(Writer writer, WriterConfig writerConfig) throws IOException {
        if (writer == null) {
            throw new NullPointerException("writer is null");
        }
        if (writerConfig == null) {
            throw new NullPointerException("config is null");
        }
        WritingBuffer writingBuffer = new WritingBuffer(writer, 128);
        write(writerConfig.createWriter(writingBuffer));
        writingBuffer.flush();
    }

    public String toString() {
        return toString(WriterConfig.MINIMAL);
    }

    public String toString(WriterConfig writerConfig) {
        StringWriter stringWriter = new StringWriter();
        try {
            writeTo(stringWriter, writerConfig);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
