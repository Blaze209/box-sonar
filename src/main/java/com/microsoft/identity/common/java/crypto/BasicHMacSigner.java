package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.CryptoObjectName;
import com.microsoft.identity.common.java.opentelemetry.ICryptoOperation;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes14.dex */
public class BasicHMacSigner implements IHMacSigner {
    private final ICryptoFactory mCryptoFactory;

    public BasicHMacSigner(ICryptoFactory iCryptoFactory) {
        this.mCryptoFactory = iCryptoFactory;
    }

    @Override // com.microsoft.identity.common.java.crypto.IHMacSigner
    public byte[] sign(final byte[] bArr, final String str, final byte[] bArr2) throws ClientException {
        if (str == null) {
            throw new NullPointerException("hmacAlgorithm is marked non-null but is null");
        }
        return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Mac, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicHMacSigner.1
            @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
            public byte[] perform() throws ClientException {
                return BasicHMacSigner.this.signWithMac(bArr, str, bArr2);
            }
        });
    }

    public byte[] signWithMac(byte[] bArr, String str, byte[] bArr2) throws ClientException {
        if (str == null) {
            throw new NullPointerException("hmacAlgorithm is marked non-null but is null");
        }
        try {
            Mac mac = this.mCryptoFactory.getMac(str);
            mac.init(new SecretKeySpec(bArr, str));
            return mac.doFinal(bArr2);
        } catch (IllegalStateException e) {
            throw new ClientException(ErrorStrings.ENCRYPTION_ERROR, e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
        }
    }
}
