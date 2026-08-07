package com.eclipsesource.json;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class JsonString extends JsonValue {
    private final String string;

    @Override // com.eclipsesource.json.JsonValue
    public boolean isString() {
        return true;
    }

    JsonString(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.string = str;
    }

    @Override // com.eclipsesource.json.JsonValue
    void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeString(this.string);
    }

    @Override // com.eclipsesource.json.JsonValue
    public String asString() {
        return this.string;
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
            return this.string.equals(((JsonString) obj).string);
        }
        return false;
    }
}
