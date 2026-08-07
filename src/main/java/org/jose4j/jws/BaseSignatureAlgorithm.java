package org.jose4j.jws;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseSignatureAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private AlgorithmParameterSpec algorithmParameterSpec;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public abstract void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException;

    public abstract void validatePublicKey(PublicKey publicKey) throws InvalidKeyException;

    public BaseSignatureAlgorithm(String str, String str2, String str3) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm(str2);
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
        setKeyType(str3);
    }

    protected void setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        this.algorithmParameterSpec = algorithmParameterSpec;
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        Signature signature = getSignature(providerContext);
        initForVerify(signature, key);
        try {
            signature.update(bArr2);
            return signature.verify(bArr);
        } catch (SignatureException e) {
            if (!this.log.isDebugEnabled()) {
                return false;
            }
            this.log.debug("Problem verifying signature: " + e);
            return false;
        }
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        Signature signature = getSignature(providerContext);
        initForSign(signature, key, providerContext);
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (SignatureException e) {
            throw new JoseException("Problem creating signature.", e);
        }
    }

    private void initForSign(Signature signature, Key key, ProviderContext providerContext) throws InvalidKeyException {
        try {
            PrivateKey privateKey = (PrivateKey) key;
            SecureRandom secureRandom = providerContext.getSecureRandom();
            if (secureRandom == null) {
                signature.initSign(privateKey);
            } else {
                signature.initSign(privateKey, secureRandom);
            }
        } catch (java.security.InvalidKeyException e) {
            throw new InvalidKeyException(getBadKeyMessage(key) + "for " + getJavaAlgorithm(), e);
        }
    }

    private void initForVerify(Signature signature, Key key) throws InvalidKeyException {
        try {
            signature.initVerify((PublicKey) key);
        } catch (java.security.InvalidKeyException e) {
            throw new InvalidKeyException(getBadKeyMessage(key) + "for " + getJavaAlgorithm(), e);
        }
    }

    private String getBadKeyMessage(Key key) {
        return "The given key (" + (key == null ? "key is null" : "algorithm=" + key.getAlgorithm()) + ") is not valid ";
    }

    private Signature getSignature(ProviderContext providerContext) throws JoseException {
        String signatureProvider = providerContext.getSuppliedKeyProviderContext().getSignatureProvider();
        String javaAlgorithm = getJavaAlgorithm();
        try {
            Signature signature = signatureProvider == null ? Signature.getInstance(javaAlgorithm) : Signature.getInstance(javaAlgorithm, signatureProvider);
            AlgorithmParameterSpec algorithmParameterSpec = this.algorithmParameterSpec;
            if (algorithmParameterSpec != null) {
                try {
                    signature.setParameter(algorithmParameterSpec);
                    return signature;
                } catch (UnsupportedOperationException e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Unable to set algorithm parameter spec on Signature (java algorithm name: " + javaAlgorithm + ") so ignoring the UnsupportedOperationException and relying on the default parameters.", (Throwable) e);
                    }
                    return signature;
                }
            }
            return signature;
        } catch (InvalidAlgorithmParameterException e2) {
            throw new JoseException("Invalid algorithm parameter (" + this.algorithmParameterSpec + ") for: " + javaAlgorithm, e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new JoseException("Unable to get an implementation of algorithm name: " + javaAlgorithm, e3);
        } catch (NoSuchProviderException e4) {
            throw new JoseException("Unable to get an implementation of " + javaAlgorithm + " for provider " + signatureProvider, e4);
        }
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateSigningKey(Key key) throws InvalidKeyException {
        checkForNullKey(key);
        try {
            validatePrivateKey((PrivateKey) key);
        } catch (ClassCastException e) {
            throw new InvalidKeyException(getBadKeyMessage(key) + "(not a private key or is the wrong type of key) for " + getJavaAlgorithm() + " / " + getAlgorithmIdentifier() + " " + e);
        }
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateVerificationKey(Key key) throws InvalidKeyException {
        checkForNullKey(key);
        try {
            validatePublicKey((PublicKey) key);
        } catch (ClassCastException e) {
            throw new InvalidKeyException(getBadKeyMessage(key) + "(not a public key or is the wrong type of key) for " + getJavaAlgorithm() + "/" + getAlgorithmIdentifier() + " " + e);
        }
    }

    private void checkForNullKey(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("Key cannot be null");
        }
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        try {
            return getSignature(new ProviderContext()) != null;
        } catch (Exception e) {
            this.log.debug(getAlgorithmIdentifier() + " vai " + getJavaAlgorithm() + " is NOT available from the underlying JCE (" + ExceptionHelp.toStringWithCauses(e) + ").");
            return false;
        }
    }
}
