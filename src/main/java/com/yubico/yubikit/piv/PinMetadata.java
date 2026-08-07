package com.yubico.yubikit.piv;

/* JADX INFO: loaded from: classes3.dex */
public class PinMetadata {
    private final int attemptsRemaining;
    private final boolean defaultValue;
    private final int totalAttempts;

    public PinMetadata(boolean z, int i, int i2) {
        this.defaultValue = z;
        this.totalAttempts = i;
        this.attemptsRemaining = i2;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }

    public int getTotalAttempts() {
        return this.totalAttempts;
    }

    public int getAttemptsRemaining() {
        return this.attemptsRemaining;
    }
}
