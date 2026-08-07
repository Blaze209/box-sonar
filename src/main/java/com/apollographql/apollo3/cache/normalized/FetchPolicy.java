package com.apollographql.apollo3.cache.normalized;

import kotlin.Metadata;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", "", "(Ljava/lang/String;I)V", "CacheFirst", "CacheOnly", "NetworkFirst", "NetworkOnly", "CacheAndNetwork", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum FetchPolicy {
    CacheFirst,
    CacheOnly,
    NetworkFirst,
    NetworkOnly,
    CacheAndNetwork
}
