package com.yubico.yubikit.piv;

/* JADX INFO: loaded from: classes3.dex */
public enum TouchPolicy {
    DEFAULT(0),
    NEVER(1),
    ALWAYS(2),
    CACHED(3);

    public final int value;

    TouchPolicy(int i) {
        this.value = i;
    }

    public static TouchPolicy fromValue(int i) {
        for (TouchPolicy touchPolicy : values()) {
            if (touchPolicy.value == i) {
                return touchPolicy;
            }
        }
        throw new IllegalArgumentException("Not a valid TouchPolicy :" + i);
    }
}
