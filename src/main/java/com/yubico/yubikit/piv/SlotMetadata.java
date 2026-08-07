package com.yubico.yubikit.piv;

import com.yubico.yubikit.core.keys.PublicKeyValues;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class SlotMetadata {
    private final boolean generated;
    private final KeyType keyType;
    private final PinPolicy pinPolicy;
    private final byte[] publicKeyEncoded;
    private final TouchPolicy touchPolicy;

    public SlotMetadata(KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy, boolean z, byte[] bArr) {
        this.keyType = keyType;
        this.pinPolicy = pinPolicy;
        this.touchPolicy = touchPolicy;
        this.generated = z;
        this.publicKeyEncoded = Arrays.copyOf(bArr, bArr.length);
    }

    public KeyType getKeyType() {
        return this.keyType;
    }

    public PinPolicy getPinPolicy() {
        return this.pinPolicy;
    }

    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }

    public boolean isGenerated() {
        return this.generated;
    }

    public PublicKeyValues getPublicKeyValues() {
        return PivSession.parsePublicKeyFromDevice(this.keyType, this.publicKeyEncoded);
    }

    @Deprecated
    public PublicKey getPublicKey() {
        try {
            return getPublicKeyValues().toPublicKey();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
