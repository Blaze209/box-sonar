package io.opentelemetry.sdk.logs.data;

/* JADX INFO: loaded from: classes4.dex */
abstract class StringBody implements Body {
    @Override // io.opentelemetry.sdk.logs.data.Body
    public abstract String asString();

    StringBody() {
    }

    static Body create(String str) {
        return new AutoValue_StringBody(str);
    }

    @Override // io.opentelemetry.sdk.logs.data.Body
    public final Body.Type getType() {
        return Body.Type.STRING;
    }
}
