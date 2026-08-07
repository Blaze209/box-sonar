package io.opentelemetry.sdk.logs.data;

/* JADX INFO: loaded from: classes4.dex */
public interface Body {

    public enum Type {
        EMPTY,
        STRING
    }

    String asString();

    Type getType();

    static Body string(String str) {
        return StringBody.create(str);
    }

    static Body empty() {
        return EmptyBody.INSTANCE;
    }
}
