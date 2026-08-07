package com.microsoft.identity.common.java.authorities;

/* JADX INFO: loaded from: classes14.dex */
public class AnyOrganizationalAccount extends AzureActiveDirectoryAudience {
    public AnyOrganizationalAccount() {
        setTenantId(AzureActiveDirectoryAudience.ORGANIZATIONS);
    }

    public AnyOrganizationalAccount(String str) {
        setCloudUrl(str);
        setTenantId(AzureActiveDirectoryAudience.ORGANIZATIONS);
    }
}
