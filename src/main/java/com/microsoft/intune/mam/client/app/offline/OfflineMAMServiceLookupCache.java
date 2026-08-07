package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMServiceLookupCache;
import com.microsoft.intune.mam.policy.cache.MAMServiceUrlCache;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMServiceLookupCache implements MAMServiceLookupCache {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineMAMServiceLookupCache.class);
    private final MAMServiceUrlCache mCache;
    private final MAMLogPIIFactory mMAMLogPIIFactory;

    public OfflineMAMServiceLookupCache(MAMLogPIIFactory mAMLogPIIFactory, MAMServiceUrlCache mAMServiceUrlCache) {
        this.mCache = mAMServiceUrlCache;
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupCache
    public Map<String, String> getMAMServiceUrls(MAMIdentity mAMIdentity) {
        Map<String, String> urls = this.mCache.getUrls(mAMIdentity);
        if (!urls.isEmpty()) {
            long timestamp = this.mCache.getTimestamp(mAMIdentity);
            if (timestamp != 0 && System.currentTimeMillis() <= timestamp + MAMServiceLookupCache.CACHE_ENTRY_TTL_MS) {
                return urls;
            }
            LOGGER.info("MAM Service URL found in cache, but data is stale; discarding.", new Object[0]);
            return null;
        }
        LOGGER.info("No MAM Service URL found in the cache for user {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        return null;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupCache
    public void setMAMServiceUrls(MAMIdentity mAMIdentity, Map<String, String> map, long j) {
        this.mCache.setUrls(mAMIdentity, map, j);
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupCache
    public void clearMAMServiceUrls(MAMIdentity mAMIdentity) {
        this.mCache.clear(mAMIdentity);
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupCache
    public boolean okToReQuery(MAMIdentity mAMIdentity) {
        if (this.mCache.getUrls(mAMIdentity).isEmpty()) {
            return true;
        }
        return System.currentTimeMillis() >= this.mCache.getTimestamp(mAMIdentity) + DEFAULT_REQUERY_INTERVAL_MS;
    }
}
