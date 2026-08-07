package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.identity.MAMIdentity;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMWEEnroller {
    void attemptMamEnrollment(MAMIdentity mAMIdentity);

    String getMAMServiceTokenFromCallback(MAMIdentity mAMIdentity);

    boolean isAuthenticationCallbackRegistered();
}
