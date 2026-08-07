package com.microsoft.identity.common.java.authorities;

/* JADX INFO: loaded from: classes14.dex */
public class AnyPersonalAccount extends AzureActiveDirectoryAudience {
    public static final String ANY_PERSONAL_ACCOUNT_TENANT_ID = "consumers";

    public AnyPersonalAccount() {
        setTenantId("consumers");
    }

    public AnyPersonalAccount(String str) {
        setTenantId("consumers");
        setCloudUrl(str);
    }
}
