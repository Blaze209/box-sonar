package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMActivityBlockingListener {
    @Deprecated
    default void onMAMCompanyPortalRequired(String str) {
    }

    default void onMAMCompanyPortalRequired(String str, String str2) {
        onMAMCompanyPortalRequired(str);
    }
}
