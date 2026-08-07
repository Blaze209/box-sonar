package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerOAuth2TokenCacheTelemetryWrapper<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends MicrosoftTokenResponse, GenericAccount extends MicrosoftAccount, GenericRefreshToken extends MicrosoftRefreshToken> extends BrokerOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> {
    private final BrokerOAuth2TokenCache mCacheToWrap;

    public BrokerOAuth2TokenCacheTelemetryWrapper(IPlatformComponents iPlatformComponents, int i, IBrokerApplicationMetadataCache iBrokerApplicationMetadataCache, BrokerOAuth2TokenCache brokerOAuth2TokenCache) {
        super(iPlatformComponents, i, iBrokerApplicationMetadataCache);
        if (iPlatformComponents == null) {
            throw new NullPointerException("mPlatformComponents is marked non-null but is null");
        }
        if (iBrokerApplicationMetadataCache == null) {
            throw new NullPointerException("applicationMetadataCache is marked non-null but is null");
        }
        if (brokerOAuth2TokenCache == null) {
            throw new NullPointerException("cacheToWrap is marked non-null but is null");
        }
        this.mCacheToWrap = brokerOAuth2TokenCache;
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(GenericOAuth2Strategy genericoauth2strategy, GenericAuthorizationRequest genericauthorizationrequest, GenericTokenResponse generictokenresponse) throws ClientException {
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.save((OAuth2Strategy) genericoauth2strategy, (AuthorizationRequest) genericauthorizationrequest, (MicrosoftTokenResponse) generictokenresponse);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_save.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(GenericOAuth2Strategy genericoauth2strategy, GenericAuthorizationRequest genericauthorizationrequest, GenericTokenResponse generictokenresponse) throws ClientException {
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.saveAndLoadAggregatedAccountData((OAuth2Strategy) genericoauth2strategy, (AuthorizationRequest) genericauthorizationrequest, (MicrosoftTokenResponse) generictokenresponse);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_save_and_load_aggregated_account_data.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.save(accountRecord, idTokenRecord);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_save.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.load(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_load.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.loadWithAggregatedAccountData(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_load_aggregated_account_data.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(Credential credential) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.removeCredential(credential);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_remove_credential.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccount(String str, String str2, String str3, String str4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccount(str, str2, str3, str4);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_account.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccountsWithAggregatedAccountData(str, str2, str3);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_accounts_with_aggregated_account_data.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByLocalAccountId(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccountByLocalAccountId(str, str2, str3);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_account_by_local_account_id.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccountWithAggregatedAccountDataByLocalAccountId(str, str2, str3);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_account_with_aggregated_account_data_by_local_account_id.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccounts(str, str2);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_accounts.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String str, AccountRecord accountRecord) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAllTenantAccountsForAccountByClientId(str, accountRecord);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_all_tenant_accounts_for_account_by_client_id.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccountsWithAggregatedAccountData(str, str2);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_accounts_with_aggregated_account_data.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(String str, AccountRecord accountRecord) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getIdTokensForAccountRecord(str, accountRecord);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_id_tokens_for_account_record.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.removeAccount(str, str2, str3, str4);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_remove_account.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.removeAccount(str, str2, str3, str4, credentialTypeArr);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_remove_account.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.mCacheToWrap.clearAll();
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_clear_all.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    protected Set<String> getAllClientIds() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAllClientIds();
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_all_client_ids.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache, com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByHomeAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.mCacheToWrap.getAccountByHomeAccountId(str, str2, str3);
        } finally {
            SpanExtension.current().setAttribute(AttributeName.elapsed_time_cache_get_account_by_home_account_id.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }
}
