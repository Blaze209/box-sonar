package com.microsoft.intune.mam.client;

/* JADX INFO: loaded from: classes3.dex */
public enum MAMIdentitySwitchResult {
    SUCCEEDED(0),
    FAILED(1),
    NOT_ALLOWED(2),
    CANCELLED(3);

    private final int mCode;

    MAMIdentitySwitchResult(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static MAMIdentitySwitchResult fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
