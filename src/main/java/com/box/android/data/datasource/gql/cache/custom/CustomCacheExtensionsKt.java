package com.box.android.data.datasource.gql.cache.custom;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheResolver;
import com.apollographql.apollo3.cache.normalized.api.FieldPolicyCacheResolver;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory;
import com.apollographql.apollo3.cache.normalized.api.TypePolicyCacheKeyGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomCacheExtensions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"customNormalizedCache", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "normalizedCacheFactory", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "writeToCacheAsynchronously", "", "configureApolloClientBuilder", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomCacheExtensionsKt {
    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, null, null, false, 14, null);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, cacheKeyGenerator, null, false, 12, null);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        return configureApolloClientBuilder$default(builder, normalizedCacheFactory, cacheKeyGenerator, cacheResolver, false, 8, null);
    }

    public static /* synthetic */ ApolloClient.Builder configureApolloClientBuilder$default(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            cacheKeyGenerator = TypePolicyCacheKeyGenerator.INSTANCE;
        }
        if ((i & 4) != 0) {
            cacheResolver = FieldPolicyCacheResolver.INSTANCE;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return configureApolloClientBuilder(builder, normalizedCacheFactory, cacheKeyGenerator, cacheResolver, z);
    }

    public static final ApolloClient.Builder configureApolloClientBuilder(ApolloClient.Builder builder, NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        return NormalizedCache.store(builder, new CustomApolloStore(normalizedCacheFactory, cacheKeyGenerator, cacheResolver), z);
    }
}
