package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes3.dex */
public class PivRsaSignatureSpi extends SignatureSpi {

    @Nullable
    private Signature delegate;
    private final Map<KeyType, KeyPair> dummyKeys;

    @Nullable
    private PivPrivateKey.RsaKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;
    private final String signature;

    PivRsaSignatureSpi(Callback<Callback<Result<PivSession, Exception>>> callback, Map<KeyType, KeyPair> map, String str) throws NoSuchPaddingException {
        this.provider = callback;
        this.dummyKeys = map;
        this.signature = str;
    }

    private Signature getDelegate(boolean z) throws NoSuchAlgorithmException {
        if (this.delegate == null) {
            Signature signature = Signature.getInstance(this.signature);
            this.delegate = signature;
            if (z) {
                try {
                    signature.initSign(this.dummyKeys.get(KeyType.RSA2048).getPrivate());
                } catch (InvalidKeyException unused) {
                    throw new NoSuchAlgorithmException();
                }
            }
        }
        return this.delegate;
    }

    @Override // java.security.SignatureSpi
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        throw new InvalidKeyException("Can only be used for signing.");
    }

    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof PivPrivateKey.RsaKey) {
            PivPrivateKey.RsaKey rsaKey = (PivPrivateKey.RsaKey) privateKey;
            this.privateKey = rsaKey;
            try {
                getDelegate(false).initSign(this.dummyKeys.get(rsaKey.keyType).getPrivate());
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new InvalidKeyException(e);
            }
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte b) throws SignatureException {
        Signature signature = this.delegate;
        if (signature != null) {
            signature.update(b);
            return;
        }
        throw new SignatureException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        Signature signature = this.delegate;
        if (signature != null) {
            signature.update(bArr, i, i2);
            return;
        }
        throw new SignatureException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected byte[] engineSign() throws SignatureException {
        if (this.privateKey == null || this.delegate == null) {
            throw new SignatureException("Not initialized");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(1, this.dummyKeys.get(this.privateKey.keyType).getPublic());
            return this.privateKey.rawSignOrDecrypt(this.provider, cipher.doFinal(this.delegate.sign()));
        } catch (Exception e) {
            throw new SignatureException(e);
        }
    }

    @Override // java.security.SignatureSpi
    protected boolean engineVerify(byte[] bArr) throws SignatureException {
        throw new SignatureException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected void engineSetParameter(String str, Object obj) throws InvalidParameterException {
        try {
            getDelegate(true).setParameter(str, obj);
        } catch (NoSuchAlgorithmException unused) {
            throw new InvalidParameterException("Not initialized");
        }
    }

    @Override // java.security.SignatureSpi
    protected Object engineGetParameter(String str) throws InvalidParameterException {
        Signature signature = this.delegate;
        if (signature != null) {
            return signature.getParameter(str);
        }
        throw new InvalidParameterException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        try {
            getDelegate(true).setParameter(algorithmParameterSpec);
        } catch (NoSuchAlgorithmException unused) {
            throw new InvalidParameterException("Not initialized");
        }
    }

    @Override // java.security.SignatureSpi
    protected AlgorithmParameters engineGetParameters() {
        Signature signature = this.delegate;
        if (signature != null) {
            return signature.getParameters();
        }
        throw new InvalidParameterException("Not initialized");
    }
}
