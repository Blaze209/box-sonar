package com.microsoft.intune.mam.client.identity;

/* JADX INFO: loaded from: classes3.dex */
public class MAMDataProtectionInfoImpl implements MAMDataProtectionInfo {
    private MAMIdentity mIdentity;

    MAMDataProtectionInfoImpl(MAMIdentity mAMIdentity) {
        this.mIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMProtectionInfo
    public String getIdentity() {
        return this.mIdentity.rawUPN();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMProtectionInfo
    public String getIdentityOID() {
        return MAMIdentity.isValid(this.mIdentity) ? this.mIdentity.aadId() : "";
    }
}
