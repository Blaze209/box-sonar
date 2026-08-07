package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public enum AppIdentitySwitchResult {
    SUCCESS(0),
    FAILURE(1);

    private final int mCode;

    AppIdentitySwitchResult(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static AppIdentitySwitchResult fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
