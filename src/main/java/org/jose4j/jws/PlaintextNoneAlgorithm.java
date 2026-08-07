package org.jose4j.jws;

import java.security.Key;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class PlaintextNoneAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private static final String CANNOT_HAVE_KEY_MESSAGE = "JWS Plaintext (alg=none) must not use a key.";

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return true;
    }

    public PlaintextNoneAlgorithm() {
        setAlgorithmIdentifier("none");
        setKeyPersuasion(KeyPersuasion.NONE);
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        validateKey(key);
        return bArr.length == 0;
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        validateKey(key);
        return ByteUtil.EMPTY_BYTES;
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateSigningKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateVerificationKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    private void validateKey(Key key) throws InvalidKeyException {
        if (key != null) {
            throw new InvalidKeyException(CANNOT_HAVE_KEY_MESSAGE);
        }
    }
}
