package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum TokenNeededReason {
    NOT_NEEDED(0),
    ENROLLMENT(1),
    CHECKIN(2),
    COMPLIANCE(3);

    private final int mCode;

    TokenNeededReason(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static TokenNeededReason fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
