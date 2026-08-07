package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes3.dex */
public class PivKeyAgreementSpi extends KeyAgreementSpi {

    @Nullable
    private PivPrivateKey.EcKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    @Nullable
    private ECPoint publicPoint;

    PivKeyAgreementSpi(Callback<Callback<Result<PivSession, Exception>>> callback) {
        this.provider = callback;
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof PivPrivateKey.EcKey) {
            this.privateKey = (PivPrivateKey.EcKey) key;
            return;
        }
        throw new InvalidKeyException("Key must be instance of PivPrivateKey");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        engineInit(key, secureRandom);
    }

    @Override // javax.crypto.KeyAgreementSpi
    @Nullable
    protected Key engineDoPhase(Key key, boolean z) throws IllegalStateException, InvalidKeyException {
        PivPrivateKey.EcKey ecKey = this.privateKey;
        if (ecKey == null) {
            throw new IllegalStateException("KeyAgreement not initialized");
        }
        if (!z) {
            throw new IllegalStateException("Multiple phases not supported");
        }
        if (key instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (ecKey.getParams().getCurve().equals(eCPublicKey.getParams().getCurve())) {
                this.publicPoint = eCPublicKey.getW();
                return null;
            }
        }
        throw new InvalidKeyException("Wrong key type");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected byte[] engineGenerateSecret() throws IllegalStateException {
        ECPoint eCPoint;
        PivPrivateKey.EcKey ecKey = this.privateKey;
        if (ecKey != null && (eCPoint = this.publicPoint) != null) {
            try {
                try {
                    byte[] bArrKeyAgreement = ecKey.keyAgreement(this.provider, eCPoint);
                    this.publicPoint = null;
                    return bArrKeyAgreement;
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            } catch (Throwable th) {
                this.publicPoint = null;
                throw th;
            }
        }
        throw new IllegalStateException("Not initialized with both private and public keys");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        try {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        } catch (IndexOutOfBoundsException unused) {
            throw new ShortBufferException();
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected SecretKey engineGenerateSecret(String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        throw new IllegalStateException("Not supported");
    }
}
