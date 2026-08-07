package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import com.nimbusds.jose.util.KeyUtils;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import org.jose4j.jwe.SimpleAeadCipher;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class AESGCM {
    public static final int AUTH_TAG_BIT_LENGTH = 128;
    public static final int IV_BIT_LENGTH = 96;

    public static byte[] generateIV(SecureRandom secureRandom) {
        byte[] bArr = new byte[12];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static AuthenticatedCipherText encrypt(SecretKey secretKey, Container<byte[]> container, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        Cipher cipher;
        SecretKey aESKey = KeyUtils.toAESKey(secretKey);
        byte[] bArr3 = container.get();
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(SimpleAeadCipher.GCM_TRANSFORMATION_NAME, provider);
            } else {
                cipher = Cipher.getInstance(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
            }
            cipher.init(1, aESKey, new GCMParameterSpec(128, bArr3));
            cipher.updateAAD(bArr2);
            try {
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                int length = bArrDoFinal.length - ByteUtils.byteLength(128);
                byte[] bArrSubArray = ByteUtils.subArray(bArrDoFinal, 0, length);
                byte[] bArrSubArray2 = ByteUtils.subArray(bArrDoFinal, length, ByteUtils.byteLength(128));
                container.set(actualIVOf(cipher));
                return new AuthenticatedCipherText(bArrSubArray, bArrSubArray2);
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new JOSEException("Couldn't encrypt with AES/GCM/NoPadding: " + e.getMessage(), e);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new JOSEException("Couldn't create AES/GCM/NoPadding cipher: " + e2.getMessage(), e2);
        }
    }

    private static byte[] actualIVOf(Cipher cipher) throws JOSEException {
        GCMParameterSpec gCMParameterSpecActualParamsOf = actualParamsOf(cipher);
        byte[] iv = gCMParameterSpecActualParamsOf.getIV();
        validate(iv, gCMParameterSpecActualParamsOf.getTLen());
        return iv;
    }

    private static void validate(byte[] bArr, int i) throws JOSEException {
        if (ByteUtils.safeBitLength(bArr) != 96) {
            throw new JOSEException(String.format("IV length of %d bits is required, got %d", 96, Integer.valueOf(ByteUtils.safeBitLength(bArr))));
        }
        if (i != 128) {
            throw new JOSEException(String.format("Authentication tag length of %d bits is required, got %d", 128, Integer.valueOf(i)));
        }
    }

    private static GCMParameterSpec actualParamsOf(Cipher cipher) throws JOSEException {
        AlgorithmParameters parameters = cipher.getParameters();
        if (parameters == null) {
            throw new JOSEException("AES GCM ciphers are expected to make use of algorithm parameters");
        }
        try {
            return (GCMParameterSpec) parameters.getParameterSpec(GCMParameterSpec.class);
        } catch (InvalidParameterSpecException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider) throws JOSEException {
        Cipher cipher;
        SecretKey aESKey = KeyUtils.toAESKey(secretKey);
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(SimpleAeadCipher.GCM_TRANSFORMATION_NAME, provider);
            } else {
                cipher = Cipher.getInstance(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
            }
            cipher.init(2, aESKey, new GCMParameterSpec(128, bArr));
            cipher.updateAAD(bArr3);
            try {
                return cipher.doFinal(ByteUtils.concat(bArr2, bArr4));
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new JOSEException("AES/GCM/NoPadding decryption failed: " + e.getMessage(), e);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new JOSEException("Couldn't create AES/GCM/NoPadding cipher: " + e2.getMessage(), e2);
        }
    }

    private AESGCM() {
    }
}
