package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.CryptoObjectName;
import com.microsoft.identity.common.java.opentelemetry.ICryptoOperation;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes14.dex */
public class BasicSigner implements ISigner {
    private final ICryptoFactory mCryptoFactory;

    public BasicSigner(ICryptoFactory iCryptoFactory) {
        this.mCryptoFactory = iCryptoFactory;
    }

    @Override // com.microsoft.identity.common.java.crypto.ISigner
    public byte[] sign(final PrivateKey privateKey, final String str, final byte[] bArr) throws ClientException {
        if (privateKey == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("signingAlgorithm is marked non-null but is null");
        }
        return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Signature, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicSigner.1
            @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
            public byte[] perform() throws ClientException {
                return BasicSigner.this.signWithSignature(privateKey, str, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] signWithSignature(PrivateKey privateKey, String str, byte[] bArr) throws ClientException {
        if (privateKey == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("signingAlgorithm is marked non-null but is null");
        }
        try {
            Signature signature = this.mCryptoFactory.getSignature(str);
            signature.initSign(privateKey);
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e) {
            throw new ClientException(ClientException.INVALID_KEY, e.getMessage(), e);
        } catch (SignatureException e2) {
            throw new ClientException(ClientException.SIGNING_FAILURE, e2.getMessage(), e2);
        }
    }
}
