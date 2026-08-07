package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum MAMCAComplianceStatus {
    UNKNOWN(-1),
    COMPLIANT(0),
    NOT_COMPLIANT(1),
    SERVICE_FAILURE(2),
    NETWORK_FAILURE(3),
    CLIENT_ERROR(4),
    PENDING(5),
    COMPANY_PORTAL_REQUIRED(6);

    private final int mCode;

    MAMCAComplianceStatus(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static MAMCAComplianceStatus fromCode(int i) {
        for (int i2 = 0; i2 < values().length; i2++) {
            if (values()[i2].getCode() == i) {
                return values()[i2];
            }
        }
        return UNKNOWN;
    }
}
