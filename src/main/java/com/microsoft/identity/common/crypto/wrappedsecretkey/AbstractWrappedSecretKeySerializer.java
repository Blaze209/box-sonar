package com.microsoft.identity.common.crypto.wrappedsecretkey;

import com.microsoft.identity.common.logging.Logger;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractWrappedSecretKeySerializer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H$J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/AbstractWrappedSecretKeySerializer;", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/IWrappedSecretKeySerializer;", "()V", "deserialize", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "wrappedSecretKeyByteArray", "", "deserializeMetadata", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeyMetadata;", "metadataByteArray", "serialize", "wrappedSecretKey", "serializeMetadata", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractWrappedSecretKeySerializer implements IWrappedSecretKeySerializer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAGIC_BYTES_SIZE_BYTES = 4;
    public static final int METADATA_FORMAT_MAGIC_BYTES = 16727211;
    public static final int METADATA_ID_SIZE_BYTES = 4;
    public static final int METADATA_LENGTH_FIELD_SIZE_BYTES = 4;
    public static final String TAG = "AbstractWrappedSecretKeySerializer";

    protected abstract WrappedSecretKeyMetadata deserializeMetadata(byte[] metadataByteArray);

    public abstract byte[] serializeMetadata(WrappedSecretKey wrappedSecretKey);

    /* JADX INFO: compiled from: AbstractWrappedSecretKeySerializer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/AbstractWrappedSecretKeySerializer$Companion;", "", "()V", "MAGIC_BYTES_SIZE_BYTES", "", "METADATA_FORMAT_MAGIC_BYTES", "METADATA_ID_SIZE_BYTES", "METADATA_LENGTH_FIELD_SIZE_BYTES", "TAG", "", "getSerializerIdFromByteArray", "wrappedSecretKeyByteArray", "", "([B)Ljava/lang/Integer;", "isSerializedWithMetadata", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final boolean isSerializedWithMetadata(byte[] wrappedSecretKeyByteArray) {
            if (wrappedSecretKeyByteArray.length >= 12) {
                return ByteBuffer.wrap(wrappedSecretKeyByteArray, 0, 4).getInt() == 16727211;
            }
            Logger.warn("AbstractWrappedSecretKeySerializer:isNewFormat", "Data too small to contain header, assuming legacy format");
            return false;
        }

        public final Integer getSerializerIdFromByteArray(byte[] wrappedSecretKeyByteArray) {
            Intrinsics.checkNotNullParameter(wrappedSecretKeyByteArray, "wrappedSecretKeyByteArray");
            if (isSerializedWithMetadata(wrappedSecretKeyByteArray)) {
                return Integer.valueOf(ByteBuffer.wrap(wrappedSecretKeyByteArray, 4, 4).getInt());
            }
            return null;
        }
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public byte[] serialize(WrappedSecretKey wrappedSecretKey) {
        Intrinsics.checkNotNullParameter(wrappedSecretKey, "wrappedSecretKey");
        byte[] bArrSerializeMetadata = serializeMetadata(wrappedSecretKey);
        byte[] bArrArray = ByteBuffer.allocate(bArrSerializeMetadata.length + 12 + wrappedSecretKey.getWrappedKeyData().length).putInt(METADATA_FORMAT_MAGIC_BYTES).putInt(getId()).putInt(bArrSerializeMetadata.length).put(bArrSerializeMetadata).put(wrappedSecretKey.getWrappedKeyData()).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(bufferSize)\n   …data\n            .array()");
        return bArrArray;
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public WrappedSecretKey deserialize(byte[] wrappedSecretKeyByteArray) {
        Intrinsics.checkNotNullParameter(wrappedSecretKeyByteArray, "wrappedSecretKeyByteArray");
        Logger.info("AbstractWrappedSecretKeySerializer:loadFromNewFormat", "Loading key using metadata format");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(wrappedSecretKeyByteArray);
        byteBufferWrap.getInt();
        byteBufferWrap.getInt();
        byte[] bArr = new byte[byteBufferWrap.getInt()];
        byteBufferWrap.get(bArr);
        WrappedSecretKeyMetadata wrappedSecretKeyMetadataDeserializeMetadata = deserializeMetadata(bArr);
        if (wrappedSecretKeyMetadataDeserializeMetadata.getKeyLength() != byteBufferWrap.remaining()) {
            Logger.warn("AbstractWrappedSecretKeySerializer:loadFromNewFormat", "Key data length mismatch. Expected: " + wrappedSecretKeyMetadataDeserializeMetadata.getKeyLength() + ", Actual: " + byteBufferWrap.remaining());
        }
        byte[] bArr2 = new byte[byteBufferWrap.remaining()];
        byteBufferWrap.get(bArr2);
        Logger.verbose("AbstractWrappedSecretKeySerializer:loadFromNewFormat", "Successfully loaded key with algorithm: " + wrappedSecretKeyMetadataDeserializeMetadata.getAlgorithm() + ", transformation: " + wrappedSecretKeyMetadataDeserializeMetadata.getCipherTransformation());
        return new WrappedSecretKey(bArr2, wrappedSecretKeyMetadataDeserializeMetadata.getAlgorithm(), wrappedSecretKeyMetadataDeserializeMetadata.getCipherTransformation());
    }
}
