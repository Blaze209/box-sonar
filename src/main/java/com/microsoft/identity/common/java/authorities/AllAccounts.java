package com.microsoft.identity.common.java.authorities;

/* JADX INFO: loaded from: classes14.dex */
public class AllAccounts extends AzureActiveDirectoryAudience {
    public static final String ALL_ACCOUNTS_TENANT_ID = "common";

    public AllAccounts() {
        setTenantId("common");
    }

    public AllAccounts(String str) {
        if (str == null) {
            throw new NullPointerException("cloudUrl is marked non-null but is null");
        }
        setCloudUrl(str);
        setTenantId("common");
    }
}
