package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
abstract class PivKeyPairGeneratorSpi extends KeyPairGeneratorSpi {
    private final KeyType.Algorithm algorithm;
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    @Nullable
    PivAlgorithmParameterSpec spec;

    PivKeyPairGeneratorSpi(Callback<Callback<Result<PivSession, Exception>>> callback, KeyType.Algorithm algorithm) {
        this.provider = callback;
        this.algorithm = algorithm;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof PivAlgorithmParameterSpec) {
            PivAlgorithmParameterSpec pivAlgorithmParameterSpec = (PivAlgorithmParameterSpec) algorithmParameterSpec;
            this.spec = pivAlgorithmParameterSpec;
            if (pivAlgorithmParameterSpec.keyType.params.algorithm != this.algorithm) {
                throw new InvalidAlgorithmParameterException("Invalid key algorithm for this KeyPairGenerator");
            }
            return;
        }
        throw new InvalidAlgorithmParameterException("Must be instance of PivAlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("Initialize with PivAlgorithmParameterSpec!");
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.spec == null) {
            throw new IllegalStateException("KeyPairGenerator not initialized!");
        }
        try {
            final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            this.provider.invoke(new Callback() { // from class: com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi$$ExternalSyntheticLambda1
                @Override // com.yubico.yubikit.core.util.Callback
                public final void invoke(Object obj) {
                    this.f$0.m14421xa21aac86(arrayBlockingQueue, (Result) obj);
                }
            });
            return (KeyPair) ((Result) arrayBlockingQueue.take()).getValue();
        } catch (Exception e) {
            throw new IllegalStateException("An error occurred when generating the key pair", e);
        }
    }

    /* JADX INFO: renamed from: lambda$generateKeyPair$1$com-yubico-yubikit-piv-jca-PivKeyPairGeneratorSpi, reason: not valid java name */
    /* synthetic */ void m14421xa21aac86(BlockingQueue blockingQueue, final Result result) {
        blockingQueue.add(Result.of(new Callable() { // from class: com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m14420x5e8f8ec5(result);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$generateKeyPair$0$com-yubico-yubikit-piv-jca-PivKeyPairGeneratorSpi, reason: not valid java name */
    /* synthetic */ KeyPair m14420x5e8f8ec5(Result result) throws Exception {
        PublicKey publicKeyGenerateKey = ((PivSession) result.getValue()).generateKey(this.spec.slot, this.spec.keyType, this.spec.pinPolicy, this.spec.touchPolicy);
        return new KeyPair(publicKeyGenerateKey, PivPrivateKey.from(publicKeyGenerateKey, this.spec.slot, this.spec.pinPolicy, this.spec.touchPolicy, this.spec.pin));
    }

    public static class Rsa extends PivKeyPairGeneratorSpi {
        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ KeyPair generateKeyPair() {
            return super.generateKeyPair();
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(int i, SecureRandom secureRandom) {
            super.initialize(i, secureRandom);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            super.initialize(algorithmParameterSpec, secureRandom);
        }

        Rsa(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback, KeyType.Algorithm.RSA);
        }
    }

    public static class Ec extends PivKeyPairGeneratorSpi {
        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ KeyPair generateKeyPair() {
            return super.generateKeyPair();
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(int i, SecureRandom secureRandom) {
            super.initialize(i, secureRandom);
        }

        @Override // com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi, java.security.KeyPairGeneratorSpi
        public /* bridge */ /* synthetic */ void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            super.initialize(algorithmParameterSpec, secureRandom);
        }

        Ec(Callback<Callback<Result<PivSession, Exception>>> callback) {
            super(callback, KeyType.Algorithm.EC);
        }
    }
}
