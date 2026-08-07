package com.yubico.yubikit.piv;

/* JADX INFO: loaded from: classes3.dex */
public enum PinPolicy {
    DEFAULT(0),
    NEVER(1),
    ONCE(2),
    ALWAYS(3);

    public final int value;

    PinPolicy(int i) {
        this.value = i;
    }

    public static PinPolicy fromValue(int i) {
        if (i >= 0 && i < values().length) {
            return values()[i];
        }
        throw new IllegalArgumentException("Not a valid PinPolicy :" + i);
    }
}
