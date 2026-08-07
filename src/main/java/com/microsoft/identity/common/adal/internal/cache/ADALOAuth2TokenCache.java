package com.microsoft.identity.common.adal.internal.cache;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.adal.cache.CacheKey;
import com.microsoft.identity.common.java.adal.cache.DateTimeAdapter;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.AccountDeletionRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class ADALOAuth2TokenCache extends OAuth2TokenCache<AzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse> implements IShareSingleSignOnState {
    private static final String SHARED_PREFERENCES_FILENAME = "com.microsoft.aad.adal.cache";
    private static final String TAG = "ADALOAuth2TokenCache";
    private Gson mGson;
    private INameValueStorage<String> mISharedPreferencesFileManager;
    private List<IShareSingleSignOnState<MicrosoftAccount, MicrosoftRefreshToken>> mSharedSSOCaches;

    public ADALOAuth2TokenCache(IPlatformComponents iPlatformComponents) {
        super(iPlatformComponents);
        this.mGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTimeAdapter()).create();
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        validateSecretKeySetting();
        initializeSharedPreferencesFileManager(SHARED_PREFERENCES_FILENAME);
        this.mSharedSSOCaches = new ArrayList();
    }

    public ADALOAuth2TokenCache(IPlatformComponents iPlatformComponents, List<IShareSingleSignOnState<MicrosoftAccount, MicrosoftRefreshToken>> list) {
        super(iPlatformComponents);
        this.mGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTimeAdapter()).create();
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        validateSecretKeySetting();
        initializeSharedPreferencesFileManager(SHARED_PREFERENCES_FILENAME);
        this.mSharedSSOCaches = list;
    }

    protected void initializeSharedPreferencesFileManager(String str) {
        String str2 = TAG;
        Logger.verbose(str2, "Initializing SharedPreferencesFileManager");
        Logger.verbosePII(str2, "Initializing with name: " + str);
        this.mISharedPreferencesFileManager = getComponents().getStorageSupplier().getEncryptedNameValueStore(str, String.class);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(AzureActiveDirectoryOAuth2Strategy azureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) throws ClientException {
        String str = TAG + ":save";
        String issuerCacheIdentifier = azureActiveDirectoryOAuth2Strategy.getIssuerCacheIdentifier(azureActiveDirectoryAuthorizationRequest);
        AzureActiveDirectoryAccount azureActiveDirectoryAccountCreateAccount = azureActiveDirectoryOAuth2Strategy.createAccount(azureActiveDirectoryTokenResponse);
        String authority = Uri.parse(issuerCacheIdentifier).getAuthority();
        azureActiveDirectoryAccountCreateAccount.setEnvironment(authority);
        AzureActiveDirectoryRefreshToken refreshTokenFromResponse = azureActiveDirectoryOAuth2Strategy.getRefreshTokenFromResponse(azureActiveDirectoryTokenResponse);
        refreshTokenFromResponse.setEnvironment(authority);
        Logger.info(str, "Constructing new ADALTokenCacheItem");
        ADALTokenCacheItem aDALTokenCacheItem = new ADALTokenCacheItem(azureActiveDirectoryOAuth2Strategy, azureActiveDirectoryAuthorizationRequest, azureActiveDirectoryTokenResponse);
        logTokenCacheItem(aDALTokenCacheItem, str);
        Logger.info(str, "Setting items to cache for user...");
        for (String str2 : azureActiveDirectoryAccountCreateAccount.getCacheIdentifiers()) {
            String scope = azureActiveDirectoryAuthorizationRequest.getScope();
            String clientId = azureActiveDirectoryAuthorizationRequest.getClientId();
            Logger.infoPII(str, "issuerCacheIdentifier: [" + issuerCacheIdentifier + "]");
            Logger.infoPII(str, "scope: [" + scope + "]");
            Logger.infoPII(str, "clientId: [" + clientId + "]");
            Logger.infoPII(str, "cacheIdentifier: [" + str2 + "]");
            setItemToCacheForUser(issuerCacheIdentifier, scope, clientId, aDALTokenCacheItem, str2);
        }
        setItemToCacheForUser(issuerCacheIdentifier, azureActiveDirectoryAuthorizationRequest.getScope(), azureActiveDirectoryAuthorizationRequest.getClientId(), aDALTokenCacheItem, null);
        Logger.info(str, "Syncing SSO state to caches...");
        Iterator<IShareSingleSignOnState<MicrosoftAccount, MicrosoftRefreshToken>> it = this.mSharedSSOCaches.iterator();
        while (it.hasNext()) {
            try {
                it.next().setSingleSignOnState(azureActiveDirectoryAccountCreateAccount, refreshTokenFromResponse);
            } catch (ClientException e) {
                Logger.errorPII(TAG, "Exception setting single sign on state for account " + azureActiveDirectoryAccountCreateAccount.getUsername(), e);
            } catch (IllegalStateException e2) {
                Logger.errorPII(TAG, "Exception setting single sign on state for account " + azureActiveDirectoryAccountCreateAccount.getUsername(), e2);
                if (!AuthenticationSettings.INSTANCE.shouldIgnoreKeyLoaderNotFoundError()) {
                    throw e2;
                }
            }
        }
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(AzureActiveDirectoryOAuth2Strategy azureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) throws ClientException {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(Credential credential) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccount(String str, String str2, String str3, String str4) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2, String str3) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByLocalAccountId(String str, String str2, String str3) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String str, String str2, String str3) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(String str, String str2) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String str, AccountRecord accountRecord) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(String str, AccountRecord accountRecord) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    protected Set<String> getAllClientIds() {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByHomeAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    private static void logTokenCacheItem(ADALTokenCacheItem aDALTokenCacheItem, String str) {
        if (str == null) {
            throw new NullPointerException("methodTag is marked non-null but is null");
        }
        Logger.info(str, "Logging TokenCacheItem");
        Logger.infoPII(str, "resource: [" + aDALTokenCacheItem.getResource() + "]");
        Logger.infoPII(str, "authority: [" + aDALTokenCacheItem.getAuthority() + "]");
        Logger.infoPII(str, "clientId: [" + aDALTokenCacheItem.getClientId() + "]");
        Logger.infoPII(str, "expiresOn: [" + aDALTokenCacheItem.getExpiresOn() + "]");
        Logger.infoPII(str, "isMrrt: [" + aDALTokenCacheItem.getIsMultiResourceRefreshToken() + "]");
        Logger.infoPII(str, "tenantId: [" + aDALTokenCacheItem.getTenantId() + "]");
        Logger.infoPII(str, "foci: [" + aDALTokenCacheItem.getFamilyClientId() + "]");
        Logger.infoPII(str, "extendedExpires: [" + aDALTokenCacheItem.getExtendedExpiresOn() + "]");
        Logger.infoPII(str, "speRing: [" + aDALTokenCacheItem.getSpeRing() + "]");
    }

    private void setItemToCacheForUser(String str, String str2, String str3, ADALTokenCacheItem aDALTokenCacheItem, String str4) {
        String str5 = TAG + ":setItemToCacheForUser";
        Logger.info(str5, "Setting cacheitem for RT entry.");
        setItem(CacheKey.createCacheKeyForRTEntry(str, str2, str3, str4), aDALTokenCacheItem);
        if (aDALTokenCacheItem.getIsMultiResourceRefreshToken()) {
            Logger.info(str5, "CacheItem is an MRRT.");
            setItem(CacheKey.createCacheKeyForMRRT(str, str3, str4), ADALTokenCacheItem.getAsMRRTTokenCacheItem(aDALTokenCacheItem));
        }
        if (StringUtil.isNullOrEmpty(aDALTokenCacheItem.getFamilyClientId())) {
            return;
        }
        Logger.info(str5, "CacheItem is an FRT.");
        setItem(CacheKey.createCacheKeyForFRT(str, aDALTokenCacheItem.getFamilyClientId(), str4), ADALTokenCacheItem.getAsFRTTokenCacheItem(aDALTokenCacheItem));
    }

    private void setItem(String str, ADALTokenCacheItem aDALTokenCacheItem) {
        Logger.info(TAG + ":setItem", "Setting item to cache");
        this.mISharedPreferencesFileManager.put(str, this.mGson.toJson(aDALTokenCacheItem));
    }

    private void validateSecretKeySetting() {
        Logger.verbose(TAG, "Validating secret key settings.");
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public void setSingleSignOnState(BaseAccount baseAccount, RefreshToken refreshToken) {
        Logger.warn(TAG, "setSingleSignOnState was called, but is not implemented.");
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public RefreshToken getSingleSignOnState(BaseAccount baseAccount) {
        Logger.warn(TAG, "getSingleSignOnState was called, but is not implemented.");
        return null;
    }

    public static String getAdalCacheFilename() {
        Logger.info(TAG + ":getAdalCacheFilename", "Getting ADAL cache file name...");
        return SHARED_PREFERENCES_FILENAME;
    }
}
