package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAccount extends MicrosoftAccount {
    private static final String TAG = "AzureActiveDirectoryAccount";
    private String mIdentityProvider;

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    protected boolean canEqual(Object obj) {
        return obj instanceof AzureActiveDirectoryAccount;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AzureActiveDirectoryAccount)) {
            return false;
        }
        AzureActiveDirectoryAccount azureActiveDirectoryAccount = (AzureActiveDirectoryAccount) obj;
        if (!azureActiveDirectoryAccount.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String str = this.mIdentityProvider;
        String str2 = azureActiveDirectoryAccount.mIdentityProvider;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.mIdentityProvider;
        return (iHashCode * 59) + (str == null ? 43 : str.hashCode());
    }

    public AzureActiveDirectoryAccount() {
    }

    public AzureActiveDirectoryAccount(IDToken iDToken, ClientInfo clientInfo) {
        super(iDToken, clientInfo);
        if (iDToken == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        if (clientInfo == null) {
            throw new NullPointerException("clientInfo is marked non-null but is null");
        }
        this.mIdentityProvider = (String) new HashMap(iDToken.getTokenClaims()).get("idp");
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    public synchronized void setIdentityProvider(String str) {
        this.mIdentityProvider = str;
    }

    public synchronized String getIdentityProvider() {
        return this.mIdentityProvider;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        return MicrosoftAccount.AUTHORITY_TYPE_MS_STS;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    protected String getDisplayableIdFromClaims(Map<String, ?> map) {
        if (!StringUtil.isNullOrEmpty((String) map.get("upn"))) {
            Logger.info(TAG + ":getDisplayableId", "Returning upn as displayableId");
            return (String) map.get("upn");
        }
        if (StringUtil.isNullOrEmpty((String) map.get("email"))) {
            return null;
        }
        Logger.info(TAG + ":getDisplayableId", "Returning email as displayableId");
        return (String) map.get("email");
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount
    public String toString() {
        return "AzureActiveDirectoryAccount{} " + super.toString() + ", mIdentityProvider='" + this.mIdentityProvider + '\'';
    }
}
