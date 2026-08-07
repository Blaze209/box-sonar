package io.split.android.client;

import io.split.android.client.shared.UserConsent;

/* JADX INFO: loaded from: classes4.dex */
public interface UserConsentManager {
    UserConsent getStatus();

    void setStatus(UserConsent status);
}
