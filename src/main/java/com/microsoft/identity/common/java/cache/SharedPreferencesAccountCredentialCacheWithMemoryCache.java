package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class SharedPreferencesAccountCredentialCacheWithMemoryCache extends AbstractAccountCredentialCache {
    private static final String TAG = "SharedPreferencesAccountCredentialCacheWithMemoryCache";
    private final Object mCacheLock;
    private final ICacheKeyValueDelegate mCacheValueDelegate;
    private Map<String, AccountRecord> mCachedAccountRecordsWithKeys;
    private Map<String, Credential> mCachedCredentialsWithKeys;
    private boolean mLoaded;

    public SharedPreferencesAccountCredentialCacheWithMemoryCache(ICacheKeyValueDelegate iCacheKeyValueDelegate, INameValueStorage<String> iNameValueStorage) {
        super(iNameValueStorage);
        this.mCacheLock = new Object();
        this.mLoaded = false;
        this.mCachedAccountRecordsWithKeys = new HashMap();
        this.mCachedCredentialsWithKeys = new HashMap();
        if (iCacheKeyValueDelegate == null) {
            throw new NullPointerException("accountCacheValueDelegate is marked non-null but is null");
        }
        if (iNameValueStorage == null) {
            throw new NullPointerException("sharedPreferencesFileManager is marked non-null but is null");
        }
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mCacheValueDelegate = iCacheKeyValueDelegate;
        new Thread(new Runnable() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13855xa4e1d1cd();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public void m13855xa4e1d1cd() {
        Object obj;
        String str = TAG + ":load";
        synchronized (this.mCacheLock) {
            try {
                try {
                    this.mCachedAccountRecordsWithKeys = loadAccountsWithKeys();
                    Logger.info(str, "Loaded " + this.mCachedAccountRecordsWithKeys.size() + " AccountRecords");
                    this.mCachedCredentialsWithKeys = loadCredentialsWithKeys();
                    Logger.info(str, "Loaded " + this.mCachedCredentialsWithKeys.size() + " Credentials");
                    this.mLoaded = true;
                    obj = this.mCacheLock;
                } catch (Throwable th) {
                    try {
                        Logger.error(str, "Failed to load initial accounts or credentials from SharedPreferences", th);
                        this.mLoaded = true;
                        obj = this.mCacheLock;
                    } catch (Throwable th2) {
                        this.mLoaded = true;
                        this.mCacheLock.notifyAll();
                        throw th2;
                    }
                }
                obj.notifyAll();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private void waitForInitialLoad() {
        String str = TAG + ":waitForInitialLoad";
        while (!this.mLoaded) {
            try {
                this.mCacheLock.wait();
            } catch (InterruptedException e) {
                Logger.error(str, "Caught InterruptedException while waiting", e);
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void saveAccount(AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountInput is marked non-null but is null");
        }
        String str = TAG + ":saveAccount";
        try {
            AccountRecord accountRecord2 = (AccountRecord) accountRecord.m13856clone();
            Logger.verbose(str, "Saving Account...");
            Logger.verbose(str, "Account type: [" + accountRecord2.getClass().getSimpleName() + "]");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(accountRecord2);
            Logger.verbosePII(str, "Generated cache key: [" + strGenerateCacheKey + "]");
            synchronized (this.mCacheLock) {
                waitForInitialLoad();
                AccountRecord account = getAccount(strGenerateCacheKey);
                if (account != null) {
                    accountRecord2.mergeAdditionalFields(account);
                }
                this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(accountRecord2));
                this.mCachedAccountRecordsWithKeys.put(strGenerateCacheKey, accountRecord2);
            }
        } catch (CloneNotSupportedException e) {
            Logger.error(str, "Failed to clone AccountRecord", e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void saveCredential(Credential credential) {
        if (credential == null) {
            throw new NullPointerException("credentialInput is marked non-null but is null");
        }
        String str = TAG + ":saveCredential";
        try {
            Credential credential2 = (Credential) credential.m13856clone();
            Logger.verbose(str, "Saving credential...");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(credential2);
            Logger.verbosePII(str, "Generated cache key: [" + strGenerateCacheKey + "]");
            synchronized (this.mCacheLock) {
                waitForInitialLoad();
                Credential credential3 = getCredential(strGenerateCacheKey);
                if (credential3 != null) {
                    credential2.mergeAdditionalFields(credential3);
                }
                this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(credential2));
                this.mCachedCredentialsWithKeys.put(strGenerateCacheKey, credential2);
            }
        } catch (CloneNotSupportedException e) {
            Logger.error(str, "Failed to clone Credential", e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public AccountRecord getAccount(String str) {
        AccountRecord accountRecord;
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":getAccount";
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            accountRecord = this.mCachedAccountRecordsWithKeys.get(str);
        }
        if (accountRecord != null) {
            try {
                return (AccountRecord) accountRecord.m13856clone();
            } catch (CloneNotSupportedException e) {
                Logger.error(str2, "Failed to clone AccountRecord", e);
            }
        }
        return accountRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public Credential getCredential(String str) {
        Credential credential;
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":getCredential";
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            credential = this.mCachedCredentialsWithKeys.get(str);
        }
        if (credential != null) {
            try {
                return (Credential) credential.m13856clone();
            } catch (CloneNotSupportedException e) {
                Logger.error(str2, "Failed to clone Credential", e);
            }
        }
        return credential;
    }

    private Map<String, AccountRecord> loadAccountsWithKeys() {
        String str = TAG + ":loadAccountsWithKeys";
        Logger.verbose(str, "Loading Accounts + keys...");
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache.1
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str2) {
                return SharedPreferencesAccountCredentialCacheWithMemoryCache.isAccount(str2);
            }
        });
        HashMap map = new HashMap();
        if (allFilteredByKey != null) {
            while (allFilteredByKey.hasNext()) {
                Map.Entry<String, String> next = allFilteredByKey.next();
                String key = next.getKey();
                AccountRecord accountRecord = (AccountRecord) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), AccountRecord.class);
                if (accountRecord == null) {
                    Logger.warn(str, SharedPreferencesAccountCredentialCache.ACCOUNT_RECORD_DESERIALIZATION_FAILED);
                } else if (SharedPreferencesAccountCredentialCache.EMPTY_ACCOUNT.equals(accountRecord)) {
                    Logger.warn(str, "The returned Account was uninitialized. Removing...");
                    this.mSharedPreferencesFileManager.remove(key);
                } else {
                    map.put(key, accountRecord);
                }
            }
        }
        Logger.verbose(str, "Returning [" + map.size() + "] Accounts w/ keys...");
        return map;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<AccountRecord> getAccounts() {
        ArrayList arrayList;
        String str = TAG + ":getAccounts";
        Logger.verbose(str, "Loading Accounts...(no arg)");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            arrayList = new ArrayList();
            Iterator<AccountRecord> it = this.mCachedAccountRecordsWithKeys.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((AccountRecord) it.next().m13856clone());
                } catch (CloneNotSupportedException e) {
                    Logger.error(str, "Failed to clone AccountRecord", e);
                }
            }
            Logger.info(str, "Found [" + arrayList.size() + "] Accounts...");
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<AccountRecord> getAccountsFilteredBy(String str, String str2, String str3) {
        String str4 = TAG + ":getAccountsFilteredBy";
        Logger.verbose(str4, "Loading Accounts...");
        List<AccountRecord> accountsFilteredByInternal = getAccountsFilteredByInternal(str, str2, str3, getAccounts());
        Logger.verbose(str4, "Found [" + accountsFilteredByInternal.size() + "] matching Accounts...");
        return accountsFilteredByInternal;
    }

    private Map<String, Credential> loadCredentialsWithKeys() {
        String str = TAG + ":getCredentialsWithKeys";
        Logger.verbose(str, "Loading Credentials with keys...");
        HashMap map = new HashMap();
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache.2
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str2) {
                return SharedPreferencesAccountCredentialCacheWithMemoryCache.isCredential(str2);
            }
        });
        while (allFilteredByKey.hasNext()) {
            Map.Entry<String, String> next = allFilteredByKey.next();
            String key = next.getKey();
            Class<? extends Credential> clsCredentialClassForType = credentialClassForType(key);
            Credential credential = (Credential) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), clsCredentialClassForType);
            if (credential == null) {
                Logger.warn(str, SharedPreferencesAccountCredentialCache.CREDENTIAL_DESERIALIZATION_FAILED);
            } else if ((AccessTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_AT.equals(credential)) || ((RefreshTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_RT.equals(credential)) || (IdTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_ID.equals(credential)))) {
                Logger.warn(str, "The returned Credential was uninitialized. Removing...");
                this.mSharedPreferencesFileManager.remove(key);
            } else {
                map.put(key, credential);
            }
        }
        Logger.verbose(str, "Loaded [" + map.size() + "] Credentials...");
        return map;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentials() {
        ArrayList arrayList;
        String str = TAG + ":getCredentials";
        Logger.verbose(str, "Loading Credentials...");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            arrayList = new ArrayList();
            Iterator<Credential> it = this.mCachedCredentialsWithKeys.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((Credential) it.next().m13856clone());
                } catch (CloneNotSupportedException e) {
                    Logger.error(str, "Failed to clone Credential", e);
                }
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = TAG + ":getCredentialsFilteredBy";
        Logger.verbose(str9, "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(getCredentials(), str, str2, credentialType, str3, str4, str5, str6, str7, str8, null, null, false);
        Logger.verbose(str9, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, List<Credential> list) {
        if (list == null) {
            throw new NullPointerException("inputCredentials is marked non-null but is null");
        }
        String str9 = TAG + ":getCredentialsFilteredBy";
        Logger.verbose(str9, "getCredentialsFilteredBy() -- with input list");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, null, null, false);
        Logger.verbose(str9, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10 = TAG + ":getCredentialsFilteredBy";
        Logger.verbose(str10, "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(getCredentials(), str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, null, false);
        Logger.verbose(str10, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<Credential> list) {
        if (list == null) {
            throw new NullPointerException("inputCredentials is marked non-null but is null");
        }
        String str10 = TAG + ":getCredentialsFilteredBy";
        Logger.verbose(str10, "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, null, false);
        Logger.verbose(str10, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, List<Credential> list) {
        if (list == null) {
            throw new NullPointerException("inputCredentials is marked non-null but is null");
        }
        String str10 = TAG + ":getCredentialsFilteredBy";
        Logger.verbose(str10, "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, null, z);
        Logger.verbose(str10, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(String str, String str2, Set<CredentialType> set, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (set == null) {
            throw new NullPointerException("credentialTypes is marked non-null but is null");
        }
        List<Credential> credentials = getCredentials();
        ArrayList arrayList = new ArrayList();
        Iterator<CredentialType> it = set.iterator();
        while (it.hasNext()) {
            arrayList.addAll(getCredentialsFilteredByInternal(credentials, str, str2, it.next(), str3, str4, str5, str6, str7, str8, str9, null, false));
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(List<Credential> list, String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        if (list == null) {
            throw new NullPointerException("inputCredentials is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, str10, false));
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public boolean removeAccount(AccountRecord accountRecord) {
        boolean z;
        if (accountRecord == null) {
            throw new NullPointerException("accountToRemove is marked non-null but is null");
        }
        String str = TAG + ":removeAccount";
        Logger.info(str, "Removing Account...");
        if (accountRecord == null) {
            throw new IllegalArgumentException("Param [accountToRemove] cannot be null.");
        }
        String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(accountRecord);
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
                this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
                z = true;
            } else {
                z = false;
            }
            Logger.info(str, "Account was removed? [" + z + "]");
            this.mCachedAccountRecordsWithKeys.remove(strGenerateCacheKey);
        }
        return z;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public boolean removeCredential(Credential credential) {
        boolean z;
        if (credential == null) {
            throw new NullPointerException("credentialToRemove is marked non-null but is null");
        }
        String str = TAG + ":removeCredential";
        Logger.info(str, "Removing Credential...");
        if (credential == null) {
            throw new IllegalArgumentException("Param [credentialToRemove] cannot be null.");
        }
        String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(credential);
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
                this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
                z = true;
            } else {
                z = false;
            }
            Logger.info(str, "Credential was removed? [" + z + "]");
            this.mCachedCredentialsWithKeys.remove(strGenerateCacheKey);
        }
        return z;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void clearAll() {
        String str = TAG + ":clearAll";
        Logger.info(str, "Clearing all SharedPreferences entries...");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            this.mSharedPreferencesFileManager.clear();
            this.mCachedCredentialsWithKeys.clear();
            this.mCachedAccountRecordsWithKeys.clear();
        }
        Logger.info(str, "SharedPreferences cleared.");
    }

    private Class<? extends Credential> credentialClassForType(String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":credentialClassForType";
        Logger.verbose(str2, "Resolving class for key/CredentialType...");
        Logger.verbosePII(str2, "Supplied key: [" + str + "]");
        CredentialType credentialTypeForCredentialCacheKey = getCredentialTypeForCredentialCacheKey(str);
        if (credentialTypeForCredentialCacheKey == null) {
            return null;
        }
        Logger.verbose(str2, "CredentialType matched: [" + credentialTypeForCredentialCacheKey + "]");
        return getTargetClassForCredentialType(str, credentialTypeForCredentialCacheKey);
    }

    public static CredentialType getCredentialTypeForCredentialCacheKey(String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":getCredentialTypeForCredentialCacheKey";
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Param [cacheKey] cannot be null.");
        }
        HashSet<String> hashSet = new HashSet();
        Iterator<String> it = CredentialType.valueSet().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toLowerCase(Locale.US));
        }
        for (String str3 : hashSet) {
            if (str.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + str3 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                if (CredentialType.AccessToken.name().equalsIgnoreCase(str3)) {
                    return CredentialType.AccessToken;
                }
                if (CredentialType.AccessToken_With_AuthScheme.name().equalsIgnoreCase(str3)) {
                    return CredentialType.AccessToken_With_AuthScheme;
                }
                if (CredentialType.RefreshToken.name().equalsIgnoreCase(str3)) {
                    return CredentialType.RefreshToken;
                }
                if (CredentialType.IdToken.name().equalsIgnoreCase(str3)) {
                    return CredentialType.IdToken;
                }
                if (CredentialType.V1IdToken.name().equalsIgnoreCase(str3)) {
                    return CredentialType.V1IdToken;
                }
                if (CredentialType.PrimaryRefreshToken.name().equalsIgnoreCase(str3)) {
                    return CredentialType.PrimaryRefreshToken;
                }
                Logger.warn(str2, "Unexpected credential type.");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAccount(String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":isAccount";
        Logger.verbosePII(str2, "Evaluating cache key: [" + str + "]");
        boolean z = getCredentialTypeForCredentialCacheKey(str) == null;
        Logger.verbose(str2, "isAccount? [" + z + "]");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCredential(String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG + ":isCredential";
        Logger.verbosePII(str2, "Evaluating cache key: [" + str + "]");
        boolean z = getCredentialTypeForCredentialCacheKey(str) != null;
        Logger.verbose(str2, "isCredential? [" + z + "]");
        return z;
    }
}
