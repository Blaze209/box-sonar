package com.apollographql.apollo3.cache.normalized.api;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheKeyGenerator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "", "cacheKeyForObject", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "obj", "", "", "context", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGeneratorContext;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CacheKeyGenerator {
    CacheKey cacheKeyForObject(Map<String, ? extends Object> obj, CacheKeyGeneratorContext context);
}
