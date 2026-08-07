package com.yubico.yubikit.piv;

/* JADX INFO: loaded from: classes3.dex */
public class ManagementKeyMetadata {
    private final boolean defaultValue;
    private final ManagementKeyType keyType;
    private final TouchPolicy touchPolicy;

    public ManagementKeyMetadata(ManagementKeyType managementKeyType, boolean z, TouchPolicy touchPolicy) {
        this.keyType = managementKeyType;
        this.defaultValue = z;
        this.touchPolicy = touchPolicy;
    }

    public ManagementKeyType getKeyType() {
        return this.keyType;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }

    public TouchPolicy getTouchPolicy() {
        return this.touchPolicy;
    }
}
