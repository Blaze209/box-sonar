package com.apollographql.apollo3.cache.normalized.api;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemoryCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/MemoryCacheFactory;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "maxSizeBytes", "", "expireAfterMillis", "", "(IJ)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/cache/normalized/api/MemoryCache;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MemoryCacheFactory extends NormalizedCacheFactory {
    private final long expireAfterMillis;
    private final int maxSizeBytes;

    public MemoryCacheFactory() {
        this(0, 0L, 3, null);
    }

    public MemoryCacheFactory(int i) {
        this(i, 0L, 2, null);
    }

    public /* synthetic */ MemoryCacheFactory(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? -1L : j);
    }

    public MemoryCacheFactory(int i, long j) {
        this.maxSizeBytes = i;
        this.expireAfterMillis = j;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory
    public MemoryCache create() {
        return new MemoryCache(this.maxSizeBytes, this.expireAfterMillis);
    }
}
