package com.eclipsesource.json;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import java.io.Reader;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class Json {
    public static final JsonValue NULL = new JsonLiteral(AbstractJsonLexerKt.NULL);
    public static final JsonValue TRUE = new JsonLiteral(TelemetryEventStrings.Value.TRUE);
    public static final JsonValue FALSE = new JsonLiteral("false");

    private Json() {
    }

    public static JsonValue value(int i) {
        return new JsonNumber(Integer.toString(i, 10));
    }

    public static JsonValue value(long j) {
        return new JsonNumber(Long.toString(j, 10));
    }

    public static JsonValue value(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
        }
        return new JsonNumber(cutOffPointZero(Float.toString(f)));
    }

    public static JsonValue value(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
        }
        return new JsonNumber(cutOffPointZero(Double.toString(d)));
    }

    public static JsonValue value(String str) {
        return str == null ? NULL : new JsonString(str);
    }

    public static JsonValue value(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static JsonArray array() {
        return new JsonArray();
    }

    public static JsonArray array(int... iArr) {
        if (iArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (int i : iArr) {
            jsonArray.add(i);
        }
        return jsonArray;
    }

    public static JsonArray array(long... jArr) {
        if (jArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (long j : jArr) {
            jsonArray.add(j);
        }
        return jsonArray;
    }

    public static JsonArray array(float... fArr) {
        if (fArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (float f : fArr) {
            jsonArray.add(f);
        }
        return jsonArray;
    }

    public static JsonArray array(double... dArr) {
        if (dArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (double d : dArr) {
            jsonArray.add(d);
        }
        return jsonArray;
    }

    public static JsonArray array(boolean... zArr) {
        if (zArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (boolean z : zArr) {
            jsonArray.add(z);
        }
        return jsonArray;
    }

    public static JsonArray array(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("values is null");
        }
        JsonArray jsonArray = new JsonArray();
        for (String str : strArr) {
            jsonArray.add(str);
        }
        return jsonArray;
    }

    public static JsonObject object() {
        return new JsonObject();
    }

    public static JsonValue parse(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        DefaultHandler defaultHandler = new DefaultHandler();
        new JsonParser(defaultHandler).parse(str);
        return defaultHandler.getValue();
    }

    public static JsonValue parse(Reader reader) throws IOException {
        if (reader == null) {
            throw new NullPointerException("reader is null");
        }
        DefaultHandler defaultHandler = new DefaultHandler();
        new JsonParser(defaultHandler).parse(reader);
        return defaultHandler.getValue();
    }

    private static String cutOffPointZero(String str) {
        return str.endsWith(".0") ? str.substring(0, str.length() - 2) : str;
    }

    static class DefaultHandler extends JsonHandler<JsonArray, JsonObject> {
        protected JsonValue value;

        DefaultHandler() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.eclipsesource.json.JsonHandler
        public JsonArray startArray() {
            return new JsonArray();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.eclipsesource.json.JsonHandler
        public JsonObject startObject() {
            return new JsonObject();
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endNull() {
            this.value = Json.NULL;
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endBoolean(boolean z) {
            this.value = z ? Json.TRUE : Json.FALSE;
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endString(String str) {
            this.value = new JsonString(str);
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endNumber(String str) {
            this.value = new JsonNumber(str);
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endArray(JsonArray jsonArray) {
            this.value = jsonArray;
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endObject(JsonObject jsonObject) {
            this.value = jsonObject;
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endArrayValue(JsonArray jsonArray) {
            jsonArray.add(this.value);
        }

        @Override // com.eclipsesource.json.JsonHandler
        public void endObjectValue(JsonObject jsonObject, String str) {
            jsonObject.add(str, this.value);
        }

        JsonValue getValue() {
            return this.value;
        }
    }
}
