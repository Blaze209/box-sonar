package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public enum AppIdentitySwitchReason {
    CREATE(0),
    RESUME_CANCELLED(1),
    NEW_INTENT(2);

    private final int mCode;

    AppIdentitySwitchReason(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static AppIdentitySwitchReason fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
