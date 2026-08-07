package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMActivityIdentityRequirementListener {
    @Deprecated
    default void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        appIdentitySwitchResultCallback.reportIdentitySwitchResult(AppIdentitySwitchResult.SUCCESS);
    }

    default void onMAMIdentitySwitchRequired(String str, String str2, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        onMAMIdentitySwitchRequired(str, appIdentitySwitchReason, appIdentitySwitchResultCallback);
    }
}
