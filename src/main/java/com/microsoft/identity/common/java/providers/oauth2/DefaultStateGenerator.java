package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultStateGenerator implements IStateGenerator {
    @Override // com.microsoft.identity.common.java.providers.oauth2.IStateGenerator
    public String generate() {
        return UUID.randomUUID().toString() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + UUID.randomUUID().toString();
    }
}
