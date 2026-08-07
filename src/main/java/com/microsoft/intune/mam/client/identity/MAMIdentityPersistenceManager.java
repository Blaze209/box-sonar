package com.microsoft.intune.mam.client.identity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMIdentityPersistenceManager {
    List<MAMIdentity> getPersistedIdentities();

    MAMIdentity persistIdentity(MAMIdentity mAMIdentity);
}
