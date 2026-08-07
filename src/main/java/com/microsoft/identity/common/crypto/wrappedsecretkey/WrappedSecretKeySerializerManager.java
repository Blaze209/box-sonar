package com.microsoft.identity.common.crypto.wrappedsecretkey;

import com.microsoft.identity.common.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrappedSecretKeySerializerManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeySerializerManager;", "", "()V", "TAG", "", "getSerializer", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/IWrappedSecretKeySerializer;", "serializerId", "", "identifySerializer", "wrappedSecretKeyByteArray", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrappedSecretKeySerializerManager {
    public static final WrappedSecretKeySerializerManager INSTANCE = new WrappedSecretKeySerializerManager();
    private static final String TAG = "WrappedSecretKeySerializerManager";

    private WrappedSecretKeySerializerManager() {
    }

    public final int identifySerializer(byte[] wrappedSecretKeyByteArray) {
        Intrinsics.checkNotNullParameter(wrappedSecretKeyByteArray, "wrappedSecretKeyByteArray");
        Integer serializerIdFromByteArray = AbstractWrappedSecretKeySerializer.INSTANCE.getSerializerIdFromByteArray(wrappedSecretKeyByteArray);
        Logger.info("WrappedSecretKeySerializerManager:identifySerializer", "Detected serializer ID: " + serializerIdFromByteArray);
        if (serializerIdFromByteArray != null) {
            return serializerIdFromByteArray.intValue();
        }
        return 0;
    }

    public final IWrappedSecretKeySerializer getSerializer(int serializerId) {
        Logger.info("WrappedSecretKeySerializerManager:getSerializer", "Getting serializer for ID: " + serializerId);
        if (serializerId == 0) {
            return new WrappedSecretKeyLegacySerializer();
        }
        if (serializerId == 1) {
            return new WrappedSecretKeyBinaryStreamSerializer();
        }
        throw new IllegalArgumentException("Unsupported serializer ID: " + serializerId);
    }
}
