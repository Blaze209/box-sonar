package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.policy.UserStatus;
import com.microsoft.intune.mam.policy.UserStatusManagerBehavior;
import com.microsoft.intune.mam.policy.clock.UserClockStatus;

/* JADX INFO: loaded from: classes3.dex */
class OfflineUserStatusManagerBehavior implements UserStatusManagerBehavior {
    private final IdentityParamConverter mIdentityParamConverter;

    OfflineUserStatusManagerBehavior(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.policy.UserStatusManagerBehavior
    @Deprecated
    public UserStatus getUserStatus(String str) {
        return getUserStatus(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.policy.UserStatusManagerBehavior
    public UserStatus getUserStatus(MAMIdentity mAMIdentity) {
        return new UserStatus() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineUserStatusManagerBehavior$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.policy.UserStatus
            public final UserClockStatus getClockStatus() {
                return UserClockStatus.NOT_CONFIGURED;
            }
        };
    }
}
