package org.jose4j.jws;

import com.yubico.yubikit.core.fido.CtapException;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import org.jose4j.jca.ProviderContext;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class EcdsaUsingShaAlgorithm extends BaseSignatureAlgorithm implements JsonWebSignatureAlgorithm {
    private String curveName;
    private int signatureByteLength;

    public EcdsaUsingShaAlgorithm(String str, String str2, String str3, int i) {
        super(str, str2, "EC");
        this.curveName = str3;
        this.signatureByteLength = i;
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm, org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        try {
            return super.verifySignature(convertConcatenatedToDer(bArr), key, bArr2, providerContext);
        } catch (IOException e) {
            throw new JoseException("Unable to convert R and S as a concatenated byte array to DER encoding.", e);
        }
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm, org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        try {
            return convertDerToConcatenated(super.sign(key, bArr, providerContext), this.signatureByteLength);
        } catch (IOException e) {
            throw new JoseException("Unable to convert DER encoding to R and S as a concatenated byte array.", e);
        }
    }

    public static byte[] convertConcatenatedToDer(byte[] bArr) throws IOException {
        byte[] bArr2;
        int length = bArr.length / 2;
        int i = length;
        while (i > 0 && bArr[length - i] == 0) {
            i--;
        }
        int i2 = length - i;
        int i3 = bArr[i2] < 0 ? i + 1 : i;
        int i4 = length;
        while (i4 > 0 && bArr[(length * 2) - i4] == 0) {
            i4--;
        }
        int i5 = (length * 2) - i4;
        int i6 = bArr[i5] < 0 ? i4 + 1 : i4;
        int i7 = i3 + 4 + i6;
        if (i7 > 255) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        int i8 = 1;
        if (i7 < 128) {
            bArr2 = new byte[i3 + 6 + i6];
        } else {
            bArr2 = new byte[i3 + 7 + i6];
            bArr2[1] = -127;
            i8 = 2;
        }
        bArr2[0] = CtapException.ERR_NOT_ALLOWED;
        bArr2[i8] = (byte) i7;
        bArr2[i8 + 1] = 2;
        bArr2[i8 + 2] = (byte) i3;
        int i9 = i8 + 3 + i3;
        System.arraycopy(bArr, i2, bArr2, i9 - i, i);
        bArr2[i9] = 2;
        bArr2[i9 + 1] = (byte) i6;
        System.arraycopy(bArr, i5, bArr2, ((i9 + 2) + i6) - i4, i4);
        return bArr2;
    }

    public static byte[] convertDerToConcatenated(byte[] bArr, int i) throws IOException {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b = bArr[1];
        if (b > 0) {
            i2 = 2;
        } else {
            if (b != -127) {
                throw new IOException("Invalid format of ECDSA signature");
            }
            i2 = 3;
        }
        int i3 = bArr[i2 + 1];
        int i4 = i3;
        while (i4 > 0 && bArr[((i2 + 2) + i3) - i4] == 0) {
            i4--;
        }
        int i5 = i2 + 2 + i3;
        int i6 = bArr[i5 + 1];
        int i7 = i6;
        while (i7 > 0 && bArr[((i5 + 2) + i6) - i7] == 0) {
            i7--;
        }
        int iMax = Math.max(Math.max(i4, i7), i / 2);
        int i8 = bArr[i2 - 1];
        if ((i8 & 255) != bArr.length - i2 || (i8 & 255) != i3 + 4 + i6 || bArr[i2] != 2 || bArr[i5] != 2) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        int i9 = iMax * 2;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i5 - i4, bArr2, iMax - i4, i4);
        System.arraycopy(bArr, ((i5 + 2) + i6) - i7, bArr2, i9 - i7, i7);
        return bArr2;
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm
    public void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        validateKeySpec(privateKey);
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm
    public void validatePublicKey(PublicKey publicKey) throws InvalidKeyException {
        validateKeySpec(publicKey);
    }

    private void validateKeySpec(Key key) throws InvalidKeyException {
        if (key instanceof ECKey) {
            String name = EllipticCurves.getName(((ECKey) key).getParams().getCurve());
            if (!getCurveName().equals(name)) {
                throw new InvalidKeyException(getAlgorithmIdentifier() + "/" + getJavaAlgorithm() + " expects a key using " + getCurveName() + " but was " + name);
            }
        }
    }

    public String getCurveName() {
        return this.curveName;
    }

    public static class EcdsaP256UsingSha256 extends EcdsaUsingShaAlgorithm {
        public EcdsaP256UsingSha256() {
            super(AlgorithmIdentifiers.ECDSA_USING_P256_CURVE_AND_SHA256, "SHA256withECDSA", EllipticCurves.P_256, 64);
        }
    }

    public static class EcdsaP384UsingSha384 extends EcdsaUsingShaAlgorithm {
        public EcdsaP384UsingSha384() {
            super(AlgorithmIdentifiers.ECDSA_USING_P384_CURVE_AND_SHA384, "SHA384withECDSA", EllipticCurves.P_384, 96);
        }
    }

    public static class EcdsaP521UsingSha512 extends EcdsaUsingShaAlgorithm {
        public EcdsaP521UsingSha512() {
            super(AlgorithmIdentifiers.ECDSA_USING_P521_CURVE_AND_SHA512, "SHA512withECDSA", EllipticCurves.P_521, Token.TARGET);
        }
    }
}
