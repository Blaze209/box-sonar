package com.microsoft.intune.mam.client.app;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AllowedAccountsBehavior {
    List<AllowedAccountInfo> getAllowedAccounts();

    boolean isAccountAllowed(String str);

    void listenForChanges(AllowedAccountsListener allowedAccountsListener);

    void unregisterListener(AllowedAccountsListener allowedAccountsListener);
}
