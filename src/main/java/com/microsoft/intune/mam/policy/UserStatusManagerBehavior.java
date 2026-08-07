package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.identity.MAMIdentity;

/* JADX INFO: loaded from: classes3.dex */
public interface UserStatusManagerBehavior {
    UserStatus getUserStatus(MAMIdentity mAMIdentity);

    @Deprecated
    UserStatus getUserStatus(String str);
}
