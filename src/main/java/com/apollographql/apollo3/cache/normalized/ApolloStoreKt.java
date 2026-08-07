package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheResolver;
import com.apollographql.apollo3.cache.normalized.api.FieldPolicyCacheResolver;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory;
import com.apollographql.apollo3.cache.normalized.api.TypePolicyCacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApolloStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"ApolloStore", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "normalizedCacheFactory", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "apollo-normalized-cache"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ApolloStoreKt {
    public static /* synthetic */ ApolloStore ApolloStore$default(NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver, int i, Object obj) {
        if ((i & 2) != 0) {
            cacheKeyGenerator = TypePolicyCacheKeyGenerator.INSTANCE;
        }
        if ((i & 4) != 0) {
            cacheResolver = FieldPolicyCacheResolver.INSTANCE;
        }
        return ApolloStore(normalizedCacheFactory, cacheKeyGenerator, cacheResolver);
    }

    public static final ApolloStore ApolloStore(NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver) {
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        return new DefaultApolloStore(normalizedCacheFactory, cacheKeyGenerator, cacheResolver);
    }
}
