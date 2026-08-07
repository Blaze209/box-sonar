package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManagerBase;
import com.microsoft.intune.mam.client.identity.MAMIdentityPersistenceManager;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMIdentityManager extends MAMIdentityManagerBase {
    public OfflineMAMIdentityManager(MAMIdentityPersistenceManager mAMIdentityPersistenceManager) {
        super(mAMIdentityPersistenceManager);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityManager
    public MAMIdentity fromString(String str) {
        return create(str, null);
    }
}
