package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.oauth2.IDToken;

/* JADX INFO: loaded from: classes14.dex */
public class TenantProfile extends Account implements ITenantProfile {
    public TenantProfile(String str, IDToken iDToken) {
        super(str, iDToken);
    }

    @Override // com.microsoft.identity.client.Account, com.microsoft.identity.client.IClaimable
    public String getTenantId() {
        String str;
        return (getClaims() == null || (str = (String) getClaims().get("tid")) == null) ? "" : str;
    }
}
