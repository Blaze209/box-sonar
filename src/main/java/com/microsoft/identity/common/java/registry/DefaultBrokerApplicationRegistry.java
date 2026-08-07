package com.microsoft.identity.common.java.registry;

import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultBrokerApplicationRegistry extends NameValueStorageFileManagerSimpleCacheImpl<BrokerApplicationRegistryData> implements IBrokerApplicationRegistry {
    private static final String DEFAULT_APP_REGISTRY_CACHE_NAME = "com.microsoft.identity.app-registry";
    private static final String KEY_APP_REGISTRY = "app-registry";
    private static final String TAG = "DefaultBrokerApplicationRegistry";

    public DefaultBrokerApplicationRegistry(IPlatformComponents iPlatformComponents) {
        super(iPlatformComponents, DEFAULT_APP_REGISTRY_CACHE_NAME, KEY_APP_REGISTRY);
        if (iPlatformComponents == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IListTypeToken
    public Type getListTypeToken() {
        return TypeToken.getParameterized(List.class, BrokerApplicationRegistryData.class).getType();
    }

    @Override // com.microsoft.identity.common.java.registry.IBrokerApplicationRegistry
    public BrokerApplicationRegistryData getMetadata(String str, String str2, int i) {
        BrokerApplicationRegistryData next;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        Iterator<BrokerApplicationRegistryData> it = getAll().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equals(next.getClientId()) && i == next.getUid() && (str2 == null || str2.equals(next.getEnvironment()))) {
                Logger.verbose(TAG + next, "Metadata located.");
                break;
            }
        }
        if (next == null) {
            Logger.warn(TAG + ":getMetadata", "Metadata could not be found for clientId, environment: [" + str + ", " + str2 + "]");
        }
        return next;
    }
}
