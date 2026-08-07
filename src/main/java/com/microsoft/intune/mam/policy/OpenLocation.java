package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum OpenLocation {
    ONEDRIVE_FOR_BUSINESS(1),
    SHAREPOINT(2),
    CAMERA(4),
    LOCAL(8),
    ACCOUNT_DOCUMENT(16),
    PHOTO_LIBRARY(32),
    OTHER(Integer.MIN_VALUE);

    private final int mCode;

    OpenLocation(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static OpenLocation fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
