package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(final RSAPublicKey pubKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        int iBitLength2 = (modulus.bitLength() + 6) / 8;
        if (iBitLength != signature.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(signature);
        if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        emsaPssVerify(data, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
    }

    private void emsaPssVerify(byte[] m, byte[] em, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(m);
        int digestLength = engineFactory.getDigestLength();
        int length = em.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        byte b = 1;
        if (em[em.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i = length - digestLength;
        int i2 = i - 1;
        byte[] bArrCopyOf = Arrays.copyOf(em, i2);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(em, bArrCopyOf.length, bArrCopyOf.length + digestLength);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            byte b2 = b;
            int i5 = i2;
            long j = (((long) length) * 8) - ((long) emBits);
            if (i3 < j) {
                if (((bArrCopyOf[i4 / 8] >> (7 - (i4 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i3 = i4 + 1;
                b = b2;
                i2 = i5;
            } else {
                byte[] bArrMgf1 = SubtleUtil.mgf1(bArrCopyOfRange, i5, this.mgf1Hash);
                int length2 = bArrMgf1.length;
                byte[] bArr = new byte[length2];
                for (int i6 = 0; i6 < length2; i6++) {
                    bArr[i6] = (byte) (bArrMgf1[i6] ^ bArrCopyOf[i6]);
                }
                for (int i7 = 0; i7 <= j; i7++) {
                    int i8 = i7 / 8;
                    bArr[i8] = (byte) ((~(b2 << (7 - (i7 % 8)))) & bArr[i8]);
                }
                int i9 = 0;
                while (true) {
                    int i10 = this.saltLength;
                    if (i9 < (i - i10) - 2) {
                        if (bArr[i9] != 0) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        i9++;
                    } else {
                        if (bArr[(i - i10) - 2] != b2) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, length2 - i10, length2);
                        int i11 = digestLength + 8;
                        byte[] bArr2 = new byte[this.saltLength + i11];
                        System.arraycopy(bArrDigest, 0, bArr2, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr2, i11, bArrCopyOfRange2.length);
                        if (!Bytes.equal(engineFactory.digest(bArr2), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                }
            }
        }
    }
}
