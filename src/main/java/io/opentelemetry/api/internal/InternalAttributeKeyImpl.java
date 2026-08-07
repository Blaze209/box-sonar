package io.opentelemetry.api.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributeType;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalAttributeKeyImpl<T> implements AttributeKey<T> {
    private final int hashCode;
    private final String key;

    @Nullable
    private byte[] keyUtf8;
    private final AttributeType type;

    private InternalAttributeKeyImpl(AttributeType attributeType, String str) {
        if (attributeType == null) {
            throw new NullPointerException("Null type");
        }
        this.type = attributeType;
        if (str == null) {
            throw new NullPointerException("Null key");
        }
        this.key = str;
        this.hashCode = buildHashCode(attributeType, str);
    }

    public static <T> AttributeKey<T> create(@Nullable String str, AttributeType attributeType) {
        if (str == null) {
            str = "";
        }
        return new InternalAttributeKeyImpl(attributeType, str);
    }

    @Override // io.opentelemetry.api.common.AttributeKey
    public AttributeType getType() {
        return this.type;
    }

    @Override // io.opentelemetry.api.common.AttributeKey
    public String getKey() {
        return this.key;
    }

    public byte[] getKeyUtf8() {
        byte[] bArr = this.keyUtf8;
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.key.getBytes(StandardCharsets.UTF_8);
        this.keyUtf8 = bytes;
        return bytes;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalAttributeKeyImpl) {
            InternalAttributeKeyImpl internalAttributeKeyImpl = (InternalAttributeKeyImpl) obj;
            if (this.type.equals(internalAttributeKeyImpl.getType()) && this.key.equals(internalAttributeKeyImpl.getKey())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return this.key;
    }

    private int buildHashCode() {
        return buildHashCode(this.type, this.key);
    }

    private static int buildHashCode(AttributeType attributeType, String str) {
        return ((attributeType.hashCode() ^ 1000003) * 1000003) ^ str.hashCode();
    }
}
