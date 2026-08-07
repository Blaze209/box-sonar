package com.microsoft.intune.mam.log;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityLogUtils;

/* JADX INFO: loaded from: classes3.dex */
public class PIIUPN implements PIIObj {
    private final String mAlternativeId;
    private final String mUPN;

    public PIIUPN(String str, String str2) {
        this.mUPN = MAMIdentityLogUtils.formatForLog(str, str2, true);
        this.mAlternativeId = MAMIdentityLogUtils.formatForLog(str, str2, false);
    }

    public PIIUPN(MAMIdentity mAMIdentity) {
        this.mUPN = MAMIdentityLogUtils.formatForLog(mAMIdentity, true);
        this.mAlternativeId = MAMIdentityLogUtils.formatForLog(mAMIdentity, false);
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toString() {
        return this.mAlternativeId;
    }

    @Override // com.microsoft.intune.mam.log.PIIObj
    public String toStringPIIfull() {
        return this.mUPN;
    }
}
