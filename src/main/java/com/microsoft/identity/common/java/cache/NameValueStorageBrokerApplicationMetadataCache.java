package com.microsoft.identity.common.java.cache;

import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class NameValueStorageBrokerApplicationMetadataCache extends NameValueStorageFileManagerSimpleCacheImpl<BrokerApplicationMetadata> implements IBrokerApplicationMetadataCache {
    private static final String DEFAULT_APP_METADATA_CACHE_NAME = "com.microsoft.identity.app-meta-cache";
    private static final String KEY_CACHE_LIST = "app-meta-cache";
    private static final String TAG = "NameValueStorageBrokerApplicationMetadataCache";

    public NameValueStorageBrokerApplicationMetadataCache(IPlatformComponents iPlatformComponents) {
        super(iPlatformComponents, DEFAULT_APP_METADATA_CACHE_NAME, KEY_CACHE_LIST, true);
        if (iPlatformComponents == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllClientIds() {
        HashSet hashSet = new HashSet();
        Iterator<BrokerApplicationMetadata> it = getAll().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getClientId());
        }
        Logger.verbose(TAG + ":getAllClientIds", "Found [" + hashSet.size() + "] client ids.");
        return hashSet;
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllFociClientIds() {
        return getAllFociClientIds(false);
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllNonFociClientIds() {
        return getAllFociClientIds(true);
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public List<BrokerApplicationMetadata> getAllFociApplicationMetadata() {
        Set<String> allFociClientIds = getAllFociClientIds();
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (allFociClientIds.contains(brokerApplicationMetadata.getClientId())) {
                arrayList.add(brokerApplicationMetadata);
            }
        }
        return arrayList;
    }

    private Set<String> getAllFociClientIds(boolean z) {
        HashSet hashSet = new HashSet();
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (!z) {
                if (!StringUtil.isNullOrEmpty(brokerApplicationMetadata.getFoci())) {
                    hashSet.add(brokerApplicationMetadata.getClientId());
                }
            } else if (StringUtil.isNullOrEmpty(brokerApplicationMetadata.getFoci())) {
                hashSet.add(brokerApplicationMetadata.getClientId());
            }
        }
        Logger.verbose(TAG + ":getAllFociClientIds", "Found [" + hashSet.size() + "] client ids.");
        return hashSet;
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public BrokerApplicationMetadata getMetadata(String str, String str2, int i) {
        BrokerApplicationMetadata next;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        Iterator<BrokerApplicationMetadata> it = getAll().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equals(next.getClientId()) && str2.equals(next.getEnvironment()) && i == next.getUid()) {
                Logger.verbose(TAG + next, "Metadata located.");
                break;
            }
        }
        if (next == null) {
            Logger.warn(TAG + ":getMetadata", "Metadata could not be found for clientId, environment: [" + str + ", " + str2 + "]");
        }
        return next;
    }

    public void remove(String str, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (str.equalsIgnoreCase(brokerApplicationMetadata.getClientId()) && i == brokerApplicationMetadata.getUid()) {
                remove(brokerApplicationMetadata);
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IListTypeToken
    public Type getListTypeToken() {
        return TypeToken.getParameterized(List.class, BrokerApplicationMetadata.class).getType();
    }
}
