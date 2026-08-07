package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends MicrosoftTokenResponse, GenericAccount extends MicrosoftAccount, GenericRefreshToken extends MicrosoftRefreshToken> extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse> {
    private static final String TAG = "BrokerOAuth2TokenCache";
    private static final String UNCHECKED = "unchecked";
    private final IBrokerApplicationMetadataCache mApplicationMetadataCache;
    private ProcessUidCacheFactory mDelegate;
    private final MicrosoftFamilyOAuth2TokenCache mFociCache;
    private final int mUid;

    public interface ProcessUidCacheFactory {
        MsalOAuth2TokenCache getTokenCache(IPlatformComponents iPlatformComponents, int i);
    }

    public BrokerOAuth2TokenCache(IPlatformComponents iPlatformComponents, int i, IBrokerApplicationMetadataCache iBrokerApplicationMetadataCache) {
        super(iPlatformComponents);
        this.mDelegate = null;
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iBrokerApplicationMetadataCache == null) {
            throw new NullPointerException("applicationMetadataCache is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append("ctor").toString(), "Init::" + str);
        this.mUid = i;
        this.mFociCache = initializeFociCache(getComponents());
        this.mApplicationMetadataCache = iBrokerApplicationMetadataCache;
    }

    public BrokerOAuth2TokenCache(IPlatformComponents iPlatformComponents, int i, IBrokerApplicationMetadataCache iBrokerApplicationMetadataCache, ProcessUidCacheFactory processUidCacheFactory, MicrosoftFamilyOAuth2TokenCache microsoftFamilyOAuth2TokenCache) {
        super(iPlatformComponents);
        this.mDelegate = null;
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iBrokerApplicationMetadataCache == null) {
            throw new NullPointerException("applicationMetadataCache is marked non-null but is null");
        }
        if (processUidCacheFactory == null) {
            throw new NullPointerException("delegate is marked non-null but is null");
        }
        if (microsoftFamilyOAuth2TokenCache == null) {
            throw new NullPointerException("fociCache is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append("ctor").toString(), "Init::" + str);
        this.mApplicationMetadataCache = iBrokerApplicationMetadataCache;
        this.mUid = i;
        this.mDelegate = processUidCacheFactory;
        this.mFociCache = microsoftFamilyOAuth2TokenCache;
    }

    @Deprecated
    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord, String str) throws ClientException {
        ICacheRecord iCacheRecordSave;
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        Logger.info(sb.append(str2).append(":save (4 args)").toString(), "Saving to FOCI cache? [" + (!zIsNullOrEmpty) + "]");
        if (!zIsNullOrEmpty) {
            iCacheRecordSave = this.mFociCache.save(accountRecord, idTokenRecord, accessTokenRecord);
        } else {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(idTokenRecord.getClientId(), idTokenRecord.getEnvironment(), this.mUid);
            if (tokenCacheForClient == null) {
                Logger.warn(str2 + ":save (4 args)", "Existing cache not found. A new one will be created.");
                tokenCacheForClient = initializeProcessUidCache(getComponents(), this.mUid);
            }
            iCacheRecordSave = tokenCacheForClient.save(accountRecord, idTokenRecord, accessTokenRecord);
        }
        updateApplicationMetadataCache(iCacheRecordSave.getAccessToken().getClientId(), iCacheRecordSave.getAccessToken().getEnvironment(), str, this.mUid);
        return iCacheRecordSave;
    }

    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord, RefreshTokenRecord refreshTokenRecord, String str) throws ClientException {
        ICacheRecord iCacheRecordSave;
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
        Logger.info(TAG + ":save (5 args)", "Saving to FOCI cache? [" + (!zIsNullOrEmpty) + "]");
        if (!zIsNullOrEmpty) {
            iCacheRecordSave = this.mFociCache.save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord);
        } else {
            iCacheRecordSave = initializeProcessUidCache(getComponents(), this.mUid).save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord);
        }
        updateApplicationMetadataCache(iCacheRecordSave.getAccessToken().getClientId(), iCacheRecordSave.getAccessToken().getEnvironment(), str, this.mUid);
        return iCacheRecordSave;
    }

    @Deprecated
    public synchronized List<ICacheRecord> saveAndLoadAggregatedAccountData(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord, String str, AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException {
        List<ICacheRecord> listLoadAggregatedAccountData;
        try {
            if (accountRecord == null) {
                throw new NullPointerException("accountRecord is marked non-null but is null");
            }
            if (idTokenRecord == null) {
                throw new NullPointerException("idTokenRecord is marked non-null but is null");
            }
            if (accessTokenRecord == null) {
                throw new NullPointerException("accessTokenRecord is marked non-null but is null");
            }
            if (abstractAuthenticationScheme == null) {
                throw new NullPointerException("authScheme is marked non-null but is null");
            }
            synchronized (this) {
                listLoadAggregatedAccountData = loadAggregatedAccountData(abstractAuthenticationScheme, save(accountRecord, idTokenRecord, accessTokenRecord, str));
            }
            return listLoadAggregatedAccountData;
        } catch (Throwable th) {
            throw th;
        }
        return listLoadAggregatedAccountData;
    }

    public synchronized List<ICacheRecord> saveAndLoadAggregatedAccountData(AccountRecord accountRecord, IdTokenRecord idTokenRecord, AccessTokenRecord accessTokenRecord, RefreshTokenRecord refreshTokenRecord, String str, AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException {
        List<ICacheRecord> listLoadAggregatedAccountData;
        try {
            if (accountRecord == null) {
                throw new NullPointerException("accountRecord is marked non-null but is null");
            }
            if (idTokenRecord == null) {
                throw new NullPointerException("idTokenRecord is marked non-null but is null");
            }
            if (accessTokenRecord == null) {
                throw new NullPointerException("accessTokenRecord is marked non-null but is null");
            }
            if (abstractAuthenticationScheme == null) {
                throw new NullPointerException("authScheme is marked non-null but is null");
            }
            synchronized (this) {
                listLoadAggregatedAccountData = loadAggregatedAccountData(abstractAuthenticationScheme, save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord, str));
            }
            return listLoadAggregatedAccountData;
        } catch (Throwable th) {
            throw th;
        }
        return listLoadAggregatedAccountData;
    }

    private List<ICacheRecord> loadAggregatedAccountData(AbstractAuthenticationScheme abstractAuthenticationScheme, ICacheRecord iCacheRecord) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        String clientId = iCacheRecord.getAccessToken().getClientId();
        String target = iCacheRecord.getAccessToken().getTarget();
        String environment = iCacheRecord.getAccessToken().getEnvironment();
        String applicationIdentifier = iCacheRecord.getAccessToken().getApplicationIdentifier();
        String mamEnrollmentIdentifier = iCacheRecord.getAccessToken().getMamEnrollmentIdentifier();
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(clientId, environment, this.mUid);
        if (tokenCacheForClient == null) {
            Logger.warn(TAG + ":loadAggregatedAccountData", "Cache not found for clientid: " + clientId + "environment:" + environment + "processUid: " + this.mUid);
            return null;
        }
        return tokenCacheForClient.loadWithAggregatedAccountData(clientId, applicationIdentifier, mamEnrollmentIdentifier, target, iCacheRecord.getAccount(), abstractAuthenticationScheme);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(GenericOAuth2Strategy genericoauth2strategy, GenericAuthorizationRequest genericauthorizationrequest, GenericTokenResponse generictokenresponse) throws ClientException {
        OAuth2TokenCache oAuth2TokenCacheInitializeProcessUidCache;
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(generictokenresponse.getFamilyId());
        boolean z = !zIsNullOrEmpty;
        if (!zIsNullOrEmpty) {
            Logger.verbose(TAG + ":save", "Received FOCI value: [" + generictokenresponse.getFamilyId() + "]");
        }
        Logger.info(TAG + ":save", "Saving to FOCI cache? [" + z + "]");
        if (!zIsNullOrEmpty) {
            oAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
        } else {
            oAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid);
        }
        ICacheRecord iCacheRecordSave = oAuth2TokenCacheInitializeProcessUidCache.save(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
        updateApplicationMetadataCache(iCacheRecordSave.getRefreshToken().getClientId(), iCacheRecordSave.getRefreshToken().getEnvironment(), iCacheRecordSave.getRefreshToken().getFamilyId(), this.mUid);
        return iCacheRecordSave;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(GenericOAuth2Strategy genericoauth2strategy, GenericAuthorizationRequest genericauthorizationrequest, GenericTokenResponse generictokenresponse) throws ClientException {
        OAuth2TokenCache oAuth2TokenCacheInitializeProcessUidCache;
        List<ICacheRecord> listSaveAndLoadAggregatedAccountData;
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
            boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(generictokenresponse.getFamilyId());
            Logger.info(TAG + ":saveAndLoadAggregatedAccountData", "Saving to FOCI cache? [" + (!zIsNullOrEmpty) + "]");
            if (!zIsNullOrEmpty) {
                oAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
            } else {
                oAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid);
            }
            listSaveAndLoadAggregatedAccountData = oAuth2TokenCacheInitializeProcessUidCache.saveAndLoadAggregatedAccountData(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            ICacheRecord iCacheRecord = listSaveAndLoadAggregatedAccountData.get(0);
            updateApplicationMetadataCache(iCacheRecord.getRefreshToken().getClientId(), iCacheRecord.getRefreshToken().getEnvironment(), iCacheRecord.getRefreshToken().getFamilyId(), this.mUid);
        }
        return listSaveAndLoadAggregatedAccountData;
    }

    private void updateApplicationMetadataCache(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        BrokerApplicationMetadata brokerApplicationMetadata = new BrokerApplicationMetadata();
        brokerApplicationMetadata.setClientId(str);
        brokerApplicationMetadata.setEnvironment(str2);
        brokerApplicationMetadata.setFoci(str3);
        brokerApplicationMetadata.setUid(i);
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        Logger.verbose(sb.append(str4).append(":updateApplicationMetadataCache").toString(), "Adding cache entry for clientId: [" + str + "]");
        Logger.info(str4 + ":updateApplicationMetadataCache", "Cache updated successfully? [" + this.mApplicationMetadataCache.insert(brokerApplicationMetadata) + "]");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        boolean z;
        ICacheRecord iCacheRecordLoad;
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
        StringBuilder sb = new StringBuilder();
        String str5 = TAG;
        Logger.verbose(sb.append(str5).append(":load").toString(), "Performing lookup in app-specific cache.");
        BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, accountRecord.getEnvironment(), this.mUid);
        if (metadata != null) {
            z = metadata.getFoci() != null;
            Logger.info(str5 + ":load", "App is known foci? " + z);
        } else {
            z = false;
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, accountRecord.getEnvironment(), this.mUid);
        boolean z2 = tokenCacheForClient == null || z;
        Logger.info(str5 + ":load", "Loading from FOCI cache? [" + z2 + "]");
        if (z2) {
            iCacheRecordLoad = this.mFociCache.loadByFamilyId(str, str4, accountRecord, abstractAuthenticationScheme);
        } else {
            iCacheRecordLoad = tokenCacheForClient.load(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
        }
        Logger.verbose(str5 + ":load", "Result found? [" + (iCacheRecordLoad.getRefreshToken() != null) + "]");
        return iCacheRecordLoad;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        boolean z;
        List<ICacheRecord> listLoadWithAggregatedAccountData;
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
            BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, accountRecord.getEnvironment(), this.mUid);
            boolean z2 = true;
            if (metadata != null) {
                z = metadata.getFoci() != null;
                Logger.info(TAG + ":loadWithAggregatedAccountData", "App is known foci? " + z);
            } else {
                z = false;
            }
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(metadata);
            boolean z3 = tokenCacheForClient == null;
            StringBuilder sb = new StringBuilder();
            String str5 = TAG;
            Logger.info(sb.append(str5).append(":loadWithAggregatedAccountData").toString(), "Loading from FOCI cache? [" + (z || z3) + "]");
            if (z3) {
                listLoadWithAggregatedAccountData = new ArrayList<>();
                listLoadWithAggregatedAccountData.add(this.mFociCache.loadByFamilyId(str, str4, accountRecord, abstractAuthenticationScheme));
            } else if (z) {
                listLoadWithAggregatedAccountData = this.mFociCache.loadByFamilyIdWithAggregatedAccountData(str, str4, accountRecord, abstractAuthenticationScheme);
            } else {
                listLoadWithAggregatedAccountData = tokenCacheForClient.loadWithAggregatedAccountData(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
            }
            if (listLoadWithAggregatedAccountData.isEmpty() || listLoadWithAggregatedAccountData.get(0).getRefreshToken() == null) {
                z2 = false;
            }
            Logger.verbose(str5 + ":loadWithAggregatedAccountData", "Result found? [" + z2 + "]");
        }
        return listLoadWithAggregatedAccountData;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(Credential credential) {
        boolean zRemoveCredential;
        if (credential == null) {
            throw new NullPointerException("credential is marked non-null but is null");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(credential.getClientId(), credential.getEnvironment(), this.mUid);
        if (tokenCacheForClient == null) {
            Logger.warn(TAG + ":removeCredential", "Could not remove credential. Cache not found.");
            zRemoveCredential = false;
        } else {
            zRemoveCredential = tokenCacheForClient.removeCredential(credential);
        }
        Logger.verbose(TAG + ":removeCredential", "Credential removed? [" + zRemoveCredential + "]");
        return zRemoveCredential;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccount(String str, String str2, String str3, String str4) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                Logger.verbose(TAG + ":getAccount", "Target cache was null. Using FOCI cache.");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccount(str, str2, str3, str4);
        }
        Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
        AccountRecord account = null;
        while (account == null && it.hasNext()) {
            account = it.next().getAccount(null, str2, str3, str4);
        }
        return account;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                Logger.verbose(TAG + ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccountsWithAggregatedAccountData(str, str2, str3);
        }
        List<OAuth2TokenCache> tokenCachesForClientId = getTokenCachesForClientId(str2);
        ArrayList arrayList = new ArrayList();
        Iterator<OAuth2TokenCache> it = tokenCachesForClientId.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAccountsWithAggregatedAccountData(null, str2, str3));
        }
        return arrayList;
    }

    private List<OAuth2TokenCache> getTokenCachesForClientId(String str) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        List<BrokerApplicationMetadata> all = this.mApplicationMetadataCache.getAll();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        for (BrokerApplicationMetadata brokerApplicationMetadata : all) {
            if (str.equals(brokerApplicationMetadata.getClientId())) {
                if (brokerApplicationMetadata.getFoci() != null && !z) {
                    arrayList.add(this.mFociCache);
                    z = true;
                } else if (!z2 && (msalOAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid)) != null) {
                    arrayList.add(msalOAuth2TokenCacheInitializeProcessUidCache);
                    z2 = true;
                }
            }
        }
        return arrayList;
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
        Logger.verbose(sb.append(str4).append(":getAccountByLocalAccountId").toString(), "Loading account by local account id.");
        if (str != null) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            Logger.info(str4 + ":getAccountByLocalAccountId", "Loading from FOCI cache? [" + (tokenCacheForClient == null) + "]");
            if (tokenCacheForClient != null) {
                return tokenCacheForClient.getAccountByLocalAccountId(str, str2, str3);
            }
            return this.mFociCache.getAccountByLocalAccountId(str, str2, str3);
        }
        Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
        AccountRecord accountByLocalAccountId = null;
        while (accountByLocalAccountId == null && it.hasNext()) {
            accountByLocalAccountId = it.next().getAccountByLocalAccountId(null, str2, str3);
        }
        return accountByLocalAccountId;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        if (str != null) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            Logger.info(TAG + ":getAccountWithAggregatedAccountDataByLocalAccountId", "Loading from FOCI cache? [" + (tokenCacheForClient == null) + "]");
            if (tokenCacheForClient != null) {
                return tokenCacheForClient.getAccountWithAggregatedAccountDataByLocalAccountId(str, str2, str3);
            }
            return this.mFociCache.getAccountWithAggregatedAccountDataByLocalAccountId(str, str2, str3);
        }
        Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
        ICacheRecord accountWithAggregatedAccountDataByLocalAccountId = null;
        while (accountWithAggregatedAccountDataByLocalAccountId == null && it.hasNext()) {
            accountWithAggregatedAccountDataByLocalAccountId = it.next().getAccountWithAggregatedAccountDataByLocalAccountId(null, str2, str3);
        }
        return accountWithAggregatedAccountDataByLocalAccountId;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                Logger.warn(TAG + ":getAccounts (2 param)", "No caches to inspect.");
                return arrayList;
            }
            arrayList.addAll(tokenCacheForClient.getAccounts(str, str2));
            return arrayList;
        }
        for (OAuth2TokenCache oAuth2TokenCache : getTokenCachesForClientId(str2)) {
            if (oAuth2TokenCache != null) {
                arrayList.addAll(oAuth2TokenCache.getAccounts(null, str2));
            }
        }
        Logger.verbose(TAG + ":getAccounts (2 param)", "Found [" + arrayList.size() + "] accounts.");
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String str, AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, accountRecord.getEnvironment(), this.mUid);
        if (tokenCacheForClient == null) {
            Logger.warn(TAG + ":getAllTenantAccountsForAccountByClientId", "Cache not found for clientid: " + str + "environment:" + accountRecord.getEnvironment() + "processUid: " + this.mUid);
            return Collections.emptyList();
        }
        return tokenCacheForClient.getAllTenantAccountsForAccountByClientId(str, accountRecord);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                Logger.verbose(TAG + ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccountsWithAggregatedAccountData(str, str2);
        }
        List<OAuth2TokenCache> tokenCachesForClientId = getTokenCachesForClientId(str2);
        ArrayList arrayList = new ArrayList();
        Iterator<OAuth2TokenCache> it = tokenCachesForClientId.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAccountsWithAggregatedAccountData(null, str2));
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(String str, AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        String environment = accountRecord.getEnvironment();
        if (str == null) {
            throw new UnsupportedOperationException("Aggregating IdTokens across ClientIds is not supported - do you have a feature request?");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, environment, this.mUid);
        if (tokenCacheForClient == null) {
            Logger.warn(TAG + ":getIdTokensForAccountRecord", "Cache not found for clientid: " + str + "environment:" + accountRecord.getEnvironment() + "processUid: " + this.mUid);
            return Collections.emptyList();
        }
        return tokenCacheForClient.getIdTokensForAccountRecord(str, accountRecord);
    }

    public List<AccountRecord> getAccounts() {
        HashSet hashSet = new HashSet();
        Iterator<BrokerApplicationMetadata> it = this.mApplicationMetadataCache.getAll().iterator();
        while (it.hasNext()) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(it.next());
            if (tokenCacheForClient != null) {
                hashSet.addAll(tokenCacheForClient.getAccountCredentialCache().getAccounts());
            }
        }
        hashSet.addAll(this.mFociCache.getAccountCredentialCache().getAccounts());
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.verbose(TAG + ":getAccounts", "Found [" + arrayList.size() + "] accounts.");
        return arrayList;
    }

    public AccountDeletionRecord removeAccountFromDevice(AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        Set<String> allClientIds = this.mApplicationMetadataCache.getAllClientIds();
        Logger.info(TAG + ":removeAccountFromDevice", "Found [" + allClientIds.size() + "] client ids.");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = allClientIds.iterator();
        while (it.hasNext()) {
            BrokerOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> brokerOAuth2TokenCache = this;
            arrayList.add(brokerOAuth2TokenCache.removeAccountInternal(accountRecord.getEnvironment(), it.next(), accountRecord.getHomeAccountId(), null, true));
            this = brokerOAuth2TokenCache;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.addAll((AccountDeletionRecord) it2.next());
        }
        Logger.info(TAG + ":removeAccountFromDevice", "Deleted [" + arrayList2.size() + "] AccountRecords.");
        return new AccountDeletionRecord(arrayList2);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4) {
        return removeAccountInternal(str, str2, str3, str4, false);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        for (BrokerApplicationMetadata brokerApplicationMetadata : this.mApplicationMetadataCache.getAll()) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(brokerApplicationMetadata.getClientId(), brokerApplicationMetadata.getEnvironment(), brokerApplicationMetadata.getUid());
            if (tokenCacheForClient != null) {
                tokenCacheForClient.clearAll();
            }
        }
        this.mFociCache.clearAll();
        this.mApplicationMetadataCache.clear();
    }

    public boolean isClientIdKnownToCache(String str) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        return getAllClientIds().contains(str);
    }

    public List<ICacheRecord> getFociCacheRecords() {
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : this.mApplicationMetadataCache.getAllFociApplicationMetadata()) {
            for (AccountRecord accountRecord : this.mFociCache.getAccounts(brokerApplicationMetadata.getEnvironment(), brokerApplicationMetadata.getClientId())) {
                String homeAccountId = accountRecord.getHomeAccountId();
                String environment = accountRecord.getEnvironment();
                String clientId = brokerApplicationMetadata.getClientId();
                String realm = accountRecord.getRealm();
                List<Credential> credentialsFilteredBy = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.RefreshToken, clientId, null, null, null, null, null);
                List<Credential> credentialsFilteredBy2 = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.V1IdToken, clientId, null, null, realm, null, null);
                List<Credential> credentialsFilteredBy3 = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.IdToken, clientId, null, null, realm, null, null);
                if (!credentialsFilteredBy.isEmpty()) {
                    CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                    cacheRecordBuilderBuilder.account(accountRecord);
                    cacheRecordBuilderBuilder.refreshToken((RefreshTokenRecord) credentialsFilteredBy.get(0));
                    if (!credentialsFilteredBy2.isEmpty()) {
                        Logger.verbose(TAG + ":getFociCacheRecords", "Found [" + credentialsFilteredBy2.size() + "] V1IdTokens");
                        cacheRecordBuilderBuilder.v1IdToken((IdTokenRecord) credentialsFilteredBy2.get(0));
                    } else {
                        Logger.warn(TAG + ":getFociCacheRecords", "No V1IdTokens exist for this account.");
                    }
                    if (!credentialsFilteredBy3.isEmpty()) {
                        Logger.verbose(TAG + ":getFociCacheRecords", "Found [" + credentialsFilteredBy3.size() + "] IdTokens");
                        cacheRecordBuilderBuilder.idToken((IdTokenRecord) credentialsFilteredBy3.get(0));
                    } else {
                        Logger.warn(TAG + ":getFociCacheRecords", "No IdTokens exist for this account.");
                    }
                    arrayList.add(cacheRecordBuilderBuilder.build());
                }
            }
        }
        return arrayList;
    }

    private AccountDeletionRecord removeAccountInternal(String str, String str2, String str3, String str4, boolean z) {
        int uid;
        List<BrokerApplicationMetadata> all = this.mApplicationMetadataCache.getAll();
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : all) {
            String clientId = brokerApplicationMetadata.getClientId();
            String environment = brokerApplicationMetadata.getEnvironment();
            if (z) {
                uid = brokerApplicationMetadata.getUid();
            } else {
                uid = this.mUid;
            }
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(clientId, environment, uid);
            if (tokenCacheForClient != null) {
                arrayList.add(tokenCacheForClient.removeAccount(str, str2, str3, str4));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll((AccountDeletionRecord) it.next());
        }
        Logger.info(TAG + ":removeAccountInternal", "Deleted [" + arrayList2.size() + "] AccountRecords.");
        return new AccountDeletionRecord(arrayList2);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    protected Set<String> getAllClientIds() {
        return this.mApplicationMetadataCache.getAllClientIds();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByHomeAccountId(String str, String str2, String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        Logger.verbose(sb.append(str4).append("getAccountByHomeAccountId").toString(), "Loading account by home account id.");
        if (str != null) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            Logger.info(str4 + "getAccountByHomeAccountId", "Loading from FOCI cache? [" + (tokenCacheForClient == null) + "]");
            if (tokenCacheForClient != null) {
                return tokenCacheForClient.getAccountByHomeAccountId(str, str2, str3);
            }
            return this.mFociCache.getAccountByHomeAccountId(str, str2, str3);
        }
        Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
        AccountRecord accountByHomeAccountId = null;
        while (accountByHomeAccountId == null && it.hasNext()) {
            accountByHomeAccountId = it.next().getAccountByHomeAccountId(null, str2, str3);
        }
        return accountByHomeAccountId;
    }

    private MsalOAuth2TokenCache initializeProcessUidCache(IPlatformComponents iPlatformComponents, int i) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":initializeProcessUidCache").toString(), "Initializing uid cache.");
        if (this.mDelegate != null) {
            Logger.warn(str + ":initializeProcessUidCache", "Using swapped delegate cache.");
            return this.mDelegate.getTokenCache(iPlatformComponents, i);
        }
        return getTokenCache(iPlatformComponents, iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.getBrokerUidSequesteredFilename(i), String.class), false);
    }

    private static MicrosoftFamilyOAuth2TokenCache initializeFociCache(IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        Logger.verbose(TAG + ":initializeFociCache", "Initializing foci cache");
        return (MicrosoftFamilyOAuth2TokenCache) getTokenCache(iPlatformComponents, iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.BROKER_FOCI_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, String.class), true);
    }

    private static <T extends MsalOAuth2TokenCache> T getTokenCache(IPlatformComponents iPlatformComponents, INameValueStorage<String> iNameValueStorage, boolean z) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iNameValueStorage == null) {
            throw new NullPointerException("spfm is marked non-null but is null");
        }
        SharedPreferencesAccountCredentialCache sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCache(new CacheKeyValueDelegate(), iNameValueStorage);
        MicrosoftStsAccountCredentialAdapter microsoftStsAccountCredentialAdapter = new MicrosoftStsAccountCredentialAdapter();
        if (z) {
            return new MicrosoftFamilyOAuth2TokenCache(iPlatformComponents, sharedPreferencesAccountCredentialCache, microsoftStsAccountCredentialAdapter);
        }
        return (T) new MsalOAuth2TokenCache(iPlatformComponents, sharedPreferencesAccountCredentialCache, microsoftStsAccountCredentialAdapter);
    }

    private MsalOAuth2TokenCache getTokenCacheForClient(BrokerApplicationMetadata brokerApplicationMetadata) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (brokerApplicationMetadata != null) {
            boolean z = brokerApplicationMetadata.getFoci() != null;
            Logger.verbose(TAG + ":getTokenCacheForClient(bam)", "is Foci? [" + z + "]");
            if (z) {
                msalOAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
            } else {
                msalOAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), brokerApplicationMetadata.getUid());
            }
        } else {
            msalOAuth2TokenCacheInitializeProcessUidCache = null;
        }
        if (msalOAuth2TokenCacheInitializeProcessUidCache == null) {
            Logger.warn(TAG + ":getTokenCacheForClient(bam)", "Could not locate a cache for this app.");
        }
        return msalOAuth2TokenCacheInitializeProcessUidCache;
    }

    private MsalOAuth2TokenCache getTokenCacheForClient(String str, String str2, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, str2, i);
        Logger.info(TAG + ":getTokenCacheForClient(id, env, uid)", "Found metadata? " + (metadata != null));
        return getTokenCacheForClient(metadata);
    }

    public void setSingleSignOnState(String str, GenericAccount genericaccount, GenericRefreshToken genericrefreshtoken) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (str == null) {
            throw new NullPointerException("uidStr is marked non-null but is null");
        }
        if (genericaccount == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (genericrefreshtoken == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        boolean isFamilyRefreshToken = genericrefreshtoken.getIsFamilyRefreshToken();
        int i = Integer.parseInt(str);
        if (isFamilyRefreshToken) {
            Logger.verbose(TAG + ":setSingleSignOnState", "Saving tokens to foci cache.");
            msalOAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
        } else {
            msalOAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), i);
        }
        try {
            targetCacheSetSingleSignOnState(genericaccount, genericrefreshtoken, msalOAuth2TokenCacheInitializeProcessUidCache);
            updateApplicationMetadataCache(genericrefreshtoken.getClientId(), genericrefreshtoken.getEnvironment(), genericrefreshtoken.getFamilyId(), i);
        } catch (ClientException unused) {
            Logger.warn(TAG + ":setSingleSignOnState", "Failed to save account/refresh token. Skipping.");
        }
    }

    private void targetCacheSetSingleSignOnState(GenericAccount genericaccount, GenericRefreshToken genericrefreshtoken, MsalOAuth2TokenCache msalOAuth2TokenCache) throws ClientException {
        if (genericaccount == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (genericrefreshtoken == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        msalOAuth2TokenCache.setSingleSignOnState(genericaccount, genericrefreshtoken);
    }
}
