package com.microsoft.identity.common.java.crypto;

import com.google.common.base.Ascii;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.CryptoFactoryTelemetryHelper;
import com.microsoft.identity.common.java.opentelemetry.CryptoObjectName;
import com.microsoft.identity.common.java.opentelemetry.ICryptoOperation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes14.dex */
public class SP800108KeyGen {
    static final byte[] BIG_ENDIAN_INT_256 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(256).array();
    private static final String HMAC_ALGORITHM = "HMacSHA256";
    private final ICryptoFactory mCryptoFactory;

    public SP800108KeyGen(ICryptoFactory iCryptoFactory) {
        this.mCryptoFactory = iCryptoFactory;
    }

    public byte[] generateDerivedKey(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, IOException, InvalidKeyException, ClientException {
        return generateDerivedKey(new SecretKeySpec(bArr, HMAC_ALGORITHM), bArr2, bArr3);
    }

    public byte[] generateDerivedKey(final SecretKey secretKey, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, IOException, InvalidKeyException, ClientException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(bArr2);
        byteArrayOutputStream.write(BIG_ENDIAN_INT_256);
        return Arrays.copyOf((byte[]) CryptoFactoryTelemetryHelper.performCryptoOperationAndUploadTelemetry(CryptoObjectName.Mac, HMAC_ALGORITHM, this.mCryptoFactory, new ICryptoOperation<byte[]>() { // from class: com.microsoft.identity.common.java.crypto.SP800108KeyGen.1
            @Override // com.microsoft.identity.common.java.opentelemetry.ICryptoOperation
            public byte[] perform() throws ClientException {
                try {
                    return SP800108KeyGen.this.constructNewKey(secretKey, byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    throw new ClientException("io_error", e.getMessage(), e);
                } catch (InvalidKeyException e2) {
                    throw new ClientException(ClientException.INVALID_KEY, e2.getMessage(), e2);
                }
            }
        }), 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] constructNewKey(SecretKey secretKey, byte[] bArr) throws IOException, InvalidKeyException, ClientException {
        byte[] bArr2 = new byte[32];
        Mac mac = this.mCryptoFactory.getMac(HMAC_ALGORITHM);
        byte[] bArrUpdateDataInput = updateDataInput((byte) 1, bArr);
        mac.init(secretKey);
        mac.update(bArrUpdateDataInput);
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, 32);
        mac.reset();
        return bArr2;
    }

    private static byte[] updateDataInput(byte b, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 4);
        byteArrayOutputStream.write(b >>> Ascii.CAN);
        byteArrayOutputStream.write(b >>> Ascii.DLE);
        byteArrayOutputStream.write(b >>> 8);
        byteArrayOutputStream.write(b);
        byteArrayOutputStream.write(bArr);
        return byteArrayOutputStream.toByteArray();
    }
}
