package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.CryptoObjectName;
import com.microsoft.identity.common.java.opentelemetry.ICryptoOperation;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes14.dex */
public class BasicEncryptor implements IEncryptor {
    private final ICryptoFactory mCryptoFactory;

    public BasicEncryptor(ICryptoFactory iCryptoFactory) {
        this.mCryptoFactory = iCryptoFactory;
    }

    @Override // com.microsoft.identity.common.java.crypto.IEncryptor
    public byte[] encryptWithIv(final Key key, final String str, final byte[] bArr, final byte[] bArr2) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("encryptAlgorithm is marked non-null but is null");
        }
        return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Cipher, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicEncryptor.1
            @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
            public byte[] perform() throws ClientException {
                return BasicEncryptor.this.encryptWithIvInternal(key, str, bArr, bArr2);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.crypto.IEncryptor
    public byte[] encryptWithGcm(final Key key, final String str, final byte[] bArr, final byte[] bArr2, final int i, final byte[] bArr3) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("encryptAlgorithm is marked non-null but is null");
        }
        return (byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Cipher, str, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.BasicEncryptor.2
            @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
            public byte[] perform() throws ClientException {
                return BasicEncryptor.this.encryptWithGcmInternal(key, str, bArr, bArr2, i, bArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0019 A[Catch: InvalidAlgorithmParameterException -> 0x0021, InvalidKeyException -> 0x002e, IllegalBlockSizeException -> 0x003b, BadPaddingException -> 0x0048, TryCatch #2 {InvalidAlgorithmParameterException -> 0x0021, InvalidKeyException -> 0x002e, BadPaddingException -> 0x0048, IllegalBlockSizeException -> 0x003b, blocks: (B:6:0x000d, B:8:0x0010, B:10:0x001c, B:9:0x0019), top: B:28:0x000d }] */
    public byte[] encryptWithIvInternal(Key key, String str, byte[] bArr, byte[] bArr2) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("encryptAlgorithm is marked non-null but is null");
        }
        Cipher cipher = this.mCryptoFactory.getCipher(str);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    cipher.init(1, key, new IvParameterSpec(bArr));
                } else {
                    cipher.init(1, key);
                }
            } catch (InvalidAlgorithmParameterException e) {
                throw new ClientException(ClientException.INVALID_ALG_PARAMETER, e.getMessage(), e);
            } catch (InvalidKeyException e2) {
                throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
            } catch (BadPaddingException e3) {
                throw new ClientException(ClientException.BAD_PADDING, e3.getMessage(), e3);
            } catch (IllegalBlockSizeException e4) {
                throw new ClientException(ClientException.INVALID_BLOCK_SIZE, e4.getMessage(), e4);
            }
        } else {
            cipher.init(1, key);
        }
        return cipher.doFinal(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] encryptWithGcmInternal(Key key, String str, byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws ClientException {
        if (key == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("encryptAlgorithm is marked non-null but is null");
        }
        Cipher cipher = this.mCryptoFactory.getCipher(str);
        try {
            cipher.init(1, key, new GCMParameterSpec(i * 8, bArr));
            if (bArr3 != null) {
                cipher.updateAAD(bArr3);
            }
            return cipher.doFinal(bArr2);
        } catch (InvalidAlgorithmParameterException e) {
            throw new ClientException(ClientException.INVALID_ALG_PARAMETER, e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new ClientException(ClientException.BAD_PADDING, e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e4) {
            throw new ClientException(ClientException.INVALID_BLOCK_SIZE, e4.getMessage(), e4);
        }
    }
}
