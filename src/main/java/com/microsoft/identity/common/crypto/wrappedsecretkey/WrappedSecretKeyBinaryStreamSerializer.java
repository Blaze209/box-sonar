package com.microsoft.identity.common.crypto.wrappedsecretkey;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrappedSecretKeyBinaryStreamSerializer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeyBinaryStreamSerializer;", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/AbstractWrappedSecretKeySerializer;", "()V", "id", "", "getId", "()I", "deserializeMetadata", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeyMetadata;", "metadataByteArray", "", "serializeMetadata", "wrappedSecretKey", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrappedSecretKeyBinaryStreamSerializer extends AbstractWrappedSecretKeySerializer {
    public static final int ID = 1;
    private final int id = 1;

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.IWrappedSecretKeySerializer
    public int getId() {
        return this.id;
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.AbstractWrappedSecretKeySerializer
    public byte[] serializeMetadata(WrappedSecretKey wrappedSecretKey) throws IOException {
        Intrinsics.checkNotNullParameter(wrappedSecretKey, "wrappedSecretKey");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
            try {
                DataOutputStream dataOutputStream2 = dataOutputStream;
                dataOutputStream2.writeUTF(wrappedSecretKey.getAlgorithm());
                dataOutputStream2.writeUTF(wrappedSecretKey.getCipherTransformation());
                dataOutputStream2.writeInt(wrappedSecretKey.getWrappedKeyData().length);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(dataOutputStream, null);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream().…m.toByteArray()\n        }");
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(dataOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(byteArrayOutputStream, th3);
                throw th4;
            }
        }
    }

    @Override // com.microsoft.identity.common.crypto.wrappedsecretkey.AbstractWrappedSecretKeySerializer
    protected WrappedSecretKeyMetadata deserializeMetadata(byte[] metadataByteArray) throws IOException {
        Intrinsics.checkNotNullParameter(metadataByteArray, "metadataByteArray");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(metadataByteArray);
        try {
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                DataInputStream dataInputStream2 = dataInputStream;
                String algorithm = dataInputStream2.readUTF();
                String cipherTransformation = dataInputStream2.readUTF();
                int i = dataInputStream2.readInt();
                Intrinsics.checkNotNullExpressionValue(algorithm, "algorithm");
                Intrinsics.checkNotNullExpressionValue(cipherTransformation, "cipherTransformation");
                WrappedSecretKeyMetadata wrappedSecretKeyMetadata = new WrappedSecretKeyMetadata(algorithm, cipherTransformation, i);
                CloseableKt.closeFinally(dataInputStream, null);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return wrappedSecretKeyMetadata;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(dataInputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(byteArrayInputStream, th3);
                throw th4;
            }
        }
    }
}
