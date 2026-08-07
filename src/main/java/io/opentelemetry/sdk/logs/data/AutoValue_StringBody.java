package io.opentelemetry.sdk.logs.data;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_StringBody extends StringBody {
    private final String asString;

    AutoValue_StringBody(String str) {
        if (str == null) {
            throw new NullPointerException("Null asString");
        }
        this.asString = str;
    }

    @Override // io.opentelemetry.sdk.logs.data.StringBody, io.opentelemetry.sdk.logs.data.Body
    public String asString() {
        return this.asString;
    }

    public String toString() {
        return "StringBody{asString=" + this.asString + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StringBody) {
            return this.asString.equals(((StringBody) obj).asString());
        }
        return false;
    }

    public int hashCode() {
        return this.asString.hashCode() ^ 1000003;
    }
}
