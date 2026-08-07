package com.microsoft.identity.common.java.registry;

import com.microsoft.identity.common.java.cache.ISimpleCache;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrokerApplicationRegistry extends ISimpleCache<BrokerApplicationRegistryData> {
    BrokerApplicationRegistryData getMetadata(String str, String str2, int i);
}
