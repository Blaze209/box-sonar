package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.java.BaseAccount;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class ActiveDirectoryFederationServices2012R2Account extends BaseAccount {
    protected boolean canEqual(Object obj) {
        return obj instanceof ActiveDirectoryFederationServices2012R2Account;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ActiveDirectoryFederationServices2012R2Account) && ((ActiveDirectoryFederationServices2012R2Account) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public String getUniqueIdentifier() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public List<String> getCacheIdentifiers() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getHomeAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getEnvironment() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getRealm() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getLocalAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getUsername() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAlternativeAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFirstName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFamilyName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getMiddleName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAvatarUrl() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getClientInfo() {
        throw new UnsupportedOperationException("Method stub!");
    }
}
