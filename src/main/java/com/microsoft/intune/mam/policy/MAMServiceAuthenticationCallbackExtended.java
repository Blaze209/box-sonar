package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMServiceAuthenticationCallbackExtended extends MAMServiceAuthenticationCallback {
    String acquireToken(String str, String str2, String str3, String str4, String str5);

    @Override // com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallback
    default String acquireToken(String str, String str2, String str3) {
        return acquireToken(str, str2, null, null, str3);
    }
}
