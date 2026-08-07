package org.jose4j.jws;

import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes5.dex */
public class HmacUsingShaAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private int minimumKeyLength;

    public HmacUsingShaAlgorithm(String str, String str2, int i) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm(str2);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        this.minimumKeyLength = i;
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException(key.getClass() + " cannot be used for HMAC verification.");
        }
        return ByteUtil.secureEquals(bArr, getMacInstance(key, providerContext).doFinal(bArr2));
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        return getMacInstance(key, providerContext).doFinal(bArr);
    }

    private Mac getMacInstance(Key key, ProviderContext providerContext) throws JoseException {
        return MacUtil.getInitializedMac(getJavaAlgorithm(), key, providerContext.getSuppliedKeyProviderContext().getMacProvider());
    }

    void validateKey(Key key) throws InvalidKeyException {
        int iBitLength;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key.getEncoded() != null && (iBitLength = ByteUtil.bitLength(key.getEncoded())) < this.minimumKeyLength) {
            throw new InvalidKeyException("A key of the same size as the hash output (i.e. " + this.minimumKeyLength + " bits for " + getAlgorithmIdentifier() + ") or larger MUST be used with the HMAC SHA algorithms but this key is only " + iBitLength + " bits");
        }
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateSigningKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateVerificationKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return AlgorithmAvailability.isAvailable("Mac", getJavaAlgorithm());
    }

    public static class HmacSha256 extends HmacUsingShaAlgorithm {
        public HmacSha256() {
            super("HS256", "HmacSHA256", 256);
        }
    }

    public static class HmacSha384 extends HmacUsingShaAlgorithm {
        public HmacSha384() {
            super(AlgorithmIdentifiers.HMAC_SHA384, MacUtil.HMAC_SHA384, 384);
        }
    }

    public static class HmacSha512 extends HmacUsingShaAlgorithm {
        public HmacSha512() {
            super(AlgorithmIdentifiers.HMAC_SHA512, MacUtil.HMAC_SHA512, 512);
        }
    }
}
