package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MultiTenantAccount extends Account implements IMultiTenantAccount {
    private Map<String, ITenantProfile> mTenantProfiles;

    MultiTenantAccount(String str, IDToken iDToken) {
        super(str, iDToken);
        this.mTenantProfiles = new HashMap();
    }

    void setTenantProfiles(Map<String, ITenantProfile> map) {
        this.mTenantProfiles = map;
    }

    @Override // com.microsoft.identity.client.IMultiTenantAccount
    public Map<String, ITenantProfile> getTenantProfiles() {
        return Collections.unmodifiableMap(this.mTenantProfiles);
    }
}
