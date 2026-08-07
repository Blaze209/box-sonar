package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityPersistenceManager;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMIdentityPersistenceManager implements MAMIdentityPersistenceManager {
    private final LazyInit<MAMWEAccountManager> mAccountManager;

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityPersistenceManager
    public MAMIdentity persistIdentity(MAMIdentity mAMIdentity) {
        return mAMIdentity;
    }

    public OfflineMAMIdentityPersistenceManager(LazyInit<MAMWEAccountManager> lazyInit) {
        this.mAccountManager = lazyInit;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMIdentityPersistenceManager
    public List<MAMIdentity> getPersistedIdentities() {
        return this.mAccountManager.get().getRegisteredIdentitiesDirect();
    }
}
