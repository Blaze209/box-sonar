package com.microsoft.intune.mam.client.app;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class AllowedAccounts {
    private static AllowedAccountsBehavior sBehavior;

    public static List<AllowedAccountInfo> getAllowedAccounts() {
        return getBehavior().getAllowedAccounts();
    }

    public static boolean isAccountAllowed(String str) {
        return getBehavior().isAccountAllowed(str);
    }

    public static void listenForChanges(AllowedAccountsListener allowedAccountsListener) {
        getBehavior().listenForChanges(allowedAccountsListener);
    }

    public static void unregisterListener(AllowedAccountsListener allowedAccountsListener) {
        getBehavior().unregisterListener(allowedAccountsListener);
    }

    private static synchronized AllowedAccountsBehavior getBehavior() {
        if (sBehavior == null) {
            sBehavior = (AllowedAccountsBehavior) MAMComponents.get(AllowedAccountsBehavior.class);
        }
        return sBehavior;
    }

    private AllowedAccounts() {
    }
}
