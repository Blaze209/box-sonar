package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityBehaviorBase implements ActivityBehavior {
    private final IdentityParamConverter mIdentityParamConverter;

    public ActivityBehaviorBase(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    @Deprecated
    public void switchMAMIdentity(String str) {
        switchMAMIdentity(str, EnumSet.noneOf(IdentitySwitchOption.class));
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    @Deprecated
    public void switchMAMIdentity(String str, EnumSet<IdentitySwitchOption> enumSet) {
        switchMAMIdentity(this.mIdentityParamConverter.fromUpnParam(str), enumSet);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    @Deprecated
    public void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        onMAMIdentitySwitchRequired(this.mIdentityParamConverter.fromUpnParam(str), appIdentitySwitchReason, appIdentitySwitchResultCallback);
    }
}
