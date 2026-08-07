package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class PBKDF2 {
    static final long MAX_DERIVED_KEY_LENGTH = 4294967295L;
    public static final int MIN_SALT_LENGTH = 8;
    static final byte[] ZERO_BYTE = {0};

    public static byte[] formatSalt(JWEAlgorithm jWEAlgorithm, byte[] bArr) throws JOSEException {
        byte[] bytes = jWEAlgorithm.toString().getBytes(StandardCharset.UTF_8);
        if (bArr == null) {
            throw new JOSEException("The salt must not be null");
        }
        if (bArr.length < 8) {
            throw new JOSEException("The salt must be at least 8 bytes long");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.write(ZERO_BYTE);
            byteArrayOutputStream.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static SecretKey deriveKey(byte[] bArr, byte[] bArr2, int i, PRFParams pRFParams, Provider provider) throws JOSEException {
        SecretKeyFactory secretKeyFactory;
        if (bArr2 == null) {
            throw new JOSEException("The formatted salt must not be null");
        }
        if (i < 1) {
            throw new JOSEException("The iteration count must be greater than 0");
        }
        PBEKeySpec pBEKeySpec = new PBEKeySpec(new String(bArr, StandardCharsets.UTF_8).toCharArray(), bArr2, i, ByteUtils.bitLength(pRFParams.getDerivedKeyByteLength()));
        try {
            if (provider != null) {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2With" + pRFParams.getMACAlgorithm(), provider);
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2With" + pRFParams.getMACAlgorithm());
            }
            return new SecretKeySpec(secretKeyFactory.generateSecret(pBEKeySpec).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new JOSEException(e.getLocalizedMessage(), e);
        }
    }

    static byte[] extractBlock(byte[] bArr, int i, int i2, Mac mac) throws JOSEException {
        if (bArr == null) {
            throw new JOSEException("The formatted salt must not be null");
        }
        if (i < 1) {
            throw new JOSEException("The iteration count must be greater than 0");
        }
        byte[] bArrDoFinal = null;
        byte[] bArrDoFinal2 = null;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 == 1) {
                bArrDoFinal = mac.doFinal(ByteUtils.concat(bArr, IntegerUtils.toBytes(i2)));
                bArrDoFinal2 = bArrDoFinal;
            } else {
                bArrDoFinal2 = mac.doFinal(bArrDoFinal2);
                for (int i4 = 0; i4 < bArrDoFinal2.length; i4++) {
                    bArrDoFinal[i4] = (byte) (bArrDoFinal2[i4] ^ bArrDoFinal[i4]);
                }
            }
        }
        return bArrDoFinal;
    }

    private PBKDF2() {
    }
}
