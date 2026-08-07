package com.microsoft.intune.mam.client;

/* JADX INFO: loaded from: classes3.dex */
public class MamificationMetadata implements MamificationMetadataAccess {
    @Override // com.microsoft.intune.mam.client.MamificationMetadataAccess
    public String[] getExcludedClasses() {
        return new String[]{"com.box.android.activities.login.CustomTabsHelper"};
    }
}
