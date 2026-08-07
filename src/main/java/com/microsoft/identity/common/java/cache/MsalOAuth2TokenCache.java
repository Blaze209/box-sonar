package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.events.CacheEndEvent;
import com.microsoft.identity.common.java.telemetry.events.CacheStartEvent;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class MsalOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken> extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse> implements IShareSingleSignOnState<GenericAccount, GenericRefreshToken> {
    private static final String TAG = "MsalOAuth2TokenCache";
    private static final Object sCacheLock = new Object();
    private final IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> mAccountCredentialAdapter;
    private IAccountCredentialCache mAccountCredentialCache;

    public MsalOAuth2TokenCache(IPlatformComponents iPlatformComponents, IAccountCredentialCache iAccountCredentialCache, IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> iAccountCredentialAdapter) {
        super(iPlatformComponents);
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mAccountCredentialCache = iAccountCredentialCache;
        this.mAccountCredentialAdapter = iAccountCredentialAdapter;
    }

    public static MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> create(IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        return create(iPlatformComponents, false);
    }

    public static MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> create(IPlatformComponents iPlatformComponents, boolean z) {
        IAccountCredentialCache sharedPreferencesAccountCredentialCache;
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        Logger.verbose(TAG + ":create", "Creating MsalOAuth2TokenCache");
        CacheKeyValueDelegate cacheKeyValueDelegate = new CacheKeyValueDelegate();
        INameValueStorage encryptedNameValueStore = iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.DEFAULT_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, String.class);
        if (z) {
            sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCacheWithMemoryCache(cacheKeyValueDelegate, encryptedNameValueStore);
        } else {
            sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCache(cacheKeyValueDelegate, encryptedNameValueStore);
        }
        return new MsalOAuth2TokenCache<>(iPlatformComponents, sharedPreferencesAccountCredentialCache, new MicrosoftStsAccountCredentialAdapter());
    }

    void validateNonNull(Object obj, String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("type is marked non-null but is null");
        }
        String str2 = str + " passed in is Null";
        if (obj != null) {
            return;
        }
        Logger.warn(TAG, str2);
        throw new ClientException(str2);
    }

    @Deprecated
    ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
        boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
        boolean zIsAccessTokenSchemaCompliant = isAccessTokenSchemaCompliant(accessTokenRecord);
        if (!zIsAccountSchemaCompliant) {
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        if (!zIsIdTokenSchemaCompliant) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(ID)]");
        }
        if (!zIsAccessTokenSchemaCompliant) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(AT)]");
        }
        Logger.verbose(TAG + ":save (3 arg)", "Accounts/Credentials are valid.... proceeding");
        saveAccounts(accountRecord);
        saveCredentialsInternal(idTokenRecord, accessTokenRecord);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.accessToken(accessTokenRecord);
        if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
            cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
        } else {
            cacheRecordBuilderBuilder.idToken(idTokenRecord);
        }
        return cacheRecordBuilderBuilder.build();
    }

    ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord, RefreshTokenRecord refreshTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        if (!isAccountSchemaCompliant(accountRecord)) {
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        if (!isIdTokenSchemaCompliant(idTokenRecord)) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(ID)]");
        }
        if (!isAccessTokenSchemaCompliant(accessTokenRecord)) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(AT)]");
        }
        if (refreshTokenRecord != null && !isRefreshTokenSchemaCompliant(refreshTokenRecord)) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(RT)]");
        }
        Logger.verbose(TAG + ":save (4 arg)", "Accounts/Credentials are valid.... proceeding");
        saveAccounts(accountRecord);
        saveCredentialsInternal(idTokenRecord, accessTokenRecord, refreshTokenRecord);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.accessToken(accessTokenRecord);
        cacheRecordBuilderBuilder.refreshToken(refreshTokenRecord);
        if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
            cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
        } else {
            cacheRecordBuilderBuilder.idToken(idTokenRecord);
        }
        return cacheRecordBuilderBuilder.build();
    }

    List<ICacheRecord> saveAndLoadAggregatedAccountData(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        return mergeCacheRecordWithOtherTenantCacheRecords(save(accountRecord, idTokenRecord, accessTokenRecord));
    }

    private List<ICacheRecord> mergeCacheRecordWithOtherTenantCacheRecords(ICacheRecord iCacheRecord) {
        if (iCacheRecord == null) {
            throw new NullPointerException("savedCacheRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(iCacheRecord);
        ArrayList arrayList2 = new ArrayList(getAllTenantAccountsForAccountByClientId(iCacheRecord.getRefreshToken().getClientId(), iCacheRecord.getAccount()));
        if (!arrayList2.isEmpty()) {
            arrayList2.remove(0);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(getSparseCacheRecordForAccount(iCacheRecord.getRefreshToken().getClientId(), (AccountRecord) it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
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
        AccountRecord accountRecordCreateAccount = this.mAccountCredentialAdapter.createAccount(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
        AccessTokenRecord accessTokenRecordCreateAccessToken = this.mAccountCredentialAdapter.createAccessToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
        RefreshTokenRecord refreshTokenRecordCreateRefreshToken = this.mAccountCredentialAdapter.createRefreshToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
        IdTokenRecord idTokenRecordCreateIdToken = this.mAccountCredentialAdapter.createIdToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
        validateCacheArtifacts(accountRecordCreateAccount, accessTokenRecordCreateAccessToken, refreshTokenRecordCreateRefreshToken, idTokenRecordCreateIdToken);
        saveAccounts(accountRecordCreateAccount);
        synchronized (sCacheLock) {
            saveCredentialsInternal(accessTokenRecordCreateAccessToken, refreshTokenRecordCreateRefreshToken, idTokenRecordCreateIdToken);
            removeAllRefreshTokensExcept(accountRecordCreateAccount, refreshTokenRecordCreateRefreshToken);
        }
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecordCreateAccount);
        cacheRecordBuilderBuilder.accessToken(accessTokenRecordCreateAccessToken);
        cacheRecordBuilderBuilder.refreshToken(refreshTokenRecordCreateRefreshToken);
        setToCacheRecord(cacheRecordBuilderBuilder, idTokenRecordCreateIdToken);
        return cacheRecordBuilderBuilder.build();
    }

    private void removeAllRefreshTokensExcept(AccountRecord accountRecord, RefreshTokenRecord refreshTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("deletionExemptRefreshToken is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId());
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":removeAllRefreshTokensExcept").toString(), "isFamilyRefreshToken? [" + (!zIsNullOrEmpty) + "]");
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        Logger.info(str + ":removeAllRefreshTokensExcept", "isMultiResourceCapable? [" + zEquals + "]");
        if (!zIsNullOrEmpty || zEquals) {
            String environment = accountRecord.getEnvironment();
            String clientId = refreshTokenRecord.getClientId();
            if (!zIsNullOrEmpty) {
                clientId = null;
            }
            int iRemoveCredentialsOfTypeForAccountExcept = removeCredentialsOfTypeForAccountExcept(environment, clientId, CredentialType.RefreshToken, accountRecord, true, refreshTokenRecord);
            Logger.info(str + ":removeAllRefreshTokensExcept", "Refresh tokens removed: [" + iRemoveCredentialsOfTypeForAccountExcept + "]");
            if (iRemoveCredentialsOfTypeForAccountExcept > 1) {
                Logger.warn(str + ":removeAllRefreshTokensExcept", "Multiple refresh tokens found for Account.");
            }
        }
    }

    private int removeCredentialsOfTypeForAccountExcept(String str, String str2, CredentialType credentialType, AccountRecord accountRecord, boolean z, Credential credential) {
        if (str == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (credentialType == null) {
            throw new NullPointerException("credentialType is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("targetAccount is marked non-null but is null");
        }
        if (credential == null) {
            throw new NullPointerException("deletionExemptRecord is marked non-null but is null");
        }
        int i = 0;
        for (Credential credential2 : this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), str, credentialType, str2, null, null, z ? null : accountRecord.getRealm(), null, null)) {
            if (!credential.equals(credential2) && this.mAccountCredentialCache.removeCredential(credential2)) {
                i++;
            }
        }
        return i;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(GenericOAuth2Strategy genericoauth2strategy, GenericAuthorizationRequest genericauthorizationrequest, GenericTokenResponse generictokenresponse) throws ClientException {
        List<ICacheRecord> listMergeCacheRecordWithOtherTenantCacheRecords;
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        synchronized (this) {
            listMergeCacheRecordWithOtherTenantCacheRecords = mergeCacheRecordWithOtherTenantCacheRecords(save(genericoauth2strategy, genericauthorizationrequest, generictokenresponse));
        }
        return listMergeCacheRecordWithOtherTenantCacheRecords;
    }

    ICacheRecord getSparseCacheRecordForAccount(String str, AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("acct is marked non-null but is null");
        }
        List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str, accountRecord);
        if (idTokensForAccountRecord.size() > CredentialType.ID_TOKEN_TYPES.size()) {
            Logger.warn(TAG + ":getSparseCacheRecordForAccount", "Found more IdTokens than expected.\nFound: [" + idTokensForAccountRecord.size() + "]");
        }
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
        while (it.hasNext()) {
            setToCacheRecord(cacheRecordBuilderBuilder, it.next());
        }
        return cacheRecordBuilderBuilder.build();
    }

    void removeRefreshTokenIfNeeded(AccountRecord accountRecord, RefreshTokenRecord refreshTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenRecord is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId());
        boolean z = !zIsNullOrEmpty;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":removeRefreshTokenIfNeeded").toString(), "isFamilyRefreshToken? [" + z + "]");
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        Logger.info(str + ":removeRefreshTokenIfNeeded", "isMultiResourceCapable? [" + zEquals + "]");
        if (!zIsNullOrEmpty || zEquals) {
            int iRemoveRefreshTokensForAccount = removeRefreshTokensForAccount(accountRecord, z, accountRecord.getEnvironment(), refreshTokenRecord.getClientId());
            Logger.info(str + ":removeRefreshTokenIfNeeded", "Refresh tokens removed: [" + iRemoveRefreshTokensForAccount + "]");
            if (iRemoveRefreshTokensForAccount > 1) {
                Logger.warn(str + ":removeRefreshTokenIfNeeded", "Multiple refresh tokens found for Account.");
            }
        }
    }

    private int removeRefreshTokensForAccount(AccountRecord accountRecord, boolean z, String str, String str2) {
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (z) {
            str2 = null;
        }
        return removeCredentialsOfTypeForAccount(str, str2, CredentialType.RefreshToken, accountRecord, true);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord) {
        String str;
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenToSave is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        Logger.verbose(sb.append(str2).append(":save").toString(), "Importing AccountRecord, IdTokenRecord (direct)");
        boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
        boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        if (!zIsAccountSchemaCompliant || !zIsIdTokenSchemaCompliant) {
            if (zIsAccountSchemaCompliant) {
                str = "[";
            } else {
                str = "[(Account)";
            }
            if (!zIsIdTokenSchemaCompliant) {
                str = str + "(ID)";
            }
            Logger.warn(str2 + ":save", "Skipping persistence of non-compliant credentials: " + (str + "]"));
        } else {
            saveAccounts(accountRecord);
            saveCredentialsInternal(idTokenRecord);
            cacheRecordBuilderBuilder.account(accountRecord);
            if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
                cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
            } else {
                cacheRecordBuilderBuilder.idToken(idTokenRecord);
            }
        }
        return cacheRecordBuilderBuilder.build();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        RefreshTokenRecord familyRefreshTokenForAccount;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        Telemetry.emit(new CacheStartEvent());
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        List<Credential> credentials = this.mAccountCredentialCache.getCredentials();
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(credentials, accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), getAccessTokenCredentialTypeForAuthenticationScheme(abstractAuthenticationScheme), str, str2, str3, accountRecord.getRealm(), str4, abstractAuthenticationScheme.getName(), (String) null, abstractAuthenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal ? ((PopAuthenticationSchemeWithClientKeyInternal) abstractAuthenticationScheme).getKid() : null);
        List<Credential> credentialsFilteredBy2 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.RefreshToken, str, (String) null, (String) null, zEquals ? null : accountRecord.getRealm(), zEquals ? null : str4, (String) null, credentials);
        if (credentialsFilteredBy2.isEmpty() && (familyRefreshTokenForAccount = getFamilyRefreshTokenForAccount(accountRecord)) != null) {
            credentialsFilteredBy2 = new ArrayList<>();
            credentialsFilteredBy2.add(familyRefreshTokenForAccount);
        }
        List<Credential> credentialsFilteredBy3 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        List<Credential> credentialsFilteredBy4 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.V1IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.accessToken(credentialsFilteredBy.isEmpty() ? null : (AccessTokenRecord) credentialsFilteredBy.get(0));
        cacheRecordBuilderBuilder.refreshToken(credentialsFilteredBy2.isEmpty() ? null : (RefreshTokenRecord) credentialsFilteredBy2.get(0));
        cacheRecordBuilderBuilder.idToken(credentialsFilteredBy3.isEmpty() ? null : (IdTokenRecord) credentialsFilteredBy3.get(0));
        cacheRecordBuilderBuilder.v1IdToken(credentialsFilteredBy4.isEmpty() ? null : (IdTokenRecord) credentialsFilteredBy4.get(0));
        Telemetry.emit(new CacheEndEvent().putCacheRecordStatus(cacheRecordBuilderBuilder.build()));
        return cacheRecordBuilderBuilder.build();
    }

    private RefreshTokenRecord getFamilyRefreshTokenForAccount(AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.RefreshToken, null, null, null, null, null, null);
        if (credentialsFilteredBy.isEmpty()) {
            return null;
        }
        Logger.verbose(TAG + ":getFamilyRefreshTokensForAccount", "Inspecting fallback RTs for a FoCI match.");
        for (Credential credential : credentialsFilteredBy) {
            if (credential instanceof RefreshTokenRecord) {
                RefreshTokenRecord refreshTokenRecord = (RefreshTokenRecord) credential;
                if (!StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId())) {
                    Logger.verbose(TAG + ":getFamilyRefreshTokensForAccount", "Fallback RT found.");
                    return refreshTokenRecord;
                }
            }
        }
        return null;
    }

    public RefreshTokenRecord getFamilyRefreshTokenForHomeAccountId(String str) {
        if (str == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        for (AccountRecord accountRecord : this.mAccountCredentialCache.getAccounts()) {
            if (accountRecord.getHomeAccountId().equals(str)) {
                return getFamilyRefreshTokenForAccount(accountRecord);
            }
        }
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        ArrayList arrayList;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("applicationIdentifier is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        synchronized (this) {
            arrayList = new ArrayList();
            arrayList.add(load(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme));
            for (ICacheRecord iCacheRecord : getAccountsWithAggregatedAccountData(accountRecord.getEnvironment(), str, accountRecord.getHomeAccountId())) {
                if (!accountRecord.equals(iCacheRecord.getAccount())) {
                    arrayList.add(iCacheRecord);
                }
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(String str, AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        List<Credential> credentials = this.mAccountCredentialCache.getCredentials();
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        credentialsFilteredBy.addAll(this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.V1IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials));
        for (Credential credential : credentialsFilteredBy) {
            if (credential instanceof IdTokenRecord) {
                arrayList.add((IdTokenRecord) credential);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(Credential credential) {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":removeCredential").toString(), "Removing credential...");
        Logger.verbosePII(str + ":removeCredential", "ClientId: [" + credential.getClientId() + "]\nCredentialType: [" + credential.getCredentialType() + "]\nCachedAt: [" + credential.getCachedAt() + "]\nEnvironment: [" + credential.getEnvironment() + "]\nHomeAccountId: [" + credential.getHomeAccountId() + "]\nIsExpired?: [" + credential.isExpired() + "]");
        return this.mAccountCredentialCache.removeCredential(credential);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccount(String str, String str2, String str3, String str4) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str5 = TAG;
        Logger.verbosePII(sb.append(str5).append(":getAccount").toString(), "Environment: [" + str + "]\nClientId: [" + str2 + "]\nHomeAccountId: [" + str3 + "]\nRealm: [" + str4 + "]");
        List<AccountRecord> accounts = getAccounts(str, str2);
        Logger.info(str5 + ":getAccount", "Found " + accounts.size() + " accounts");
        for (AccountRecord accountRecord : accounts) {
            if (str3.equals(accountRecord.getHomeAccountId()) && (str4 == null || str4.equals(accountRecord.getRealm()))) {
                return accountRecord;
            }
        }
        Logger.warn(TAG + ":getAccount", "No matching account found.");
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        AccountRecord account = getAccount(str, str2, str3, null);
        if (account != null) {
            Iterator<AccountRecord> it = getAllTenantAccountsForAccountByClientId(str2, account).iterator();
            while (it.hasNext()) {
                arrayList.add(getSparseCacheRecordForAccount(str2, it.next()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByLocalAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        Logger.verbosePII(sb.append(str4).append(":getAccountByLocalAccountId").toString(), "LocalAccountId: [" + str3 + "]");
        List<AccountRecord> accounts = this.mAccountCredentialCache.getAccounts();
        if (accounts.isEmpty()) {
            Logger.warn(str4 + ":getAccountByLocalAccountId", "No accounts found in the cache.");
            return null;
        }
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy((String) null, str, new HashSet(Arrays.asList(CredentialType.IdToken, CredentialType.V1IdToken, CredentialType.RefreshToken)), str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        for (AccountRecord accountRecord : accounts) {
            if (accountRecord.getLocalAccountId().equals(str3) && accountHasCredential(accountRecord, credentialsFilteredBy)) {
                return accountRecord;
            }
        }
        return null;
    }

    public List<AccountRecord> getAccountsByUsername(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        List<AccountRecord> accounts = getAccounts(str, str2);
        for (AccountRecord accountRecord : accounts) {
            if (StringUtil.equalsIgnoreCase(accountRecord.getUsername(), str3)) {
                arrayList.add(accountRecord);
            }
        }
        Logger.verbose(TAG + ":getAccountsByUsername", "Found " + accounts.size() + " accounts matching username.");
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        AccountRecord accountByLocalAccountId = getAccountByLocalAccountId(str, str2, str3);
        if (accountByLocalAccountId == null) {
            return null;
        }
        List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str2, accountByLocalAccountId);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountByLocalAccountId);
        Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
        while (it.hasNext()) {
            setToCacheRecord(cacheRecordBuilderBuilder, it.next());
        }
        return cacheRecordBuilderBuilder.build();
    }

    private void setToCacheRecord(CacheRecord.CacheRecordBuilder cacheRecordBuilder, IdTokenRecord idTokenRecord) {
        if (cacheRecordBuilder == null) {
            throw new NullPointerException("target is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        CredentialType credentialTypeFromString = CredentialType.fromString(idTokenRecord.getCredentialType());
        if (credentialTypeFromString != null) {
            if (CredentialType.V1IdToken == credentialTypeFromString) {
                cacheRecordBuilder.v1IdToken(idTokenRecord);
            } else if (CredentialType.IdToken == credentialTypeFromString) {
                cacheRecordBuilder.idToken(idTokenRecord);
            } else {
                Logger.warn(TAG + ":setToCacheRecord", "Unrecognized IdToken type: " + idTokenRecord.getCredentialType());
            }
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str3 = TAG;
        Logger.verbosePII(sb.append(str3).append(":getAccounts").toString(), "Environment: [" + str + "]\nClientId: [" + str2 + "]");
        ArrayList arrayList = new ArrayList();
        List<AccountRecord> accountsFilteredBy = this.mAccountCredentialCache.getAccountsFilteredBy(null, str, null);
        Logger.verbose(str3 + ":getAccounts", "Found " + accountsFilteredBy.size() + " accounts for this environment");
        if (accountsFilteredBy.isEmpty()) {
            return Collections.unmodifiableList(arrayList);
        }
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy((String) null, str, new HashSet(Arrays.asList(CredentialType.IdToken, CredentialType.V1IdToken, CredentialType.RefreshToken)), str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        for (AccountRecord accountRecord : accountsFilteredBy) {
            if (accountHasCredential(accountRecord, credentialsFilteredBy)) {
                arrayList.add(accountRecord);
            }
        }
        Logger.verbose(TAG + ":getAccounts", "Found " + arrayList.size() + " accounts for this clientId");
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String str, AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(accountRecord);
        List<AccountRecord> accountsFilteredBy = this.mAccountCredentialCache.getAccountsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), null);
        for (AccountRecord accountRecord2 : getAccounts(accountRecord.getEnvironment(), str)) {
            if (accountsFilteredBy.contains(accountRecord2) && !accountRecord.equals(accountRecord2)) {
                arrayList.add(accountRecord2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        for (AccountRecord accountRecord : getAccounts(str, str2)) {
            List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str2, accountRecord);
            if (idTokensForAccountRecord != null && idTokensForAccountRecord.size() != 0) {
                CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                cacheRecordBuilderBuilder.account(accountRecord);
                Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
                while (it.hasNext()) {
                    setToCacheRecord(cacheRecordBuilderBuilder, it.next());
                }
                arrayList.add(cacheRecordBuilderBuilder.build());
            }
        }
        Logger.verbose(TAG + ":getAccountsWithAggregatedAccountData", "Found " + arrayList.size() + " accounts with IdTokens");
        return Collections.unmodifiableList(arrayList);
    }

    private CredentialType getAccessTokenCredentialTypeForAuthenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        if ("Bearer".equalsIgnoreCase(abstractAuthenticationScheme.getName())) {
            return CredentialType.AccessToken;
        }
        return CredentialType.AccessToken_With_AuthScheme;
    }

    private boolean accountHasCredential(AccountRecord accountRecord, List<Credential> list) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("appCredentials is marked non-null but is null");
        }
        String homeAccountId = accountRecord.getHomeAccountId();
        String environment = accountRecord.getEnvironment();
        Logger.verbosePII(TAG + ":accountHasCredential", "HomeAccountId: [" + homeAccountId + "]\nEnvironment: [" + environment + "]");
        for (Credential credential : list) {
            if (homeAccountId.equals(credential.getHomeAccountId()) && environment.equals(credential.getEnvironment())) {
                Logger.verbose(TAG + ":accountHasCredential", "Credentials located for account.");
                return true;
            }
        }
        return false;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4) {
        return removeAccount(str, str2, str3, str4, CredentialType.AccessToken, CredentialType.AccessToken_With_AuthScheme, CredentialType.RefreshToken, CredentialType.IdToken, CredentialType.V1IdToken);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr) {
        AccountRecord account;
        MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> msalOAuth2TokenCache;
        String str5;
        StringBuilder sb = new StringBuilder();
        String str6 = TAG;
        Logger.verbosePII(sb.append(str6).append(":removeAccount").toString(), "Environment: [" + str + "]\nClientId: [" + str2 + "]\nHomeAccountId: [" + str3 + "]\nRealm: [" + str4 + "]\nCredentialTypes to delete: [" + Arrays.toString(credentialTypeArr) + "]");
        if (str2 == null || str3 == null || (account = getAccount(str, str2, str3, str4)) == null) {
            Logger.warn(str6 + ":removeAccount", "Insufficient filtering provided for account removal - preserving Account.");
            return new AccountDeletionRecord(null);
        }
        boolean z = str4 == null;
        Logger.verbose(str6 + ":removeAccount", "IsRealmAgnostic? " + z);
        if (credentialTypeArr != null && credentialTypeArr.length > 0) {
            int length = credentialTypeArr.length;
            int i = 0;
            while (i < length) {
                CredentialType credentialType = credentialTypeArr[i];
                MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> msalOAuth2TokenCache2 = this;
                String str7 = str;
                String str8 = str2;
                Logger.info(TAG + ":removeAccount", "Removed " + msalOAuth2TokenCache2.removeCredentialsOfTypeForAccount(str7, str8, credentialType, account, z) + " credentials of type: " + credentialType);
                i++;
                this = msalOAuth2TokenCache2;
                str = str7;
                str2 = str8;
            }
            msalOAuth2TokenCache = this;
            str5 = str;
        } else {
            msalOAuth2TokenCache = this;
            str5 = str;
            Logger.warn(str6 + ":removeAccount", "removeAccount called, but no CredentialTypes to remove specified");
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (AccountRecord accountRecord : msalOAuth2TokenCache.mAccountCredentialCache.getAccountsFilteredBy(str3, str5, null)) {
                if (msalOAuth2TokenCache.mAccountCredentialCache.removeAccount(accountRecord)) {
                    arrayList.add(accountRecord);
                }
            }
        } else if (msalOAuth2TokenCache.mAccountCredentialCache.removeAccount(account)) {
            arrayList.add(account);
        }
        return new AccountDeletionRecord(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        Logger.warn(TAG + ":clearAll", "Clearing cache.");
        this.mAccountCredentialCache.clearAll();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    protected Set<String> getAllClientIds() {
        HashSet hashSet = new HashSet();
        Iterator<Credential> it = this.mAccountCredentialCache.getCredentials().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getClientId());
        }
        Logger.verbose(TAG + ":getAllClientIds", "Found [" + hashSet.size() + "] clientIds/");
        return hashSet;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByHomeAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        List<AccountRecord> accounts = getAccounts(str, str2);
        Logger.verbosePII(TAG + ":getAccountByHomeAccountId", "homeAccountId: [" + str3 + "]");
        for (AccountRecord accountRecord : accounts) {
            if (str3.equals(accountRecord.getHomeAccountId())) {
                return accountRecord;
            }
        }
        return null;
    }

    private int removeCredentialsOfTypeForAccount(String str, String str2, CredentialType credentialType, AccountRecord accountRecord, boolean z) {
        if (credentialType == null) {
            throw new NullPointerException("credentialType is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("targetAccount is marked non-null but is null");
        }
        Iterator<Credential> it = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), str, credentialType, str2, null, null, z ? null : accountRecord.getRealm(), null, null).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.mAccountCredentialCache.removeCredential(it.next())) {
                i++;
            }
        }
        return i;
    }

    private void saveAccounts(AccountRecord... accountRecordArr) {
        for (AccountRecord accountRecord : accountRecordArr) {
            this.mAccountCredentialCache.saveAccount(accountRecord);
        }
    }

    void saveCredentialsInternal(Credential... credentialArr) {
        saveCredentialsInternal(false, credentialArr);
    }

    void saveCredentialsInternal(boolean z, Credential... credentialArr) {
        for (Credential credential : credentialArr) {
            if (credential != null) {
                if (credential instanceof AccessTokenRecord) {
                    deleteAccessTokensWithIntersectingScopes((AccessTokenRecord) credential, z);
                }
                this.mAccountCredentialCache.saveCredential(credential);
            }
        }
    }

    void validateCacheArtifacts(AccountRecord accountRecord, AccessTokenRecord accessTokenRecord, RefreshTokenRecord refreshTokenRecord, IdTokenRecord idTokenRecord) throws ClientException {
        String str;
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenToSave is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenToSave is marked non-null but is null");
        }
        Logger.verbose(TAG + ":validateCacheArtifacts", "Validating cache artifacts...");
        boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
        boolean z = accessTokenRecord == null || isAccessTokenSchemaCompliant(accessTokenRecord);
        boolean zIsRefreshTokenSchemaCompliant = isRefreshTokenSchemaCompliant(refreshTokenRecord);
        boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
        if (!zIsAccountSchemaCompliant) {
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        if (z && zIsRefreshTokenSchemaCompliant && zIsIdTokenSchemaCompliant) {
            return;
        }
        if (z) {
            str = "[";
        } else {
            str = "[(AT)";
        }
        if (!zIsRefreshTokenSchemaCompliant) {
            str = str + "(RT)";
        }
        if (!zIsIdTokenSchemaCompliant) {
            str = str + "(ID)";
        }
        throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, str + "]");
    }

    private void deleteAccessTokensWithIntersectingScopes(AccessTokenRecord accessTokenRecord, boolean z) {
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accessTokenRecord.getHomeAccountId(), accessTokenRecord.getEnvironment(), CredentialType.fromString(accessTokenRecord.getCredentialType()), accessTokenRecord.getClientId(), accessTokenRecord.getApplicationIdentifier(), accessTokenRecord.getMamEnrollmentIdentifier(), accessTokenRecord.getRealm(), (String) null, accessTokenRecord.getAccessTokenType(), accessTokenRecord.getRequestedClaims(), z, this.mAccountCredentialCache.getCredentials());
        Logger.verbose(TAG + ":deleteAccessTokensWithIntersectingScopes", "Inspecting " + credentialsFilteredBy.size() + " accessToken[s].");
        for (Credential credential : credentialsFilteredBy) {
            if (scopesIntersect(accessTokenRecord, (AccessTokenRecord) credential, true)) {
                Logger.infoPII(TAG + ":deleteAccessTokensWithIntersectingScopes", "Removing credential: " + credential);
                this.mAccountCredentialCache.removeCredential(credential);
            }
        }
    }

    private boolean scopesIntersect(AccessTokenRecord accessTokenRecord, AccessTokenRecord accessTokenRecord2, boolean z) {
        Set<String> setScopesAsSet = scopesAsSet(accessTokenRecord);
        Set<String> setScopesAsSet2 = scopesAsSet(accessTokenRecord2);
        if (z) {
            setScopesAsSet.removeAll(AuthenticationConstants.DEFAULT_SCOPES);
            setScopesAsSet2.removeAll(AuthenticationConstants.DEFAULT_SCOPES);
        }
        for (String str : setScopesAsSet2) {
            if (setScopesAsSet.contains(str)) {
                StringBuilder sb = new StringBuilder();
                String str2 = TAG;
                Logger.info(sb.append(str2).append(":scopesIntersect").toString(), "Scopes intersect.");
                Logger.infoPII(str2 + ":scopesIntersect", setScopesAsSet.toString() + " contains [" + str + "]");
                return true;
            }
        }
        return false;
    }

    private Set<String> scopesAsSet(AccessTokenRecord accessTokenRecord) {
        String target = accessTokenRecord.getTarget();
        if (!StringUtil.isNullOrEmpty(target)) {
            String[] strArrSplit = target.split("\\s+");
            HashSet hashSet = new HashSet();
            for (String str : strArrSplit) {
                hashSet.add(str.toLowerCase(Locale.US));
            }
            return hashSet;
        }
        return new HashSet();
    }

    private static boolean isSchemaCompliant(Class<?> cls, String[][] strArr) {
        boolean z = true;
        for (String[] strArr2 : strArr) {
            z = z && !StringUtil.isNullOrEmpty(strArr2[1]);
        }
        if (!z) {
            Logger.warn(TAG + ":isSchemaCompliant", cls.getSimpleName() + " does not contain all required fields.");
            for (String[] strArr3 : strArr) {
                Logger.warn(TAG + ":isSchemaCompliant", strArr3[0] + " is null? [" + StringUtil.isNullOrEmpty(strArr3[1]) + "]");
            }
        }
        return z;
    }

    private boolean isAccountSchemaCompliant(AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        return isSchemaCompliant(accountRecord.getClass(), new String[][]{new String[]{"home_account_id", accountRecord.getHomeAccountId()}, new String[]{"environment", accountRecord.getEnvironment()}, new String[]{AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID, accountRecord.getLocalAccountId()}, new String[]{"username", accountRecord.getUsername()}, new String[]{AccountRecord.SerializedNames.AUTHORITY_TYPE, accountRecord.getAuthorityType()}});
    }

    boolean isAccessTokenSchemaCompliant(AccessTokenRecord accessTokenRecord) {
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        return isSchemaCompliant(accessTokenRecord.getClass(), new String[][]{new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, accessTokenRecord.getCredentialType()}, new String[]{"home_account_id", accessTokenRecord.getHomeAccountId()}, new String[]{"environment", accessTokenRecord.getEnvironment()}, new String[]{"client_id", accessTokenRecord.getClientId()}, new String[]{"target", accessTokenRecord.getTarget()}, new String[]{Credential.SerializedNames.CACHED_AT, accessTokenRecord.getCachedAt()}, new String[]{Credential.SerializedNames.EXPIRES_ON, accessTokenRecord.getExpiresOn()}, new String[]{Credential.SerializedNames.SECRET, accessTokenRecord.getSecret()}});
    }

    private boolean isRefreshTokenSchemaCompliant(RefreshTokenRecord refreshTokenRecord) {
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        return isSchemaCompliant(refreshTokenRecord.getClass(), new String[][]{new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, refreshTokenRecord.getCredentialType()}, new String[]{"environment", refreshTokenRecord.getEnvironment()}, new String[]{"home_account_id", refreshTokenRecord.getHomeAccountId()}, new String[]{"client_id", refreshTokenRecord.getClientId()}, new String[]{Credential.SerializedNames.SECRET, refreshTokenRecord.getSecret()}});
    }

    private boolean isIdTokenSchemaCompliant(IdTokenRecord idTokenRecord) {
        if (idTokenRecord == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        return isSchemaCompliant(idTokenRecord.getClass(), new String[][]{new String[]{"home_account_id", idTokenRecord.getHomeAccountId()}, new String[]{"environment", idTokenRecord.getEnvironment()}, new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, idTokenRecord.getCredentialType()}, new String[]{"client_id", idTokenRecord.getClientId()}, new String[]{Credential.SerializedNames.SECRET, idTokenRecord.getSecret()}});
    }

    protected IAccountCredentialCache getAccountCredentialCache() {
        return this.mAccountCredentialCache;
    }

    IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> getAccountCredentialAdapter() {
        return this.mAccountCredentialAdapter;
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public void setSingleSignOnState(GenericAccount genericaccount, GenericRefreshToken genericrefreshtoken) throws ClientException {
        Logger.info(TAG + ":setSingleSignOnState", "Set SSO state called.");
        AccountRecord accountRecordAsAccount = this.mAccountCredentialAdapter.asAccount(genericaccount);
        RefreshTokenRecord refreshTokenRecordAsRefreshToken = this.mAccountCredentialAdapter.asRefreshToken(genericrefreshtoken);
        IdTokenRecord idTokenRecordAsIdToken = this.mAccountCredentialAdapter.asIdToken(genericaccount, genericrefreshtoken);
        validateCacheArtifacts(accountRecordAsAccount, null, refreshTokenRecordAsRefreshToken, idTokenRecordAsIdToken);
        saveAccounts(accountRecordAsAccount);
        synchronized (sCacheLock) {
            saveCredentialsInternal(idTokenRecordAsIdToken, refreshTokenRecordAsRefreshToken);
            removeAllRefreshTokensExcept(accountRecordAsAccount, refreshTokenRecordAsRefreshToken);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public GenericRefreshToken getSingleSignOnState(GenericAccount genericaccount) {
        throw new UnsupportedOperationException("Unimplemented!");
    }
}
