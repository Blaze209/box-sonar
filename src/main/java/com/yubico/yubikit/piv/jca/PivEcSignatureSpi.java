package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PivEcSignatureSpi extends SignatureSpi {

    @Nullable
    private PivPrivateKey.EcKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    protected abstract byte[] digest();

    protected abstract void update(byte b);

    protected abstract void update(byte[] bArr, int i, int i2);

    protected PivEcSignatureSpi(Callback<Callback<Result<PivSession, Exception>>> callback) {
        this.provider = callback;
    }

    @Override // java.security.SignatureSpi
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        throw new InvalidKeyException("Can only be used for signing.");
    }

    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof PivPrivateKey.EcKey) {
            this.privateKey = (PivPrivateKey.EcKey) privateKey;
            return;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte b) throws SignatureException {
        if (this.privateKey != null) {
            update(b);
            return;
        }
        throw new SignatureException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.privateKey != null) {
            update(bArr, i, i2);
            return;
        }
        throw new SignatureException("Not initialized");
    }

    @Override // java.security.SignatureSpi
    protected byte[] engineSign() throws SignatureException {
        PivPrivateKey.EcKey ecKey = this.privateKey;
        if (ecKey == null) {
            throw new SignatureException("Not initialized");
        }
        try {
            return ecKey.rawSignOrDecrypt(this.provider, digest());
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
        throw new InvalidParameterException("ECDSA doesn't take parameters");
    }

    @Override // java.security.SignatureSpi
    protected Object engineGetParameter(String str) throws InvalidParameterException {
        throw new InvalidParameterException("ECDSA doesn't take parameters");
    }

    public static class Prehashed extends PivEcSignatureSpi {
        private final ByteArrayOutputStream buffer;

        Prehashed(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback);
            this.buffer = new ByteArrayOutputStream();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi, java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            super.engineInitSign(privateKey);
            this.buffer.reset();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected void update(byte b) {
            this.buffer.write(b);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected void update(byte[] bArr, int i, int i2) {
            this.buffer.write(bArr, i, i2);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected byte[] digest() {
            return this.buffer.toByteArray();
        }
    }

    public static class Hashed extends PivEcSignatureSpi {
        private final MessageDigest digest;

        Hashed(Callback<Callback<Result<PivSession, Exception>>> callback, String str) throws NoSuchAlgorithmException {
            super(callback);
            this.digest = MessageDigest.getInstance(str);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi, java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            super.engineInitSign(privateKey);
            this.digest.reset();
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected void update(byte b) {
            this.digest.update(b);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected void update(byte[] bArr, int i, int i2) {
            this.digest.update(bArr, i, i2);
        }

        @Override // com.yubico.yubikit.piv.jca.PivEcSignatureSpi
        protected byte[] digest() {
            return this.digest.digest();
        }
    }
}
