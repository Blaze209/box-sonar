package com.microsoft.identity.client;

import android.text.TextUtils;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.dto.AccountRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public abstract class TokenParameters {
    private IAccount mAccount;
    private AccountRecord mAccountRecord;
    private AuthenticationScheme mAuthenticationScheme;
    private String mAuthority;
    private ClaimsRequest mClaimsRequest;
    private String mCorrelationId;
    private List<String> mScopes;

    protected TokenParameters(Builder builder) {
        this.mAccount = builder.mAccount;
        this.mAuthority = builder.mAuthority;
        this.mClaimsRequest = builder.mClaimsRequest;
        this.mScopes = builder.mScopes;
        this.mAuthenticationScheme = builder.mAuthenticationScheme;
        this.mCorrelationId = builder.mCorrelationId;
    }

    public AuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    public List<String> getScopes() {
        return this.mScopes;
    }

    void setScopes(List<String> list) {
        this.mScopes = list;
    }

    public IAccount getAccount() {
        return this.mAccount;
    }

    void setAccount(IAccount iAccount) {
        this.mAccount = iAccount;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    void setAuthority(String str) {
        this.mAuthority = str;
    }

    public ClaimsRequest getClaimsRequest() {
        return this.mClaimsRequest;
    }

    public void setAccountRecord(AccountRecord accountRecord) {
        this.mAccountRecord = accountRecord;
    }

    public AccountRecord getAccountRecord() {
        return this.mAccountRecord;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public static abstract class Builder<B extends Builder<B>> {
        private IAccount mAccount;
        private AuthenticationScheme mAuthenticationScheme;
        private String mAuthority;
        private ClaimsRequest mClaimsRequest;
        private String mCorrelationId;
        private List<String> mScopes;

        public abstract TokenParameters build();

        public abstract B self();

        public B withAuthenticationScheme(AuthenticationScheme authenticationScheme) {
            this.mAuthenticationScheme = authenticationScheme;
            return (B) self();
        }

        public B withScopes(List<String> list) {
            if (this.mScopes != null) {
                throw new IllegalArgumentException("Scopes is already set.");
            }
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Empty scopes list.");
            }
            this.mScopes = list;
            return (B) self();
        }

        public B forAccount(IAccount iAccount) {
            this.mAccount = iAccount;
            return (B) self();
        }

        public B fromAuthority(String str) {
            this.mAuthority = str;
            return (B) self();
        }

        public B fromAuthority(AzureCloudInstance azureCloudInstance, AadAuthorityAudience aadAuthorityAudience, String str) {
            if (!TextUtils.isEmpty(str)) {
                if (aadAuthorityAudience != AadAuthorityAudience.AzureAdMyOrg) {
                    throw new IllegalArgumentException("Audience must be " + AadAuthorityAudience.AzureAdMyOrg + " when tenant is specified");
                }
                return (B) fromAuthority(azureCloudInstance, str);
            }
            if (aadAuthorityAudience == AadAuthorityAudience.AzureAdMyOrg) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Tenant must be specified when the audience is " + aadAuthorityAudience);
                }
                this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + str;
                return (B) self();
            }
            this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + aadAuthorityAudience.getAudienceValue();
            return (B) self();
        }

        public B fromAuthority(AzureCloudInstance azureCloudInstance, AadAuthorityAudience aadAuthorityAudience) {
            return (B) fromAuthority(azureCloudInstance, aadAuthorityAudience, null);
        }

        public B fromAuthority(AzureCloudInstance azureCloudInstance, String str) {
            this.mAuthority = azureCloudInstance.getCloudInstanceUri() + "/" + str;
            return (B) self();
        }

        public B withClaims(ClaimsRequest claimsRequest) {
            this.mClaimsRequest = claimsRequest;
            return (B) self();
        }

        public B withResource(String str) {
            if (this.mScopes != null) {
                throw new IllegalArgumentException("Scopes is already set. Scopes and resources cannot be combined in a single request.");
            }
            if (StringUtil.isEmpty(str)) {
                throw new IllegalArgumentException("Empty resource string.");
            }
            this.mScopes = new ArrayList<String>(str) { // from class: com.microsoft.identity.client.TokenParameters.Builder.1
                final /* synthetic */ String val$resource;

                {
                    this.val$resource = str;
                    add(str.trim() + "/.default");
                }
            };
            return (B) self();
        }

        public B withCorrelationId(UUID uuid) {
            this.mCorrelationId = uuid.toString();
            return (B) self();
        }
    }
}
