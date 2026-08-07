package com.eclipsesource.json;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class JsonNumber extends JsonValue {
    private final String string;

    @Override // com.eclipsesource.json.JsonValue
    public boolean isNumber() {
        return true;
    }

    JsonNumber(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.string = str;
    }

    @Override // com.eclipsesource.json.JsonValue
    public String toString() {
        return this.string;
    }

    @Override // com.eclipsesource.json.JsonValue
    void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeNumber(this.string);
    }

    @Override // com.eclipsesource.json.JsonValue
    public int asInt() {
        return Integer.parseInt(this.string, 10);
    }

    @Override // com.eclipsesource.json.JsonValue
    public long asLong() {
        return Long.parseLong(this.string, 10);
    }

    @Override // com.eclipsesource.json.JsonValue
    public float asFloat() {
        return Float.parseFloat(this.string);
    }

    @Override // com.eclipsesource.json.JsonValue
    public double asDouble() {
        return Double.parseDouble(this.string);
    }

    @Override // com.eclipsesource.json.JsonValue
    public int hashCode() {
        return this.string.hashCode();
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.string.equals(((JsonNumber) obj).string);
        }
        return false;
    }
}
