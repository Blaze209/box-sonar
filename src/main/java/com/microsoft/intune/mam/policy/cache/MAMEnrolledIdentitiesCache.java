package com.microsoft.intune.mam.policy.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.MAMSDKCapability;
import com.microsoft.intune.mam.client.app.AndroidManifestData;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMEnrolledIdentitiesCache {
    static final String KEY_MIGRATED = "migrated";
    private static final String KEY_PREFIX_IDENTITY = "identity-";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMEnrolledIdentitiesCache.class);
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.enrolledIdentities";
    private final Context mContext;
    private final MAMIdentityManager mIdentityManager;
    private final MAMEnrollmentStatusCache mLegacyCache;
    private final MAMLogPIIFactory mPIIFactory;
    private final boolean mUseLegacyCache;

    public MAMEnrolledIdentitiesCache(Context context, AndroidManifestData androidManifestData, MAMIdentityManager mAMIdentityManager, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mContext = context;
        this.mLegacyCache = mAMEnrollmentStatusCache;
        this.mUseLegacyCache = !androidManifestData.getCapabilities().contains(MAMSDKCapability.SINGLE_IDENTITY_ENROLLMENT_STATUS_CACHE_DEPRECATIONS);
        this.mIdentityManager = mAMIdentityManager;
        this.mPIIFactory = mAMLogPIIFactory;
    }

    public List<MAMIdentity> getEnrolledIdentities() {
        if (this.mUseLegacyCache) {
            cleanupNewCacheIfNeeded();
            return new ArrayList<MAMIdentity>() { // from class: com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache.1
                {
                    String enrolledIdentity = MAMEnrolledIdentitiesCache.this.mLegacyCache.getEnrolledIdentity();
                    if (enrolledIdentity != null) {
                        add(MAMEnrolledIdentitiesCache.this.mIdentityManager.fromString(enrolledIdentity));
                    }
                }
            };
        }
        ensureMigratedFromLegacyCache();
        ArrayList arrayList = new ArrayList();
        Iterator<CacheEntry> it = getAllCacheEntries().iterator();
        while (it.hasNext()) {
            MAMIdentity mAMIdentityConvertToIdentity = convertToIdentity(it.next());
            if (mAMIdentityConvertToIdentity != null) {
                arrayList.add(mAMIdentityConvertToIdentity);
            }
        }
        return arrayList;
    }

    public boolean isEnrolled(MAMIdentity mAMIdentity) {
        if (MAMIdentity.isValid(mAMIdentity)) {
            return getEnrolledIdentities().contains(mAMIdentity);
        }
        return false;
    }

    public List<MAMIdentity> getManagedIdentities() {
        if (this.mUseLegacyCache) {
            cleanupNewCacheIfNeeded();
            return new ArrayList<MAMIdentity>() { // from class: com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache.2
                {
                    String enrolledIdentity = MAMEnrolledIdentitiesCache.this.mLegacyCache.getEnrolledIdentity();
                    if (enrolledIdentity == null || !MAMEnrolledIdentitiesCache.this.mLegacyCache.getWasManaged()) {
                        return;
                    }
                    add(MAMEnrolledIdentitiesCache.this.mIdentityManager.fromString(enrolledIdentity));
                }
            };
        }
        ensureMigratedFromLegacyCache();
        ArrayList arrayList = new ArrayList();
        for (CacheEntry cacheEntry : getAllCacheEntries()) {
            MAMIdentity mAMIdentityConvertToIdentity = convertToIdentity(cacheEntry);
            if (mAMIdentityConvertToIdentity != null && cacheEntry.mIsManaged) {
                arrayList.add(mAMIdentityConvertToIdentity);
            }
        }
        return arrayList;
    }

    private MAMIdentity convertToIdentity(CacheEntry cacheEntry) {
        MAMIdentity mAMIdentityFetchFromUPN;
        if (cacheEntry.mAadId != null) {
            mAMIdentityFetchFromUPN = this.mIdentityManager.fetch(cacheEntry.mAadId);
        } else {
            LOGGER.warning("AAD ID not available for {0}. Fetching persisted identity by UPN instead.", this.mPIIFactory.getPIIUPN(cacheEntry.mUpn, null));
            mAMIdentityFetchFromUPN = this.mIdentityManager.fetchFromUPN(cacheEntry.mUpn);
        }
        if (mAMIdentityFetchFromUPN != null) {
            return mAMIdentityFetchFromUPN;
        }
        LOGGER.warning("Failed to find a persisted identity for {0}. Creating an unpersisted identity.", this.mPIIFactory.getPIIUPN(cacheEntry.mUpn, cacheEntry.mAadId));
        return this.mIdentityManager.create(cacheEntry.mUpn, cacheEntry.mAadId);
    }

    private List<CacheEntry> getAllCacheEntries() {
        return getAllCacheEntries(this.mContext);
    }

    private static List<CacheEntry> getAllCacheEntries(Context context) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : getPrefs(context).getAll().entrySet()) {
            if (entry.getKey().startsWith(KEY_PREFIX_IDENTITY)) {
                Object value = entry.getValue();
                if (!(value instanceof String)) {
                    LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_CORRUPT_ENTRY, "Cache entry for enrolled identity is not a string.", new Object[0]);
                } else {
                    CacheEntry cacheEntryDeserialize = CacheEntry.deserialize((String) value);
                    if (cacheEntryDeserialize != null) {
                        arrayList.add(cacheEntryDeserialize);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean getWasManagedForAnyIdentity() {
        if (this.mUseLegacyCache) {
            cleanupNewCacheIfNeeded();
        } else {
            ensureMigratedFromLegacyCache();
        }
        return getWasManagedForAnyIdentity(this.mContext, this.mLegacyCache);
    }

    public static boolean getWasManagedForAnyIdentity(Context context, MAMEnrollmentStatusCache mAMEnrollmentStatusCache) {
        if (!getPrefs(context).getBoolean(KEY_MIGRATED, false)) {
            return mAMEnrollmentStatusCache.getEnrolledIdentity() != null && mAMEnrollmentStatusCache.getWasManaged();
        }
        Iterator<CacheEntry> it = getAllCacheEntries(context).iterator();
        while (it.hasNext()) {
            if (it.next().mIsManaged) {
                return true;
            }
        }
        return false;
    }

    public void put(MAMIdentity mAMIdentity, boolean z) {
        putLegacy(mAMIdentity, z);
        if (this.mUseLegacyCache) {
            cleanupNewCacheIfNeeded();
            return;
        }
        ensureMigratedFromLegacyCache();
        if (!mAMIdentity.hasValidAadId()) {
            LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_INVALID_IDENTITY, "Invalid AAD ID for enrolled identity. Not caching identity.", new Object[0]);
            return;
        }
        CacheEntry cacheEntry = new CacheEntry(mAMIdentity.aadId(), mAMIdentity.rawUPN(), z);
        if (!cacheEntry.isValid()) {
            LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_INVALID_IDENTITY, "Invalid cache entry for enrolled identity. Not caching identity.", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Iterator<String> it = CacheEntry.getPossibleKeys(mAMIdentity).iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.putString(cacheEntry.getKey(), CacheEntry.serialize(cacheEntry));
        editorEdit.commit();
    }

    private void putLegacy(MAMIdentity mAMIdentity, boolean z) {
        String enrolledIdentity = this.mLegacyCache.getEnrolledIdentity();
        if (enrolledIdentity == null || mAMIdentity.hasUPN(enrolledIdentity)) {
            if (enrolledIdentity == null) {
                enrolledIdentity = mAMIdentity.rawUPN();
            }
            this.mLegacyCache.setEnrolledIdentity(enrolledIdentity, z);
        }
    }

    public void remove(MAMIdentity mAMIdentity) {
        removeLegacy(mAMIdentity);
        if (this.mUseLegacyCache) {
            cleanupNewCacheIfNeeded();
            return;
        }
        ensureMigratedFromLegacyCache();
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Iterator<String> it = CacheEntry.getPossibleKeys(mAMIdentity).iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.commit();
    }

    private void removeLegacy(MAMIdentity mAMIdentity) {
        String enrolledIdentity = this.mLegacyCache.getEnrolledIdentity();
        if (mAMIdentity.hasUPN(enrolledIdentity)) {
            this.mLegacyCache.clearEnrolledIdentity(enrolledIdentity);
        }
    }

    public void clear() {
        getPrefs().edit().clear().putBoolean(KEY_MIGRATED, getPrefs().getBoolean(KEY_MIGRATED, false)).commit();
    }

    private synchronized void ensureMigratedFromLegacyCache() {
        if (getPrefs().getBoolean(KEY_MIGRATED, false)) {
            return;
        }
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.clear();
        editorEdit.putBoolean(KEY_MIGRATED, true);
        String enrolledIdentity = this.mLegacyCache.getEnrolledIdentity();
        if (enrolledIdentity == null) {
            LOGGER.fine("Skipping legacy cache migration. No enrolled identity found.", new Object[0]);
            editorEdit.commit();
            return;
        }
        MAMIdentity mAMIdentityFetchFromUPN = this.mIdentityManager.fetchFromUPN(enrolledIdentity);
        if (mAMIdentityFetchFromUPN == null) {
            LOGGER.warning("Failed to find persisted identity by UPN for migration. Using unpersisted identity instead.", new Object[0]);
            mAMIdentityFetchFromUPN = this.mIdentityManager.create(enrolledIdentity, null);
        }
        MAMLogger mAMLogger = LOGGER;
        mAMLogger.info("Migrating enrolled identity {0} from legacy cache.", this.mPIIFactory.getPIIUPN(mAMIdentityFetchFromUPN));
        CacheEntry cacheEntry = new CacheEntry(mAMIdentityFetchFromUPN.aadId(), mAMIdentityFetchFromUPN.rawUPN(), this.mLegacyCache.getWasManaged());
        if (cacheEntry.isValid()) {
            editorEdit.putString(cacheEntry.getKey(), CacheEntry.serialize(cacheEntry));
        } else {
            mAMLogger.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_INVALID_IDENTITY, "Invalid cache entry for legacy enrolled identity. Not migrating identity.", new Object[0]);
        }
        editorEdit.commit();
    }

    private void cleanupNewCacheIfNeeded() {
        if (this.mUseLegacyCache && getPrefs().getBoolean(KEY_MIGRATED, false)) {
            LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_ROLLBACK, "App's SDK version requires legacy enrollment status cache, but we previously migrated to new cache. This indicates the MAM SDK update was rolled back. A rollback is not supported.", new Object[0]);
            getPrefs().edit().putBoolean(KEY_MIGRATED, false).commit();
        }
    }

    private SharedPreferences getPrefs() {
        return getPrefs(this.mContext);
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("com.microsoft.intune.mam.enrolledIdentities", 0);
    }

    private static class CacheEntry {
        private static final int ENTRY_COUNT = 3;
        private static final String ENTRY_SEPARATOR = ";";
        private static final int INDEX_AAD_ID = 0;
        private static final int INDEX_IS_MANAGED = 2;
        private static final int INDEX_UPN = 1;
        final String mAadId;
        final boolean mIsManaged;
        final String mUpn;

        CacheEntry(String str, String str2, boolean z) {
            this.mAadId = str;
            this.mUpn = str2;
            this.mIsManaged = z;
        }

        boolean isValid() {
            String str = this.mAadId;
            if (str != null && !str.isEmpty()) {
                return true;
            }
            String str2 = this.mUpn;
            return (str2 == null || str2.isEmpty()) ? false : true;
        }

        String getKey() {
            if (this.mAadId != null) {
                return MAMEnrolledIdentitiesCache.KEY_PREFIX_IDENTITY + this.mAadId;
            }
            if (this.mUpn != null) {
                return MAMEnrolledIdentitiesCache.KEY_PREFIX_IDENTITY + this.mUpn;
            }
            return null;
        }

        static List<String> getPossibleKeys(MAMIdentity mAMIdentity) {
            return new ArrayList<String>() { // from class: com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache.CacheEntry.1
                {
                    if (this.val$identity.hasValidAadId()) {
                        add(MAMEnrolledIdentitiesCache.KEY_PREFIX_IDENTITY + this.val$identity.aadId());
                    }
                    Iterator<String> it = this.val$identity.upns().iterator();
                    while (it.hasNext()) {
                        add(MAMEnrolledIdentitiesCache.KEY_PREFIX_IDENTITY + it.next());
                    }
                }
            };
        }

        static CacheEntry deserialize(String str) {
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length < 3) {
                MAMEnrolledIdentitiesCache.LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_CORRUPT_ENTRY, "Enrolled identity cache entry has too few parts.", new Object[0]);
                return null;
            }
            String str2 = strArrSplit[0];
            if (str2.isEmpty()) {
                str2 = null;
            }
            String str3 = strArrSplit[1];
            if (str2 == null && str3.isEmpty()) {
                MAMEnrolledIdentitiesCache.LOGGER.error(MAMInterfaceError.ENROLLED_IDENTITIES_CACHE_CORRUPT_ENTRY, "Enrolled identity cache entry has empty AAD ID and UPN field. At least one must be present.", new Object[0]);
                return null;
            }
            return new CacheEntry(str2, str3, Boolean.parseBoolean(strArrSplit[2]));
        }

        static String serialize(CacheEntry cacheEntry) {
            ArrayList arrayList = new ArrayList(3);
            String str = cacheEntry.mAadId;
            if (str == null) {
                str = "";
            }
            arrayList.add(0, str);
            String str2 = cacheEntry.mUpn;
            arrayList.add(1, str2 != null ? str2 : "");
            arrayList.add(2, Boolean.toString(cacheEntry.mIsManaged));
            return String.join(";", arrayList);
        }
    }
}
