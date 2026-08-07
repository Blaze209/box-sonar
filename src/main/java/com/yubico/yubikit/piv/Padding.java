package com.yubico.yubikit.piv;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class Padding {
    private static final String RAW_RSA = "RSA/ECB/NoPadding";
    private static final Pattern ECDSA_HASH_PATTERN = Pattern.compile("^(.+)withECDSA$", 2);
    private static final Pattern SHA_PATTERN = Pattern.compile("^SHA[0-9]+$", 2);

    Padding() {
    }

    static byte[] pad(KeyType keyType, byte[] bArr, Signature signature) throws NoSuchAlgorithmException {
        KeyType.KeyParams keyParams = keyType.params;
        int i = AnonymousClass1.$SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[keyParams.algorithm.ordinal()];
        if (i == 1) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(keyParams.algorithm.name());
            keyPairGenerator.initialize(keyParams.bitLength);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            try {
                signature.initSign(keyPairGenerateKeyPair.getPrivate());
                signature.update(bArr);
                Cipher cipher = Cipher.getInstance(RAW_RSA);
                cipher.init(1, keyPairGenerateKeyPair.getPublic());
                return cipher.doFinal(signature.sign());
            } catch (InvalidKeyException | SignatureException | BadPaddingException | IllegalBlockSizeException e) {
                throw new IllegalStateException(e);
            } catch (NoSuchPaddingException e2) {
                throw new UnsupportedOperationException("SecurityProvider doesn't support RSA without padding", e2);
            }
        }
        if (i == 2) {
            Matcher matcher = ECDSA_HASH_PATTERN.matcher(signature.getAlgorithm());
            if (!matcher.find()) {
                throw new IllegalArgumentException("Invalid algorithm for given key");
            }
            String strGroup = matcher.group(1);
            if (!"NONE".equals(strGroup)) {
                if (SHA_PATTERN.matcher(strGroup).matches()) {
                    strGroup = strGroup.replace("SHA", "SHA-");
                }
                bArr = MessageDigest.getInstance(strGroup).digest(bArr);
            }
            int i2 = keyParams.bitLength / 8;
            if (bArr.length > i2) {
                return Arrays.copyOf(bArr, i2);
            }
            if (bArr.length >= i2) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, i2 - bArr.length, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: com.yubico.yubikit.piv.Padding$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm;

        static {
            int[] iArr = new int[KeyType.Algorithm.values().length];
            $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm = iArr;
            try {
                iArr[KeyType.Algorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[KeyType.Algorithm.EC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static byte[] unpad(byte[] bArr, Cipher cipher) throws BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher2 = Cipher.getInstance(RAW_RSA);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyType.Algorithm.RSA.name());
        keyPairGenerator.initialize(bArr.length * 8);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        try {
            cipher2.init(1, keyPairGenerateKeyPair.getPublic());
            cipher.init(2, keyPairGenerateKeyPair.getPrivate());
            return cipher.doFinal(cipher2.doFinal(bArr));
        } catch (InvalidKeyException | IllegalBlockSizeException e) {
            throw new IllegalStateException(e);
        }
    }
}
