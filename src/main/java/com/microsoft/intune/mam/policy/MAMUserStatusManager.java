package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMUserStatusManager {
    private static CachedBehaviorProvider<UserStatusManagerBehavior> sCachedBehavior = new CachedBehaviorProvider<>(UserStatusManagerBehavior.class);

    @Deprecated
    public static UserStatus getUserStatus(String str) {
        return sCachedBehavior.get().getUserStatus(str);
    }

    public static UserStatus getUserStatusForOID(String str) {
        return sCachedBehavior.get().getUserStatus(ExternalIdentityUtils.identityFromOID(str));
    }

    private MAMUserStatusManager() {
    }
}
