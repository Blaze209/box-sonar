package com.eclipsesource.json;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
class JsonLiteral extends JsonValue {
    private final boolean isFalse;
    private final boolean isNull;
    private final boolean isTrue;
    private final String value;

    JsonLiteral(String str) {
        this.value = str;
        this.isNull = AbstractJsonLexerKt.NULL.equals(str);
        this.isTrue = TelemetryEventStrings.Value.TRUE.equals(str);
        this.isFalse = "false".equals(str);
    }

    @Override // com.eclipsesource.json.JsonValue
    void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeLiteral(this.value);
    }

    @Override // com.eclipsesource.json.JsonValue
    public String toString() {
        return this.value;
    }

    @Override // com.eclipsesource.json.JsonValue
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isNull() {
        return this.isNull;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isTrue() {
        return this.isTrue;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isFalse() {
        return this.isFalse;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean isBoolean() {
        return this.isTrue || this.isFalse;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean asBoolean() {
        return this.isNull ? super.asBoolean() : this.isTrue;
    }

    @Override // com.eclipsesource.json.JsonValue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.value.equals(((JsonLiteral) obj).value);
        }
        return false;
    }
}
