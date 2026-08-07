package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PinPolicy;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.TouchPolicy;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes3.dex */
public class PivAlgorithmParameterSpec implements AlgorithmParameterSpec, Destroyable {
    private boolean destroyed = false;
    final KeyType keyType;

    @Nullable
    final char[] pin;
    final PinPolicy pinPolicy;
    final Slot slot;
    final TouchPolicy touchPolicy;

    public PivAlgorithmParameterSpec(Slot slot, KeyType keyType, @Nullable PinPolicy pinPolicy, @Nullable TouchPolicy touchPolicy, @Nullable char[] cArr) {
        this.slot = slot;
        this.keyType = keyType;
        this.pinPolicy = pinPolicy == null ? PinPolicy.DEFAULT : pinPolicy;
        this.touchPolicy = touchPolicy == null ? TouchPolicy.DEFAULT : touchPolicy;
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
}
