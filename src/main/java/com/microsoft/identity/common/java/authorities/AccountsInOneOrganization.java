package com.microsoft.identity.common.java.authorities;

/* JADX INFO: loaded from: classes14.dex */
public class AccountsInOneOrganization extends AzureActiveDirectoryAudience {
    public AccountsInOneOrganization() {
    }

    public AccountsInOneOrganization(String str) {
        setTenantId(str);
    }

    public AccountsInOneOrganization(String str, String str2) {
        setCloudUrl(str);
        setTenantId(str2);
    }
}
