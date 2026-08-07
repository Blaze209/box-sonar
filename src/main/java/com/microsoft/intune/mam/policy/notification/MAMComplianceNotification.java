package com.microsoft.intune.mam.policy.notification;

import com.microsoft.intune.mam.policy.MAMCAComplianceStatus;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMComplianceNotification extends MAMUserNotification {
    String getComplianceErrorMessage();

    String getComplianceErrorTitle();

    MAMCAComplianceStatus getComplianceStatus();
}
