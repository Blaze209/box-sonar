package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum NotificationRestriction {
    UNRESTRICTED(0),
    BLOCK_ORG_DATA(1),
    BLOCKED(2);

    private final int mCode;

    NotificationRestriction(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static NotificationRestriction fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return UNRESTRICTED;
    }
}
