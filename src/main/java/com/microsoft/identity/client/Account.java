package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class Account implements IAccount {
    private static final String TAG = "Account";
    private String mClientInfo;
    private String mEnvironment;
    private String mHomeAccountId;
    private String mHomeOid;
    private String mHomeTenantId;
    private final Map<String, ?> mIdTokenClaims;
    private final String mRawIdToken;

    public Account(String str, IDToken iDToken) {
        this.mClientInfo = str;
        if (iDToken != null) {
            this.mIdTokenClaims = iDToken.getTokenClaims();
            this.mRawIdToken = iDToken.getRawIDToken();
        } else {
            this.mIdTokenClaims = null;
            this.mRawIdToken = null;
        }
    }

    void setId(String str) {
        this.mHomeOid = str;
    }

    @Override // com.microsoft.identity.client.IAccount
    public String getId() {
        ClientInfo clientInfo;
        String uIdFromHomeAccountId;
        String str = TAG + ":getId";
        if (this.mClientInfo != null) {
            try {
                clientInfo = new ClientInfo(this.mClientInfo);
            } catch (MsalClientException e) {
                com.microsoft.identity.common.logging.Logger.error(str, "Failed to parse ClientInfo", e);
                clientInfo = null;
            }
        } else {
            clientInfo = null;
        }
        if (clientInfo != null) {
            uIdFromHomeAccountId = clientInfo.getUniqueIdentifier();
        } else {
            Map<String, ?> map = this.mIdTokenClaims;
            if (map != null) {
                uIdFromHomeAccountId = (String) map.get("oid");
            } else {
                uIdFromHomeAccountId = this.mHomeOid;
            }
        }
        if (StringUtil.isEmpty(uIdFromHomeAccountId)) {
            com.microsoft.identity.common.logging.Logger.warn(str, "Unable to get account id from either ClientInfo or IdToken. Attempting to obtain from home account id.");
            uIdFromHomeAccountId = com.microsoft.identity.common.java.util.StringUtil.getUIdFromHomeAccountId(this.mHomeAccountId);
        }
        if (!StringUtil.isEmpty(uIdFromHomeAccountId)) {
            return uIdFromHomeAccountId;
        }
        com.microsoft.identity.common.logging.Logger.warn(str, "Account ID is empty. Returning MISSING_FROM_THE_TOKEN_RESPONSE.");
        return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    void setTenantId(String str) {
        this.mHomeTenantId = str;
    }

    @Override // com.microsoft.identity.client.IClaimable
    public String getTenantId() {
        return this.mHomeTenantId;
    }

    public String getHomeAccountId() {
        return getId() + "." + this.mHomeTenantId;
    }

    void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    @Override // com.microsoft.identity.client.IClaimable
    public String getIdToken() {
        return this.mRawIdToken;
    }

    @Override // com.microsoft.identity.client.IClaimable
    public Map<String, ?> getClaims() {
        return this.mIdTokenClaims;
    }

    @Override // com.microsoft.identity.client.IClaimable
    public String getUsername() {
        if (getClaims() != null) {
            return SchemaUtil.getDisplayableId(getClaims());
        }
        return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    @Override // com.microsoft.identity.client.IAccount
    public String getAuthority() {
        if (getClaims() != null) {
            String str = (String) getClaims().get("iss");
            if (StringUtil.isEmpty(str)) {
                return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
            }
            return (!str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT) || StringUtil.isEmpty(getEnvironment()) || StringUtil.isEmpty(getTenantId())) ? str : CIAMAuthority.getTenantIdVariantUrlFromAuthorityWithoutPath(getEnvironment(), getTenantId());
        }
        return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    public void setHomeAccountId(String str) {
        this.mHomeAccountId = str;
    }
}
