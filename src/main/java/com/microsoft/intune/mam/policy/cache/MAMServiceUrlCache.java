package com.microsoft.intune.mam.policy.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.MAMSDKCapability;
import com.microsoft.intune.mam.client.app.AndroidManifestData;
import com.microsoft.intune.mam.client.app.OfflineSharedPreferencesConstants;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.MAMWERetryScheduler;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceUrlCache {
    private static final long DEFAULT_TIMESTAMP_MS = 0;
    private static final String KEY_MIGRATED = "migrated";
    private static final String KEY_PREFIX_IDENTITY = "identity-";
    private static final int LATEST_CERT_VERSION = 1;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMLogger.class);
    private final Context mContext;
    private final MAMIdentityManager mIdentityManager;
    private final MAMEnrollmentStatusCache mLegacyCache;
    private final MAMLogPIIFactory mPIIFactory;
    private final boolean mUseLegacyCache;

    public MAMServiceUrlCache(Context context, AndroidManifestData androidManifestData, MAMIdentityManager mAMIdentityManager, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mContext = context;
        this.mUseLegacyCache = !androidManifestData.getCapabilities().contains(MAMSDKCapability.SINGLE_IDENTITY_ENROLLMENT_STATUS_CACHE_DEPRECATIONS);
        this.mIdentityManager = mAMIdentityManager;
        this.mLegacyCache = mAMEnrollmentStatusCache;
        this.mPIIFactory = mAMLogPIIFactory;
    }

    public Map<String, String> getUrls(MAMIdentity mAMIdentity) {
        if (this.mUseLegacyCache) {
            Map<String, String> mAMServiceUrls = (mAMIdentity == null || !mAMIdentity.hasUPN(this.mLegacyCache.getMAMServiceUrlIdentity())) ? null : this.mLegacyCache.getMAMServiceUrls();
            return mAMServiceUrls == null ? new HashMap() : mAMServiceUrls;
        }
        ensureLegacyCacheMigrated();
        CacheEntry entryForIdentity = getEntryForIdentity(mAMIdentity);
        if (entryForIdentity == null || entryForIdentity.mCertVersion != 1) {
            return new HashMap();
        }
        return entryForIdentity.mUrls;
    }

    public long getUnlicensedRetryInterval(MAMIdentity mAMIdentity) {
        if (this.mUseLegacyCache) {
            return (mAMIdentity == null || !mAMIdentity.hasUPN(this.mLegacyCache.getMAMServiceUrlIdentity())) ? MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS : this.mLegacyCache.getMAMServiceUnlicensedRetryInterval();
        }
        ensureLegacyCacheMigrated();
        CacheEntry entryForIdentity = getEntryForIdentity(mAMIdentity);
        return entryForIdentity == null ? MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS : entryForIdentity.mUnlicensedRetryInterval;
    }

    public long getTimestamp(MAMIdentity mAMIdentity) {
        if (this.mUseLegacyCache) {
            if (mAMIdentity == null || !mAMIdentity.hasUPN(this.mLegacyCache.getMAMServiceUrlIdentity())) {
                return 0L;
            }
            return this.mLegacyCache.getMAMServiceUrlTimestamp();
        }
        ensureLegacyCacheMigrated();
        CacheEntry entryForIdentity = getEntryForIdentity(mAMIdentity);
        if (entryForIdentity == null) {
            return 0L;
        }
        return entryForIdentity.mTimestamp;
    }

    public void setUrls(MAMIdentity mAMIdentity, Map<String, String> map, long j) {
        if (this.mUseLegacyCache) {
            this.mLegacyCache.setMAMServiceUrls(mAMIdentity.canonicalUPN(), map, j);
            return;
        }
        ensureLegacyCacheMigrated();
        if (mAMIdentity.hasValidAadId()) {
            CacheEntry cacheEntry = new CacheEntry(mAMIdentity.aadId(), map, System.currentTimeMillis(), j, 1);
            getPrefs().edit().putString(cacheEntry.getKey(), CacheEntry.serialize(cacheEntry)).commit();
        }
    }

    public void clear(MAMIdentity mAMIdentity) {
        if (mAMIdentity == null) {
            return;
        }
        if (this.mUseLegacyCache) {
            if (mAMIdentity.hasUPN(this.mLegacyCache.getMAMServiceUrlIdentity())) {
                this.mLegacyCache.clearMAMServiceUrls();
                this.mLegacyCache.clearCompanyPortalRequired();
                return;
            }
            return;
        }
        ensureLegacyCacheMigrated();
        if (mAMIdentity.hasValidAadId()) {
            getPrefs().edit().remove(CacheEntry.getKey(mAMIdentity)).commit();
        }
    }

    private synchronized void ensureLegacyCacheMigrated() {
        if (getPrefs().getBoolean(KEY_MIGRATED, false)) {
            return;
        }
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        editorEdit.putBoolean(KEY_MIGRATED, true);
        String mAMServiceUrlIdentity = this.mLegacyCache.getMAMServiceUrlIdentity();
        if (mAMServiceUrlIdentity == null) {
            LOGGER.fine("Skipping legacy cache migration. No enrolled identity found.", new Object[0]);
            editorEdit.commit();
            return;
        }
        MAMIdentity mAMIdentityFetchFromUPN = this.mIdentityManager.fetchFromUPN(mAMServiceUrlIdentity);
        if (mAMIdentityFetchFromUPN == null) {
            LOGGER.warning("Failed to find persisted identity by UPN for migration. Skipping migration.", new Object[0]);
            editorEdit.commit();
            return;
        }
        Map<String, String> mAMServiceUrls = this.mLegacyCache.getMAMServiceUrls();
        if (mAMServiceUrls != null && !mAMServiceUrls.isEmpty()) {
            LOGGER.info("Migrating MAM service url cache from legacy cache for {0}.", this.mPIIFactory.getPIIUPN(mAMIdentityFetchFromUPN));
            CacheEntry cacheEntry = new CacheEntry(mAMIdentityFetchFromUPN.aadId(), mAMServiceUrls, this.mLegacyCache.getMAMServiceUrlTimestamp(), this.mLegacyCache.getMAMServiceUnlicensedRetryInterval(), 1);
            editorEdit.putString(cacheEntry.getKey(), CacheEntry.serialize(cacheEntry));
            editorEdit.commit();
            return;
        }
        editorEdit.commit();
    }

    private CacheEntry getEntryForIdentity(MAMIdentity mAMIdentity) {
        if (mAMIdentity.hasValidAadId()) {
            return CacheEntry.deserialize(getPrefs().getString(CacheEntry.getKey(mAMIdentity), null));
        }
        return null;
    }

    private SharedPreferences getPrefs() {
        return this.mContext.getSharedPreferences(OfflineSharedPreferencesConstants.MAM_SERVICE_URL_CACHE_SHARED_PREFS_NAME, 0);
    }

    private static class CacheEntry {
        private static final int ENTRY_COUNT = 4;
        private static final String ENTRY_SEPARATOR = ";";
        private static final int INDEX_AAD_ID = 0;
        private static final int INDEX_CERT_VERSION = 4;
        private static final int INDEX_RETRY_INTERVAL = 3;
        private static final int INDEX_TIMESTAMP = 2;
        private static final int INDEX_URLS = 1;
        private static final String URL_JSON_KEY = "key";
        private static final String URL_JSON_VALUE = "value";
        final String mAadId;
        final int mCertVersion;
        final long mTimestamp;
        final long mUnlicensedRetryInterval;
        final Map<String, String> mUrls;

        CacheEntry(String str, Map<String, String> map, long j, long j2, int i) {
            this.mAadId = str;
            this.mUrls = map;
            this.mTimestamp = j;
            this.mUnlicensedRetryInterval = j2;
            this.mCertVersion = i;
        }

        String getKey() {
            return MAMServiceUrlCache.KEY_PREFIX_IDENTITY + this.mAadId;
        }

        static String getKey(MAMIdentity mAMIdentity) {
            return MAMServiceUrlCache.KEY_PREFIX_IDENTITY + mAMIdentity.aadId();
        }

        static CacheEntry deserialize(String str) {
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length < 4) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "MAM service URL cache entry has too few parts.", new Object[0]);
                return null;
            }
            String str2 = strArrSplit[0];
            if (str2.isEmpty()) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "MAM service URL cache entry did not contain an AAD ID.", new Object[0]);
                return null;
            }
            Map<String, String> mapUrlsJsonToMap = urlsJsonToMap(strArrSplit[1]);
            if (mapUrlsJsonToMap == null) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to parse URLs from cache entry.", new Object[0]);
                return null;
            }
            try {
                try {
                    try {
                        return new CacheEntry(str2, mapUrlsJsonToMap, Long.parseLong(strArrSplit[2]), Long.parseLong(strArrSplit[3]), Integer.parseInt(strArrSplit[4]));
                    } catch (NumberFormatException e) {
                        MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to parse certificate version from cache entry.", e);
                        return null;
                    }
                } catch (NumberFormatException e2) {
                    MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to parse unlicensed retry interval from cache entry.", e2);
                    return null;
                }
            } catch (NumberFormatException e3) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to parse timestamp from cache entry.", e3);
                return null;
            }
        }

        static String serialize(CacheEntry cacheEntry) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(0, cacheEntry.mAadId);
            arrayList.add(1, urlsMapToJson(cacheEntry.mUrls));
            arrayList.add(2, Long.toString(cacheEntry.mTimestamp));
            arrayList.add(3, Long.toString(cacheEntry.mUnlicensedRetryInterval));
            arrayList.add(4, Integer.toString(cacheEntry.mCertVersion));
            return String.join(";", arrayList);
        }

        private static Map<String, String> urlsJsonToMap(String str) {
            HashMap map = new HashMap();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    map.put(jSONObject.getString("key"), URLDecoder.decode(jSONObject.getString("value")));
                }
                return map;
            } catch (JSONException e) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to decode MAM service URL map from JSON.", e);
                return null;
            }
        }

        private static String urlsMapToJson(Map<String, String> map) {
            try {
                JSONArray jSONArray = new JSONArray();
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("key", entry.getKey());
                        jSONObject.put("value", URLEncoder.encode(entry.getValue()));
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            } catch (JSONException e) {
                MAMServiceUrlCache.LOGGER.error(MAMInterfaceError.URL_CACHE_CORRUPT_ENTRY, "Failed to encode MAM service URL map to JSON.", e);
                return null;
            }
        }
    }
}
