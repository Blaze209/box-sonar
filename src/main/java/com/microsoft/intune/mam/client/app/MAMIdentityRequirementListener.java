package com.microsoft.intune.mam.client.app;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMIdentityRequirementListener {
    @Deprecated
    default void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        appIdentitySwitchResultCallback.reportIdentitySwitchResult(AppIdentitySwitchResult.SUCCESS);
    }

    default void onMAMIdentitySwitchRequired(String str, String str2, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        onMAMIdentitySwitchRequired(str, appIdentitySwitchResultCallback);
    }
}
