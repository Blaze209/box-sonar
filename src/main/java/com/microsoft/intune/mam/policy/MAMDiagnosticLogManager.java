package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMDiagnosticLogManager {

    public enum Result {
        LOG_UPLOAD_SUCCEEDED,
        LOG_UPLOAD_FAILED,
        USER_CONSENT_DENIED
    }

    public enum ServiceType {
        PowerLift,
        Other
    }

    void reportStatus(String str, String str2, ServiceType serviceType, Result result, String str3);
}
