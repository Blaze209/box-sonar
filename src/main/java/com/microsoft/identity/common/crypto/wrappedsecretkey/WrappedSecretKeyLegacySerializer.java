package com.microsoft.identity.common.crypto.wrappedsecretkey;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrappedSecretKeyLegacySerializer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeyLegacySerializer;", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/IWrappedSecretKeySerializer;", "()V", "id", "", "getId", "()I", "deserialize", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "wrappedSecretKeyByteArray", "", "serialize", "wrappedSecretKey", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrappedSecretKeyLegacySerializer implements IWrappedSecretKeySerializer {
    private static final String DEFAULT_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    public static final int ID = 0;
    private final int id;

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public byte[] serialize(WrappedSecretKey wrappedSecretKey) {
        Intrinsics.checkNotNullParameter(wrappedSecretKey, "wrappedSecretKey");
        return wrappedSecretKey.getWrappedKeyData();
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public WrappedSecretKey deserialize(byte[] wrappedSecretKeyByteArray) {
        Intrinsics.checkNotNullParameter(wrappedSecretKeyByteArray, "wrappedSecretKeyByteArray");
        return new WrappedSecretKey(wrappedSecretKeyByteArray, "AES", DEFAULT_CIPHER_TRANSFORMATION);
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public int getId() {
        return this.id;
    }
}
