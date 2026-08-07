package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum SaveLocation {
    ONEDRIVE_FOR_BUSINESS(1),
    SHAREPOINT(2),
    BOX(4),
    DROPBOX(8),
    GOOGLE_DRIVE(16),
    LOCAL(32),
    ACCOUNT_DOCUMENT(64),
    PHOTO_LIBRARY(128),
    OTHER(Integer.MIN_VALUE);

    private final int mCode;

    SaveLocation(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static SaveLocation fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return null;
    }
}
