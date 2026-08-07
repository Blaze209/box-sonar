package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PinPolicy;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.TouchPolicy;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PivPrivateKey implements PrivateKey, Destroyable {
    private boolean destroyed = false;
    final KeyType keyType;

    @Nullable
    protected char[] pin;

    @Nullable
    private final PinPolicy pinPolicy;
    final Slot slot;

    @Nullable
    private final TouchPolicy touchPolicy;

    @Override // java.security.Key
    @Nullable
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    @Nullable
    public String getFormat() {
        return null;
    }

    static PivPrivateKey from(PublicKey publicKey, Slot slot, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, @Nullable char[] cArr) {
        KeyType keyTypeFromKey = KeyType.fromKey(publicKey);
        if (keyTypeFromKey.params.algorithm == KeyType.Algorithm.RSA) {
            return new RsaKey(slot, keyTypeFromKey, pinPolicy, touchPolicy, ((RSAPublicKey) publicKey).getModulus(), cArr);
        }
        return new EcKey(slot, keyTypeFromKey, pinPolicy, touchPolicy, ((ECPublicKey) publicKey).getParams(), cArr);
    }

    protected PivPrivateKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, @Nullable char[] cArr) {
        this.slot = slot;
        this.keyType = keyType;
        this.pinPolicy = pinPolicy;
        this.touchPolicy = touchPolicy;
        this.pin = cArr != null ? Arrays.copyOf(cArr, cArr.length) : null;
    }

    byte[] rawSignOrDecrypt(Callback<Callback<Result<PivSession, Exception>>> callback, final byte[] bArr) throws Exception {
        if (this.destroyed) {
            throw new IllegalStateException("PivPrivateKey has been destroyed");
        }
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        callback.invoke(new Callback() { // from class: com.yubico.yubikit.piv.jca.PivPrivateKey$$ExternalSyntheticLambda1
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                this.f$0.m14423xd46fc12d(arrayBlockingQueue, bArr, (Result) obj);
            }
        });
        return (byte[]) ((Result) arrayBlockingQueue.take()).getValue();
    }

    /* JADX INFO: renamed from: lambda$rawSignOrDecrypt$1$com-yubico-yubikit-piv-jca-PivPrivateKey, reason: not valid java name */
    /* synthetic */ void m14423xd46fc12d(BlockingQueue blockingQueue, final byte[] bArr, final Result result) {
        blockingQueue.add(Result.of(new Callable() { // from class: com.yubico.yubikit.piv.jca.PivPrivateKey$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m14422xcd0a8c0e(result, bArr);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$rawSignOrDecrypt$0$com-yubico-yubikit-piv-jca-PivPrivateKey, reason: not valid java name */
    /* synthetic */ byte[] m14422xcd0a8c0e(Result result, byte[] bArr) throws Exception {
        PivSession pivSession = (PivSession) result.getValue();
        char[] cArr = this.pin;
        if (cArr != null) {
            pivSession.verifyPin(cArr);
        }
        return pivSession.rawSignOrDecrypt(this.slot, this.keyType, bArr);
    }

    public Slot getSlot() {
        return this.slot;
    }

    @Nullable
    public PinPolicy getPinPolicy() {
        return this.pinPolicy;
    }

    @Nullable
    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }

    public void setPin(@Nullable char[] cArr) {
        if (this.destroyed) {
            throw new IllegalStateException("PivPrivateKey has been destroyed");
        }
        char[] cArr2 = this.pin;
        if (cArr2 != null) {
            Arrays.fill(cArr2, (char) 0);
        }
        this.pin = cArr != null ? Arrays.copyOf(cArr, cArr.length) : null;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        char[] cArr = this.pin;
        if (cArr != null) {
            Arrays.fill(cArr, (char) 0);
        }
        this.destroyed = true;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.keyType.params.algorithm.name();
    }

    static class EcKey extends PivPrivateKey implements ECKey {
        private final ECParameterSpec ecSpec;

        private EcKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, ECParameterSpec eCParameterSpec, @Nullable char[] cArr) {
            super(slot, keyType, pinPolicy, touchPolicy, cArr);
            this.ecSpec = eCParameterSpec;
        }

        byte[] keyAgreement(Callback<Callback<Result<PivSession, Exception>>> callback, final ECPoint eCPoint) throws Exception {
            final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            callback.invoke(new Callback() { // from class: com.yubico.yubikit.piv.jca.PivPrivateKey$EcKey$$ExternalSyntheticLambda1
                @Override // com.yubico.yubikit.core.util.Callback
                public final void invoke(Object obj) {
                    this.f$0.m14425x2766404(arrayBlockingQueue, eCPoint, (Result) obj);
                }
            });
            return (byte[]) ((Result) arrayBlockingQueue.take()).getValue();
        }

        /* JADX INFO: renamed from: lambda$keyAgreement$1$com-yubico-yubikit-piv-jca-PivPrivateKey$EcKey, reason: not valid java name */
        /* synthetic */ void m14425x2766404(BlockingQueue blockingQueue, final ECPoint eCPoint, final Result result) {
            blockingQueue.add(Result.of(new Callable() { // from class: com.yubico.yubikit.piv.jca.PivPrivateKey$EcKey$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m14424xc8abc225(result, eCPoint);
                }
            }));
        }

        /* JADX INFO: renamed from: lambda$keyAgreement$0$com-yubico-yubikit-piv-jca-PivPrivateKey$EcKey, reason: not valid java name */
        /* synthetic */ byte[] m14424xc8abc225(Result result, ECPoint eCPoint) throws Exception {
            PivSession pivSession = (PivSession) result.getValue();
            if (this.pin != null) {
                pivSession.verifyPin(this.pin);
            }
            return pivSession.calculateSecret(this.slot, eCPoint);
        }

        @Override // java.security.interfaces.ECKey
        public ECParameterSpec getParams() {
            return this.ecSpec;
        }
    }

    static class RsaKey extends PivPrivateKey implements RSAKey {
        private final BigInteger modulus;

        private RsaKey(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, BigInteger bigInteger, @Nullable char[] cArr) {
            super(slot, keyType, pinPolicy, touchPolicy, cArr);
            this.modulus = bigInteger;
        }

        @Override // java.security.interfaces.RSAKey
        public BigInteger getModulus() {
            return this.modulus;
        }
    }
}
