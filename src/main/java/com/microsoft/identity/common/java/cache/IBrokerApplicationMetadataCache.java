package com.microsoft.identity.common.java.cache;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrokerApplicationMetadataCache extends ISimpleCache<BrokerApplicationMetadata> {
    Set<String> getAllClientIds();

    List<BrokerApplicationMetadata> getAllFociApplicationMetadata();

    Set<String> getAllFociClientIds();

    Set<String> getAllNonFociClientIds();

    BrokerApplicationMetadata getMetadata(String str, String str2, int i);
}
