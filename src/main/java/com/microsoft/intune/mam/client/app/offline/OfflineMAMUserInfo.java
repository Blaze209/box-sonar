package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMUserInfo;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineMAMUserInfo implements MAMUserInfo {
    private String mOid;
    private String mUpn;

    public OfflineMAMUserInfo(OfflineMAMIdentityManager offlineMAMIdentityManager, MAMWEAccountManager mAMWEAccountManager) {
        this.mUpn = null;
        this.mOid = null;
        if (MAMInfo.isMMAEnabled()) {
            return;
        }
        for (MAMIdentity mAMIdentity : offlineMAMIdentityManager.getIdentities()) {
            if (mAMWEAccountManager.getAccountStatus(mAMIdentity) == MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED) {
                this.mUpn = mAMIdentity.rawUPN();
                this.mOid = mAMIdentity.aadId();
                return;
            }
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMUserInfo
    public String getPrimaryUser() {
        checkMMANoPrimaryUser();
        return this.mUpn;
    }

    @Override // com.microsoft.intune.mam.policy.MAMUserInfo
    public String getPrimaryUserOID() {
        checkMMANoPrimaryUser();
        return this.mOid;
    }

    private void checkMMANoPrimaryUser() {
        if (MAMInfo.isMMAEnabled()) {
            throw new UnsupportedOperationException("There is no concept of a primary user in MMA mode");
        }
    }
}
