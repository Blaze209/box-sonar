package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class PivCipherSpi extends CipherSpi {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivCipherSpi.class);
    private final Map<KeyType, KeyPair> dummyKeys;

    @Nullable
    private String mode;

    @Nullable
    private String padding;

    @Nullable
    private PivPrivateKey privateKey;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private int opmode = -1;

    @Override // javax.crypto.CipherSpi
    @Nullable
    protected AlgorithmParameters engineGetParameters() {
        return null;
    }

    PivCipherSpi(Callback<Callback<Result<PivSession, Exception>>> callback, Map<KeyType, KeyPair> map) throws NoSuchPaddingException {
        this.provider = callback;
        this.dummyKeys = map;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetMode(String str) throws NoSuchAlgorithmException {
        this.mode = str;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetPadding(String str) throws NoSuchPaddingException {
        this.padding = str;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        PivPrivateKey pivPrivateKey = this.privateKey;
        if (pivPrivateKey == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        return pivPrivateKey.keyType.params.bitLength / 8;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetOutputSize(int i) {
        return engineGetBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Engine init: mode={} padding={}", this.mode, this.padding);
        if (key instanceof PivPrivateKey) {
            if (!KeyType.Algorithm.RSA.name().equals(key.getAlgorithm())) {
                throw new InvalidKeyException("Cipher only supports RSA.");
            }
            this.privateKey = (PivPrivateKey) key;
            this.opmode = i;
            this.buffer.reset();
            return;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, @Nullable AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("Cipher must be initialized with params = null");
        }
        engineInit(i, key, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, @Nullable AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters != null) {
            throw new InvalidAlgorithmParameterException("Cipher must be initialized with params = null");
        }
        engineInit(i, key, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return new byte[0];
    }

    @Override // javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        if (this.privateKey == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        if (i2 > 0) {
            this.buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.buffer.toByteArray();
        try {
            KeyPair keyPair = this.dummyKeys.get(this.privateKey.keyType);
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(this.opmode, keyPair.getPublic());
            Cipher cipher2 = Cipher.getInstance("RSA/" + this.mode + "/" + this.padding);
            cipher2.init(this.opmode, keyPair.getPrivate());
            int i3 = this.opmode;
            if (i3 != 1) {
                if (i3 == 2) {
                    return cipher2.doFinal(cipher.doFinal(this.privateKey.rawSignOrDecrypt(this.provider, byteArray)));
                }
                throw new UnsupportedOperationException();
            }
            try {
                return this.privateKey.rawSignOrDecrypt(this.provider, cipher.doFinal(cipher2.doFinal(byteArray)));
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new IllegalStateException(e);
            }
        } catch (NoSuchPaddingException e2) {
            throw new UnsupportedOperationException("SecurityProvider doesn't support RSA without padding", e2);
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        try {
            System.arraycopy(bArrEngineDoFinal, 0, bArr2, i3, bArrEngineDoFinal.length);
            return bArrEngineDoFinal.length;
        } catch (IndexOutOfBoundsException unused) {
            throw new ShortBufferException();
        }
    }
}
